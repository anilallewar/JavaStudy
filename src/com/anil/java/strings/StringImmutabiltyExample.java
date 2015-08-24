/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.strings;

/**
 *
 * @author Anil Allewar
 */
public class StringImmutabiltyExample {
    
    public void checkStrings(){
        String x ="Anil";
        System.out.println("The original String is: "+ x);
        x.concat(" Allewar");
        System.out.println("The String after x.concat(Allewar)is: "+ x + 
                " . Notice that it has not changed because a new String object was created by the JVM " +
                "but it was not referenced by any variable");
        System.out.println();
        //Assign the newly created reference variable to the old String variable.
        x=x.concat(" Allewar");
        System.out.println("The String after x=x.concat(Allewar)is: "+ x + 
                " . Notice that it HAS changed because a new String object was created by the JVM " +
                "but its reference was assigned to the previously variable. The original String referenced by x is lost");
        System.out.println();     
        System.out.println("The anonymous String creation works in Sysout because we use the newly created String in the println" +
                    "However the newly created String is lost once the println executes: " + x.toUpperCase());
        System.out.println();     
        System.out.println("The unchanged String after the call to x.toUpperCase() is:" + x);     
    }   
    
    public void StringFunctions(){
        
        System.out.println();
        String x = "Anil Allewar";
        System.out.println("The string is: "+x);
        System.out.println("The method x.charAt(2) returns back characters based on zero based index. The values of x.charAt(2) is: "+ x.charAt(2));
        
        System.out.println("The second argument in x.substring(0, 8) is the length of substring.\n Hence this will return substring from 0 position to (8-1) 7th position:" + x.substring(0, 8));
        System.out.println("The values of x.subString(5) is: "+x.substring(5));
        System.out.println("The value of x.toString() is: "+ x.toString());
    }
    
    public static void main(String[] args){
        StringImmutabiltyExample strImmtExpl = new StringImmutabiltyExample();
        strImmtExpl.checkStrings();
        strImmtExpl.StringFunctions();
    }
}
