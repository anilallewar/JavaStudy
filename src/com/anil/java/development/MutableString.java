/**
 * 
 */
package com.anil.java.development;

/**
 * @author anila
 * 
 */
class StringCreator extends Thread {
	MutableString ms;

	public StringCreator(MutableString muts) {
		ms = muts;
	}

	public void run() {
		while (true)
			ms.str = new String("hello"); // 1
	}
}

class StringReader extends Thread {
	MutableString ms;

	public StringReader(MutableString muts) {
		ms = muts;
	}

	public void run() {
		while (true) {
			if (!(ms.str.equals("hello"))) // 2
			{
				System.out.println("String is not immutable!");
				break;
			}
		}
	}
}

public class MutableString {
	public String str; // 3

	public static void main(String args[]) {
		/*
		 * Running this code on old JVMs like Sun JDK 1.2.1 results in the out-of-order 
		 * write problem, and thus, a non-immutable String.
		 */
		MutableString ms = new MutableString(); // 4
		new StringCreator(ms).start(); // 5
		new StringReader(ms).start(); // 6
	}
}
