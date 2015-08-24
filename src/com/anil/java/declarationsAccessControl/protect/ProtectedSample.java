/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.declarationsAccessControl.protect;

/**
 *
 * @author hp
 */
public class ProtectedSample {
    protected int x=10;
    
    private int y =100;
    
    //Final variable needs to be initialized in the constructor; else compiler errors
    private final int a;

    public ProtectedSample() {
        a=22;
    }
    
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    private int doStuff(int z){
        System.out.println("Inside the private doStuff method of :" + this.getClass().getName() + " and value of argument is:" + z);
        return z;
        //Set the final variable. Got cannot assign a value to a final variable
        //a=z;
    }
}
