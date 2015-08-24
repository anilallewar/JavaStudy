package com.anil.java.overriding;

public class TestVariableOverriding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		A b = new B();
		System.out.println(a.getClassName() + " has name:" + a.name);
		System.out.println(b.getClassName() + " has name:" + b.name);
		System.out.println("This indicates that there is no variable overriding...\nThe variables are accessible based on the type of reference variable");
	}

}

class A{
	String name="A";
	
	public String getName(){
		return name;
	}
	
	public String getClassName(){
		return "Class A";
	}
}

class B extends A{
	String name="B";
	
	public String getName(){
		return name;
	}
	
	public String getClassName(){
		return "Class B";
	}
}