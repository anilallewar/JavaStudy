/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.java.flowcontrol;

/**
 *
 * @author Anil Allewar
 */
public class ForLoopExample {

    byte b;
    int y;
    final int z=y;
    //b = z;  
    {
        System.out.println("The value of b is: " + b + " and the value of z is: " + z);
        //Gives compile error as z is already assigned
        //z=33;
    }
    public static void main(String[] args) {

        long[] larray = {3L, 7L, 9L};

        //Primitive arrays can be assigned to only the arrays of the same 
        //primitive types. Only Object references arrays can be converted/cast
        //int[] iarray = larray;
        long[] iarray = larray;

        for (long l : larray) {
            System.out.println("Using boxing the array value is: " + l);
        }
        
        Long[] Longarray = {3L, 7L, 9L};
        System.out.println("Longarray instanceof Long[] returns true: " + (Longarray instanceof Long[]) + "but Longarray instanceof Long gives compile error");
        //Since the + operator is resolved from left to right, the addition occurs first and then the 
        //concatanation occurs
        System.out.println(1+2+"3");
        System.out.println("1"+2+3);
        
        //Instanticate an object of this class to call the instance initialization block
        ForLoopExample fle = new ForLoopExample();
    }
}
