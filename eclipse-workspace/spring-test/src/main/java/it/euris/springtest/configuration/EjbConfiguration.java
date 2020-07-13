package it.euris.springtest.configuration;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.euris.testspringejb.JsonPlaceholderServiceRemote;

@Configuration
public class EjbConfiguration {
	
	@Bean   
	public Context context(@Value("${java.naming.provider.url}") String namingProviderUrl) throws NamingException {
	    Properties jndiProps = new Properties();
	    jndiProps.put("java.naming.factory.initial", "org.jboss.naming.remote.client.InitialContextFactory");
	    jndiProps.put("jboss.naming.client.ejb.context", true);
	    jndiProps.put("java.naming.provider.url", namingProviderUrl);
	    return new InitialContext(jndiProps);
	}

	@Bean
	public JsonPlaceholderServiceRemote jsonPlaceholderServiceRemote(Context context, @Value("${ejb.jsonplaceholder}") String ejbUrl) 
	  throws NamingException {
	 
	    return (JsonPlaceholderServiceRemote) 
	      context.lookup(ejbUrl);
	} 
}
