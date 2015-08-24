/**
 * 
 */
package com.anil.jmx;

import java.beans.ConstructorProperties;
import java.util.Date;

/**
 * This class is converted to a CompositeDataSupport instance by the MXBean framework
 * so that the client is not dependant on this class for using the MBean.<br><br>
 * 
 * If you had defined QueueSampler as a standard MBean rather than as an MXBean, 
 * JConsole would not have found the QueueSample class because it would not be in its class path.
 * 
 * @author anila
 */
public class QueueSample {

	private final Date date;
	private final int size;
	private final String head;
	
	
	/**
	 * 
	 * The general principle is for simple types such as int or String to remain unchanged, 
	 * while complex types such as <code>QueueSample</code> get mapped to the standard type 
	 * <code>CompositeDataSupport</code>.<br><br> 
	 * 
	 * In the QueueSample class, the MXBean framework calls all the getters in 
	 * QueueSample to convert the given instance into a CompositeData instance 
	 * and uses the <b>@ConstructorProperties</b> annotation to reconstruct a QueueSample 
	 * instance from a CompositeData instance.<br><br> 
	 * 
	 * See link {@code java.beans.ConstructorProperties}
	 *  
	 * @param date
	 * @param size
	 * @param head
	 */
	@ConstructorProperties({"date", "size","head"})
	public QueueSample(Date date, int size, String head){
		this.date = date;
		this.size = size;
		this.head = head;
	}


	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}


	/**
	 * @return the head
	 */
	public String getHead() {
		return head;
	}
}
