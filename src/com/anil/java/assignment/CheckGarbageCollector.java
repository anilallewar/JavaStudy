/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.assignment;

import java.util.Date;

/**
 *
 * @author Anil Allewar
 */
public class CheckGarbageCollector {
    
    public static void main(String[] args){
        Runtime rt = Runtime.getRuntime();
        System.out.println("Max JVM memory that can be used:" + rt.maxMemory() + " and the long MAX value is:" + Long.MAX_VALUE);
        System.out.println("Total JVM memory:" + rt.totalMemory());
        System.out.println("Current free memory:" + rt.freeMemory());
        System.out.println("Running loop for memory usage");
        for (int i=0; i<400; i++){
            Date d = new Date();
            //d=null;//It is ok if we set to NULL because the variable is eligible for GC once we come out of the loop
            //rt.gc();
            //System.out.println("Current free memory after running garbage collector:" + rt.freeMemory() + " for iteration: " + i);
        }
        System.out.println("Current free memory after loop:" + rt.freeMemory());
        rt.gc();
        System.out.println("Current free memory after running garbage collector:" + rt.freeMemory());
    }

}
