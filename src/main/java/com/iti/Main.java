package com.iti;


import com.iti.model.entity.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Main {
    public static void main(String [] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mmd");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDetails user = new UserDetails();
        user.setUserName("Ahmed");
        user.setBirthday(new Date());
        user.setCreditLimit(15.0);
        user.setEmail("m@m.com");
        user.setPhoneNumber("+201021213");
        user.setPassword("123456789");
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
