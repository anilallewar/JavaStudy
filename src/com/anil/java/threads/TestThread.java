/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.java.threads;

/**
 *
 * @author Anil Allewar
 */
public class TestThread {

    public static synchronized void main(String[] args) throws
            InterruptedException {
        Thread t = new Thread();
        t.start();
        System.out.print("X");
        t.wait(10000);
        System.out.print("Y");
    }
}
