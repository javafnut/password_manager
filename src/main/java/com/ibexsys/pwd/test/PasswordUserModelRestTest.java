package com.ibexsys.pwd.test;


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

@Component
@Path("/testpwd")
public class PasswordUserModelRestTest {

	private static Map<Integer, PasswordUserModel> pwdUserDB = new ConcurrentHashMap<Integer, PasswordUserModel>();
	private static AtomicInteger idCounter = new AtomicInteger();
	
	static{
		
		PasswordUserModel pwdUserModel = new PasswordUserModel();
		
		
		
	}
	
}
