package com.anil.java.threads;

public class ExtendingThreadExample extends Thread {

	public void run(){
		System.out.println("I am instanticated using a new thread..and my name is: " + this.getName());
		System.out.println("The child Thread is: " + Thread.currentThread().getName());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		ExtendingThreadExample extendThread = new ExtendingThreadExample();
		extendThread.start();
		Thread.sleep(10000);
		System.out.println("The main Thread is: " + Thread.currentThread().getName());
	}
}
