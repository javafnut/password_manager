package com.ibexsys.pwd.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


//import com.ibexsys.pwd.entities.AppUser;
//import com.ibexsys.pwd.entities.Category;
//import com.ibexsys.pwd.entities.Site;


public class HibernateCheck {

    public static void main(String[] args) throws Exception {

        // Set up the table and data for testing
        JPAUtil.droptable("drop table SEQUENCE");

        // Perform JPA operation
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("PwdManagerDbService");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

       
        em.close();
        emf.close();

        // Display the table for verification
        JPAUtil.checkData("select * from AppUser");
        JPAUtil.checkData("select * from Category");
        JPAUtil.checkData("Select * from Site");
    }
}

