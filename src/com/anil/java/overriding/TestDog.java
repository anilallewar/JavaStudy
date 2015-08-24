/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.overriding;

import java.io.IOException;

/**
 *
 * @author Anil Allewar
 */

class Animal{
    void makeNoise(){
        System.out.println("Generic base noise method");
    }
}

class Dog extends Animal{
    
    //Check if exceptions can be added. Java gives compile time error if new
    //exceptions are added or made broader in overriding methods
    //void makeNoise() throws IOException{
    
    //The compiler also throws errors if incompatible return types are used while overriding
    //int makeNoise(){
    
    void makeNoise(){
        System.out.println("Dog barks");
        //Compiler error - void method cannot return a value
        //return null;
        return;
    }
    
    //However it is possible to overload methods with added exceptions or changed return types
    //The only certainity for overloading is that the argument list must change either in order, or 
    //in argument types or in number of arguments
    String makeNoise(String noise) throws IOException{
        System.out.print(noise);
        return noise;
    }
    
    public Dog doIt(){
        //Below statement does NOT work because a Dog-is-a-animal and not the other way around
        //i.e. every animal is NOT a dog
        //return new Animal();
        
        return new Dog();
    }
    
     void playDead(){
             System.out.println(this.getClass().getName() + " :Roll over to play dead");
     }
}
public class TestDog {
    
    public static void main(String [] args){
     
        Animal [] a = { new Animal(), new Dog(), new Animal()};
        
        //New for loop for iterating through object arrays
        for (Animal animal:a){
            //The call to makeNoise method is resolved at run time based on overriding
            animal.makeNoise();
            if (animal instanceof Dog){
                //Will not compile because the reference is for Animal and animal does not
                //have a playDead() method
                //animal.playDead();
                
                //Downcasting to enable call to playDead
                Dog d=(Dog) animal;
                d.playDead();
            }
        }
        Animal animal = new Animal();
        //Compiles because the compiler only checks for type compability
        // Will fail at run time with class cast exception
        Dog d = (Dog)animal; 
        //Call dog specific method. This will fail at run time because this Dog is actually referring
        //to a Animal and Animal does not have the playDead method
        d.playDead();
    }
}
