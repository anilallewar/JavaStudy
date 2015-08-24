/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.declarationsAccessControl.enumexample;

/**
 *
 * @author Anil Allewar
 */
public class EnumExample {
    CoffeeSize size;
    
    public static void main( String[] args){
        EnumExample e1 = new EnumExample();
        System.out.println("About to initialize BIG");
        e1.size = CoffeeSize.BIG;
        
        EnumExample e2 = new EnumExample();
        System.out.println("About to initialize OVERWHELMINING");
        e2.size=CoffeeSize.OVERWHELMINING;
        
        EnumExample e3 = new EnumExample();
        //Will give an incompatible types compile error because 
        //only the enum type can be assigned to a enum variable
        //e3.size=5;
        System.out.println("About to initialize LARGE");
        e3.size=CoffeeSize.LARGE;
        
        System.out.println("Printing out the ounces and lid with each enum");
        System.out.println("Enum with CoffeeSize.BIG:" +  CoffeeSize.BIG);
        System.out.println("Ounces: "+e1.size.getOunces() );
        System.out.println("Lid: " + e1.size.getLid());
        System.out.println("Enum with CoffeeSize.OVERWHELMINING");
        System.out.println("Ounces: "+e2.size.getOunces());
        System.out.println("Lid: " + e2.size.getLid());
        System.out.println("Enum with CoffeeSize.LARGE");
        System.out.println("Ounces: "+e3.size.getOunces());
        System.out.println("Lid: " + e3.size.getLid());
    }
}

enum CoffeeSize {BIG(8), LARGE(8),OVERWHELMINING(24){
    	//The getLid() method is overridden for the OVERWHELMINING enum type
		public int getLid(){
            return 4;
        }
    }; //semi colon required if enum has a body   
    
    private int ounces;
    
    CoffeeSize(int ounces){
        System.out.println("Inside CoffeeSize constructor with size: " +ounces);
        this.ounces = ounces;
    }

    public int getLid(){
        return 2;
    }
    
    public int getOunces(){
        return this.ounces;
    }
}     

    