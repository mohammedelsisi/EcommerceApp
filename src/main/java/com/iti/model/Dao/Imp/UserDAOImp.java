package com.iti.model.Dao.Imp;


import com.iti.model.DTO.*;
import com.iti.model.Dao.UserDao;
import com.iti.model.entity.*;


import com.iti.persistence.DatabaseManager;
import jakarta.inject.Scope;

import javax.persistence.EntityManager;
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
    public List<UserDTO> retriveall() {

        //TODO access ORM to Retrieve Users
        return null;
    }

    @Override
    public List<UserDTO> retrieveFilteredUsers(UserDTO userFilter) {
        return null;
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
            System.out.println("####@@@@@");
            user.getAddresses().stream().forEach(e -> {
                System.out.println("####@@@@@" + e.getAddress());
                if (entityManager.find(Address.class, e.getAddress()) == null) {
                    System.out.println("/-/-/-/-/-" + e.getAddress());
                    e.setUserDetails(user);
                    entityManager.persist(e);
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
    public boolean editImage(String image) {
        UserDTO user = new UserDTO();
        user.setImage(image);
        return true;
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
            }
        });

        entityManager.merge(user);
        entityManager.getTransaction().commit();


        return entityManager.find(UserDetails.class, user.getId());
    }

    @Override
    public List<RoleUser> getRoles() {
        List<RoleUser> rolesList = new ArrayList<>();
        rolesList.add(RoleUser.Admin_Role);
        rolesList.add(RoleUser.CustomerRole);
        return rolesList;
    }


}
