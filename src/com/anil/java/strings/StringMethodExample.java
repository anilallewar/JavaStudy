/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.strings;

/**
 *
 * @author Anil Allewar
 */
public class StringMethodExample extends Base{

    /**
     * Keep variables non-transient or, if they must be marked transient, don't use 
     * then to determine hashcodes or equality.
     */
    private int height;
    private int weight;

    public StringMethodExample() {
        this.height = 1;
        this.weight = 1;
    }
    
    public StringMethodExample(int height, int weight){
        this.height = height;
        this.weight = weight;
    }
   
    /**
     * Overriding the equals method
     * @param o
     * @return
     */
    public boolean equals(Object o){
        if(o instanceof StringMethodExample){
            StringMethodExample temp = (StringMethodExample)o;
            if (temp.height==this.height && this.weight == temp.weight)
                return true;
            else
                return false;
        }else
            return false;
    }
    
    /**
     * Overiding the hashcode method.
     * 
     * The String API contracts specifies that <br><br>
     * 
     * 1. Whenever it is invoked on the same object more than once during an execution 
     * of a Java application, the hashcode() method must consistently return the
     * same integer, provided no information used in equals() comparisons on the
     * object is modified. This integer need not remain consistent from one execution 
     * of an application to another execution of the same application.<br><br>
     * 2. If two objects are equal according to the equals(object) method, then 
     * calling the hashCode() method on each of the two objects must produce the same integer result.<br><br>
     * 3. It is NOT required that if two objects are unequal according to the 
     * equals(Java.lang.Object) method, then calling the hashCode() method on 
     * each of the two objects must produce distinct integer results. However, 
     * the programmer should be aware that producing distinct integer results for 
     * unequal objects may improve the performance of hashtables.<br>
     * 
     */
    public int hashCode(){
        return this.height * this.weight;
        //Valid hashcode method that returns the same hashcode irrespective of 
        //whether the objects are equal or not
        //return 32;
    }
    
    public static void main(String[] args){
        StringMethodExample exmple1 = new StringMethodExample();
        StringMethodExample exmple2 = new StringMethodExample(12,45);
        StringMethodExample exmple3 = new StringMethodExample(12,45);
        
        System.out.println("The results of exmple1.equals(exmple2) is: " + exmple1.equals(exmple2) + 
                " and the corresponding hashcodes are exmple1: " + exmple1.hashCode() +
                " exmple2: " + exmple2.hashCode());
        
        System.out.println("The results of exmple2.equals(exmple3) is: " + exmple2.equals(exmple3) + 
                " and the corresponding hashcodes are exmple2: " + exmple2.hashCode() +
                " exmple3: " + exmple3.hashCode());
        
        System.out.println("The results of exmple3.equals(exmple1) is: " + exmple3.equals(exmple1) + 
                " and the corresponding hashcodes are exmple3: " + exmple3.hashCode() +
                " exmple1: " + exmple1.hashCode());
        
        System.out.println("The results of exmple3.equals(null) is: " + exmple3.equals(null));
    }
}

class Base{
    Base(){
        System.out.println("In the base class default constructor");
    }
    
    Base(int height, int weight){
        System.out.println("Height and weight is: " + height + " " + weight);
    }
}
