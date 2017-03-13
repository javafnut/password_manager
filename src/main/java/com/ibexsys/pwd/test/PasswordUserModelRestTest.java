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

import com.ibexsys.pwd.model.AppUser;
import com.ibexsys.pwd.model.Category;
import com.ibexsys.pwd.model.PasswordUserModel;
import com.ibexsys.pwd.model.Site;

import com.ibexsys.pwd.services.PasswordEncryptionService;

@Component
@Path("/testpwd")
public class PasswordUserModelRestTest {

	private static AtomicInteger idCounter = new AtomicInteger();
	private static PasswordUserModel pwdUserModel = new PasswordUserModel();

	static {

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

		AppUser user = new AppUser();
		user.setUserId(1000);
		user.setFirstName("Todd");
		user.setLastName("Johnston");
		user.setEmail("foo@foobar.com");
		user.setSalt(lSalt);
		user.setPassword(lEncPwd);
		user.setCreatedDTM(new Timestamp(calendar.getTimeInMillis()));
		user.setModifiedDTM(user.getCreatedDTM());

		pwdUserModel.setAppUser(user);

		// Setup root category, all id's are set to ROOT_ID
		Category category = new Category();
		category.setCatID(Category.ROOT_ID);
		category.setChildID(Category.ROOT_ID); // ROOT is it's own child by
												// design
		category.setParentID(Category.ROOT_ID);
		category.setDescription(Category.ROOT_NAME);
		category.setUserID(pwdUserModel.getAppUser().getUserId());
		category.setName(Category.ROOT_NAME);
		category.setCreatedDTM(new Timestamp(calendar.getTimeInMillis()));
		category.setModifiedDTM(category.getCreatedDTM());

		try {
			pwdUserModel.addCategory(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// For now, setup 1evel deep

		for (int i = 0; i < NUM_CATEGORY_MAX; i++) {

			int id = 101 + i;
			Category cat = new Category();
			cat.setCatID(id);
			cat.setChildID(id);
			cat.setParentID(Category.ROOT_ID);
			cat.setDescription(id + "- Description");
			cat.setUserID(pwdUserModel.getAppUser().getUserId());
			cat.setName("Category - " + id);
			cat.setCreatedDTM(new Timestamp(calendar.getTimeInMillis()));
			cat.setModifiedDTM(category.getCreatedDTM());

			try {
				pwdUserModel.addCategory(cat);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		for (int j = 0; j < NUM_SITES_MAX_PER_CATEGORY; j++) {
			Site site = new Site();
			site.setSiteId(idCounter.incrementAndGet());
			site.setAppUserId(user.getUserId());
			site.setCatId(cat.getCatID());
			site.setSiteName("My_Site_Name_" + site.getSiteId());
			site.setSiteURL("http://foobar.com/foobar");
			site.setNotes("My_Site_Notes_" + site.getSiteId());
			site.setLogin("Login_Name_" + site.getSiteId());
			site.setCreateDTM(new Timestamp(calendar.getTimeInMillis()));
			site.setModifiedDTM(site.getCreateDTM());

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
				pwdUserModel.addSite(site);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		}
	}
	
	
	@GET
	@Path("/user")
	@Produces({"application/json"})
	public Response getAppUserInfo(){
		AppUser user = pwdUserModel.getAppUser();
		
	    return Response.ok().entity(user).type(MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/categories")
	@Produces({"application/json"})
	public Response getCategories(){
		Map<String,Category> catMap = pwdUserModel.getCategoryMap();
		return Response.ok().entity(catMap).type(MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/category/{id}")
	@Produces({"application/json"})
	public Response getCategory(@PathParam("id") String id){
		
		PasswordUserModel pwdModel = pwdUserModel;

		Category category = (Category) pwdModel.getCategoryMap().get(id);
		
		System.out.println(category.toString());
			
		return Response.ok().entity(category).type(MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/site/{id}")
	@Produces({"application/json"})
	public Response getSite(@PathParam("id") String id){
		PasswordUserModel pwdModel = pwdUserModel;
		Site site = (Site) pwdModel.getSitesMap().get(id);
		
		return Response.ok().entity(site).type(MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/sites")
	@Produces({"application/json"})
	public Response getSites(){
		PasswordUserModel pwdModel = pwdUserModel;
		Map<String,Site> sites = pwdModel.getSitesMap();
		
		return Response.ok().entity(sites).type(MediaType.APPLICATION_JSON).build();
	}
	

	// Static Dump
	@GET
	@Produces({ "application/json" })
	public Response getPwdUserModel() {
		PasswordUserModel pwdModel = pwdUserModel;
		return Response.ok().entity(pwdModel).type(MediaType.APPLICATION_JSON).build();

	}

	@GET
	@Path("/xml")
	@Produces({ "application/xml" })
	public Response getPwdUserModel2XML() {
		PasswordUserModel pwdModel = pwdUserModel;
		return Response.ok().entity(pwdModel).type(MediaType.APPLICATION_XML).build();

	}

}
