/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.declarationsAccessControl.test;

/**
 * 
 * @author Anil Allewar
 */
class PublicClass {

	// This will give a run time error if you try to run NoPublicClass
	public static void main(String[] args) {
		System.out.println("The command line arguments passed are");
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		inner i = new inner();
		System.out.println("Data returned by inner is: " + i.senddata());
		System.out.println("Calling method specific to inner class");
		i.innerMethod();
		outer o = new outer();
		System.out.println("Data returned by outer is: " + o.senddata());
		System.out.println("Calling method specific to outer class");
		o.outerMethod();

		if (i instanceof outer) {
			System.out.println("i instanceof outer returns TRUE");
		} else {
			System.out.println("i instanceof outer returns FALSE");
		}

		i = o;
		System.out.println("Data returned by by pointing outer to inner is: "
				+ i.senddata());
		System.out
				.println("The following methods are available by pointing outer to inner is:");
		i.innerMethod();

		// Will not work because the reference is for inner. Compiler error
		// Symbol not found
		// i.outerMethod();

		if (i instanceof inner) {
			System.out
					.println("i instanceof inner returns TRUE after pointing outer to inner");
		} else {
			System.out
					.println("i instanceof inner returns FALSE after pointing outer to inner");
		}

		if (o instanceof inner) {
			System.out.println("o instanceof inner returns TRUE");
			outer o1 = (outer) i;
			System.out
					.println("Accessing methods after type casting the inner class to outer variable");
			o1.outerMethod();
			System.out.println();
			System.out
					.println("THIS PROVES THAT THE METHOD VISIBILTY IS BASED ON THE TYPE OF REFERENCE VARIABLE AND NOT WHAT IT IS POINTING TO");
		} else {
			System.out.println("o instanceof inner returns FALSE");
		}
	}
}

interface SendData {
	int senddata();
}

class inner implements SendData {
	private int x = 5;

	public int senddata() {
		return x;
	}

	public void innerMethod() {
		System.out.println("I am the inner class method!!");
	}
}

class outer extends inner {
	private int x = 10;

	public int senddata() {
		return x;
	}

	public void outerMethod() {
		System.out.println("I am the outer class method!!");
	}
}
