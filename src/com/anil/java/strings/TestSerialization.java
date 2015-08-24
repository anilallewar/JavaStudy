package com.anil.java.strings;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialization {
	  public static void main(String[] args) {
	    SpecialSerial s = new SpecialSerial() ;
	    try {
	      ObjectOutputStream os = new ObjectOutputStream(
	         new FileOutputStream("myFile"));
	      os.writeObject(s);  os. close();
	      //It is ok to use + all by itself as addition of one string variable will convert it
	      //to a concatenation operator 
	      System.out.print( + + s.z);
	      System.out.println(+ + + + + + + s.y + "");

	      ObjectInputStream is = new ObjectInputStream(
	         new FileInputStream("myFile"));
	      SpecialSerial s2 = (SpecialSerial)is.readObject();
	      is.close();
	      //The transient variable will be initialized to default value(0 in case of int)
	      System.out.println(s2.y + " " + s2.z);
	    } catch (Exception x) {System.out.println("exc"); }
	  }
}

class SpecialSerial implements Serializable {
	  transient int y = 7;
	  static int z = 9;
	}
