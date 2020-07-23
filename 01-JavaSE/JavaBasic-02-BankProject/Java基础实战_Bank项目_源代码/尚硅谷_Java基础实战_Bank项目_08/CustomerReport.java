package banking.reports;

import java.util.Iterator;

import banking8.*;

public class CustomerReport {

	public void generateReport() {
		
		Bank bank = Bank.getBank();
		
		Customer customer = null;
		
		System.out.println("\t\t\tCUSTOMERS REPORT");
		System.out.println("\t\t\t================");

		Iterator<Customer> customers = bank.getCustomers();
		
		while(customers.hasNext()){
		
//		for (int cust_idx = 0; cust_idx < bank.getNumOfCustomers(); cust_idx++) {
//			customer = bank.getCustomer(cust_idx);

			customer = customers.next();
			
			System.out.println();
			System.out.println("Customer: " + customer.getLastName() + ", "
					+ customer.getFirstName());

			Iterator<Account> accounts = customer.getAccounts();
			
			while(accounts.hasNext()){
//			for (int acct_idx = 0; acct_idx < customer.getNumOfAccounts(); acct_idx++) {
//				Account account = customer.getAccount(acct_idx);
				
				Account account = accounts.next();
				
				String account_type = "";

				// Determine the account type
				/***
				 * Step 1: Use the instanceof operator to test what type of
				 * account we have and set account_type to an appropriate value,
				 * such as "Savings Account" or "Checking Account".
				 ***/
				if (account instanceof SavingAccount) {
					account_type = "Savings Account";
				} else if (account instanceof CheckingAccount) {
					account_type = "Checking Account";
				}

				// Print the current balance of the account
				/***
				 * Step 2: Print out the type of account and the balance. Feel
				 * free to use the currency_format formatter to generate a
				 * "currency string" for the balance.
				 ***/
				System.out.println(account_type + ": current balance is гд"
						+ account.getBalance());

			}
		}

	}

}
