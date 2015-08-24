/**
 * 
 */
package com.anil.jmx;

/**
 * An MXBean is a type of MBean that references only a predefined set of data 
 * types. In this way, you can be sure that your MBean will be usable by any 
 * client, including remote clients, without any requirement that the client 
 * have access to model-specific classes representing the types of your MBeans. <br><br>
 * 
 * MXBeans provide a convenient way to bundle related values together, without requiring 
 * clients to be specially configured to handle the bundles<br><br>
 * 
 * The annotation <b>@MXBean</b> can be also used to annotate the Java interface, instead 
 * of requiring the interface's name to be followed by the MXBean suffix.
 *  
 * @author anila
 *
 */
public interface QueueSamplerMXBean {
	/**
	 * Defines an attribute called queueSample 
	 * @return
	 */
	public QueueSample getQueueSample();
	
	/**
	 * Defines an operation clearQueue on the MXBean
	 */
	public void clearQueue();
}
