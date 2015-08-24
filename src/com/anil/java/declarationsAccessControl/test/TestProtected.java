/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.declarationsAccessControl.test;

import com.anil.java.declarationsAccessControl.protect.ProtectedSample;
/**
 *
 * @author hp
 */
public class TestProtected extends ProtectedSample{
    public static void main(String args[]){
        TestProtected test = new TestProtected();
        test.callProtected();
    }

    public void callProtected(){
        System.out.println("The value of protected variable x accessed through inheritance is:" +x); //works because x is inherited
        
        // Call the sub class by creating an instance of super class
        ProtectedSample ps = new ProtectedSample();
        //This method call will not compile as the protected variable behaves as an private
        //variable when called using the instance reference 
        //System.out.println("The value of protected variable x after calling thru super class is:" +ps.x);
        System.out.println("Cannot access the protected variable when called using the instance reference");
    }
}
