/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.java.generics;

import java.util.HashSet;

/**
 *
 * @author Anil Allewar
 */
public class TestGenerics extends HashSet<Person> {
    public static void main(String[] args) {
        TestGenerics g = new TestGenerics () ;
        g.add(new Person("Hans"));
        g.add(new Person("Lotte"));

        g.add(new Person("Jane"));
        g.add(new Person("Hans"));
        g.add(new Person("Jane"));
        System.out.println ("Total: " + g.size() );
    }
    //Change the add method signature to add the HashSet type Person
    public boolean add(Person o) {
        System.out.println("Adding: " + o) ;
        return super.add(o);
    }
}
class Person {
    private final String name;
    public Person(String name) { this.name = name; }
    public String toString() { return name; }
}

interface Hungry<E> {

    void munch(E x);
}

interface Carnivore<E extends Animal1> extends Hungry<E> {
}

//interface Herbivore<E extends Plant> extends Hungry<E> {
interface Herbivore<E extends Animal1> extends Hungry<E> {
}

abstract class Plant {
}

class Grass extends Plant {
}

abstract class Animal1 {
}

class Sheep extends Animal1 implements Herbivore<Sheep> {

    public void munch(Sheep x) {
    }
}

class Wolf extends Animal1 implements Carnivore<Sheep> {

    public void munch(Sheep x) {
    }
}
