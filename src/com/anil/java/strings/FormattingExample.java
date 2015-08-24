/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.strings;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 
 * @author Anil Allewar
 */
public class FormattingExample {

	public void checkDateFormatting() {
		Date d1 = new Date(1000000000000L); // One trillion
		System.out.println("The date in the  default format is: "
				+ d1.toString());

		Calendar c = Calendar.getInstance();
		c.setTime(d1);

		System.out
				.println("The first day of the week as per current locale is: "
						+ c.getFirstDayOfWeek());

		c.add(Calendar.MONTH, 3);
		Date d2 = c.getTime();

		System.out.println("The date after addding 3 months is: "
				+ d2.toString());

		System.out
				.println("The difference with the roll method is that other larger parts of date do NOT get changed");

		c.roll(Calendar.MONTH, 9);
		Date d3 = c.getTime();

		System.out.println("The date after rolling 9 months is: "
				+ d3.toString());
		
		System.out.println((int)(Math.random() * 100));
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale(
				"it")); // Italian

		System.out.println("The date after formatting in Italian locale is: "
				+ df.format(d3));

		String s = df.format(d2);

		System.out
				.println("The 2nd date after formatting in Italian locale is: "
						+ s);

		System.out
				.println("Trying to parse the string back to date. Need to have the code in try...catch");

		/*
		 * Getting the date in desired format as a String 
		 */
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calObj = new GregorianCalendar(new GregorianCalendar().get(Calendar.YEAR), Calendar.JANUARY, 1);
		                        
		System.out.println("The calender corresponding to first of the year is: " + format.format(calObj.getTime()));
		
		try {
			Date d4 = df.parse(s);
			System.out.println("The date after parsing the date is: "
					+ d4.toString() + ".Note that there is loss of precision");
		} catch (ParseException pe) {
			System.out.println("Got ParseException while parsing date: "
					+ pe.getMessage());
		}

		GregorianCalendar cal = new GregorianCalendar();
		System.out.println(cal.get(Calendar.YEAR));
	}

	public static void main(String[] args) {
		FormattingExample fe = new FormattingExample();
		fe.checkDateFormatting();
	}
}
