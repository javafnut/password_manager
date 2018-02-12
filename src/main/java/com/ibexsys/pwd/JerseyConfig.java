package com.ibexsys.pwd;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.ibexsys.pwd.util.PasswordProfileStaticREST;

@Component
@ApplicationPath("/pwdmanager")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(PasswordProfileStaticREST.class);
	}

}
