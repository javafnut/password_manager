package com.ibexsys.pwd.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ibexsys.pwd.entities.*;
import com.ibexsys.pwd.services.PasswordEncryptionService;
import com.ibexsys.pwd.util.JPAUtil;

public class SimpleORMTestForPwdManager {
	
	public static void createTestData(EntityManager em){
		
		int NUM_SITES_MAX_PER_CATEGORY = 3;
		int NUM_CATEGORY_MAX = 5;

		String pwd = "()ThisIsATestPassword!@44";
		byte[] lSalt = null;
		byte[] lEncPwd = null;
		Random random = new Random();
		Calendar calendar = Calendar.getInstance();

		try {
			lSalt = PasswordEncryptionService.generateSalt();
			lEncPwd = PasswordEncryptionService.getEncryptedPassword(pwd, lSalt);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		em.getTransaction().begin();

		AppUser user = new AppUser();
		user.setFirstName("Todd");
		user.setLastName("Johnston");
		user.setEmail("foo@foobar.com");
		user.setSalt(lSalt);
		user.setPassword(lEncPwd);
		user.setCreatedDTM(new Timestamp(calendar.getTimeInMillis()));
		user.setModifiedDTM(user.getCreatedDTM());
		
	    em.persist(user);
		
	    System.out.println(user.toString());
	    
		// Setup root category, all id's are set to ROOT_ID
		Category category = new Category();
		category.setChildId(Category.ROOT_ID); // ROOT is it's own child by
     	category.setParentId(Category.ROOT_ID);
		category.setDescription(Category.ROOT_NAME);
		category.setUserID(user.getUserId());
		category.setName(Category.ROOT_NAME);
		category.setCreatedDTM(new Timestamp(calendar.getTimeInMillis()));
		category.setModifiedDTM(category.getCreatedDTM());
		
		em.persist(category);
		
		
		
		
		Site site = new Site();
		site.setAppUserId(user.getUserId());
		site.setCatId(category.getCatID());
		site.setSiteName("My_Site_Name_" );
		site.setSiteURL("http://foobar.com/foobar");
		site.setNotes("My_Site_Notes_");
		site.setLogin("Login_Name_");
		site.setCreatedDTM(new Timestamp(calendar.getTimeInMillis()));
		site.setModifiedDTM(site.getCreatedDTM());
		
	    em.persist(site);
		em.getTransaction().commit();
		
	}

    public static void DeleteData(EntityManager em){
    	
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        // Perform JPA operation
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("PwdManagerDbService");
        EntityManager em = emf.createEntityManager();

       
      
        SimpleORMTestForPwdManager.createTestData(em);
        

        
        em.close();
        emf.close();

        // Display the table for verification
        JPAUtil.checkData("select * from AppUser");
        JPAUtil.checkData("select * from Category");
        JPAUtil.checkData("Select * from Site");
        
        

	}

}
