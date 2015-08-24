package com.anil.java.jndi;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class RemoteJNDILookUp {

	public final static String JNDI_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";

	public void doLookup() throws NamingException {
		Properties jndiProps = new Properties();
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
		jndiProps.put(Context.PROVIDER_URL, "remote://134.132.100.29:4447");
		// create a context passing these propertiesContext
		InitialContext ctx = new InitialContext(jndiProps);
		// Note that for remote JNDI lookups the client always starts with
		// java:jboss/exported/ namespace and we don't provide it here
		Object object = ctx.lookup("Northwind");
	}

	public static void main(String[] arg) {
		RemoteJNDILookUp jndiLookup = new RemoteJNDILookUp();
		try {
			jndiLookup.doLookup();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
