package com.anil.java.flowcontrol;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ExceptionExample {

	public int checkException() throws NullPointerException, IOException{
		//int i=0;
		Throwable t = new Throwable();
		
		int i =1;
		try{
			int j = 0/i;
			System.out.println("Reached the try block end. value of j is: " + j);
			if (j==0)
				return j; //The finally block gets called even after return statement
			System.out.println("After the return statement");
			
			//Throw new exception and check if finally gets executed
			throw new NullPointerException();
		}catch(ArithmeticException ae){
			System.out.println("The exception is: " + ae.getMessage());
			ae.printStackTrace(System.err);
		}
		/*
		 * Gives compiler error if anything is placed in between try, catch or finally blocks
		 */
		//System.out.println("After try and befor finally");
		finally{
			System.out.println("In the finally block of checkException method");
		}
		/*Error because finally has to be after last catch
		 * 
		 * catch(Exception e){}
		 */
		return i;
	}
	
	/*
	 * This method must declare that it throws an IOException( chceked) otherwise this will not compile.
	 * However it is not required to declare that the method thows NullPointerException as NullPointerException
	 * is a subclass of RunTimeException
	 * 
	 * Note that even if IOException is not thrown by the called method, it still has to be declared
	 * as it is a checked exception. 
	 */
	public int checkException2() throws IOException{
		return checkException();
	}
	
	public void checkInvalidExceptionPropagation(){
		/*
		 * Following code will not compile if IOException(the superclass) is placed
		 * above FileNotFoundException. This is because the FileNotFoundException is already caught 
		 * by the IOException.
		 */
		/*
		try {
			  // do risky IO things
			} catch (IOException e) {
			  // handle general IOExceptions
			} catch (FileNotFoundException ex) {
			  // handle just FileNotFoundException
			}
		*/	
		try {
				Thread.sleep(100);
                                RandomAccessFile raf = new RandomAccessFile("C:\\Anil Allewar\\Trainings\\Java\\Upgrade WAS to JRE1.4.txt1", "r");
				int data=0;
				while((data=raf.read()) != -1){
					System.out.print((char)data);
				}
			  // do risky IO things
			}catch (InterruptedException ie){
                            System.out.println("Got InterruptedException while calling Thread sleep method");
                        }catch (FileNotFoundException e) {
				// handle just FileNotFoundException
				System.out.println(("Caught FileNotFoundException"));
			} catch (IOException ex) {
				// handle general IOExceptions
				System.out.println(("Caught IOExceptions"));
			}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExceptionExample exceExmple = new ExceptionExample();
		try{
			//The exception is caught in the method and hence the next statement in this main() method executes
			exceExmple.checkInvalidExceptionPropagation();
			//This never gets printed because of the NullPointerException that is thrown by the checkException2() method
			System.out.println("The value returned is: " + exceExmple.checkException2());
		}catch (Throwable e){
			System.out.println("The exception caught by the main method is: "+ e.getMessage());
			e.printStackTrace();
		}finally{
			System.out.println("In the finally block of main() method");
		}
		/*
		 * Will not compile as main() method does not declare that it throws IOException
		 */
		//System.out.println("The value returned is: " + exceExmple.checkException2());
	}

}
