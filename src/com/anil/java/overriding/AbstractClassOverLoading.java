/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.overriding;

/**
 *
 * @author Anil Allewar
 */

abstract class AbstractBaseClass{

    public String name;
    
    AbstractBaseClass(String name) {
        this.name = name;
        System.out.println("In Abstract super class constructor with name: "+ this.name);
    }
    
    abstract int AbstractBaseClass(int y) throws UnsupportedOperationException;
    
    public void printMessage(){
        System.out.println("I am in base abstract class printMessage() method");
    }
}

class AbstractConcreteClass extends AbstractBaseClass{

    //If you do not provide the constrctor or provide constructor with no arguments
    //the compiler will complain because the default call to super() cannot be resolved
    
    public AbstractConcreteClass(String name) {
        super(name);
    }

    //Call the static method before call to this. This will call the same class constructor 
    //with the String argument
    
    public AbstractConcreteClass(){
        this(makeRandomName());
    }
    
    private static String makeRandomName(){
        int a = (int)(Math.random() * 5); //This will generate a random integer between 0 and 4
        return new String[] {"aa", "bb", "cc","dd", "ee"}[a];
    }
    
    int AbstractBaseClass(int y) {
        return ((int)(y* Math.random()));
    }   
}

public class AbstractClassOverLoading {

        //main() method can be defined without the String[] argument and it will be considered another
        //method in the class and not the entry point of execution
        public static final void main(String args[]){
            AbstractBaseClass base = new AbstractConcreteClass("Anil");
            System.out.println("The call using abstract class reference is:" + base.AbstractBaseClass(89));
            base.printMessage();
            
            AbstractConcreteClass derived = new AbstractConcreteClass();
            //Will call the abstract class printMessage()method
            derived.printMessage();
            //Call the overidden method
            System.out.println("The call using concrete class reference is:" + derived.AbstractBaseClass(56));
        }
}
