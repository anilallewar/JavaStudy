/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.strings;

/**
 *
 * @author Anil Allewar
 */
public class StringBuilderExample {

      public static void main(String[] args){
          StringBuilder sb = new StringBuilder("abc");
          sb.append("def").reverse().insert(4, "----");
          System.out.println("The value in Stringbuilder after sb.append(\"def\").reverse().insert(4, \"----\") is: "+sb);
          System.out.println("The values of sb after sb.append(3.12345f)is: " + sb.append(3.12345f));
          
          StringBuilder sb1 = new StringBuilder("0123456789");
          System.out.println("The values of sb1 is: "+ sb1.toString()+ " and the value of sb1.delete(3, 6) is: " + sb1.delete(3, 6));
          System.out.println("The value of sb1.insert(4, 34.67)is: " + sb1.insert(4, 34.67));
          
          sb1.append("abc\n");
          System.out.println(sb1+":::::::::::"+sb1.toString()+"::::::::::::");
      }  
}
