package com.anil.java.strings;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenizingExample {

	public ArrayList checkWithString(String toBeChecked, String delimiter){
		
		ArrayList list = new ArrayList();
		if (toBeChecked == null)
			return null;
		String[] tokens = toBeChecked.split(delimiter);
		for (String i:tokens){
			list.add(i);
		}
		
		return list;
	}
	
	public ArrayList checkWithScanner(String toBeChecked, String delimiter){
		
		ArrayList list = new ArrayList();
		boolean b;
		int i;
		String s;
		
		if (toBeChecked == null)
			return null;
		Scanner s1 = new Scanner(toBeChecked);
		s1.useDelimiter(delimiter);
		
		while (s1.hasNext()){
			if(s1.hasNextBoolean()){
				b=s1.nextBoolean();
				//System.out.println("Got boolean:" + b);
				list.add(b);//Autoboxing
			}else if (s1.hasNextInt()){
				i=s1.nextInt();
				//System.out.println("Got int:" + i);
				list.add(i);
			}else{
				s=s1.next();
				//System.out.println("Got String:" + s);
				list.add(s);
			}
		}
		
		return list;
	}
	
	/**
	 * format string elements you'll need to know for the exam:
	 * arg_index An integer followed directly by a $, this indicates which argument should be printed in this position.
	 * flags While many flags are available, for the exam you'll need to know:<br><br>
	 * 
	 * "-" Left justify this argument<br>
	 * " + " Include a sign (+ or -) with this argument<br>
	 * "0" Pad this argument with zeroes<br>
	 * "," Use locale-specific grouping separators (i.e., the comma in 123,456)<br>
	 * "(" Enclose negative numbers in parentheses<br><br>
	 * 
	 * <b>width</b> This value indicates the minimum number of characters to print. (If you want nice even columns, you'll use this value extensively.)<br><br>
	 * 
	 * <b>precision</b> For the exam you'll only need this when formatting a floating-point number, and in the case of floating point numbers, 
	 * precision indicates the number of digits to print after the decimal point.<br><br>
	 * 
	 * <b>conversion</b> The type of argument you'll be formatting. You'll need to know:<br><br>
	 * 
	 * b boolean<br>
	 * c char<br>
	 * d integer<br>
	 * f floating point<br>
	 * s string
	 *
	 */
	public void checkFormatting(){
		int i1 = -123;
		int i2 = 12345;
		//All the formatting methods are added to the PrintStream class
		System.out.printf(">%1$(7d< , >%2$(7d< \n", i1, i2);
		System.out.printf(">%0,7d< \n", i2);
		System.out.format(">%+-7d< \n", i2);
		System.out.printf(">%2$b + %1$5d< \n", i1, false);
		System.out.printf("%b", 123); 
		System.out.printf ("%f", 123.45); 
		System.out.printf("%s", new Long("123")); 
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TokenizingExample tokExmple = new TokenizingExample();
		//ArrayList a = tokExmple.checkWithString("anil,all,ewar,789", ",");
		
		//Note that contiguous digits created an empty token
		ArrayList a = tokExmple.checkWithString("anil,all,ewar,7798hk789789", "\\d");
		for (Object s: a){
			System.out.println((String)s);
		}
		
		System.out.println("New pattern");
		
		//Note that the . operator has to be escaped 2 times- 1st so that regex engine does not consider it
		//as a metacharacter and the second because \. is not a valid java escape character
		a = tokExmple.checkWithString("htg.7868\".kjhk.786h7..j", "\\.");
		for (Object s: a){
			System.out.println((String)s);
		}
		
		a = tokExmple.checkWithScanner("AircraftReport::MapCollectionDataSource", "::");
		
		System.out.println("Displaying the results using boxing/unboxing");
		//Should do auto boxing/unboxing
		for (Object s: a){
			System.out.println(s);
		}
		
		System.out.println();
		
		StringTokenizer stringTokenizer = new StringTokenizer("AircraftReport::MapCollectionDataSource", "::");
		
		while(stringTokenizer.hasMoreTokens()){
			System.out.println("StringTokenozer Output: " + stringTokenizer.nextToken());
		}
		tokExmple.checkFormatting();
		
		//Testing boxing example
		String s = "-";
	    Integer x = 343;
	    long L343 = 343L;
	    if(x.equals(L343)) s += ".e1 ";
	    if(x.equals(343)) s += ".e2 ";
	    Short s1 = (short)((new Short((short)343)) / (new Short((short)49)));
	    System.out.println(s1+ ":"+ Short.MAX_VALUE+":"+ Short.MIN_VALUE);
	    if (s1 == 7)       s += "=s ";
	    if(s1 < new Integer(7+1)) s += "fly ";
	    System.out.println(s);

	}

}
