/**
 * 
 */
package com.anil.jmx;

import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 * This class is used to deploy the managed JMX bean to the MBeanSerber.<br><br>
 * 
 * The Mbean can then be managed through any JMX agent like the JConsole
 * agent provided with JDK.<br><br>
 * 
 * For JDK prior to JDK 6, launch the class with the following parameter<br>
 * 		<code>java -Dcom.sun.management.jmxremote com.anil.jmx.JMXBeanDeployer</code><br><br>
 * 
 * Any application that is started in the Java SE 6 HotSpot VM is detected 
 * automatically by JConsole, and does not need to be started using the above 
 * command-line option. 
 * 
 * @author anila
 *
 */
public class JMXBeanDeployer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		//Get the Platform MBeanServer; if none exists a new one is created
		MBeanServer mbServer = ManagementFactory.getPlatformMBeanServer();
		
		try {
			//Define the Object Name that is used to identify the MBean. Every JMX MBean must have an object name.
			//Consists of 2 parts; a domain and a set of comma-sparated property values
			ObjectName mName = new ObjectName("com.anil.jmx:type=JMXHello");
			
			JMXHelloMBean hello = new JMXHello();
			
			mbServer.registerMBean(hello, mName);
			
			//Create a new MXBean and register it
			ObjectName mxname = new ObjectName("com.anil.jmx:type=QueueAnilSampler");
			
			Queue<String> queue = new ArrayBlockingQueue<String>(10);
			queue.add("Record 1");
			queue.add("Record 2");
			queue.add("Record 3");
			
			QueueSamplerMXBean queueBean = new QueueAnilSampler(queue);
			
			mbServer.registerMBean(queueBean, mxname);
			
			System.out.println("Waiting forever..this coould also be done with an infinite loop");
			
			Thread.sleep(Long.MAX_VALUE);
			
			//Now launch this class and open JConsole and invoke methods on this Mbean
			//The messages will appear on this console
			
			
		}catch (MalformedObjectNameException objectNameExp){
			System.out.println("MalformedObjectNameException thrown: " + objectNameExp.getMessage());
		}catch (NotCompliantMBeanException nonComliantExp){
			System.out.println("NotCompliantMBeanException thrown: " + nonComliantExp.getMessage());
		}catch (InstanceAlreadyExistsException instanceExistsExp){
			System.out.println("InstanceAlreadyExistsException thrown: " + instanceExistsExp.getMessage());
		}catch (MBeanRegistrationException registrationExp){
			System.out.println("MBeanRegistrationException thrown: " + registrationExp.getMessage());
		}catch (InterruptedException interruptedExp){
			System.out.println("InterruptedException thrown: " + interruptedExp.getMessage());
		}
	}
}
