package com.anil.java.flowcontrol;

public class AssertionExample {

	void noReturn() { }
	int aReturn() { return 1; }
	void go() {
	  int x = 1;
	  boolean b = true;

	  // the following six are legal assert statements
	  assert (x == 1);
	  assert(b);
	  assert true;
	  assert(x == 1) : x;
	  assert(x == 1) : aReturn();
	  assert(x == 1) : new String();

	  System.out.println("Reached through all the assertions");
	  
	  assert (x==2);
	  
	  System.out.println("Should never reach here If ASSERTION is ENABLED. By default its is disabled");
	  // the following six are ILLEGAL assert statements
	  /*
	  assert(x = 1);  // none of these are booleans
	  assert(x);
	  assert 0;
	  //assert(x == 1) : ;            // none of these return a value
	  assert(x == 1) : noReturn();
	  //assert(x == 1) : ValidAssert va;
	   * 
	   */
	}
	
	public static void main(String args[]){
		AssertionExample assertExmp = new AssertionExample();
		assertExmp.go();
	}
}
