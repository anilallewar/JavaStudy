/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.declarationsAccessControl.varargs;

/**
 *
 * @author Anil Allewar
 */
public class VarArgsTest {

    /**
     * This method takes a variable length arguments and returns an integer which
     * is multiplication of the passed vararg argument
     * @param ops
     * @param x
     * @return int
     */
    public int multiply(char ops, int... x){
        
        int result=1;
        
        switch(ops){
            case 'A':
                for (int i=0; i< x.length; i++){
                    result *=x[i];
                }
                break;
            case 'B':    
                for (int i=0; i< x.length; i++){
                    result *=(x[i]*2);
                }
                break;
            default:
                return 9999;
        }
        return result;        
    }
    
    public static void main(String[] args){
        VarArgsTest va = new VarArgsTest();
        System.out.println("Calling multiply with multiply('A',2, 4, 6) and result is: " + va.multiply('A',2, 4, 6));
        System.out.println("Calling multiply with multiply('B',200, 400, 60000) and result is: " + va.multiply('B',200, 400, 60000));
        System.out.println("Calling multiply with multiply('A',3,15) and result is: " + va.multiply('A',3,15));
        System.out.println("Calling multiply with multiply('C',2) and result is: " + va.multiply('C',2));
    }
}
