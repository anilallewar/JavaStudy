package com.anil.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TestListExample {

	public void checkArrayList(){
		//Declare a ArrayList with generics
		List<String> list = new ArrayList<String>();
		list.add("Anil");
		list.add("Allewar");
		list.add("Anil");
		list.add(2, "I am here");
		System.out.println("1. size: " + list.size());
		ListIterator li = list.listIterator();
		while(li.hasNext()){
			System.out.println(li.next());
		}
		System.out.println(list.contains("Anil"));
		System.out.println(list.remove("Anil"));
		System.out.println("2. size: " + list.size());	
		System.out.println(list);
		
		System.out.println("Sorting the Arraylist of String objects with default sort order");
		Collections.sort(list);
		System.out.println(list);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestListExample testListExmple = new TestListExample();
		testListExmple.checkArrayList();
	}

}

