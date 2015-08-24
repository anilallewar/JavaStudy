/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.overriding;

/**
 *
 * @author Anil Allewar
 */
public class PrivateOverriding {
    public static void main(String args[]){
        Super s = new Super();
        s.hi();
        System.out.println("The returned value by calling super class object is: " + s.returnValue());
        Derived d = new Derived();
        d.hi();
        s=d;
        s.hi();
        //Call the super class method which is not overridden in the derived class
        //This will call the class's own private copy of returnPrivateValue().
        
        //However if the returnPrivateValue() method is made public is sub class
        //then the call will call the sub class returnPrivateValue() method 
        System.out.println("The returned value is: " + s.returnValue());
    }
}

class Super{
    public void hi(){
        hello();
    }
    
    private void hello(){
        System.out.println("In super class Hello() method");
    }
    
    public int returnValue(){
        return returnPrivateValue();
    }
    
    /**
     * If the returnPrivateValue() method is marked public then the call from 
     * returnValue() will be resolved at run time and will call the sub class
     * implementation of the method
     * @return
     */
    public/*private*/ int returnPrivateValue(){
        return 10;
    }
}

//If you have class with the same name, then java gives a duplicate class error at RUNTIME
//no compile errors are reported
//class Super{

class Derived extends Super{
    
    //Commenting out both the methods will cause the sub class object to call
    //the super class hi() method which in turn will call the super class private 
    //hello method
    /**/
    public void hi(){
        try{
            hello();
        }catch (Exception e){}
    }
    /*/
    
    /**
     * This method does not overide the super class hello() as is evident from the
     * fact that this method declares a new checked exception that it throws.
     * 
     * The super class private method is not accessible in this class and hence cannot be overridden
     */ 
    
    private void hello() throws Exception{
        System.out.println("In derived Sub class Hello() method");
    }
    /**/
    
    public int returnPrivateValue(){
        return 20;
    }
}