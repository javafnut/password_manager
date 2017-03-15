package com.ibexsys.pwd.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAConnectionCheck {

    public static void main(String[] args) throws Exception {

        // Set up the table and data for testing
        //JPAUtil.droptable("drop table SEQUENCE");

        // Perform JPA operation
        EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("PwdManagerDbService");
        EntityManager em = emf.createEntityManager();

     
        em.close();
        emf.close();

    }
}

