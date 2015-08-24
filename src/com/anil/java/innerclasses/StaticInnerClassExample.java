package com.anil.java.innerclasses;

public class StaticInnerClassExample {
	/**
	 * Static inner classes behave as non-inner classes
	 * @author anil.al
	 *
	 */
	static class B2 {void goB2() { System.out.println("hi 2"); } }
	  public static void main(String[] args) {
	    BigOuter.Nest n = new BigOuter.Nest();   // both class names
	    n.go();
	    B2 b2 = new B2();     // access the enclosed class
	    b2.goB2();
	  }
}

class BigOuter {
	  static class Nest {void go() {System.out.println("hi"); } }
	}
