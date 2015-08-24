/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.generics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Anil Allewar
 */
public class BadGenericsExample {
    //Legacy code intermingled with Generics code
    public void insert(List list){
        list.add("abc"); //Adding a String without knowing what would be the type of collection passed
    }
    
    public static void main(String[] args){
        //This is wrong. Both the generics type in the declaration and the object creation must be same 
        //LinkedList<Number> listOfIntegers = new LinkedList<Integer>();
        
        //However it works with arrys
        Number[] numbers = new Integer[3];
        
        LinkedList<Integer> listOfIntegers = new LinkedList<Integer>();
        
        listOfIntegers.add(3);
        listOfIntegers.add(56);
        //This will NO compile because we have declared the type of LinkedList to be Integer
        //listOfIntegers.add("abc");
        BadGenericsExample badExample = new BadGenericsExample();
        //Allows us to pass a type safe collection to a non-type safe argument
        badExample.insert(listOfIntegers); 
        //Iterate through the list..this will give a class cast exception
        for(Integer i1:listOfIntegers){
            System.out.println(i1.intValue());
        }
    }
}