/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.flowcontrol;

/**
 *
 * @author Anil Allewar
 */
public class LoopExample {
    
    enum COLOR { RED, GREEN, YELLOW }
    
    public void enumSwitch(COLOR c1){
        if (c1==null)
            c1 = COLOR.GREEN;
        switch(c1){
            case GREEN:
                System.out.println("The COLOR is GREEN");
                break;
            case RED:
                System.out.println("The COLOR is RED");
                break;
            case YELLOW:
                System.out.println("The COLOR is YELLOW");
        }
    }
    public void testSwitch(){
        long l = 100L;
        //Gives compiler error as only anything that can be implicitly cast to int and enum are 
        //valid expressions
        //switch(l){
        final char ch='h';
        //Define a final variable and not initialized it.
        //This implies that the variable is not compile time constant
        final char ch1;
        ch1='a';
        System.out.println("Testing switch with character value");
        switch (ch){
            case 'a':
                System.out.println("Value is: " + ch);
                break;
            case 'c':
                System.out.println("Value is: " + ch);
                break;
            case 'C':
                System.out.println("Value is: " + ch);
            default:
                System.out.println("Value is: default");
            case 256:
                System.out.println("Value is: " + 256);
            case Character.MAX_VALUE:
                System.out.println("Value is: " + Character.MAX_VALUE);
            //Gives error as the case value is above the char range
            /*
            case 556789:
                System.out.println("Value is: " + 5556789);
            */
            //Gives error because ch1 cannot be resolved to a constant     
            /*
            case ch1:
                System.out.println("Value is: " + ch1);
            */        
        }
    }

    public void testWhileAndDo(){
        int x =3;
        while(x<5){
            System.out.println("X value is: "+x);
            x++;
        }
        System.out.println("Now testing with the DO loop");
        //This will execute at least once evn though the condition in the while loop is not true
        do{
            System.out.println("X value is: "+x);
            x++;
        }while(x<5); //Semi colon is mandatory at end
        //Gives incompatible types compiler error because the assignment evaluates to a int and not boolean
        /*
        while(x=2){
            
        }
         */
    }
    
    public static void main(String[] args){
        LoopExample lpExmple = new LoopExample();
        lpExmple.testSwitch();
        lpExmple.enumSwitch(COLOR.RED);
        COLOR c1 = COLOR.YELLOW;
        lpExmple.enumSwitch(c1);
        lpExmple.testWhileAndDo();
    }
}
