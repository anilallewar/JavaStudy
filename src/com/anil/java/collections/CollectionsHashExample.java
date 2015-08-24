package com.anil.java.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class CollectionsHashExample {

	public void checkHashMap(){
		//HashMap provides an unordered list
		HashMap<Integer, String> hash = new HashMap<Integer, String>();
		
		hash.put(1, "Anil");
		hash.put(1, "Allewar");
		hash.put(2, "Anil2");
		hash.put(null, "Anil Allewar");
		hash.put(null, "Anil Allewar 1");
		Collection c = hash.values();
		
		Iterator<String> i = c.iterator();
		System.out.println("using HashMap");
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	public void checkHashTable(){
		//HashMap provides an unordered list
		Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
		
		hash.put(1, "Anil");
		hash.put(1, "Allewar");
		//Gives NPE
		//hash.put(2, null);
		hash.put(2, "Anil Allewar");
		
		//throws NullPointerException
		//hash.put(null, "Anil Allewar");
		//hash.put(null, "Anil Allewar 1");
		
		Collection c = hash.values();
		Iterator i = c.iterator();
		System.out.println("using Hashtable..Does NOT allow NULL keys and values");
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	public void checkLinkedHashMap(){
		//HashMap provides an unordered list..specifying the type of elements held by the LinkedHashMap
		LinkedHashMap<Integer, String> hash = new LinkedHashMap<Integer, String>();
		
		hash.put(2, "Anil");
		hash.put(2, "Allewar");
		//Allows more than 1 null values
		hash.put(1, null);
		hash.put(3, "Anil Allewar");
		
		//Allows 1 null key
		hash.put(null, "Anil Allewar");
		hash.put(null, "Anil Allewar 1");
		
		Collection c = hash.values();
		Iterator i = c.iterator();
		System.out.println("using LinkedHashMap...This maintains the order in which the elements were inserted");
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("HashMap object retrieval happens in two stages of retrieval:\n" +
                    "1. Use the hashcode() method to find the correct bucket\n" +
                    "2. Use the equals() method to find the object in the bucket");
                CollectionsHashExample collHashExmple = new CollectionsHashExample();
		collHashExmple.checkHashMap();
		collHashExmple.checkHashTable();
		collHashExmple.checkLinkedHashMap();
	}

}
