/**
 * 
 */
package com.anil.java.reflection;

/**
 * @author anila
 * 
 */
public class TestAspectProxying {

	public static void main(String[] args) {
		Bar bar = (Bar) TraceProxy.newInstance(new BarImpl());
		bar.hello(2001, "xxx");
		bar.goodbye("yyy", 2002);
	}
}
