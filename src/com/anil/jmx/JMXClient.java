/**
 * 
 */
package com.anil.jmx;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import javax.management.AttributeChangeNotification;
import javax.management.InstanceNotFoundException;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;

/**
 * @author anila
 * 
 */
public class JMXClient {

	JMXConnector jmxc = null;
	MBeanServerConnection conn = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JMXClient client = new JMXClient();
		client.process();
	}

	/**
	 * Inner class that will handle the notifications
	 * 
	 * @author anila
	 * 
	 */
	class ClientListener implements NotificationListener {
		/**
		 * Used to handle the events for which we register the object
		 */
		public void handleNotification(Notification notice, Object object) {
			System.out.println();
			System.out.println("Received Notification:");
			System.out.println("\tClassName: " + notice.getClass().getName());
			System.out.println("\tSource: " + notice.getSource());
			System.out.println("\tType: " + notice.getType());
			System.out.println("\tMessage: " + notice.getMessage());

			if (notice instanceof AttributeChangeNotification) {
				AttributeChangeNotification acn = (AttributeChangeNotification) notice;
				System.out
						.println("\tAttributeChangeNotification AttributeName: "
								+ acn.getAttributeName());
				System.out
						.println("\tAttributeChangeNotification AttributeValue: "
								+ acn.getAttributeType());
				System.out.println("\tAttributeChangeNotification Old Value: "
						+ acn.getOldValue());
				System.out.println("\tAttributeChangeNotification New value: "
						+ acn.getNewValue());
			}
		}
	}

	/**
	 * ' Public API to expose working of the class
	 */
	public void process() {
		this.jmxc = getConnection();
		//inspectMBeanServer(this.jmxc);
		//invokeMbean();
		//invokeMXBean();
		closeConnection();
	}

	/**
	 * Method to create a connection to the remote MBean Server
	 * 
	 * @return
	 */
	private JMXConnector getConnection() {

		JMXConnector jmxc = null;

		System.out.println("\nCreate an RMI connector client and "
				+ "connect it to the RMI connector server");
		try {
			// Create a Service URL..this defaults to localhost if no host is
			// provided

			/*
			 * 
			 * JMXServiceURL url = new
			 * JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
			 * 
			 * JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
			 */

			HashMap<String, String> environment = new HashMap<String, String>();

			environment.put(Context.INITIAL_CONTEXT_FACTORY,
					"com.sun.jndi.rmi.registry.RegistryContextFactory");
			environment
					.put(Context.PROVIDER_URL, "rmi://[192.168.40.146]:9999");

			JMXServiceURL url = new JMXServiceURL("rmi", "192.168.40.146",
					9999, "/jndi/jmxrmi");

			jmxc = JMXConnectorFactory.connect(url, environment);

			System.out.println("JMX connector created: " + jmxc);

			waitForEnterPressed();
			
			System.out.println("Sample connectionn to JBoss if its running");
			
			environment = new HashMap<String, String>();
			environment.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			environment.put(Context.PROVIDER_URL, "jnp://localhost:1099" );
			environment.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces" );

			url = new JMXServiceURL("rmi", "192.168.40.146",
					1099, "/jndi/jmx/rmi/RMIAdaptor");

			JMXConnector jmxcJBoss = jmxc = JMXConnectorFactory.connect(url, environment);
			
			System.out.println("JMX connector created: " + jmxcJBoss);

			waitForEnterPressed();

			
		} catch (MalformedURLException urlExp) {
			System.out.println("URL Malformed: " + urlExp.getMessage());
		} catch (IOException ioexp) {
			System.out.println("IO Exception: " + ioexp.getMessage());
		}
		return jmxc;
	}

	/**
	 * Method to inspect the MBeanServer for the attributes like registered
	 * domains etc
	 * 
	 * @param jmxc
	 */
	private void inspectMBeanServer(JMXConnector jmxc) {

		try {
			this.conn = jmxc.getMBeanServerConnection();
			System.out.println("Domains");

			String[] domains = conn.getDomains();
			Arrays.sort(domains);
			for (String domain : domains) {
				System.out.println("\tThe domain is: " + domain);
			}

			System.out.println("Mbean Server Default Domain: "
					+ conn.getDefaultDomain());

			System.out.println("MBean Count: " + conn.getMBeanCount());

			System.out.println("Query MBean Server Names");

			Set<ObjectName> names = conn.queryNames(null, null);

			for (ObjectName instance : names) {
				System.out.println("\tThe object instance is: "
						+ instance.getCanonicalName());
			}

			waitForEnterPressed();
		} catch (IOException ioe) {
			System.out.println("IO Exception while inspecting MBean Server: "
					+ ioe.getMessage());
		}
	}

	/**
	 * Method to create a RMI proxy to the Mbean and invoke methods on the proxy
	 */
	private void invokeMbean() {

		try {

			System.out.println("\n>>> Perform operations on Hello MBean <<<");
			// Create an instance to get handle to the remote MBean. Same as was
			// created by the JMXBeanDeployer
			ObjectName mbName = new ObjectName("com.anil.jmx:type=JMXHello");

			ClientListener listener = new ClientListener();

			// Create a dedicated proxy for the MBean instead of
			// going directly through the MBean server connection
			JMXHelloMBean mbeanProxy = JMX.newMBeanProxy(this.conn, mbName,
					JMXHelloMBean.class, true);

			// Add notification listener on Hello MBean
			System.out.println("\nAdd notification listener...");
			this.conn.addNotificationListener(mbName, listener, null, null);

			// Get CacheSize attribute in Hello MBean
			System.out.println("\nCacheSize = " + mbeanProxy.getCache());

			// Set CacheSize attribute in Hello MBean. Calling "reset" makes the
			// Hello MBean emit a
			// notification that will be received by the registered
			// ClientListener.
			mbeanProxy.setCache(150);

			// Sleep for 2 seconds to have time to receive the notification
			System.out.println("\nWaiting for notification...");
			Thread.sleep(2000);

			// Get CacheSize attribute in Hello MBean
			System.out.println("\nCacheSize = " + mbeanProxy.getCache());

			// Invoke "sayHello" in Hello MBean
			System.out.println("\nInvoke sayHello() in Hello MBean...");
			mbeanProxy.sayHello();

			// Invoke "add" in Hello MBean
			System.out.println("\nInvoke add(2, 3) in Hello MBean...");
			System.out.println("\nadd(2, 3) = " + mbeanProxy.add(2, 3));

			waitForEnterPressed();
		} catch (MalformedObjectNameException malONExp) {
			System.out.println("MalformedObjectNameException caught: "
					+ malONExp.getMessage());
		} catch (IOException ioe) {
			System.out.println("IOException caught: " + ioe.getMessage());
		} catch (InterruptedException ie) {
			System.out.println("InterruptedException caught: "
					+ ie.getMessage());
		} catch (InstanceNotFoundException infe) {
			System.out.println("InstanceNotFoundException caught: "
					+ infe.getMessage());
		}
	}

	private void invokeMXBean(){
        // ------------------------------
        // Manage the QueueSampler MXBean
        // ------------------------------

        System.out.println("\n>>> Perform operations on QueueSampler MXBean <<<");

        try {
            // Construct the ObjectName for the QueueSampler MXBean
            ObjectName mxbeanName =
                new ObjectName("com.anil.jmx:type=QueueAnilSampler");

            // Create a dedicated proxy for the MXBean instead of
            // going directly through the MBean server connection
            QueueSamplerMXBean mxbeanProxy =
                JMX.newMXBeanProxy(this.conn, mxbeanName, QueueSamplerMXBean.class);

            // Get QueueSample attribute in QueueSampler MXBean
            QueueSample queue1 = mxbeanProxy.getQueueSample();
            System.out.println("\nQueueSample.Date = " + queue1.getDate());
            System.out.println("QueueSample.Head = " + queue1.getHead());
            System.out.println("QueueSample.Size = " + queue1.getSize());

            System.out.println("\nAgain calling the getQueueSample()");
            queue1 = mxbeanProxy.getQueueSample();
            System.out.println("\nQueueSample.Date = " + queue1.getDate());
            System.out.println("QueueSample.Head = " + queue1.getHead());
            System.out.println("QueueSample.Size = " + queue1.getSize());
            
            // Invoke "clearQueue" in QueueSampler MXBean
            System.out.println("\nInvoke clearQueue() in QueueSampler MXBean...");
            mxbeanProxy.clearQueue();

            // Get QueueSample attribute in QueueSampler MXBean
            //
            QueueSample queue2 = mxbeanProxy.getQueueSample();
            System.out.println("\nQueueSample.Date = " + queue2.getDate());
            System.out.println("QueueSample.Head = " + queue2.getHead());
            System.out.println("QueueSample.Size = " + queue2.getSize());
        }catch (MalformedObjectNameException malONExp) {
			System.out.println("MalformedObjectNameException caught: "
					+ malONExp.getMessage());
		} 

        waitForEnterPressed();

	}
	/**
	 * Utilty method to have user press <Enter>
	 */
	private void waitForEnterPressed() {
		try {
			System.out.println("\nPress <Enter> to continue...");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void closeConnection() {
		if (this.jmxc != null) {
			try {
				jmxc.close();
			} catch (IOException ioe) {
				System.out.println("Exception while closing Connector: "
						+ ioe.getMessage());
			}
		}
	}
}
