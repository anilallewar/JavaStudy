package com.anil.java.strings;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class LocaleExample {

	public void checkLocaleDate() throws java.text.ParseException{
		
		//Print default date
		Calendar c = Calendar.getInstance(Locale.getDefault());
		
		System.out.println("The default Locale is: " + Locale.getDefault().getDisplayCountry() + ":" + Locale.getDefault().getDisplayLanguage());
		
		System.out.println("The default Locale is: " + Locale.getDefault().getDisplayCountry() + ":" + Locale.getDefault().getDisplayVariant());
		
		c.set(2010, 5, 3); //3rd June 2010
		
		Date d = c.getTime();
		
		System.out.println("The date in default locale is: " + d.toString());
		
		Locale loPi = new Locale("pt"); //Portugese
		
		DateFormat dfPT = DateFormat.getDateInstance(DateFormat.LONG, loPi);
		
		//Gives unparsable date error
		//d = DateFormat.getDateInstance().parse("07/10/96");
		
		System.out.println("Portugese: " + dfPT.format(d));
		
		Locale loIN = new Locale("hi", "in"); //Checking India
		
		DateFormat dfIN = DateFormat.getDateInstance(DateFormat.LONG, loIN);
		
		System.out.println("Indian: " + dfIN.format(d));
		
		Locale locBR = new Locale("pt", "BR");  // Brazil
		Locale locDK = new Locale("da", "DK");  // Denmark
		Locale locIT = new Locale("it", "IT");  // Italy

		System.out.println("default for Brazil: " + locBR.getDisplayCountry());
		System.out.println("Country called in Brazil as: " + locBR.getDisplayCountry(locBR));
		System.out.println("Country called in Italy as: " + locBR.getDisplayCountry(locIT));
		
		System.out.println("defualt for Denmark:  " + locDK.getDisplayLanguage());
		System.out.println("Danish language called in Denmark as: " + locDK.getDisplayLanguage(locDK));
		System.out.println("Danish language called in Italy as: " + locDK.getDisplayLanguage(locIT)); 

	}
	
	public void checkNumberFormat(){
		float f = 67573.786f;
		
		//French Locale
		Locale locFR = new Locale("fr");
		
		NumberFormat[] nfa = new NumberFormat[4];
		//Default locale instances
		nfa[0] = NumberFormat.getInstance();
		nfa[1] = NumberFormat.getCurrencyInstance();
		//French locale instance
		nfa[2] = NumberFormat.getInstance(locFR);
		nfa[3] = NumberFormat.getCurrencyInstance(locFR);
		
		nfa[1].setMaximumFractionDigits(5);
		
		try{
			//Using enhanced for loop
			for (NumberFormat nf : nfa){
				System.out.println("The formatted number is: " + nf.format(f));
				System.out.println("The Maximum Fraction Digits allowed is: " + nf.getMaximumFractionDigits());
				//ParseException is thrown if the number cannot parsed as a currency
				System.out.println("Result after parsing 324.7809 is: " + nf.parse("324"));
				nf.setParseIntegerOnly(true);
				//ParseException is thrown if the number cannot parsed as a currency
				System.out.println("Result after parsing 324 and setting ParseIntergerOnly to true is: " + nf.parse("324.7809"));
			}
		}catch (java.text.ParseException pe){
			System.out.println("Got ParseExcepton in checkNumberFormat() method: " + pe.getMessage());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws java.text.ParseException {
		// TODO Auto-generated method stub

		LocaleExample locExple = new LocaleExample();
		locExple.checkLocaleDate();
		locExple.checkNumberFormat();
	}

}
