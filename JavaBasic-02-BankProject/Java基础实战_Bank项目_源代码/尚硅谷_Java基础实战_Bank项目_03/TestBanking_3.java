package test;

/*
 * This class creates the program to test the banking classes.
 * It creates a new Bank, sets the Customer (with an initial balance),
 * and performs a series of transactions with the Account object.
 */

import banking3.*;

public class TestBanking_3 {

  public static void main(String[] args) {
    Customer customer;
    Account  account;

    // Create an account that can has a 500.00 balance.
    System.out.println("Creating the customer Jane Smith.");
	//code 
    customer = new Customer("Jane", "Smith");
    
    System.out.println("Creating her account with a 500.00 balance.");
    customer.setAccount(new Account(500));
    //把 Jane Smith 的账户赋给 customer 变量
    account = customer.getAccount();
    
	//code
    // Perform some account transactions
    System.out.println("Withdraw 150.00: " + account.withdraw(150.00));
    System.out.println("Deposit 22.50: " + account.deposit(22.50));
    System.out.println("Withdraw 47.62: " + account.withdraw(47.62));
    System.out.println("Withdraw 400.00: " + account.withdraw(400.00));

    // Print out the final account balance
    System.out.println("Customer [" + customer.getLastName()
		       + ", " + customer.getFirstName()
		       + "] has a balance of " + account.getBalance());
  }
}
