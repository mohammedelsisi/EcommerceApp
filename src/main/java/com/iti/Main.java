package com.iti;


import com.iti.model.entity.Address;
import com.iti.model.entity.UserDetails;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String [] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mmd");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDetails user = new UserDetails();
        user.setUserName("Ahmed");
        user.setBirthday(new Date());
        user.setCreditLimit(15.0);
        user.setEmail("ms@dsasm.com");
        user.setPhoneNumber("+201021213");
        user.setPassword("123456789");
        Address cairo = new Address("cairo");
        cairo.setUserDetails(user);

        Address Giza = new Address("giza");
        Giza.setUserDetails(user);
        Set<Address> set = new HashSet<>();
        set.add(cairo);
        set.add(Giza);
        user.setAddresses(set);
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
