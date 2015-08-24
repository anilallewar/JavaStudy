package com.anil.java.strings;
//The java.io package provides for system input and output through data streams
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SystemInputMortgageCalculator {

	// Declaring and constructing variables
	private int[] iTerm = { 84, 180, 360 };
	private double[] dInterest = { 5.35, 5.5, 5.75 };
	private double dPayment, dRate, dAmount = 200000, dMonthlyInterest1,
			dMonthlyInterest2, dMonthlyInterest3, dMonthlyPrinciple,
			dMonthlyBalance1, dMonthlyBalance2, dMonthlyBalance3;

	DecimalFormat twoDigits = new DecimalFormat("$#,000.00");

	private boolean showReport = false;

	/**
	 * Default constructor
	 */
	public SystemInputMortgageCalculator() {
	}

	/**
	 * The main function for the mortgage calculator
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// Create an object of Week7 to process the Mortgage
		
		SystemInputMortgageCalculator mortgageCalculator = new SystemInputMortgageCalculator();
		mortgageCalculator.acceptInput();
		mortgageCalculator.process();
		
		System.out.println( (byte)0xb2);
		System.out.println(0xb2);
	}

	/**
	 * Function for the calculation of the interest into the loan payment
	 * 
	 * @param amount
	 * @param interestRate
	 * @return
	 */
	private double MonthlyInterest(double amount, double interestRate) {
		// Declaring Variables for interest on the loan
		double dMonthlyInterest = 0.0;
		// Calculation for monthly interest
		dMonthlyInterest = (amount / 12) * (interestRate / 100);
		return dMonthlyInterest;
	}

	/**
	 * function for the calculation of the interest into the loan payment
	 * 
	 * @param amount
	 * @param interestRate
	 * @param term
	 * @return
	 */
	private double monthlyPayment(double amount, double interestRate,
			double term) {
		// Declaring Variables for interest on the loan
		double dMonthlyPayment = 0.0;
		// Calculation for monthly interest
		dMonthlyPayment = (amount * interestRate)
				* (1 - Math.pow(1 / (1 + interestRate), term));
		if (amount <= 0 || dMonthlyPayment <= 0) {
			dMonthlyPayment = 0.0;
		}
		return dMonthlyPayment;
	}

	/**
	 * function for the calculation of the monthy loan balance
	 * 
	 * @param amount
	 * @param monthlyPayment
	 * @return
	 */
	private double monthlyBalance(double amount, double monthlyPayment) {
		// Declaring Variables for monthly loan balance
		double dMonthlyBalance = 0.0;
		// Calculations for monthly loan balance
		dMonthlyBalance = (amount - monthlyPayment);
		if (dMonthlyBalance <= 0) {
			dMonthlyBalance = 0.0;
		}
		return dMonthlyBalance;
	}

	/**
	 * Function to show the Mortagage Schedule
	 */
	private void showMortagageSchedule() {
		// output for month to years
		for (int i : iTerm)
			System.out.println(String.format(
					"An %1$s-month loan equals a %2$s-year loan.", i, i / 12));

		System.out.println();
		System.out.println(String.format("%1$s%2$10s%3$20s%4$20s%5$10s",
				"Term", "Payment", "Monthly Interest", "Monthly Priciple",
				"Balance"));
		// Loop for the varying Mortgage Rates and Payments

		// Month counter
		for (int i = 1; i <= 360; i++) {
			for (int p = 0; p <= 2; p++) {
				// Calculation for the monthly mortgage payment
				dRate = dInterest[p] / 1200;
				switch (p) {
				case 0:
					dPayment = monthlyPayment(dAmount, dInterest[p] / 12,
							iTerm[p]);
					dMonthlyInterest1 = MonthlyInterest(dAmount,
							dInterest[p] / 12);
					dMonthlyPrinciple = (dPayment - dMonthlyInterest1);
					dMonthlyBalance1 = monthlyBalance(dAmount,
							dMonthlyPrinciple);
					dAmount = dMonthlyBalance1;
					break;
				case 1:
					dPayment = monthlyPayment(dAmount, dInterest[p] / 12,
							iTerm[p]);
					dMonthlyInterest2 = MonthlyInterest(dAmount,
							dInterest[p] / 12);
					dMonthlyPrinciple = (dPayment - dMonthlyInterest1);
					dMonthlyBalance2 = monthlyBalance(dAmount,
							dMonthlyPrinciple);
					dAmount = dMonthlyBalance2;
					break;
				case 2:
					dPayment = monthlyPayment(dAmount, dInterest[p] / 12,
							iTerm[p]);
					dMonthlyInterest3 = MonthlyInterest(dAmount,
							dInterest[p] / 12);
					dMonthlyPrinciple = (dPayment - dMonthlyInterest1);
					dMonthlyBalance3 = monthlyBalance(dAmount,
							dMonthlyPrinciple);
					dAmount = dMonthlyBalance3;
					break;
				}

			}
			// Output for the loan information and the monthly payment
			// System.out.println("Your Monthly Payment for a " + iTerm[p] +
			// " month loan of $200,000 at " + dInterest[p] + "% is:" +
			// twoDigits.format(dPayment));
			System.out
					.println(String
							.format(
									"%1$s\t%2$10.2f\t%3$10.2f\t%4$10.2f\t%5$10.2f\t%6$10.2f\t%7$10.2f",
									i, dMonthlyBalance1, dMonthlyInterest1,
									dMonthlyBalance2, dMonthlyInterest2,
									dMonthlyBalance3, dMonthlyInterest3));
		}
	}

	/**
	 * Function to accept input from user and set it to class level variables
	 */
	public void acceptInput() {

		double principle = 0;
		// begins loop for input error checking
		boolean goodNumber = false; // declares goodNumber as boolean
		String userChoice = "No";

		// open up standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// while loop lets try and catch statements determine if an exception
		// requires user to reinput
		while (!goodNumber) {
			// try statement in case of exception such as user entering a string
			try {
				// informs user to enter amount of desired loan
				System.out
						.println("Please enter the loan amount as a number: ");
				// delcares Scanner object
				Scanner input = new Scanner(br);
				principle = input.nextDouble();
				if (principle <= 0.0) {
					System.out
							.println("Error:  Loan Amount must be greater than $0.00");
					continue; // This causes the loop to continue without
					// executing statements after this code
				}
				// Set the local variable to the class level variable
				this.dAmount = principle;
				// set goodNumber to true if no exception to let program
				// continue
				goodNumber = true;
			} catch (Exception e) {
				System.out
						.println("Error: The entered number is invalid or not a number. Please enter a valid number.");
			}
		}

		System.out
				.println("Do you see want to view the amortization 7 column table or not? Respond with Yes/No and click <ENTER> key:");
		try {
			userChoice = br.readLine();
			if (userChoice == null || "".equals(userChoice.trim())) {
				System.out
						.println("No input provided. By default the report will not be shown ");
			} else if (!("Yes".equalsIgnoreCase(userChoice) || "No"
					.equalsIgnoreCase(userChoice))) {
				System.out
						.println("Invalid input provided. By default the report will not be shown ");
			} else if ("Yes".equalsIgnoreCase(userChoice)) {
				showReport = true;
			}
			// The else condition of userChoice="No" is already covered with
			// intitialization
		} catch (IOException ioe) {
			System.out.println("IOException while reading input: "
					+ ioe.getMessage());
		}
	}

	/**
	 * Function to process the output
	 */
	public void process() {

		DecimalFormat f = new DecimalFormat("$###,###.00");
		double payment;

		// if statement to ensure user enters amount greater than 0
		if (this.dAmount > 0)

		{
			// informs user of desired loan amount
			System.out.println("\nLoan Amount = " + f.format(this.dAmount));

			// displays calculator headings
			System.out
					.println("\n\n*****************************************************");
			System.out.println("* Loan Term " + "\tInterest Rate"
					+ "\tMortgage Payment    *");
			System.out
					.println("*****************************************************");
			// begins loop to determine terms, rates, and payments
			for (int i = 0; i < dInterest.length; i++) {
				// calculations to determine payment
				payment = this.dAmount
						* ((dInterest[i] / 12) / (1 - Math.pow(
								1 / (1 + (dInterest[i] / 12)),
								((iTerm[i]) * 12))));
				// displays term in years, interest rates, and payments
				System.out.println((dInterest[i]) + "  years" + "\t"
						+ ((dInterest[i]) * 100) + "%" + "\t\t"
						+ f.format(payment));

			}

			System.out.println();

			if (this.showReport) {
				// Call function to show the mortgage schedule
				showMortagageSchedule();
			}
		}
	}
}
