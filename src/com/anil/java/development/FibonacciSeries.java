/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.development;

import javax.swing.JOptionPane;

/**
 *
 * @author Anil Allewar
 */
public class FibonacciSeries {
    public static void main(String[] args)
    {  
       String input = JOptionPane.showInputDialog("Enter n: ");
       int n = Integer.parseInt(input);
 
       int f = fibWithoutRecursion(n);
       System.out.println("fib(" + n + ") = " + f);
       
       System.exit(0);
       
    }
 
    /**
       Computes a Fibonacci number.
       @param n an integer
       @return the nth Fibonacci number
    */
    public static int fib(int n)
    {  
        System.out.println("n is:" + n);
       if (n <= 2)
            return 1;
       else 
            return fib(n - 1) + fib(n - 2);
    }
    
    /**
       Computes a Fibonacci number.
       @param n an integer
       @return the nth Fibonacci number
    */
    public static int fibWithoutRecursion(int n)
    {  
        System.out.println("n is:" + n);
        
        int value1=1, value2=1;
        int result=0;
       if (n <= 2)
            return value1;
       else {
            for(int i=3;i<=n;i++){
                result=value1+value2;
                value1=value2;
                value2=result;
            }
       }    
        return result;
    }

}
