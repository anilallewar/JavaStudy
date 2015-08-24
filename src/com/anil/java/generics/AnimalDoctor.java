/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anil Allewar
 */
public class AnimalDoctor {
    
    private void checkAnimalsWithArrays(Animal[] animals){
        for (Animal a : animals){
            a.checkUp();
        }
        //This will work with Dog[] but fail with other sub types of Animal
        //An ArrayStoreException will be thrown; however there is no equivalent exception for collections
        animals[1] = new Dog("Cheating");
    }
    
    /**
     * The method will be ueful only if we tell the compiler that the method will accept any subtype
     * of Animal and you wont be doing any modifications to the Collection. The method will NOT compile
     * if you try any modification on the passed list
     * 
     * The keyword <code>extends</code> in the context of a wildcard represents BOTH subclasses and interface implementations. 
     * There is no <? implements Serializable> syntax.
     * @param animals
     */
    private void checkAnimalsWithGenerics(List<? extends Animal> animals){
        for (Animal a : animals){
            a.checkUp();
        }
       //Gives a very meaningful message for the error that we cannot modify the List
       //animals.add(new Dog("Clover"));
    }
    
    /**
     * If you pass in a list of type Animal, then it's perfectly fine to add a Dog to it. 
     * If you pass in a list of type Dog, it's perfectly fine to add a Dog to it. And if 
     * you pass in a list of type Object, it's STILL fine to add a Dog to it. 
     * @param animals
     */
    private void checkSuperWithGenerics(List<? super Dog> animals){
        //Can add a Dog to the Collecton as we declared that the collection can hold only Dog
        //or any of its supertypes
        animals.add(new Dog("Clover"));
    }
    
    public void checkWithGenerics(){
        List<Dog> listOfDogs = new ArrayList<Dog>();
        listOfDogs.add(new Dog("Tommy"));
        listOfDogs.add(new Dog("Sheru"));
        
        List<Cat> listOfCats = new ArrayList<Cat>();
         listOfCats.add(new Cat("Bubbly"));
        listOfCats.add(new Cat("Mini maui"));
        
        List<Bird> listOfBirds = new ArrayList<Bird>();
        listOfBirds.add(new Bird("Popat"));
        listOfBirds.add(new Bird("Chimni"));
        
        System.out.println("Calling the generic method passing it the argument of subclass type collections does NOT compile");
        System.out.println("However if we modify the method signature to accept wildcard(?), it would work.");
        //Call the generics method of the class
        checkAnimalsWithGenerics(listOfDogs);
        checkAnimalsWithGenerics(listOfCats);
        checkAnimalsWithGenerics(listOfBirds);
        //Adding a Dog to the collection
        checkSuperWithGenerics(listOfDogs);
        System.out.println(listOfDogs);
    }
    
    public void checkWithArrays(){
        Dog[] listOfDogs = new Dog[2];
        listOfDogs[0] = new Dog("Tommy");
        listOfDogs[1] = new Dog("Sheru");
        
        Cat[] listOfCats = new Cat[2];
        listOfCats[0] = new Cat("Bubbly");
        listOfCats[1] = new Cat("Mini maui");
        
        Bird[] listOfBirds = new Bird[2];
        listOfBirds[0] = new Bird("Popat");
        listOfBirds[1] = new Bird("Chimni");
        
        //Call the array method of the class
        checkAnimalsWithArrays(listOfDogs);
        System.out.println("Calling the checkAnimalsWithArrays with list of cats");
        checkAnimalsWithArrays(listOfCats);
        System.out.println("Calling the checkAnimalsWithArrays with list of birds");
        checkAnimalsWithArrays(listOfBirds);
    }
    
    public static void main(String[] args){
        AnimalDoctor animalDoctor = new AnimalDoctor();
        try{
            animalDoctor.checkWithArrays();
        } catch (ArrayStoreException ae){
            System.out.println("Got ArrayStoreException: " + ae.getMessage());
        }
        animalDoctor.checkWithGenerics();
    }
}

abstract class Animal{
    public abstract void checkUp();
}

class Dog extends Animal{
    String name;
    
    Dog(String name){
        this.name = name;
    }
    
    public void checkUp(){
        System.out.println("Checking up dog: " + name);
    }
    
    public String toString(){
        return name;
    }
}

class Cat extends Animal{
    String name;
    
    Cat(String name){
        this.name = name;
    }
    
    public void checkUp(){
        System.out.println("Checking up cat: " + name);
    }
}

class Bird extends Animal{
    String name;
    
    Bird(String name){
        this.name = name;
    }
    
    public void checkUp(){
        System.out.println("Checking up bird: " + name);
    }
}