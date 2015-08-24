package com.anil.java.innerclasses;

public class AnonymousInnerClassExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		AnonymousInnerClassExample anon = new AnonymousInnerClassExample();
		anon.checkAnonymousSubClass();
		anon.checkAnonymousInterfaceImple();
		anon.checkAnonymousInterfaceInArgument();
	}

	public void checkAnonymousSubClass() {
		PopCorn p = new PopCorn() {
			public void pop() {
				System.out.println("Anonymous inner class pop");
				System.out
						.println("Note the semicolon at the end of the anonymous class declaration");
			}

			/**
			 * This method will not be reachable using a superclass reference
			 * because this is a mthod that is specific to the subclass only and
			 * the superclass does not have this method. Hence this method
			 * cannot be called using ba superclass reference.
			 * 
			 */
			public void peek() {
				System.out
						.println("I am in the peek method...If you try to reach me through a superclass reference you will get compile error");
			}
		}; // Note the semicolon at the end of the anonymous class declaration

		p.pop();

		// Method is not visible
		// p.peek();
	}

	public void checkAnonymousInterfaceImple() {

		System.out
				.println("Note that anonymous interface is the ONLY time when you will use the new keyword with an interface");
		Samosa s = new Samosa() {
			public void eatIt() {
				System.out.println("I wish I was Eating the Samosa!!!");
			}

			/**
			 * This method will not be reachable using a superclass reference
			 * because this is a mthod that is specific to the subclass only and
			 * the superclass does not have this method. Hence this method
			 * cannot be called using ba superclass reference.
			 * 
			 */
			public void peek() {
				System.out
						.println("I am in the peek method...If you try to reach me through a superclass reference you will get compile error");
			}
		};

		// Call the anonymous class implemented
		s.eatIt();

		// Method is not visible
		// s.peek();
	}

	public void checkAnonymousInterfaceInArgument() {

		PopCorn p = new PopCorn();
		/**
		 * Note that we are creating an instance of interface in the method argument. Also note that 
		 * the
		 */
		p.testInterface(new Samosa(){
			public void eatIt() {
				System.out.println("Creating the Samosa interface within the method argumet!!!");
			}
		});
		 
	}
}

class PopCorn {
	public void pop() {
		System.out.println("I am within the Popcorn class");
	}

	public void testInterface(Samosa s1) {
		System.out
				.println("IN testInterface:::Calling the test Interface method by creating the new Interface implementing anonymous class in the method argument");
	}
}

interface Samosa {
	void eatIt();
}
