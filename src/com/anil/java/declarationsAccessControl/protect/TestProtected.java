/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.declarationsAccessControl.protect;

/**
 *
 * @author hp
 */
public class TestProtected extends ProtectedSample{
    public static void main(String args[]){
        TestProtected test = new TestProtected();
        test.callProtected();
        //Checking if private method can be overridden
        test.doStuff(23);
    }

    public void callProtected(){
        System.out.println("The value of protected variable x is:" +x); //works because x is inherited
        
        // Call the sub class by creating an instance of super class
        ProtectedSample ps = new ProtectedSample();
        //This method call WILL compile as the protected variable behaves as an default
        //variable when called using the instance reference in the same package.
        //However it is only inherited in case of subclass in other package
        System.out.println("The value of protected variable x after calling thru super class is:" +ps.x);
        //Checking out if private varible is accessible via a public getter method in superclass
        System.out.println("The value of PRIVATE variable Y after calling thru super class is:" +ps.getY());
        
    }
    
    /**
     * Since it is a private method, it is not overridden from the superclass
     * @param z
     * @return
     */
    private int doStuff(int z){
        System.out.println("Inside the private doStuff method of :" + this.getClass().getName() + " and value of argument is:" + z);
        return z;
    }
}