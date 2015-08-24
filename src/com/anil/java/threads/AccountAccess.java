package com.anil.java.threads;

import java.util.Date;

public class AccountAccess implements Runnable {
	// Hold a single account access so that all the Threads will use this

	Account account = new Account();
	private static int count=0;
	
	public static int getCount(){
		return count;
	}

	public void incrementCount(){
		synchronized (AccountAccess.class) {
			count++;
		}
	}
	public void run() {
		// Loop thru the withdrawl 5 times
		for (int x = 0; x < 5; x++) {
			makeWithdrawal(10);
			if (account.getBalance() < 0) {
				System.out.println("account is overdrawn!");
			}

		}
	}

	/**
	 * The method will not work correctly and allow people to overdraw if it is
	 * not synchronized The synchronized keyword has to come before the return
	 * type
	 * 
	 * @param amount
	 */
	private/* synchronized */void makeWithdrawal(int amount) {

		//synchronized (this){
			if (account.getBalance() < amount)
				System.out.println("The balance is not sufficient for "
						+ Thread.currentThread().getName()
						+ " to withdraw and the balance is: "
						+ account.getBalance());
			else {
				System.out.println(new Date()
						+ " : About the withdraw money from the account of "
						+ Thread.currentThread().getName()
						+ " and the current balance is: "
						+ account.getBalance());
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
					System.out.println("Got InterruptedException"
							+ ie.getMessage());
				}
				
				// Withdraw the amount
				account.withdraw(amount);
					
				System.out.println(new Date()
						+ " Money withdrawal successful from the account of "
						+ Thread.currentThread().getName()
						+ " and the current balance is: "
						+ account.getBalance());
			}
		//}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountAccess acctAccess = new AccountAccess();
		// Create threads
		Thread t1 = new Thread(acctAccess, "Anil");
		Thread t2 = new Thread(acctAccess, "Pallavi");

		t1.start();
		t2.start();
	}
}

class Account {
	private int balance = 70;

	public int getBalance() {
		return this.balance;
	}

	public void withdraw(int amount) {
		this.balance -= amount;
	}
}