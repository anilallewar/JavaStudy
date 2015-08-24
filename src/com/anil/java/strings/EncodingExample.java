package com.anil.java.strings;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		char array[]={'Í','b','c','d'}; // suppose this is our array of char
		//ÍA≈A…EÊAE∆AEÙ
		String s= URLEncoder.encode("123aAS$", "UTF-8");
		String s1 = URLDecoder.decode(s, "UTF-8");
		String str=new String(array);// converting char[] into string 
		byte barray[]=str.getBytes(); //converting string into byte 
		System.out.println(new String(s.getBytes("UTF-8"), "UTF-8"));
		System.out.println(s);
		System.out.println(s1);
	}

}
