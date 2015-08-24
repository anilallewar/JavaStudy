package com.anil.java.development;

import static java.lang.System.out;
//Cannot static import the class but only static members within the class
import static java.lang.Integer.*; 
//Test to see if using wildcard import sub packages are also imported
import java.util.*;

/**
 *
 * @author Anil Allewar
 */
public class TestStaticImports {
    //As of Java 5 the main method can also be passed a vararg argument
    public static void main(String... args){
        //This will print the MAX_VALUE static constant but we do not have to append Class name to it
        out.println(MAX_VALUE);
        out.println(toHexString(32));
        
        //Same thing using normal imports
        System.out.println("Using normal java: " + Integer.MAX_VALUE);
        System.out.println("Using normal java: " + Integer.toHexString(32));
        
        System.out.println("The imported date class from imported java.util.* package is: " + new Date());
        System.out.println("Cannot access classes from the java.util.regex package unless it is imported separately");
    }
}
