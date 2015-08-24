package com.anil.java.ftp;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestFTP {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		URL url = new URL("ftp://alemailuser:AL3mailuser@10.10.11.6:22/readme.txt; type=i");
		URLConnection conn = url.openConnection();
		System.out.println("Connection opened");
		InputStream is = conn.getInputStream();
		/*
		System.out.println("The input stream is read");
		int i;
		while((i=is.read()) != -1){
			System.out.print(i);
		}
		*/
	}

}
