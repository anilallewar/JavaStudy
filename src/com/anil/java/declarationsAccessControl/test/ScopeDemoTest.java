/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.declarationsAccessControl.test;

/**
 *
 * @author Anil Allewar
 */
class ScopeDemo {

	float f;
	double d;
	long l=10L;
	private static int sint;
	
	public ScopeDemo(){
		sint=200;
	}
	
	public void showScope(){
		int x=30;
		Integer a;
		//valid declaration even though literal calculation by default are carried out
		//by promoting them to int. This is so because 4*4 lies below the byte range
		byte b = 4*4;
		
		//Creating same class objects in the method
		ScopeDemo s = new ScopeDemo();
		
		System.out.println("The default values for member variables are 1. float:" + s.f + " 2.double:"+d+" 3.long:"+l);
		//compiler error - cannot convert from int to byte
		//b = 456;
		{
			int y=35;
			Integer z = new Integer(10);
			System.out.println("X is: "+x +" and Y is: "+y +" and Integer object is: " + z.intValue());
			a=z;
		}
		//System.out.print("X is: "+x +" and Y is: "+y); --Gives compile error
		System.out.println("X is: "+x +" and Y is not available and Integer object when pointed to method level variable is: " + a.intValue());
		System.out.println("The object exists as long as a reference is available and might be in memory even when no reference exists. The object memeory would be de-allocated by the garbage collecor");
		
		VarDemo v = new VarDemo();
		
		System.out.println("The storage in bytes taken up by 'anil' is :" + v.StringLength("Anil"));

	}
	public static int returnValue(){
		return sint;
	}
	
	public static int increment(){
		//showScope(); --Cannot make call to a non-static method from a static method
		ScopeDemo s = new ScopeDemo();
		s.showScope();
		return sint++;
	}
}

class ScopeDemoTest{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		//Examing static variable
		ScopeDemo s1 = new ScopeDemo();
		ScopeDemo s2 = new ScopeDemo();
		s1.showScope();
		System.out.println("The static variable value before incrementing is:"+  s1.returnValue()+ " and:" + s2.returnValue());
		ScopeDemo.increment();
		System.out.println("The static variable value AFTER incrementing is:"+  s1.returnValue()+ " and:" + s2.returnValue());
		//You can call a class that is created using a file not having a public class
		PublicClass pc = new PublicClass();
		String[] a = {"anil", "allewar"}; 
		//The main method is called using normal message passing and not by the compiler
		pc.main(a);
		//pc.main({"Anil"}); //compile error
	}

}

class VarDemo{
	
	public int StringLength(String s){
		return s.length()*2;
	}
}
