package com.anil.java.flowcontrol;

public class CommonExceptionExample {
	
	String s;
	int count=0;
	
	public void checkNullPointerException(){
		//Try to invoke a class level variable that would be explicitly initialized to NULL
		//Cannot use local variables as they have to be initialized before they can be used
		System.out.println(s.length());
	}
	
	public void checkStackOverFlow(){
		System.out.println("The current count is: "+ count);
		count++;
		try{
			checkStackOverFlow();
		}catch (StackOverflowError se){
			System.out.println("Got stack overflow error");
		}catch(OutOfMemoryError om){
			System.out.println("Got Out of Memory error");
		}catch(Exception e){
			System.out.println("Got exception");
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args){
		CommonExceptionExample comExpExmple = new CommonExceptionExample();
		
		//Check NULL pointer exception
		//comExpExmple.checkNullPointerException();
		
		//Check stach overflow
		comExpExmple.checkStackOverFlow();
	}
}
