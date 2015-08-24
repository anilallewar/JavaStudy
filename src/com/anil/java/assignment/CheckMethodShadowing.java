package com.anil.java.assignment;

public class CheckMethodShadowing {

	Bar myBar = new Bar();

	void changeIt(Bar myBar) {
		myBar.barNum = 99;
		System.out.println("myBar.barNum in changeIt is " + myBar.barNum);
		myBar = new Bar();
		myBar.barNum = 420;
		System.out.println("myBar.barNum in changelt is now " + myBar.barNum);
	}

	public static void main(String[] args) {
		CheckMethodShadowing f = new CheckMethodShadowing();
		System.out.println("f.myBar.barNum is " + f.myBar.barNum);

		f.changeIt(f.myBar);
		System.out.println("f .myBar.barNum after changeIt is "
				+ f.myBar.barNum);

	}

}

class Bar {
	int barNum = 28;
}
