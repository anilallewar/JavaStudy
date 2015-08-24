package com.anil.java.strings;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ObjectMethodOverridingExample {

	private int height, weight;
	
	ObjectMethodOverridingExample(){
		this.height = 0;
		this.weight = 0;
	}
	
	ObjectMethodOverridingExample(int height, int weight){
		this.height = height;
		this.weight = weight;
	}
	
	//Overridden toString method. This will be now called by default when object is referred
	public String toString(){
		return "I have " + this.height + " height and " + this.weight + " weight";
	}
	
	/**
	 * Override the euqls method to provide the equals implemetation specific to this class.
	 * This method determines how the Objects of this class are considered meaningfully equal.
	 */
	public boolean equals(Object object){
		if (!(object instanceof ObjectMethodOverridingExample))
			return false;
		
		ObjectMethodOverridingExample temp = (ObjectMethodOverridingExample)object;
		
		System.out.println(this.height + ":" + temp.height + "::" + this.weight + ":" + temp.weight);
		
		if(this.height == temp.height && this.weight == temp.weight)
			return true;
		else
			return false;				
	}
	
	/**
	 * Overridden the Object hashCode() method and this will not be used to return the default hashCode
	 */
	public int hashCode(){
		return this.height*this.weight;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMethodOverridingExample exmple = new ObjectMethodOverridingExample(12,34);
		//The call to print objects will in turn call the object's toString() method
		//which we have not defined till now
		System.out.println(exmple);
		
		ObjectMethodOverridingExample exmple2 = new ObjectMethodOverridingExample();
		
		//false before overriding equals
		//exmple = exmple2;
		//System.out.println(exmple.equals(exmple2));
		//true
		
		ObjectMethodOverridingExample exmple3 = new ObjectMethodOverridingExample(12,34);
		
		System.out.println(exmple.equals(exmple2));
		System.out.println(exmple.equals(exmple3));
		System.out.println(exmple3.equals(exmple2));
		
		System.out.println("The HashMap will add 3 objects to the collection because even though the equals method \n" +
					"return true, the hashCode generated(Using Object.hashCOde()) is different till the time hashCode() method is not overridden");
		
		HashMap map = new HashMap();
		
		map.put(exmple, "Anil Allewar");
		map.put(exmple2, "Allewar");
		System.out.println("Since Example1 is same as example3, example 3 will REPLACE the example1 key at index 1 and its equals method is called");
		map.put(exmple3, "Anil");
		
		System.out.println("The map size is: " + map.size());
		System.out.println();
		System.out.println("Reading the KeySet from the map");
		
		Set set = map.keySet();
		Iterator i = set.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		System.out.println();
		System.out.println("Reading the Values from the map");
		
		Collection c = map.values();
		
		i = c.iterator();
		
		while(i.hasNext()){
			System.out.println(i.next());
		}
		
		HashSet hashset = new HashSet();
		hashset.add(exmple);
		hashset.add(exmple2);
		System.out.println("Before adding example3 to the Hashset");
		hashset.add(exmple3);
		
		Iterator i2 = hashset.iterator();
		
		System.out.println("Using HashSet");
		while(i2.hasNext()){
			System.out.println(i2.next());
		}
	}
}
