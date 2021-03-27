package com.iti.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseManager {
   private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mmd");
    private DatabaseManager(){
    }
    public synchronized static EntityManagerFactory getFactory(){
        return entityManagerFactory;
    }

}
