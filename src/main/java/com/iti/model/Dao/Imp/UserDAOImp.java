package com.iti.model.Dao.Imp;


import com.iti.model.DTO.*;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.*;


import com.iti.persistence.DatabaseManager;

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
    //    private static final UserDAOImp userDAOImp = new UserDAOImp();
    EntityManager entityManager;

    private UserDAOImp() {
        entityManager = DatabaseManager.getFactory().createEntityManager();
    }

    public static UserDAOImp getInstance() {
        return new UserDAOImp();
    }

    public void close() {
        if (entityManager.isOpen()){
            System.out.println("Closing Entity Manger of user ");
            entityManager.close();

        }
    }

    @Override
    public void editUserRole() {
        //
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
        List<String> resultList = entityManager.createQuery("select email from UserDetails where email = :userEmail", String.class).setParameter("userEmail",userEmail.toLowerCase()).getResultList();
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
    public List<UserDTO> retrieveFilteredUsers(UserDTO userFilter) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDetails> criteriaQuery = criteriaBuilder.createQuery(UserDetails.class);
        Root<UserDetails> userRoot = criteriaQuery.from(UserDetails.class);


        Predicate predicate = criteriaBuilder.conjunction();
        if (userFilter.getId() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("productId"), userFilter.getId()));
        if (userFilter.getUserName().length() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("category"), userFilter.getUserName()));
        if (userFilter.getPhoneNumber().length() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("color"), userFilter.getPhoneNumber()));
        if (userFilter.getCreditLimit() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("quantity"), userFilter.getCreditLimit()));
        if (userFilter.getEmail().length() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("price"), userFilter.getEmail()));
        if (userFilter.getRole().length() > 0)
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userRoot.get("size"), userFilter.getRole()));

        criteriaQuery.where(predicate);


        List<UserDetails> users = entityManager.createQuery(criteriaQuery).getResultList();

        return users;

    }



    @Override
    public boolean changePassword(String oldpassword, String newpassword) {
        if (oldpassword.equals("hello")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAddress(String address) {
        //I need the id of the current user here
        int id = 0;
        Address newAddress = new Address();
        EntityManager entityManager = DatabaseManager.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newAddress);
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;
    }


    @Override
    public boolean editImage(String image) {
        UserDTO user = new UserDTO();
        user.setImage(image);
        return true;
    }


    @Override
    public boolean EditProfile(UserDTO user) {
        //I need the id of the current user here
        int id = 0;
        EntityManager entityManager = DatabaseManager.getFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("update userDetails set  birthDay =" + user.getBirthday() +
                ", credit_limit= " + user.getCreditLimit() +
                " , phone_number= " + user.getPhoneNumber() +
                " , job= " + user.getJob() +
                " , user_name= " + user.getUserName() + " where id = " + id, UserDetails.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return true;

    }

    @Override
    public List<RoleUser> getRoles() {
        List<RoleUser> rolesList = new ArrayList<>();
        rolesList.add(RoleUser.Admin_Role);
        rolesList.add(RoleUser.CustomerRole);
        return rolesList;
    }


}
