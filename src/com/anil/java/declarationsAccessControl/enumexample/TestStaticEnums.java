/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anil.java.declarationsAccessControl.enumexample;

/**
 *
 * @author Anil Allewar
 */
public class TestStaticEnums {

    Animals a;
    Short story = 4000;
    String[] x;
    int[] b[] = {{1, 2}, {1}};
    Object c = new long[4];
    Object[] d = x;
    //Cannot define dimension expression when an array initializer is provided
    //static final int[] anil = new int[2]{100,200};
    static final int[] anil = {100,200};
    
    TestStaticEnums go(TestStaticEnums cb) {
        System.out.println(a.DOG.sound + " " + a.FISH.sound);
        cb = null;
        return cb;
    }

    public static void main(String[] args) {

        TestStaticEnums c1 = new TestStaticEnums();
        TestStaticEnums c2 = new TestStaticEnums();
        TestStaticEnums c3 = c1.go(c2);
        c1 = null;
        System.out.println("Output: 1: " + c1 + " 2: " + c2 + " 3: " + c3);
        int[][] a = {{1, 2, }, {3, 4}};
        int[] b = (int[]) a[1];
        Object o1 = a;
        int[][] a2 = (int[][]) o1;
        //int[] b2 = (int[]) o1;
        System.out.println(b[1]);
        for(Animals c:Animals.values())
        	System.out.println(c);
        
    }
}

enum Animals {

    DOG("woof"), CAT("meow"), FISH("burble");
    String sound;

    Animals(String s) {
        sound = s;
    }
}

class Plant {

    String getName() {
        return "plant";
    }

    Plant getType() {
        return this;
    }
}

class Flower extends Plant {
    // insert code here
    Tulip getType() {
        return new Tulip();
    }
}

class Tulip extends Flower {
}
