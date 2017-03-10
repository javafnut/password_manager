package com.ibexsys.pwd.test;


import java.util.Date;
import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;


import com.ibexsys.pwd.model.AppUser;
import com.ibexsys.pwd.model.Category;
import com.ibexsys.pwd.model.PasswordCriteria;
import com.ibexsys.pwd.model.PasswordUserModel;
import com.ibexsys.pwd.model.Site;

import com.ibexsys.pwd.services.PasswordEncryptionService;

@Component
@Path("/testpwd")
public class PasswordUserModelRestTest {

	private static Map<Integer, PasswordUserModel> pwdUserDB = new ConcurrentHashMap<Integer, PasswordUserModel>();
	private static AtomicInteger idCounter = new AtomicInteger();
	private static PasswordUserModel pwdUserModel = new PasswordUserModel();
	private static int NUM_SITES_MAX_PER_CATEGORY = 10;
	private static ArrayList<Site> siteList = new ArrayList<Site>();
	
	
	static{
		
		String pwd = "()ThisIsATestPassword!@44";
		byte[] lSalt = null;
	    byte[] lEncPwd = null;
		boolean isValid = false;
		
		try{
			lSalt = PasswordEncryptionService.generateSalt();
			lEncPwd = PasswordEncryptionService.getEncryptedPassword(pwd, lSalt);
		} catch(Exception e){
			System.out.println(e.getStackTrace());
		}
		
		AppUser user = new AppUser();
        user.setUserId(1000);
		user.setFirstName("Todd");
		user.setLastName("Johnston");
		user.setEmail("foo@foobar.com");
		user.setSalt(lSalt);
		user.setPassword(lEncPwd);
		user.setCreateDate(new Date());
		user.setModDate(new Date());
		
		pwdUserModel.setAppUser(user);
		
	    Category category = new Category();
	    category.setCatId(100);
	    category.setChildId(100);
	    category.setParentId(100);
	    category.setDescription("Description");
	    category.setUserId(1000);
	    category.setName("root");
		
 		
		for (int i = 0; i < NUM_SITES_MAX_PER_CATEGORY; i++) {
			Site site = new Site();
			site.setSiteId(idCounter.incrementAndGet());
			site.setAppUserId(user.getUserId());
		    site.setCatId(category.getCatId());
			site.setSiteName("My_Site_Name_" + site.getSiteId());
			site.setSiteURL("http://foobar.com/foobar");
			site.setNotes("My_Site_Notes_" + site.getSiteId());
			site.setSiteLogin("Login_Name_" + site.getSiteId());
			site.setModDate(new Date());

			try {
				byte[] salt = user.getSalt();
				String str = "Password_" + site.getSiteId();
				site.setPassword(PasswordEncryptionService
						.getEncryptedPassword(str, salt));
			} catch (NoSuchAlgorithmException nsa) {
				nsa.printStackTrace();
			} catch (InvalidKeySpecException ikse) {
				ikse.printStackTrace();
			}
			
			siteList.add(site);

		}
		pwdUserModel.setSiteList(siteList);
		
	}
	
	@GET
	@Produces({"application/json"})
	public PasswordUserModel getPwdUserModel()
	{
		return pwdUserModel;
		
	}
	
	
}
