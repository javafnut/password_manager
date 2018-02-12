package com.ibexsys.pwd.test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibexsys.pwd.entities.Category;
import com.ibexsys.pwd.entities.UserAppProfile;
import com.ibexsys.pwd.entities.Site;
import com.ibexsys.pwd.entities.User;
import com.ibexsys.pwd.services.PasswordEncryptionService;

public class SimpleORMAppTest {

	// Keep these for deletes
	static int USERID;
	static int CATID;
	static int SITEID;
	static int USERAPPID;
    static final int RECCREATED = 1;	
    
    String foo = "foo";
	
	EntityManagerFactory entityMngrFactory = null;
	EntityManager em = null;
	

	@Before
	public void setUp() throws Exception {

		try {
			entityMngrFactory = Persistence.createEntityManagerFactory("PwdManagerDbService");
			em = entityMngrFactory.createEntityManager();

		} catch (PersistenceException pe) {
			System.out.println(pe.getMessage());
		}
	}

	@Test
	public void checkEntityManagerOK() {
		
		assert (entityMngrFactory.isOpen());
		assert (em.isOpen());
	}
	

	// Perform simple CRUD operations using 1 record
	@Test
	public void simpleCRUD() {
		
		String pwd = "()ThisIsATestPassword!@44";
		byte[] lSalt = null;
		byte[] lEncPwd = null;
		Timestamp testTimestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
		
		try {
			lSalt = PasswordEncryptionService.generateSalt();
			lEncPwd = PasswordEncryptionService.getEncryptedPassword(pwd, lSalt);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		
		// ------------------------------ CREATE --------------------------------//
		
		em.getTransaction().begin();

		UserAppProfile appProfile = UserAppProfile.getInstance();
		appProfile.setLoginName("FooBarLogin");
		appProfile.setCreatedDTM(testTimestamp);
		appProfile.setModifiedDTM(appProfile.getCreatedDTM());
		appProfile.setLastLoginDTM(testTimestamp);
		//appProfile.setIsActive(true);
		//appProfile.setAccountLocked(false);
	
		User user = new User();
		user.setFirstName("Todd");
		user.setLastName("Johnston");
		user.setEmail("foo@foobar.com");
		user.setSalt(lSalt);
		user.setPassword(lEncPwd);
		user.setCreatedDTM(testTimestamp);
		user.setModifiedDTM(user.getCreatedDTM());
		
		em.persist(user);
	    
		appProfile.setAppUserId(user.getUserId());		
	    
		// Setup root category
		Category category = new Category();
		category.setChildId(Category.NO_ID); 
     	category.setParentId(Category.NO_ID);
		category.setDescription(Category.ROOT_NAME);
		category.setName(Category.ROOT_NAME);
		category.setCreatedDTM(testTimestamp);
		category.setModifiedDTM(category.getCreatedDTM());
		
		em.persist(category);
 
		// Now setup the root category, root is it's own parent
		category.setParentId(category.getCatId());
		appProfile.setRootId(category.getCatId());
	
		em.persist(category);
 
		
        String testPwd = "&*0ThisISAtestPwd";
        try {
			lSalt = PasswordEncryptionService.generateSalt();
			lEncPwd = PasswordEncryptionService.getEncryptedPassword(testPwd, lSalt);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
        
  		Site site = new Site();
		site.setAppUserId(user.getUserId());
		site.setCatId(category.getCatId());
		site.setSiteName("My_Site_Name_" );
		site.setLogin(site.getSiteName().concat("_").concat(user.getFirstName()));
		site.setPassword(lEncPwd);
		site.setSiteURL("http://foobar.com/foobar");
		site.setNotes("My_Site_Notes_");
		site.setLogin("Login_Name_");
		site.setCreatedDTM(testTimestamp);
		site.setModifiedDTM(site.getCreatedDTM());
	
		try {
			appProfile.addSite(site);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    em.persist(site);	
		em.persist(appProfile);
	    
		em.getTransaction().commit();
		
		// @TODO find ways around this
//		USERAPPID = appProfile.getAppUserId();
//		USERID = appProfile.getUserId();
//		CATID = category.getCatId();
//		SITEID = site.getSiteId();;
		
		// ------------------------------ READ ----------------------------------//
		
		TypedQuery<Integer> typedQuery = em.createQuery("SELECT userId FROM User WHERE userId = :p",Integer.class);
		Integer result = (Integer) typedQuery.setParameter("p",user.getUserId()).getSingleResult();
		assert(result == user.getUserId());
		
		typedQuery = em.createQuery("SELECT catId FROM Category WHERE catId = :p", Integer.class);
		result = (Integer) typedQuery.setParameter("p",category.getCatId()).getSingleResult();
		assert(result == category.getCatId());
		
		typedQuery = em.createQuery("SELECT siteId FROM Site WHERE siteId = :p",Integer.class);
		result = (Integer) typedQuery.setParameter("p",site.getSiteId()).getSingleResult();
		assert(result == site.getSiteId());
		
		typedQuery = em.createQuery("SELECT profileId FROM UserAppProfile WHERE profileId = :p",Integer.class);
		result = (Integer) typedQuery.setParameter("p",appProfile.getProfileId()).getSingleResult();
		assert(result == appProfile.getProfileId());
		
		// ------------------------------ UPDATE --------------------------------//
		String updateStr = "UpdateString.";
		String testStr = null;
		
		// User
		em.getTransaction().begin();
	   		User userUdt = em.find(User.class, user.getUserId()); 
			testStr = updateStr.concat(userUdt.getEmail());
		    userUdt.setEmail(testStr);
	    em.getTransaction().commit();
	    
	    User userRslt = em.find(User.class, user.getUserId()); 
	    assert(userRslt.getEmail().equalsIgnoreCase(testStr));
	    
	    //Category
	    em.getTransaction().begin();
		    Category catUdt = em.find(Category.class, category.getCatId());
		    testStr = updateStr.concat(catUdt.getDescription());
		    catUdt.setDescription(testStr);
	    em.getTransaction().commit();
	    
	    Category catRslt = em.find(Category.class, category.getCatId());
	    assert(catRslt.getDescription().equals(testStr));
	    
	    // Site
	    em.getTransaction().begin();
	    	Site siteUdt = em.find(Site.class, site.getSiteId());
	    	testStr = updateStr.concat(site.getLogin());
	    	siteUdt.setLogin(testStr);
	    em.getTransaction().commit();
	    
	    Site siteRslt = em.find(Site.class, site.getSiteId());
	    assert(siteRslt.getLogin().equalsIgnoreCase(testStr));
	    
	    // User App Profile
	     
	    em.getTransaction().begin();
    	    UserAppProfile profileUdt = em.find(UserAppProfile.class, appProfile.getAppUserId());
		    testStr = updateStr.concat(appProfile.getLoginName());
		    profileUdt.setLoginName(testStr);
	    em.getTransaction().commit();
		
	    UserAppProfile profileRslt = em.find(UserAppProfile.class, appProfile.getAppUserId());
	    assert(profileRslt.getLoginName().equalsIgnoreCase(testStr));
  
	    
		// ------------------------------ DELETE --------------------------------//
		em.getTransaction().begin();
		Query query = em.createQuery("DELETE FROM User WHERE userId = :p");
	    int delCnt = query.setParameter("p",appProfile.getAppUserId()).executeUpdate();
	    assert(delCnt == 1);
						
		query = em.createQuery("DELETE FROM Category WHERE CatId = :p");
	    delCnt = query.setParameter("p",category.getCatId()).executeUpdate();
	    assert(delCnt == 1);
	      
		
	    query = em.createQuery("DELETE FROM Site WHERE SiteId = :p");
	    delCnt = query.setParameter("p",site.getSiteId()).executeUpdate();
	    assert(delCnt == 1);		
			
	    query = em.createQuery("DELETE FROM UserAppProfile WHERE ProfileId = :p");
	    delCnt = query.setParameter("p",appProfile.getAppUserId()).executeUpdate();
	    assert(delCnt == 1);   
	    
	    em.getTransaction().commit();
	}
	
	@After
	public void tearDown() throws Exception {
		
		try {
			entityMngrFactory.close();
		} catch (PersistenceException pe) {
			System.out.println(pe.getMessage());
		} finally {
			entityMngrFactory = null;
			em = null;
		}

	}
//	
//    public static void DeleteData(){
//
//    	JdbcUtils.simpleDelete("delete from User where UserId = " + userId );
//    	JdbcUtils.simpleDelete("delete from Category where CatId = " + catId);
//    	JdbcUtils.simpleDelete("delete from Site where SiteId = " + siteId);
//    	JdbcUtils.simpleDelete("delete from UserAppProfile where ProfileId = " + userAppId);
//    }

}
