/**
 * 
 */
package com.anil.java.reflection;

/**
 * @author anila
 * 
 */
public class BarImpl implements Bar {
	public void hello(int i, String s) {
		System.out.println("   in com.anil.java.reflection.Bar.hello");
	}

	public void goodbye(String str, int i) {
		System.out.println("   in com.anil.java.reflection.Bar.goodbye");
	}
}
