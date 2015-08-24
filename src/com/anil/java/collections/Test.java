/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.java.collections;

import java.util.*;

/**
 *
 * @author Anil Allewar
 */
public class Test {

    public static void main(String[] args) {
        // insert code here
        Queue<String> x = new PriorityQueue<String>();
        x.add("one");
        x.add("two");
        x.add("TWO");
        System.out.println(x.poll());

        Group g = new Group();
        g.add(new Person("Hans"));
        g.add(new Person("Lotte"));

        g.add(new Person("Jane"));
        g.add(new Person("Hans"));
        g.add(new Person("Jane"));
        System.out.println("Total: " + g.size());

        String[] array = { "123", "12345678", "1", "12", "1234567890"};
        List<String> list = Arrays.asList(array);
        Collection<String> resultList = getLongWords(list);
        
        System.out.println("The array returned by the getLongWords() method is: " + resultList);
    }
    
    //public static <E extends CharSequence> Collection<? extends CharSequence> getLongWords(Collection<E> coll) 
    //public static <E extends CharSequence> List<E> getLongWords(Collection<E> coll) 
    static public <E extends CharSequence> Collection<E> getLongWords(Collection<E> coll) 
    {
        ArrayList<E> longWords = new ArrayList<E>();
        for (E word : coll)
            if (word.length() > 6) longWords.add(word);
        return longWords;
    }

}

class Group extends HashSet<Person> {

    public static void main(String[] args) {
    }
    //Cannot modify the add object to overide..Change it to add Person
    
    public boolean add(Person o) {
    System.out.println("Adding: " + o) ;
    return super.add(o);
    }
     
}

class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

