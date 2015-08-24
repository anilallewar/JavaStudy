/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.declarationsAccessControl.test;

/**
 *
 * @author hp
 */
public class OtherProtected extends TestProtected {
    
    public void writeProtected(){
        TestProtected tp = new TestProtected();
        //Wont compile because the protected member becomes private in subclass
        //System.out.println("Accessing TestProtected protected member:" + tp.x);
        
        //Accessible because the protected variable is inherited in the tree
        System.out.println("The protected variable is: " + x);
        //Calling method that has same name as class
        
        OtherProtected('a');
    }
    
    public static void main(String[] args){
        OtherProtected op = new OtherProtected();
        System.out.println("in OtherProtected");
        op.writeProtected();
    }

    private void OtherProtected(char c){
        System.out.println("Inside the method with the same name as the class:" + this.getClass().getName());
    }
}
