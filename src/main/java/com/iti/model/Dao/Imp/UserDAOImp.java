package com.iti.model.Dao.Imp;


import com.iti.model.DTO.*;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.*;


import com.iti.persistence.DatabaseManager;
import jakarta.inject.Scope;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImp implements UserDao {

    EntityManager entityManager;

    private UserDAOImp() {
        entityManager = DatabaseManager.getFactory().createEntityManager();
    }

    public static UserDAOImp getInstance() {
        return new UserDAOImp();
    }

    public void close() {
        if (entityManager.isOpen()) {
            System.out.println("Closing Entity Manger of user ");
            entityManager.close();

        }
    }


    @Override
    public boolean insertUser(UserDetails userDetails) {
        entityManager.getTransaction().begin();
        entityManager.persist(userDetails);
        userDetails.getInterests().stream().forEach((e) -> {
            e.setUserDetails(userDetails);
            entityManager.persist(e);
        });
        entityManager.getTransaction().commit();
        return true;
    }


    @Override
    public boolean isUserEmail(String userEmail) {
        List<String> resultList = entityManager.createQuery("select email from UserDetails where email = :userEmail", String.class).setParameter("userEmail", userEmail.toLowerCase()).getResultList();
        return resultList.size() > 0;
    }

    @Override
    public UserDetails getUser(String userEmail, String userPassword) {
        List<UserDetails> resultList = entityManager.createQuery("from UserDetails where email = :userEmail and password = :userPassword", UserDetails.class)
                .setParameter("userEmail", userEmail.toLowerCase())
                .setParameter("userPassword", userPassword)
                .getResultList();
        if (resultList.size() == 1) {
            System.out.println(resultList.get(0));
            return resultList.get(0);
        } else {
            return null;
        }
    }


    @Override
    public List<UserDetails> retrieveFilteredUsers(UserDetails userFilter) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDetails> criteriaQuery = criteriaBuilder.createQuery(UserDetails.class);
        Root<UserDetails> userRoot = criteriaQuery.from(UserDetails.class);


        Predicate predicate = criteriaBuilder.conjunction();
        if (userFilter.getId() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("id"), userFilter.getId()));
        if (userFilter.getUserName().length() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("userName"), userFilter.getUserName()));
        if (userFilter.getPhoneNumber().length() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("phoneNumber"), userFilter.getPhoneNumber()));
        if (userFilter.getCreditLimit() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("creditLimit"), userFilter.getCreditLimit()));
        if (userFilter.getEmail().length() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("email"), userFilter.getEmail()));
        if (userFilter.getRole().toString().length() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("role"), userFilter.getRole()));

        criteriaQuery.where(predicate);


        List<UserDetails> users = entityManager.createQuery(criteriaQuery).getResultList();

        return users;

    }

    @Override
    public boolean changePassword(UserDetails user, String oldPassword, String newpassword) {
        if (user.getPassword().equals(oldPassword)) {
            entityManager.getTransaction().begin();
            user.setPassword(newpassword);

            user.getInterests().stream().forEach((e) -> {
                e.setUserDetails(user);
                entityManager.merge(e);
            });
            user.getAddresses().stream().forEach(e -> {
                if (entityManager.createQuery("From Address where  user_id =:idd and address = :add")
                        .setParameter("idd", user.getId())
                        .setParameter("add", e.getAddress()).getResultList().size() == 0) {
                    System.out.println("/-/-/-/-/-" + e.getAddress());
                    e.setUserDetails(user);
                    entityManager.persist(e);
                } else {
                    e.setUserDetails(user);
                    entityManager.merge(e);
                }
            });
            entityManager.merge(user);

            entityManager.getTransaction().commit();
            System.out.println("password updated");
            return true;
        } else {
            System.out.println("Failed to change password");
            return false;
        }
    }


    @Override
    public UserDetails EditProfile(UserDetails user) {

        System.out.println("############# +" + user);
        entityManager.getTransaction().begin();

        user.getInterests().stream().forEach((e) -> {
            e.setUserDetails(user);
            entityManager.merge(e);
        });


        user.getAddresses().stream().forEach(e -> {
            if (entityManager.createQuery("From Address where  user_id =:idd and address = :add")
                    .setParameter("idd", user.getId())
                    .setParameter("add", e.getAddress()).getResultList().size() == 0) {
                System.out.println("/-/-/-/-/-" + e.getAddress());
                e.setUserDetails(user);
                entityManager.persist(e);
            } else {
                e.setUserDetails(user);
                entityManager.merge(e);
            }
        });

        entityManager.merge(user);
        entityManager.getTransaction().commit();


        return entityManager.find(UserDetails.class, user.getId());
    }

    @Override
    public boolean updateUserRole(UserDetails userToUpdate) {
        UserDetails user = entityManager.find(UserDetails.class, userToUpdate.getId());
        user.setRole(userToUpdate.getRole());
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }

    }

    @Override
    public List<String> getRoles() {
        List<String> rolesList = new ArrayList<>();
        rolesList.add("");
        rolesList.add(RoleUser.Admin_Role.name());
        rolesList.add(RoleUser.CustomerRole.name());
        return rolesList;
    }


}
