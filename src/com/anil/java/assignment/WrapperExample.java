/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.assignment;

/**
 *
 * @author Anil Allewar
 */
public class WrapperExample {

    Integer z;
    
    public int returnSum(int[] input){
        
        //Using multidimensional arrays
        
        int[][] multi = new int[2][]; //Valid since only the first dimension size is required while creation
        //Anonymous array creation
        multi[0] = new int[]{2,6}; //2nd dimension array size is provided while creating indvidual array objects
        
        multi[1]=new int[3];
        multi[1][0]=2; multi[1][1]=3; multi[1][2]=4;//multi[1][3]=4; // ArrayIndex is a runtime exception
        
        //Cannot assign array to new reference once it is constructed
        //int[][] multi={{10,11},{13,14,15}};
        
        //Array constants can only be used while initialization
        //multi={{10,11},{13,14,15}};
        
        for (int i=0; i< multi.length; i++){
            for (int j=0; j<multi[i].length; j++){
                System.out.println("The ["+i+"]["+j+"] element of multi array is: "+multi[i][j]);
            }
        }
        
        //Line 3 will give compilaton error if result is not intialized
        int result=0;
        for(int i=0; i<input.length; i++){
            result += input[i];
        }
        return result;
    }
    
    public void checkWrappers(){
        
        System.out.println("The results of Integer.toHexString(128): " + Integer.toHexString(128));
        System.out.println("The results of Integer.valueOf(12): " + Integer.valueOf(12).getClass().getName());
        System.out.println("The results of Integer.parseInt(\"123\",16): " + Integer.parseInt("123",16));
        
        //Boxing/unboxing example
        //Integer i = new Integer(2345);
        Integer i = 57868;
        Integer j = i;
        System.out.println("Value of i!=j is: " + (i!=j) + " and i==j is: " + (i==j) + " This is because they point to the same object \n " + 
        		"and object equals method returns true if they point to the same reference");
        System.out.println("Value of i.equals(j) is: "+i.equals(j));
        
        i++; //A new Integer object is created and assigned back to i
        System.out.println("i value: "+i +" and j value: "+j); //j continues to point to old object
        //Now they will be different objects since a new Integer wrapper was created and assigned to i 
        if (i!=j)
            System.out.println("Different objects");
        
        System.out.println("Checking for 2 Integer objects with value 23. They are same because java considers Short and Integers from -128 to 127 as the same objects");
        Integer x=23;
        Integer y = 23;
        System.out.println("Value of x==y is: " + (x==y));
        
        System.out.println("Checking for 2 Integer objects with value 1000. They are different because java considers Short and Integers from -128 to 127 as the same objects");
        Integer x1=128;
        Integer y1 = 128;
        System.out.println("Value of x1==y1 is: " + (x1==y1));
        
        //Try to use boxing without initializing wrapper. This will give run time
        //NullPointerException
        
        //z++;
        System.out.println("Z value is "+z);
    }
    
    //All these are overloaded methods that are used for studyig overloading with boxing
    //widening and varargs
    
    private void go(int i){
        System.out.println("Inside the int go() method");
    }
    
    private void go(long l){
        System.out.println("Inside the long go() method");
    }
    
    private void go(double d){
        System.out.println("Inside the double go() method");
    }
    
    private void go(byte... i){
        System.out.println("Inside the varargs byte go() method");
    }
    
    //All these methods check overloading with boxing and varargs
    
    private void goBoxing(long l){
        System.out.println("Inside the long goBoxing() method");
    }
    
    private void goBoxing(Integer i){
        System.out.println("Inside the Integer wrapper goBoxing() method");
    }
    
    private void goBoxing1(Long i){
        System.out.println("Inside the Long wrapper goBoxing1() method");
    }
    
    private void goBoxing1(Object o){
        System.out.println("Inside the Object goBoxing1() method");
        if (o instanceof Integer){
            System.out.println("Passed Integer object with value:" + ((Integer)o).intValue());
        }
        if (o instanceof Byte){
            System.out.println("Passed Byte object with value:" + ((Byte)o).byteValue());
        }
    }
    
    private void go(Byte b1, Byte b2){
        System.out.println("Inside the Byte b1, Byte b2 go() method");
    }
    
    //Check varargs with widening/boxing
    
    private void widen_varags(long... l){
        System.out.println("Inside the long... widen_varags method");
    }
   
     private void widen_varags(Integer... l){
        System.out.println("Inside the Integer... widen_varags method");
    }
    private void box_varags(Integer... l){
        System.out.println("Inside the Integer... box_varags method");
    }
    
    public void checkOverloading(){
        byte b =12;
        short s =13;
        long l =34;
        float f=23.7f;
        go(b);go(s);go(l); go(f); 
        go(b, (byte)38);
        go(b, (byte)38, (byte)39);
        goBoxing(3456);//passing an int parameter
        System.out.println("int cannot be passed to goBoxing1() method as widening with boxing is not allowed.\n" + 
                    "However boxing and then widening is allowed");
        goBoxing1(234L);//int cannot be passed to this method as widening with boxing is not allowed
        goBoxing1(2345);//Can pass the int to the object method as Java will firs box it to an Integer and then widen to Object
        goBoxing1((byte)2345);
        System.out.println("We conclude that widening beats auto-boxing while auto-boxing beats varargs");
        
        //Reference to widen_args is ambigous as both method match for int variable
        //widen_varags(5,5);
        Integer k = new Integer(23);
        //widen_varags(k);
        widen_varags((byte)34);
        
        box_varags(34,456,56);
    }
    
    public static void main(String[] args){
        WrapperExample wrapExample = new WrapperExample();
        wrapExample.returnSum(new int[] {23,24,25});
        wrapExample.checkWrappers();
        wrapExample.checkOverloading();
    }
}
