/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.declarationsAccessControl.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

/**
 * 
 * @author Anil Allewar
 */
public class TestDivide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float d = 10f / 0;
		if (d == Double.POSITIVE_INFINITY) {
			System.out.println("Positive");
		} else {
			System.out.println("Negative");
		}
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.NEGATIVE_INFINITY);
		System.out.println(new Character('\u597d').toString());

		Calendar calender = Calendar.getInstance();
		calender.set(2012, Calendar.FEBRUARY, 14, 13, 34, 55);

		Calendar calender2 = Calendar.getInstance();
		calender2.set(2012, Calendar.FEBRUARY, 13, 23, 25, 20);

		System.out.println(calculateRoundedDoubleValue(Double.valueOf((calender
				.getTimeInMillis() - calender2.getTimeInMillis())
				/ ((double) (1000 * 60 * 60)))));
	}

	private static Double calculateRoundedDoubleValue(Double inputValue) {
		Double convertedValue = null;

		System.out.println("Passed value is: " + inputValue);

		if (inputValue != null) {
			// Need to use a BigDecimal to scale the percent to 2
			BigDecimal bigDecimalInstance = new BigDecimal(inputValue);
			bigDecimalInstance = bigDecimalInstance.setScale(2,
					RoundingMode.HALF_UP);
			convertedValue = bigDecimalInstance.doubleValue();
		}

		return convertedValue;

	}
}
