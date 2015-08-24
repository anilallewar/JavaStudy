/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.strings;

import java.io.Serializable;
import java.io.File;

//The class must extend the Serializable marker interface so that the compiler knows that this
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//class can be serialized 
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


//Note that the Collar class does not implement Serializable; so it cannot be Serialized.

class Dog extends Animal implements Serializable{
    
    //Note that the String class is an object that implements the Serializable interface
    private String name;
    //Note that the COLLAR object must be declared transient so that Java 
    //does not try to serialize it on its own
    private transient Collar dogCollar;
    
    Dog(Collar dogCollar){
        this.dogCollar = dogCollar;
        this.collarWhatever = 700;
    }
    
    Dog(Collar dogCollar, String name){
        this.dogCollar = dogCollar;
        this.name=name;
        this.collarWhatever = 700;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collar getDogCollar() {
        return dogCollar;
    }

    public void setDogCollar(Collar dogCollar) {
        this.dogCollar = dogCollar;
    }
        
    //Override the callback method WriteObject to save the collar state while object is being written
    private void writeObject(ObjectOutputStream oa){
        try{
            System.out.println("1");
            oa.defaultWriteObject();
            System.out.println("2");
            oa.writeInt(this.dogCollar.getCollarSize());
            System.out.println("3");
            //Note that the reading of serialized data should happen in the same order you wrote them
            oa.writeInt(this.dogCollar.getCollarNumber());
        }catch(IOException ie){
            System.out.println("Got IOException in writeObject: " + ie.getMessage());
            ie.printStackTrace();
        }
    }
    
    //Override the callback method ReadObject to read the collar state while object is being read
    private void readObject(ObjectInputStream oi){
        try{
            oi.defaultReadObject();
            this.dogCollar = new Collar(oi.readInt()) ;
            this.dogCollar.setCollarNumber(oi.readInt());
        }catch(IOException ie){
            System.out.println("Got IOException in readObject: " + ie.getMessage());
        }catch(ClassNotFoundException ie){
            System.out.println("Got ClassNotFoundException in readObject: " + ie.getMessage());
        }
    }
}

class Collar{
    //Initialization block
    static {
        System.out.println("Note that the Collar class does not implement Serializable; so it cannot be Serialized.");
        System.out.println("Howver the state of the Collar object can be saved by the Dog object by implementing the following callback methods:");
        System.out.println("1.writeObject(ObjectOutputStream oa) 2.readObject(ObjectInputStream oi)");
        System.out.println();
        System.out.println("Note that the COLLAR object must be declared transient so that Java does not try to serialize it on its own");
        System.out.println();
    }
    
    private int collarSize;
    private int collarNumber;
    
    public Collar(int collarSize) {
        this.collarSize = collarSize;
    }
    
    public int getCollarSize(){
        return this.collarSize;
    }

    public int getCollarNumber() {
        return collarNumber;
    }

    public void setCollarNumber(int collarNumber) {
        this.collarNumber = collarNumber;
    }
}

class Animal{
    //Have a protected variable that will be set in Dog
    protected int collarWhatever = 100;
}
/**
 *
 * @author Anil Allewar
 */
public class SerializationExample {
    
    public static void main(String[] args){
        //Cannot use default constructor if atleast 1 constructor is defined
        //Dog anil = new Dog();
        
        Collar collar = new Collar(4);
        collar.setCollarNumber(356);
        
        Dog anil = new Dog(collar);        
        anil.setName("Anil");
 
        System.out.println("Writing the object state to File");
        //Write the object to file 
        try{
            File out = new File("NewDirectory", "animal.txt");
            FileOutputStream fo = new FileOutputStream(out);
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            System.out.println("The value of collarWhatever before serializing Dog is: " + anil.collarWhatever);
            oos.writeObject(anil);
            oos.close();
        }catch (FileNotFoundException fnfe){
            System.out.println("Caught FileNotFoundException exception: " + fnfe.getMessage());
        }catch (IOException ie){
            System.out.println("Caught IOException exception: " + ie.getMessage());
        }
        
        System.out.println();
        System.out.println("Reading the object state from File");
        //Write the object to file 
        try{
            File in = new File("NewDirectory", "animal.txt");
            FileInputStream fi = new FileInputStream(in);
            ObjectInput ois = new ObjectInputStream(fi);
            Dog a = (Dog) ois.readObject();
            System.out.println("The Dog name after reading from file is: " + a.getName());
            System.out.println("The value of the non-serialized Dog's collar is: " + a.getDogCollar().getCollarSize());  
            System.out.println("The value of the non-serialized Dog's collar NUMBER is: " + a.getDogCollar().getCollarNumber());  
            System.out.println();
            System.out.println("Since Dog inherits Animal and Animal is not serializable, any instance variable within Animal will default to original value: " + a.collarWhatever);
            ois.close();
            in.delete();
        }catch(ClassNotFoundException cnfe){
            System.out.println("Caught ClassNotFoundException exception: " + cnfe.getMessage());
        }catch (FileNotFoundException fnfe){
            System.out.println("Caught FileNotFoundException exception: " + fnfe.getMessage());
        }catch (IOException ie){
            System.out.println("Caught IOException exception: " + ie.getMessage());
        }
    }
}
