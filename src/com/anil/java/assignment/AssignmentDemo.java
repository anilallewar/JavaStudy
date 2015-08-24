/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.assignment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Anil Allewar
 */
class Number{
	int i;
}
public class AssignmentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number n1 = new Number();
		Number n2 = new Number();
		n1.i=30;
		n2.i=65;
		System.out.println("The original values are N1.i: "+n1.i + " and N2.i: "+n2.i);
		n1.i =n2.i;
		System.out.println("The values after assigning n1.i =n2.i are N1.i: "+n1.i + " and N2.i: "+n2.i);
		n1.i=85;
		System.out.println("The values after assigning n1.i=85 are N1.i: "+n1.i + " and N2.i: "+n2.i);
		n2=n1;
		System.out.println("The values after assigning n2=n1 are N1.i: "+n1.i + " and N2.i: "+n2.i);
		System.out.println("The original reference in N2 holding the value 65 is overwritten during assignment and effectively \n" + 
				"lost. Its object will be cleaned up by the garbage collector \n" +
				"Now both N1 and N2 point to the same object and change in any of them will affect the same object");
		n2.i=100;
		System.out.println("The values after assigning n2.i=100 are N1.i: "+n1.i + " and N2.i: "+n2.i);
		n1.i=200;
		System.out.println("The values after assigning n1.i=200 are N1.i: "+n1.i + " and N2.i: "+n2.i);
		changeNumber(n1);
		System.out.println("The values after calling changeNumber(n1) are N1.i: "+n1.i + " and N2.i: "+n2.i);
		float f = (float)n1.i;
		System.out.println("The values after converting n1 to float is: "+f );
		f = f/943.0f;
		System.out.println("The values after converting n1 to float is and dividing: "+f );
		n1.i = n1.i/1043;
		System.out.println("The values after calling 'n1.i = n1.i/1043' are N1.i: "+n1.i + " and N2.i: "+n2.i);
		System.out.println("The integer divison truncates rather than round");
		
		System.out.println("The converted date is: " + getConvertedAS400Date(null));
	}

	static void changeNumber(Number number){
		number.i=999;
	}
	
	public static long getConvertedAS400Date(Date passedDate){
		String returnValue=null;
		
		Calendar cal = Calendar.getInstance();
		
		if (passedDate!=null){
			cal.setTime(passedDate);
		}
	
		/**
		 * Return the value in the format 1DDMMYY where 1 denote the era part of year i.e. whether AD or BC.
		 * The day, month and year values are picked from the passed date<br>
		 * 	1. The first day of the month has value 1. <br>
		 * 	2. The first month of the year is JANUARY which is 0; the last depends on the number of months in a year. <br>
		 * 	3. The year is calender specific value
		 */
		returnValue= "1" + (cal.get(Calendar.YEAR)<10 ? "0" + cal.get(Calendar.YEAR):""+ cal.get(Calendar.YEAR)) +
		((cal.get(Calendar.MONTH)+ 1)<10 ? "0" + (cal.get(Calendar.MONTH)+1):""+ (cal.get(Calendar.MONTH)+1))+
		(cal.get(Calendar.DAY_OF_MONTH)<10 ? "0" + cal.get(Calendar.DAY_OF_MONTH):""+ cal.get(Calendar.DAY_OF_MONTH));	
	
		SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
		returnValue = "1" + format.format(cal.getTime());
		
		return Long.parseLong(returnValue);
	}
}

