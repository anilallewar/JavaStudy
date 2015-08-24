/**
 * 
 */
package com.anil.jmx;

import java.util.Date;
import java.util.Queue;

/**
 * In the same way as for standard MBeans, an MXBean is defined by writing a Java 
 * interface called <code>SomethingMXBean</code> and a Java class that implements 
 * that interface. However, unlike standard MBeans, MXBeans do not require the Java 
 * class to be called <code>Something</code>. In other words the Java class can have 
 * any arbitary name.<br><br>
 * 
 * @author anila
 *
 */
public class QueueAnilSampler implements QueueSamplerMXBean {

	//Define using generics
	private Queue<String> queue;
	
	public QueueAnilSampler(Queue<String> queue){
		this.queue = queue;
	}
	
	/* (non-Javadoc)
	 * @see com.anil.jmx.QueueSamplerMXBean#clearQueue()
	 */
	public void clearQueue() {
		//Synchronize so that no other thread accesses the queue while it is being cleared
		synchronized (queue) {
			queue.clear();
		}
	}

	/* (non-Javadoc)
	 * @see com.anil.jmx.QueueSamplerMXBean#getQueueSample()
	 */
	public QueueSample getQueueSample() {
		synchronized (queue) {
			return new QueueSample(new Date(), queue.size(), queue.poll());
		}
	}

}
