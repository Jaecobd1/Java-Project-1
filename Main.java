import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	static boolean isProgramRunning = true;
	static ArrayList<Customer> customers = new ArrayList<Customer>(); 
	static ArrayList<Account> accounts = new ArrayList<Account>();
	
	public static void main(String[] args) {
		// Start the Menu Program, Option 10 Changes isProgramRunning to false
		while (isProgramRunning) {
			//Print the Menu Options
			printMenu();
			// Get the choice from the user
			int choice = getChoice();
			// check if choice is 1-10
			while(choice < 1 | choice > 10) {
				// Out of limits Have user try again
				System.out.println("That number was not 1-10, try again.");
				choice = getChoice();
			}
			// Execute choice
			execute(choice);
		}
	}
	
	public static Account createCheckingAccount() {
		Scanner in = new Scanner(System.in);
		// Check if creating new customer or adding to existing
		System.out.println("Are you 1. Creating a new customer?"
				+ " \nor 2. Using existing? \nEnter 1 or 2:");
		
		int choice = getChoice();
		while(choice < 1 | choice > 2) {
			System.out.println("Please Enter 1 or 2");
			choice = getChoice();
		}
		CheckingAccount newCheckingAccount = null;
		Double balance;
		switch(choice) {
		case 1: 
			// Create new user
			Customer newCustomer = createCustomer();
			customers.add(newCustomer);
			
			System.out.println("What is the initial balance? $");
			balance = in.nextDouble();
			
			newCheckingAccount = new CheckingAccount(newCustomer, balance);
			newCustomer.addAccount(newCheckingAccount);
			accounts.add(newCheckingAccount);
			break;
		case 2:
			// Find existing customer
			System.out.println("Enter a customer ID or LIST to show all customer IDs");
			Customer customerReference = null;
			String customerID = in.nextLine();
			
			// Check if teller entered LIST
			if(customerID.equals("LIST")) {
				for(Customer customer: customers) {
					System.out.println(customer.getCustomerID());
				}
				System.out.println("Enter a Customer ID: ");
				customerID = in.nextLine();
			}
			// Search the customers for the ID			
			for(Customer customer: customers) {
				if(customer.getCustomerID() == customerID) {
					System.out.println("What is the initial balance? $");
					balance = in.nextDouble();
					newCheckingAccount = new CheckingAccount(customer, balance);
					customer.addAccount(newCheckingAccount);
					
				}
			}
		}
		
		return newCheckingAccount;
		
	}
	public static Account createGoldAccount() {
		Scanner in = new Scanner(System.in);
		Double balance;
		// Check if creating new customer or adding to existing
		System.out.println("Are you 1. Creating a new customer?"
				+ " \nor 2. Using existing? \nEnter 1 or 2:");
		
		int choice = getChoice();
		while(choice < 1 | choice > 2) {
			System.out.println("Please Enter 1 or 2");
			choice = getChoice();
		}
		GoldAccount newGoldAccount = null;
		switch(choice) {
		
		case 1: 
			// Create new user
			Customer newCustomer = createCustomer();
			customers.add(newCustomer);
			System.out.println("What is the initial balance? $");
			balance = in.nextDouble();
			newGoldAccount = new GoldAccount(newCustomer, balance);
			newCustomer.addAccount(newGoldAccount);
			accounts.add(newGoldAccount);
			break;
		case 2:
			// Find existing customer
			System.out.println("Enter a customer ID or LIST to show all customer IDs");
			Customer customerReference = null;
			String customerID = in.nextLine();
			
			// Check if teller entered LIST
			if(customerID.equals("LIST")) {
				for(Customer customer: customers) {
					System.out.println(customer.getCustomerID());
				}
				System.out.println("Enter a Customer ID: ");
				customerID = in.nextLine();
			}
			// Search the customers for the ID			
			for(Customer customer: customers) {
				if(customer.getCustomerID() == customerID) {
					System.out.println("What is the initial balance? $");
					balance = in.nextDouble();
					newGoldAccount = new GoldAccount(customer, balance);
					customer.addAccount(newGoldAccount);
					
				}
			}
		}
		
		return newGoldAccount;
		
	}
	public static Account createRegularAccount() {
	
		Scanner in = new Scanner(System.in);
		double balance;
		// Check if creating new customer or adding to existing
		System.out.println("Are you 1. Creating a new customer?"
				+ " \nor 2. Using existing? \nEnter 1 or 2:");
		
		int choice = getChoice();
		while(choice < 1 | choice > 2) {
			System.out.println("Please Enter 1 or 2");
			choice = getChoice();
		}
		RegularAccount newRegularAccount = null;
		switch(choice) {
		case 1: 
			// Create new user
			Customer newCustomer = createCustomer();
			customers.add(newCustomer);
			System.out.print("What is the initial balance? $");
			balance = in.nextDouble();
			newRegularAccount = new RegularAccount(newCustomer, balance);
			newCustomer.addAccount(newRegularAccount);
			accounts.add(newRegularAccount);
			break;
		case 2:
			// Find existing customer
			System.out.println("Enter a customer ID or LIST to show all customer IDs");
			Customer customerReference = null;
			String customerID = in.nextLine();
			
			// Check if teller entered LIST
			if(customerID.equals("LIST")) {
				for(Customer customer: customers) {
					System.out.println(customer.getCustomerID());
				}
				System.out.println("Enter a Customer ID: ");
				customerID = in.nextLine();
			}
			// Search the customers for the ID			
			for(Customer customer: customers) {
				if(customer.getCustomerID() == customerID) {
					System.out.print("What is the initial balance? $");
					balance = in.nextDouble();
					newRegularAccount = new RegularAccount(customer, balance);
					customer.addAccount(newRegularAccount);
					
				}
			}
		}
	
	return newRegularAccount;
	
}
	
	
	public static Customer createCustomer() {
		// Create a new customer object
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a Customer ID:");
		String customerID = in.nextLine();
		
		System.out.println("Enter the Customer's first name: ");
		String firstName = in.nextLine();
		
		System.out.println("Enter the Customer's last name: ");
		String lastName = in.nextLine();
		
		System.out.println("Enter the Customer's address: ");
		String address = in.nextLine();
		
		System.out.println("Enter the Customer's phone number:");
		String phoneNumber = in.nextLine();
		
		Customer newCustomer = new Customer(customerID, firstName, lastName, address, phoneNumber);
		return newCustomer;
	}
	
	
	public static void displayAccountInfo() {
		// Ask if searching by Customer or Account
		System.out.println("Are you searching by 1. Customer or 2. Account?");
		int choice = getChoice();
		if(choice < 1 | choice > 2) {
			System.out.println("Please enter 1 or 2");
			choice = getChoice();
		}else {
			switch(choice) {
			case 1: 
				// Search by customer
				searchAccountInfoByCustomer();
				break;
			case 2:
				// Search by Account
				break;
			}
		}
	}
	public static void searchAccountInfoByCustomer() {
		Scanner in = new Scanner(System.in);
		// Get an Customer from the teller
		System.out.println("What is the Customer's ID");
		String customerID = in.nextLine();
		
		// Check if Customer is in accounts
		boolean isCustomerFound = false;
		Customer currentCustomer = null;
		
		//Search
		for(Customer customer: customers) {
			if(customer.getCustomerID().equals(customerID)) {
				isCustomerFound = true;
				currentCustomer = customer;
			}
		}
		// Check if customer was found
		if(isCustomerFound) {
			printBlanks();
			System.out.println("Customer Found");
			ArrayList<Account> userAccounts = currentCustomer.getAccounts();
			
			// Check if there are accounts
			if(userAccounts.size() > 0) {
				for(Account account: userAccounts) {
					System.out.println("User Accounts:");
					System.out.println(account.getAccountNumber());
					searchAccountInfoByAccount();
				}
			} else {
				System.out.println("No Accounts found");
				keyToContinue();
			}
			
			
			
		} else {
			System.out.println("That is not a valid account number try again");
			searchAccountInfoByCustomer();
		}
		
		
				
	}
	
	public static void searchAccountInfoByAccount() {
		// Prompt teller for account number
		boolean isAccountFound = false;
		System.out.println("Enter an Account Number: ");
		int accountNum = getChoice();
		// If the account number is found getAccountInfo;
		while(!isAccountFound) {
			for(Account account: accounts) {
				if(account.getAccountNumber() == accountNum) {
					printBlanks();
					account.getAccountInfo();
					isAccountFound = true;
					keyToContinue();
				}
			}
			if(!isAccountFound) {
				System.out.println("That account number was not found");
				accountNum = getChoice();
			}
		}
		
		
	}
	
	public static void deposit() {
		Scanner in = new Scanner(System.in);
		// Get account from Teller
		printBlanks();
		System.out.println("What is the Account number: ");
		int accountNum = getChoice();
		boolean isValidAccount = false;
		Account accountReference = null;
		
		// Search for account
		while(!isValidAccount) {
			for(Account account: accounts) {
		
				if(account.getAccountNumber() == accountNum) {
					isValidAccount = true;
					accountReference = account;
				}	
			}
			// Ask for new account
			if(!isValidAccount) {
				System.out.println("That account was not found,"
						+ " Enter a different account");
				accountNum = getChoice();
			}
		}
		// Ask the teller the amount to deposit
		System.out.println("How much are they depositing? $");
		double amount = in.nextDouble();
		accountReference.deposit(amount);
		double balance = accountReference.getBalance();
		System.out.println("New balance: " + balance);
		keyToContinue();
		
		
	}
	
	public static void withdraw() {
		Scanner in = new Scanner(System.in);
		// Get account from Teller
		printBlanks();
		System.out.println("What is the Account number: ");
		int accountNum = getChoice();
		boolean isValidAccount = false;
		Account accountReference = null;
		
		// Search for account
		while(!isValidAccount) {
			for(Account account: accounts) {
		
				if(account.getAccountNumber() == accountNum) {
					isValidAccount = true;
					accountReference = account;
				}	
			}
			if(!isValidAccount) {
				System.out.println("That account was not found,"
						+ " Enter a different account");
				accountNum = getChoice();
			}
			
		}
		
		// Ask the teller the amount to deposit
		System.out.println("How much would they like to withdraw? $");
		double amount = in.nextDouble();
		accountReference.withdraw(amount);
		double balance = accountReference.getBalance();
		System.out.println("New balance: " + balance);
		keyToContinue();
		
		
	}
	
	public static void removeAccount() {
		// Get the Account from the user
		Scanner in = new Scanner(System.in);
		System.out.print("What is the account number for the account? #");
		int accountNum = in.nextInt();
		boolean isValidAccount = false;
		Account accountRef = null;
		
		// Search for account
		
		while(!isValidAccount) {
			for(Account account: accounts) {
				if(account.getAccountNumber() == accountNum) {
					isValidAccount = true;
					accountRef = account;
					
					System.out.println("Account Found");
					
				}
			}
			if(!isValidAccount) {
				System.out.println("That account was not found,"
						+ " please enter a valid account number");
				accountNum = in.nextInt();
			}
		}
		
		
		accounts.remove(accountRef);
		accountRef.removeAccount(accountRef);
		accountRef = null;
		System.out.println("Account has been removed");
		keyToContinue();
		
		
		
		
		
	}
	
	public static void endOfMonth() {
		// Run through all of the accounts and 
		// run the monthly update function
		for(Account account : accounts) {
			account.monthlyUpdates();
		}
	}
	
	public static void displayBankStats() {
		// Display Simple report for bank admin
		
		// Total sum of all accounts
		//  number of zero-balance accounts
		// average balance of accounts
		// The largest balance
		
		// Make Calculations
		double sum = 0;
		double average;
		double largestBalance = accounts.get(0).getBalance();
		Account largestBalanceAccount = null;
		
		ArrayList<Account> zeroBalanceAccounts = new ArrayList<Account>();
		
		// Get total and add Zero balances to list
		for(Account account : accounts) {
			sum += account.getBalance();
			if(account.getBalance() <= 0) {
				zeroBalanceAccounts.add(account);
			}
			if(account.getBalance() > largestBalance) {
				largestBalance = account.getBalance();
				largestBalanceAccount = account;
			}
		}
		
		// Set average after getting total
		average = sum / accounts.size();
		
		// Print Results
		printBlanks();
		System.out.println("Total Sum of all accounts: $" + sum 
				+ "\nNumber of zero-balance accounts: " + zeroBalanceAccounts.size()
				+ "\nAverage Balance of all accounts: $" + average
				+"\nLargest Balance: $" + largestBalance);
		keyToContinue();
		
	}
	
	public static void execute(int choice) {
		printBlanks();
		switch(choice) {
		case 1:
			// Create a Checking Account
			printBlanks();
			System.out.println("Create a Checking Account:");
			createCheckingAccount();
			break;
		case 2:
			// Create a Gold account
			createGoldAccount();
			break;
		case 3:
			//Create a Regular account
			createRegularAccount();
			break;
		case 4:
			// Deposit a specified amount of money to a given account
			deposit();
			break;
		case 5:
			// Withdraw money from a given account
			withdraw();
			break;
		case 6:
			// Display account information
			displayAccountInfo();
			break;
		case 7:
			// Remove an account
			removeAccount();
			break;
		case 8:
			//Apply end of month account updates
			endOfMonth();
			break;
		case 9:
			// Display Bank Statistics
			displayBankStats();
			break;
		case 10:
			// Exits the system
			System.out.println("Goodbye.");
			isProgramRunning = false;
			break;
		default:
			break;
				
		}
	}
	
	private static void printMenu() {
		printBlanks();
		System.out.println("Bank Options:");
		System.out.println("1. Create a Checking account"
				+ "\n2. Create a Gold account"
				+ "\n3. Create a Regular account"
				+ "\n4. Deposit a specified amount of money to a given account"
				+ "\n5. Withdraw money from a given account"
				+ "\n6. Display account information"
				+ "\n7. Remove an account"
				+ "\n8. Apply end of month account updates."
				+ "\n9. Display Bank Statistics"
				+ "\n10. Exit: quits the system.");
		System.out.println("Please enter a number between 1 & 10:");
	}
	private static int getChoice() {
//		Get user selection from menu
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		return choice;
	}
	
	private static void printBlanks() {
		int i = 0;
		while(i<10) {
			System.out.println("\n");
			i++;
		}
	}
	
	private static void keyToContinue() {
		Scanner in = new Scanner(System.in);
		System.out.println("Press Enter key to continue");
		in.nextLine();
	}

}
