/**
 * 
 */
package com.anil.java.operator;

import javax.swing.JButton;

/**
 * @author anil.al
 *
 */
public class OperatorExample {
	//enum has to be defined at class level
	enum Color {RED, BLUE}
	
	public void checkPrimitives(){
		System.out.println("char 'a' == 'a'? " + ('a' == 'a'));
	    System.out.println("char 'a' == 'b'? " + ('a' == 'b'));
	    System.out.println("5 != 6? " + (5 != 6));
	    System.out.println("5.0 == 5L? " + (5.0 == 5L));
	    System.out.println("(short)5 == 5L? " + ((short)5 == 5L));
	    System.out.println("true == false? " + (true == false));
	}
	
	public void checkReferences(){
		JButton a = new JButton("Exit");
	    JButton b = new JButton("Exit");
	    JButton c = a;
	    System.out.println("Is reference a == b? " + (a == b));
	    System.out.println("Is reference a == c? " + (a == c));
	}
	
	public void checkEmums(){
		Color c1 = Color.RED;
		Color c2 = Color.RED;
		System.out.println("The enum operator behaves same for == and equals() method");
		if(c1 == c2) { System.out.println("== returns true"); }
		if(c1.equals(c2)) { System.out.println("dot equals returns true"); }
	}
		
	public void checkNullInstanceOf(){
		String a = null;
		boolean b = null instanceof String;
		System.out.println("null instanceof String returns: " + b);
		b = a instanceof String;
		System.out.println("a instanceof String returns: " + b);
	}
	
	public void checkOveloadedPlusOperator(){
		int a= 10;
		int b= 20;
		System.out.print("Result of a+b is ");
		System.out.println(a+b);
		System.out.println("String usage");
		System.out.println("Result is:" + a +b);
		System.out.println("result using paranthesis (a+b): " + (a+b));
	}
	

	public static String getXYCoOrdinatesForMobileStop(Double absX, Double absY){      
	 
	        int xRefCoOrdinate = -118;
	        int yRefCoOrdinate = 34;
	 
			//Double x = stopInfo.getAddress().getGeoPoint().getGeoXAsObject();
			//Double y = stopInfo.getAddress().getGeoPoint().getGeoYAsObject();
	        System.out.println("absX : "+absX + ", absY : "+absY);
	        Double x = null;
	        Double y = null;
	 
	        x = (absX - xRefCoOrdinate) * 6000;
	        y = (absY - yRefCoOrdinate) * 6000;
	 
	        System.out.println("x : "+x.intValue() + ", y : "+y + "hex representation: " + Double.toHexString(x) + " Integer hex representation: " + Integer.toHexString(x.intValue()));
	        StringBuilder sb = new StringBuilder();
			sb.append(Integer.toHexString(x.intValue()));
	        System.out.println(Integer.toHexString(x.intValue()));
			sb.append(Integer.toHexString(y.intValue()));
	        System.out.println(Integer.toHexString(y.intValue()));
			return sb.toString().toUpperCase();
		}
	 
	public void checkInteger(){
		Integer id1 = new Integer(-1);

		Integer id = id1;
		if (id.intValue() == -1){
			System.out.println("Value is -1");
		}
	}
	
	public static void main(String[] args){
	    OperatorExample oprExample = new OperatorExample();
	    oprExample.checkInteger();
	    oprExample.checkPrimitives();
	    oprExample.checkReferences();
	    oprExample.checkEmums();
	    oprExample.checkNullInstanceOf();
	    oprExample.checkOveloadedPlusOperator();
	    System.out.println("The returned value is:" + getXYCoOrdinatesForMobileStop(-118.04550,34.10183));
	}
}
