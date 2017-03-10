package com.ibexsys.pwd;

import javax.ws.rs.ApplicationPath;

import com.ibexsys.pwd.test.CustomerResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/pwdmanager")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(CustomerResource.class);
	}

}
