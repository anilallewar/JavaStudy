/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.collections;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Anil Allewar
 */
public class CollectionsSetExample {
    public static void main(String[] args){
        //TreeSet s = new TreeSet();
        HashSet s = new HashSet();
        boolean b[] = new boolean[5];
        b[0] = s.add("a");
        b[1]=s.add("b");
        b[2] = s.add(new Integer(23));
        b[3] = s.add("b");
        b[4] = s.add(new Object());
        
        for(boolean b1:b){
            System.out.print(b1 + " ");
        }
        
        System.out.println();
        System.out.println("The set contents are");
        
        Iterator i = s.iterator();
        while(i.hasNext()){
            System.out.println(i.next().toString());
        }
        
        System.out.println("Using a TreeSet will give exception because the type of objects\n" +
                    "stored in the TreeSet must be mutually comparable, but Integer and String\nare NOT mutually comparable");
    }
}
