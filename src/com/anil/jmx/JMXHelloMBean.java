/**
 * 
 */
package com.anil.jmx;

/**
 * A standard MBean is defined by writing a Java interface called <code>SomethingMBean</code>
 * and a Java class called <code>Something</code> that implements that interface. <br><br>
 * 
 * If it does NOT; i.e. lets say we rename this interface to JMXHelloM and have the implementing 
 * class as JMXHello, then the following exceptions are thrown <br><br>
 * 
 * <i>
 * NotCompliantMBeanException thrown: MBean class com.anil.jmx.JMXHello does not implement DynamicMBean, neither follows the Standard MBean conventions
 * javax.management.NotCompliantMBeanException: Class com.anil.jmx.JMXHello is not a JMX compliant Standard MBean) nor the MXBean conventions 
 * </i>
 * @author anila
 *
 */
public interface JMXHelloMBean {

	public String getName();
	public void setName(String name);
	
	public void sayHello();
	public int add(int x, int y);
	
	public int getCache();
	public void setCache(int cacheSize);
}
