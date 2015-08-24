/**
 * 
 */
package com.anil.java.generics;

/**
 * @author anila
 * 
 */
/*
 * abstract class AbstractSuperClass implements Comparable<AbstractSuperClass>{
 * private Long uid; public String description;
 * 
 * public int compareTo(AbstractSuperClass o) {
 * System.out.println("In Super class compareTo"); return
 * this.description.compareTo(o.description); }
 * 
 * 
 * }
 */

/*
 * public class AbstractClassComparable extends AbstractSuperClass { public int
 * compareTo(AbstractSuperClass o) {
 * System.out.println("In sub class compareTo"); return
 * this.description.compareTo(o.description); }
 * 
 * public static void main(String args[]){ AbstractClassComparable a = new
 * AbstractClassComparable(); a.description = "a"; AbstractClassComparable b =
 * new AbstractClassComparable(); b.description = "b";
 * ArrayList<AbstractSuperClass> array = new ArrayList<AbstractSuperClass>();
 * array.add(a); array.add(b); Collections.sort(array); } }
 */
abstract class AbstractSuperClass<T extends AbstractSuperClass> implements
		Comparable<T> {
	private Long uid;

	/**
	 * @param o
	 * @return
	 */
	
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class AbstractClassComparable extends
		AbstractSuperClass<AbstractClassComparable> {
	@Override
	public int compareTo(AbstractClassComparable o) {
		// TODO Auto-generated method stub
		return 0;
	}
}