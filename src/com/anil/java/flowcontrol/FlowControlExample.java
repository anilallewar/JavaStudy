/**
 * 
 */
package com.anil.java.flowcontrol;

/**
 * @author anil.al
 *
 */
public class FlowControlExample {

	public void checkIf(){
		int x= 5;
		//Check else if
		if(x> 10){
			System.out.println("x is greater than 10");
		}else if(x>7){
			System.out.println("x is greater than 7");
		}else if (x> 4){
			System.out.println("x is greater than 4");
		}else{
			System.out.println("No condition match");
		}
		
		//Assign boolean within if statement
		boolean boo= true;
		if (boo=false){
			System.out.println("boo is false");
		}else{
			System.out.println("boo is true");
		}
		
		int y;
		//Gives type mismatch compile error 
		/*
		if(y=9){
			System.out.println("This code cannot compile");
		}
		*/
	}
	
	public void checkForLoop(){
		//Multiple initialization and iterations
		for(int x=0, y=9;y>x;x++, y=y-3){
			System.out.println("The value of x is: "+x + " and y is: "+y);
		}
		
		//Infinite for loop
		/*
		for( ; ; ) {
			  System.out.println("Inside an endless loop");
		}
		*/
		
		System.out.println("Checking the enhanced For loop");
		
		int[][] a = { {1, 2,3}, {15,16}, {23, 24}};
		for (int[] i:a){
			for(int j:i){
				if (j==1)
					continue;//Will skip this iteration
				if (j==15)
					//Will break out of the innermost for loop. 
					//Note that "if" is not considered a looping construct
					break;
				System.out.println("The array value is: "+ j);
			}
		}
		//Declared variable
		long l2;
		//Boxing 
		Long[] larray = {3L, 7L, 9L};
                
		for (long l:larray){
			System.out.println("Using boxing the array value is: " +l);
		}
		
		System.out.println("Trying to use an already declared variable in for loop declaration WILL GIVE COMPILE ERROR");
		/*
		for(l2:larray){
			System.out.println("Using boxing the array value is: " +l);
		}
		*/
	}
	
	public void checkLabel(){
		System.out.println("Checking the labelled for loop for break. Note that the break will start execution from the labelled block and not exit from the innermost loop");
		boolean alwaysTrue = true;
		//Labeling the outer loop
                //This causes the next statement after the labelled for loop to execute.
                //The For loop is not checked again and control exists out of the labelled loop
		out:
                        for(int i=0; i<5; i++){
				while(alwaysTrue){
					System.out.println("Inside while. The value of i is: " + i);
					break out;//Break to the outer for block
				}
				System.out.println("Trying to reach next statment in the for block");
			}
		
		System.out.println();
		System.out.println("Good-Bye");
		System.out.println();
		System.out.println("Checking the labelling with continue statement. Note that the label has to be for the FOR statement");
		
		out1:
			//System.out.println("In continue loop"); //Gives compile error - label is missing
			for(int i=0; i<5; i++){
				while(alwaysTrue){
					System.out.println("Inside while with continue. The value of i is: " + i);
					//continue out; //Gives compile error - label is missing
					continue out1;//Break to the outer for block
				}
				System.out.println("Trying to reach next statment in the for block");
			}
		
		System.out.println();
		System.out.println("Good-Bye 2");
		
		int age=12;
		out:
			while(age<21){
				age++;
				if (age==16){
					System.out.println("You have reached legal age..Try getting a license: " + age);
					//continue out; //While loop will continue after 16
                                        break out; //This will terminate the while loop at 16
				}
					System.out.println("You are not legal age: " + age);
			
				//This will lead to infinite loop at 16
				//age++;
			}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlowControlExample flowContrlExmp = new FlowControlExample();
		flowContrlExmp.checkIf();
		flowContrlExmp.checkForLoop();
		flowContrlExmp.checkLabel();
	}

}
