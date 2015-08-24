/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.generics;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author Anil Allewar
 */
public class GenericsCarRentalClass<E, T> {

    private HashMap<E, T> rentedCar;
    
    /**
     * The constructor adds the typed hashmap to the class hashmap
     * @param rentedCar
     */
    public <M> GenericsCarRentalClass(HashMap<E, T> rentedCar, M m) {
        this.rentedCar = rentedCar;
        System.out.println("The passed Generic parameter to the constructor is: " + m);
        //Gives incompatible types error
        //m="anil";
    }
    
    /**
     * Get the genric value given generic key 
     * @param a
     * @return
     */
    public T getRentedDate(E a){
        if (!rentedCar.containsKey(a))
                return null;
        return rentedCar.get(a);
    }
    
    /**
     * Add a car to the typed collection
     * @param a
     * @param b
     */
    public void addRentedCar(E a, T b){
        rentedCar.put(a, b);
    }

    /**
     * This method will remove the rented car from the collection
     * @param a
     * @return
     */
    public boolean returnRentedCarToDealer(E a){
        if (!rentedCar.containsKey(a))
                return false;
        if (rentedCar.remove(a) != null)
            return true;
        else 
            return false;
    }
    
    /**
     * This method defines an generic argument X. Note that X has to be defined with a 
     * type notation <X> which has to be declared BEFORE the return statement.
     * 
     * You MUST declare the type like that unless the type is specified for the class. 
     * 
     * Here X can be Number of any of its subtypes because the Generic definitions states that
     * X extends Number. Hence primitives that can be boxed to wrapper classes that are subtypes
     * of Number are accepatable as arguments.
     * 
     * @param x
     * @return
     */
    public <X extends Number> String getCarList(X x){
        return rentedCar.toString() + " <=>passed value: " + x;
    }
    
    /**
     * Main method:)
     * @param args
     */
    public static void main(String[] args){
        //Create a Hashmap..The hashmap has to be of same type as the creation
        //parameters for the GenericsCarRentalClass; else we would get COMPILER error
        HashMap<String , Date> hash = new HashMap<String , Date>();
        //Create new generic class
        GenericsCarRentalClass<String, Date> rentalClass = new GenericsCarRentalClass<String, Date>(hash, "Anil is checking constructor");
        //Add the cars
        rentalClass.addRentedCar("Merc1", new Date());
        rentalClass.addRentedCar("Lamborgini1", new Date(6897868768378L));
        rentalClass.addRentedCar("BMW1", new Date(763426834923L));
        //See if the rented cars exists in the class including a car that was not added
        System.out.println("The date Lamborgini1 was added was: " + rentalClass.getRentedDate("Lamborgini1"));
        System.out.println("The date Merc1 was added was: " + rentalClass.getRentedDate("Merc1"));
        System.out.println("The date Anil was added was: " + rentalClass.getRentedDate("Anil"));
        System.out.println("The date BMW1 was added was: " + rentalClass.getRentedDate("BMW1"));
        //Try to remove existing and non existing cars
        System.out.println("trying to remove BMW1: " + rentalClass.returnRentedCarToDealer("BMW1"));
        System.out.println("trying to remove AnilAllewar: " + rentalClass.returnRentedCarToDealer("AnilAllewar"));
        //Again see if the rented cars exists in the class including a car that was not added
        System.out.println("The date Lamborgini1 was added was: " + rentalClass.getRentedDate("Lamborgini1"));
        System.out.println("The date Merc1 was added was: " + rentalClass.getRentedDate("Merc1"));
        System.out.println("The date Anil was added was: " + rentalClass.getRentedDate("Anil"));
        System.out.println("The date BMW1 was added was: " + rentalClass.getRentedDate("BMW1"));
        //Call the genric method passing it 2 generic number types
        System.out.println("Calling getCarList() with int parameter: " + rentalClass.getCarList(34));
        System.out.println("Calling getCarList() with float parameter: " + rentalClass.getCarList(564.78));
    }
}
