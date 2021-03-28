package com.iti;


import com.iti.model.entity.Address;
import com.iti.model.entity.UserDetails;
import com.iti.persistence.DatabaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String [] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mmd");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        String email= "'m@m.com'";
//        String password = "123456789";
//        List<UserDetails> resultList = entityManager.createQuery("from UserDetails where email = "+email+ "and password="+password, UserDetails.class).getResultList();
//
//        System.out.println(resultList.size());
//        System.out.println(resultList);
//        System.out.println(resultList.get(0));
        UserDetails user = new UserDetails();
        user.setUserName("Ahmed");
        user.setBirthday(new Date());
        user.setCreditLimit(15.0);
        user.setEmail("m@m3.com");
        user.setPhoneNumber("+201021213");
        user.setPassword("123456789");
        user.setRole("Admin_Role");
        Address cairo = new Address("cairo");
        cairo.setUserDetails(user);
//
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
