/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.java.overriding;

/**
 *
 * @author Anil Allewar
 */
public class TestVariableShadowing {

    public final static void main(String... args) {
        S1 s1 = new S1();
        S2 s2 = new S2();

        System.out.println(s1.s);
        System.out.println(s1.getS());
        System.out.println(s2.s);
        System.out.println(s2.getS());
        s1.display();
        s2.display();
        //Assign the sub class object to the super class reference
        s1=s2;
        //Since variables are resolved at compile time, they are linked to the type of reference that 
        //the variable is holding. Hence in this case, S1's s string will be printed
        System.out.println(s1.s);
        //However method invocation happens at runtime and hence the method called will depend on the 
        //actual object that is being referred to.
        System.out.println(s1.getS());
    }
}

class S1 {

    String s = "S1";

    public String getS() {
        return "Return Super class " + s;
    }
    
    void display(){
        System.out.println("Super class " + s);
    }
}

class S2 extends S1{

    String s = "S2";
    //If we comment out this method, then the super class method will be called
    //which would have reference to the super class variable only
    
    public String getS() {
        return "Return Sub class " + s;
    }
        
    @Override
    void display(){
        super.display();
        System.out.println("Sub class " + s);
    }
}
