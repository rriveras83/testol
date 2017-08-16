package mx.com.jrrs.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import mx.com.jrrs.controller.CustomerController;

import javax.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/services")
public class JerseyConfiguration extends ResourceConfig {
	public JerseyConfiguration() {
		register(CustomerController.class);
	}
}
