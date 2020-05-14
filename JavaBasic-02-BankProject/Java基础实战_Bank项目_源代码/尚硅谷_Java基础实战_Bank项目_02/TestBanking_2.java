package test;

import banking2.Account;
import banking2.Customer;

/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */

public class TestBanking_2 {

	public static void main(String[] args) {
		Customer customer;
		// Account account;

		// Create an account that can has a 500.00 balance.
		System.out.println("Creating the customer Jane Smith.");
		// code
		customer = new Customer("Jane", "Smith");

		System.out.println("Creating her account with a 500.00 balance.");
		// code
		// account = new Account(500);
		// customer.setAccount(account);

		customer.setAccount(new Account(500));

		System.out.println("Withdraw 150.00");

		// code
		customer.getAccount().withdraw(150);

		System.out.println("Deposit 22.50");
		// code
		customer.getAccount().deposit(22.50);

		System.out.println("Withdraw 47.62");
		// code
		customer.getAccount().withdraw(47.62);

		// Print out the final account balance
		System.out.println("Customer [" + customer.getLastName() + ", "
				+ customer.getFirstName() + "] has a balance of "
				+ customer.getAccount().getBalance());
	}
}
