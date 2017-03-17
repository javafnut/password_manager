package com.ibexsys.pwd.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;
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

import com.ibexsys.pwd.entities.AppUser;
import com.ibexsys.pwd.entities.Category;
import com.ibexsys.pwd.entities.PwdAppProfile;
import com.ibexsys.pwd.entities.Site;

import com.ibexsys.pwd.services.PasswordEncryptionService;

@Component
@Path("/testpwd")
public class PasswordProfileStaticREST {

	private static AtomicInteger idCounter = new AtomicInteger();
	private static PwdAppProfile appProfile = PwdAppProfile.getInstance();

	static {

		int NUM_SITES_MAX_PER_CATEGORY = 3;
		int NUM_CATEGORY_MAX = 5;

		String pwd = "()ThisIsATestPassword!@44";
		byte[] lSalt = null;
		byte[] lEncPwd = null;
		Random random = new Random();


		try {
			lSalt = PasswordEncryptionService.generateSalt();
			lEncPwd = PasswordEncryptionService.getEncryptedPassword(pwd, lSalt);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		appProfile.setProfileId(1000);
		appProfile.setLoginName("FooBarLogin");
		appProfile.setCreatedDTM(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		appProfile.setModifiedDTM(appProfile.getCreatedDTM());
		appProfile.setLastLoginDTM(appProfile.getCreatedDTM());

		AppUser user = new AppUser();
		user.setUserId(1000);
		user.setFirstName("Todd");
		user.setLastName("Johnston");
		user.setEmail("foo@foobar.com");
		user.setSalt(lSalt);
		user.setPassword(lEncPwd);
		user.setCreatedDTM(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		user.setModifiedDTM(user.getCreatedDTM());

		appProfile.setAppUser(user);
		appProfile.setAppUserId(user.getUserId());


		// Setup root category, all id's are set to ROOT_ID
		Category category = new Category();
		category.setCatID(user.getUserId());
		category.setChildId(Category.NO_ID); // ROOT is it's own child by
												// design
		category.setParentId(category.getCatID());
		category.setDescription(Category.ROOT_NAME);
		category.setName(Category.ROOT_NAME);
		category.setCreatedDTM(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		category.setModifiedDTM(category.getCreatedDTM());
		
		appProfile.setRootId(category.getCatID());

		try {
			appProfile.addCategory(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// For now, setup 1evel deep

		for (int i = 0; i < NUM_CATEGORY_MAX; i++) {

			Integer id = new Integer(101 + i);
			Category cat = new Category();
			cat.setCatID(id);
			cat.setChildId(id);
			cat.setParentId(Category.NO_ID);
			cat.setDescription(id + "- Description");
			cat.setName("Category - " + id);
			cat.setCreatedDTM(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			cat.setModifiedDTM(category.getCreatedDTM());

			try {
				appProfile.addCategory(cat);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		for (int j = 0; j < NUM_SITES_MAX_PER_CATEGORY; j++) {
			Site site = new Site();
			site.setSiteId(new Integer(idCounter.incrementAndGet()));
			site.setAppUserId(user.getUserId());
			site.setCatId(cat.getCatID());
			site.setSiteName("My_Site_Name_" + site.getSiteId());
			site.setSiteURL("http://foobar.com/foobar");
			site.setNotes("My_Site_Notes_" + site.getSiteId());
			site.setLogin("Login_Name_" + site.getSiteId());
			site.setCreatedDTM(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			site.setModifiedDTM(site.getCreatedDTM());

			try {
				byte[] salt = user.getSalt();
				String str = "Password_" + site.getSiteId();
				site.setPassword(PasswordEncryptionService.getEncryptedPassword(str, salt));
			} catch (NoSuchAlgorithmException nsa) {
				nsa.printStackTrace();
			} catch (InvalidKeySpecException ikse) {
				ikse.printStackTrace();
			}

			try {
				appProfile.addSite(site);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		  }
		}
	}
	
	@GET
	@Produces({"application/json"})
	public Response getUserAppProfile(){

		PwdAppProfile pwdModel = appProfile;	
		
     return Response.ok().entity(pwdModel).type(MediaType.APPLICATION_JSON).build();
     
	}
	
	
	@GET
	@Path("/appProfile")
	@Produces({"application/json"})
	public Response getUserAppProfileInfo(){

		PwdAppProfile pwdModel = appProfile;	
		
     return Response.ok().entity(pwdModel).type(MediaType.APPLICATION_JSON).build();
     
	}
	
	
	
	@GET
	@Path("/user")
	@Produces({"application/json"})
	public Response getAppUserInfo(){
		AppUser user = appProfile.getAppUser();
		
	    return Response.ok().entity(user).type(MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/categories")
	@Produces({"application/json"})
	public Response getCategories(){
		Map<String,Category> catMap = appProfile.getCategoryMap();
		return Response.ok().entity(catMap).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/category/{id}")
	@Produces({"application/json"})
	public Response getCategory(@PathParam("id") String id){
		
		PwdAppProfile pwdModel = appProfile;

		Category category = (Category) pwdModel.getCategoryMap().get(id);
		
		System.out.println(category.toString());
			
		return Response.ok().entity(category).type(MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/site/{id}")
	@Produces({"application/json"})
	public Response getSite(@PathParam("id") String id){
		PwdAppProfile pwdModel = appProfile;
		Site site = (Site) pwdModel.getSitesMap().get(id);
		
		return Response.ok().entity(site).type(MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/sites")
	@Produces({"application/json"})
	public Response getSites(){
		PwdAppProfile pwdModel = appProfile;
		Map<String,Site> sites = pwdModel.getSitesMap();
		
		return Response.ok().entity(sites).type(MediaType.APPLICATION_JSON).build();
	}
	

//	// Static Dump
//	@GET
//	@Produces({ "application/json" })
//	public Response getPwdUserModel() {
//		PwdAppProfile pwdModel = appProfile;
//		return Response.ok().entity(pwdModel).type(MediaType.APPLICATION_JSON).build();
//
//	}

	@GET
	@Path("/xml")
	@Produces({ "application/xml" })
	public Response getPwdUserModel2XML() {
		PwdAppProfile pwdModel = appProfile;
		return Response.ok().entity(pwdModel).type(MediaType.APPLICATION_XML).build();

	}

}
