package com.iti;


import com.iti.model.DTO.ProductDTO;
import com.iti.model.DTO.ProductFilter;
import com.iti.model.Dao.Imp.ProductDaoImp;
import com.iti.model.Dao.ProductDao;
import com.iti.model.entity.Address;
import com.iti.model.entity.Product;
import com.iti.model.entity.UserDetails;
import com.iti.model.mapper.ProductMapper;
import com.iti.persistence.DatabaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mmd");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
//        List<String>colors = new ArrayList<>();
//        colors.add("Red");
//        colors.add("Black");
//        List<String>sizes = new ArrayList<>();
//        sizes.add("Small");
//        sizes.add("Medium");
//        String search  = "children";
//        double minPrice = 0;
//        double maxPrice = 2000;
//        ProductFilter productFilter = new ProductFilter();
//        productFilter.setColors(colors);
//        productFilter.setMinPrice(minPrice);
//        productFilter.setMaxPrice(maxPrice);
//        productFilter.setEmpty(false);
//        productFilter.setSizes(sizes);
//        productFilter.setSearch(search);
//
//        ProductDao productDao = ProductDaoImp.getInstance();
//        List<Product> products = productDao.retrieveFilteredProducts(productFilter);
//        products.stream().forEach((e)->{
//            System.out.println(e.getType());
//        });


//        /*  Inserting Products */
        for (int i = 0; i < 5; i++) {


            ProductDTO p1 = new ProductDTO("Finding perfect t-shirt", "layout/images/cloth_1.jpg", 50);
            p1.setProdType("T-Shirt");
            p1.setProdQuantity(50);
            p1.setSize("Small");
            p1.setCategory("Men");
            p1.setColor("Black");
            p1.setSecondProdImg("layout/images/cloth_1.jpg");


            ProductDTO p2 = new ProductDTO("Finding perfect t-shirt", "layout/images/cloth_2.jpg", 50);
            p2.setProdType("T-Shirt");
            p2.setProdQuantity(16);
            p2.setSize("Large");
            p2.setCategory("Men");
            p2.setColor("White");
            p2.setSecondProdImg("layout/images/cloth_1.jpg");
            ProductDTO p3 = new ProductDTO("Finding perfect t-shirt", "layout/images/cloth_3.jpg", 50);
            p3.setProdType("Pants");
            p3.setProdQuantity(25);
            p3.setSize("Small");
            p3.setCategory("Women");
            p3.setColor("Blue");
            p3.setSecondProdImg("layout/images/cloth_1.jpg");

            ProductDTO p4 = new ProductDTO("Finding perfect t-shirt", "layout/images/cloth_4.jpg", 50);
            p4.setProdType("Hoodie");
            p4.setProdQuantity(40);
            p4.setSize("Medium");
            p4.setCategory("Children");
            p4.setColor("Red");
            p4.setSecondProdImg("\"layout/images/cloth_1.jpg\"");

            Product entity = ProductMapper.getInstance().getEntity(p1);
            Product entity2 = ProductMapper.getInstance().getEntity(p2);
            Product entity3 = ProductMapper.getInstance().getEntity(p3);
            Product entity4 = ProductMapper.getInstance().getEntity(p4);
            System.out.println(entity);

            entityManager.persist(entity);
            entityManager.persist(entity2);
            entityManager.persist(entity3);
            entityManager.persist(entity4);

        }

        entityManager.getTransaction().commit();




        /* Inserting Users */
//        String email= "'m@m.com'";
//        String password = "123456789";
//        List<UserDetails> resultList = entityManager.createQuery("from UserDetails where email = "+email+ "and password="+password, UserDetails.class).getResultList();
//
//        System.out.println(resultList.size());
//        System.out.println(resultList);
//        System.out.println(resultList.get(0));
//        UserDetails user = new UserDetails();
//        user.setUserName("Ahmed");
//        user.setBirthday(new Date());
//        user.setCreditLimit(15.0);
//        user.setEmail("m@m3.com");
//        user.setPhoneNumber("+201021213");
//        user.setPassword("123456789");
//        user.setRole("Admin_Role");
//        Address cairo = new Address("cairo");
//        cairo.setUserDetails(user);
////
//        Address Giza = new Address("giza");
//        Giza.setUserDetails(user);
//        Set<Address> set = new HashSet<>();
//        set.add(cairo);
//        set.add(Giza);
//        user.setAddresses(set);
//        entityManager.getTransaction().begin();
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();

//        List<UserDetails> from_userDetails = entityManager.createQuery("from UserDetails", UserDetails.class).setFirstResult(0).setMaxResults(4).getResultList();
//        System.out.println(from_userDetails);

//        entityManager.close();
//    }}
    }
}
