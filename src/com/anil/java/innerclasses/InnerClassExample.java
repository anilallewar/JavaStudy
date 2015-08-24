package com.anil.java.innerclasses;

public class InnerClassExample {
	
	private int x = 78;
	private String a = "Anil";
	private static String b = "static method call";
;	
	/**
	 * Calling the inner class from the outer class
	 *
	 */
	public void makeInner(){
		inner in = new inner();
		System.out.println("Calling via the makeInner() method");
		in.testOuter();
	}
	
	class inner{
		private int x= 45;
		public void testOuter(){
			System.out.println("The inner class x variable is: " + x + " and the outer variable is: " + InnerClassExample.this.x);
			System.out.println("The inner class is: " + this);
			System.out.println("The outer class is: " + InnerClassExample.this);
		}
	}
	
	public void checkInnerMethodClass(){
		final int y =45;
		class InnerMethodClass{
			public void doPrintA(){
				System.out.println("The string variable in the outer class is: " + a);
				System.out.println("The method variable is not accessed from within method level inner class unless it is FINAL: " + y);
			}
		}//end of class InnerMethodClass
		
		//Create a class instance and use it. This line must come after the class definition
		InnerMethodClass innerMethodClass = new InnerMethodClass();
		innerMethodClass.doPrintA();
		
	}//end checkInnerMethodClass()
	
	
	public static void checkInnerStaticMethodClass(){
		final int y =87;
		class StaticInnerMethodClass{
			public void doPrintA(){
				//This will not work with a as it is an instance variable and we can only access static variables from a static method
				System.out.println("The STATIC string variable in the outer class is: " + b);
				System.out.println("The method variable is not accessed from within method level inner class unless it is FINAL: " + y);
			}
		}//end of class InnerMethodClass
		
		//Create a class instance and use it. This line must come after the class definition
		StaticInnerMethodClass innerMethodClass = new StaticInnerMethodClass();
		innerMethodClass.doPrintA();
		
	}//end checkInnerMethodClass()
	/**
	 * Calling the inner class from some other class. Note that the inner class has default access
	 * @param args
	 */
	public static void main(String[] args) {
		
		InnerClassExample.inner fromOtherInner = new InnerClassExample().new inner();
		fromOtherInner.testOuter();
		
		//Create a outer class and call the method
		InnerClassExample in = new InnerClassExample();
		in.makeInner();
		System.out.println();
		in.checkInnerMethodClass();
		System.out.println();
		InnerClassExample.checkInnerStaticMethodClass();
		System.out.println();
		System.out.println("A method-local inner class can be instantiated only within the method where the inner class is defined.\n" + 
				"However, the inner class object cannot use the local variables of the method the inner class is in.");
                //Runnable r = new Runnable() {public void run{}}; -- THE RUN METHOD DOES NOT HAVE METHOD BRACES
                System.out.println(new Runnable() {public void run() { }}); 

	}

}


class Boo {
   Boo(String s) { }
   Boo() { }
}
class Bar extends Boo {
   Bar() { }
   Bar(String s) {super(s);}
   void zoo() {
   // insert code here
       Boo f = new Boo("aNIL") {}; 
   }
}

