/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.assignment;

/**
 *
 * @author Anil Allewar
 */
public class CastingExample {

    //Array initialization
    int[] array1;
    int array2[] = new int[10];
    
    private void ByteAdd(){
        byte a =3;
        //compiles as 3 can fit into a byte even though the literal by default is an int
        byte b = 7; 
        //Following wont compile because int-or-smaller expression always result in an int
        //byte c = a + b; 
        
        //This wont compile because a is cast to byte but b still remains an int
        //byte c = (byte) a + b;
        
        //The explicit casting of the result to byte will compile
        byte c =(byte)(a+b);
        System.out.println("The result of (byte)(a+b) is: " +c);       
        
        //b+=23 compiles because an implicit cast is used for assignement operators
        //+=, -+, *= and /=
        System.out.println("The result of b+=123; is: " +(b+=123));       
       
        System.out.println("The uninitialized array1 is: "+array1);

        System.out.println("The initialized int array2 with default values is:");
        
        for(int i=0; i<array2.length; i++){
            System.out.println("Element " + i + " is:" +array2[i]);
        }
    }
    
    private void OverFlowTest(){
        //Cannot assign 128 to a byte because of the overflow and it needs to be explicitly cast leading 
        //to loss in precision
        byte a = (byte)128;
        
        System.out.println("The result of (byte)128 is: " +a);       
        
        System.out.println("The result of (byte) 130L is: " +(byte) 130L);
        
        float f = 48764.78F;
        short s = (short)f;
        
        System.out.println("The result of (short)f 48764.78F is: " +s);
    }
    
    private void testLocalInitialization(String passed){
        int x;
        if (array1 !=null){
            x=7;
        }
        //Follwing does not compile because the compiles does not know if x has been initialized or not
        //System.out.println(x);
        
        String s1 = "anil";
        String s2=s1;
        //A brand new string object is created and then discarded after this call
        s2.toUpperCase();
        System.out.println("String s2 is: "+s2 +" and s2.toUpperCase() is: " + s2.toUpperCase());
        System.out.println("String s1 is: " + s1 + " and String s2 is: "+s2);
        s2=s1+ "Allewar";
        
        System.out.println("String s1 is: " + s1 + " and String s2 is: "+s2);
        System.out.println("Even when we change the string referenced by 2 variables, still only the assigned \n" +
                " variable gets changed. This is because any time we make any change to a string, the JVM \n" +
                "will update the reference variable to refer to a different object");
        
        System.out.println("The passed value is: " + passed);
        //Won't work as we cannot reassign a new reference to the object parameter variable
        passed = passed.toUpperCase();
        //passed = new String("New");
        //This is because you cannot MODIFY the reference that the object variable is referring to,
        //but you can assign a new reference to the same object
        System.out.println("The passed value after assigning it to new reference variable is: " + passed);
        
        x =20;
        System.out.println("The value of x is: " + x);
        x = x++ + ++x;
        System.out.println("The value of x after x = x++ + ++x is: " + x);
        System.out.println();
    }
    
    public static void main(String args[]){
        CastingExample castExmple = new CastingExample();
        castExmple.ByteAdd();
        castExmple.OverFlowTest();
        castExmple.testLocalInitialization("I Am passing");
    }
}
