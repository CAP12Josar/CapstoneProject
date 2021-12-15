package com.gbs;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import com.gbs.entity.Transaction;
import com.gbs.stub.AccountResponse;
import com.gbs.stub.UserResponse;

import gom.gbs.model.Account;
import gom.gbs.model.User;

public class ClientApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String choiceWhile;
		do {
			
			System.out.println("******************************");
			System.out.println("WELCOME TO GBS BANKING!");
			System.out.println("******************************");
			System.out.println("[1] SIGN IN");
			System.out.println("[2] SIGN UP");
			System.out.println("[3] EXIT");

			System.out.print("SELECT ACTION: ");

			String Sc = new Scanner(System.in).next();
			if (Sc.equals("1")) {
				System.out.println("Please login");
				System.out.println("Username: ");
				String userName = new Scanner(System.in).nextLine();

				System.out.println("Password: ");
				String userPassword = new Scanner(System.in).nextLine();

				RestTemplate usersRestTemplate = new RestTemplate();
				final String restApiURLString = "http://localhost:8081/ecz/api/usersResponse";
				UserResponse userResponse = usersRestTemplate.getForObject(restApiURLString, UserResponse.class);
				boolean found = false;
				List<User> users = userResponse.getUsers();
				for (User user : users) {

					String valusername = user.getUserName().toString();
					String valuserpassword = user.getUserPassword().toString();
					boolean validation = (valusername.equals(userName) && valuserpassword.equals(userPassword));
					if (validation) {
						found = true;
					}

				}

				if (found) {

					System.out.println("Login Success!");
					header();
					validated(userName);

				} else {
					System.out.println("Login Failed!");
					main(null);
				}

			} else if (Sc.equals("2")) {
					System.out.println("******************");
					System.out.println("SIGN UP HERE");
					System.out.println("******************");

					System.out.println("Username: ");
					String username = new Scanner(System.in).nextLine();

					System.out.println("Password");
					String password = new Scanner(System.in).nextLine();

					System.out.println("Creation Date MM/DD/YEAR");
					String cdate = new Scanner(System.in).nextLine();

					System.out.println("Number of Accounts");
					int numberfaccounts = new Scanner(System.in).nextInt();

					System.out.println("List of Accounts");
					String listofaccounts = new Scanner(System.in).nextLine();

					System.out.println("Total Balance");
					Float totalbalance = new Scanner(System.in).nextFloat();

					System.out.println("Contact Number");
					String cnumber = new Scanner(System.in).nextLine();

					RestTemplate signRestTemplate = new RestTemplate();
					final String restApiURLString = "http://localhost:8081/ecz/api/register";

					User regUser = new User();
					regUser.setUserName(username);
					regUser.setUserPassword(password);
					regUser.setCreationDate(cdate);
					regUser.setNumberOfAccounts(numberfaccounts);
					regUser.setListOfAccounts(listofaccounts);
					regUser.setTotalBalance(totalbalance);
					regUser.setContactNumber(cnumber);

					User createUser = signRestTemplate.postForObject(restApiURLString, regUser, User.class);
					System.out.println("**************************");
					System.out.println("REGISTRATION COMPLETE!");
					System.out.println("**************************");
					main(null);

				} else if(Sc.equals("3")) {
						System.out.println("Program Terminated...");
						System.exit(0);
					}else {
						System.out.println("Invalid Input.");
				} 
			System.out.println("Try again? (Y/N)");
			choiceWhile = new Scanner(System.in).next();
		}while(choiceWhile.equalsIgnoreCase("Y"));

		
		
		
	}

	public static void validated(String userName) {

		do {
			System.out.println("WELCOME " + userName);
			System.out.println("[1] PERSONAL INFORMATION");
			System.out.println("[2] ACCOUNTS");
			System.out.println("[3] TRANSFER FUNDS");
			System.out.println("[4] LOGOUT");
			int choice = new Scanner(System.in).nextInt();

			if (choice == 1) {
				personalInfo(userName);

			} else if (choice == 2) {
				displayAccount(userName);

			} else if (choice == 3) {
				transferFunds(userName);
			} else
				main(null);
			{

			}
		} while (true);

	}

	public static void personalInfo(String userName) {

		RestTemplate usersRestTemplate = new RestTemplate();
		final String restApiURLString = "http://localhost:8081/ecz/api/userdetails";
		UserResponse userResponse = usersRestTemplate.getForObject(restApiURLString, UserResponse.class);
		List<User> users = userResponse.getUsers();
		for (User user : users) {
			if (userName.equals(user.getUserName())) {

				System.out.println("****************************");
				System.out.println("USER INFORMATION");
				System.out.println("****************************");
				System.out.println("Username: " + user.getUserName());
				System.out.println("Password: " + user.getUserPassword());
				System.out.println("Creation Date: " + user.getCreationDate());
				System.out.println("Number of Accounts: " + user.getNumberOfAccounts());
				System.out.println("List of Accounts: " + user.getListOfAccounts());
				System.out.println("Total Balance: " + user.getTotalBalance());
				System.out.println("Contact Number: " + user.getContactNumber());
				System.out.println("");
				validated(userName);
			}
		}

	}

	public static void header() {
		System.out.println("******************************");
		System.out.println("WELCOME TO GBS BANKING!");
		System.out.println("******************************");
		System.out.println("");
	}

	public static void transferFunds(String Username) {

		RestTemplate accountRestTemplate = new RestTemplate();
		final String accountRestApiURLString = "http://localhost:9091/ecz/api/accountsResponse";
		AccountResponse accountResponse = accountRestTemplate.getForObject(accountRestApiURLString,
				AccountResponse.class);

		Scanner input = new Scanner(System.in);
		System.out.println("**** Enter Account Number ****");
		System.out.println("To Send: ");
		String fromAccount = input.next();
		boolean foundFrom = false;
		for (Account fromAccountFound : accountResponse.getAccounts()) {
			if (fromAccountFound.getAccountNumber().equals(fromAccount)) {
				foundFrom = true;
			}

		}
		if (!foundFrom) {
			System.out.println("Invalid account number!");
		} else {
			System.out.println("To Receive: ");
			String toAccount = input.next();
			boolean foundTo = false;
			for (Account toAccountFound : accountResponse.getAccounts()) {
				if (toAccountFound.getAccountNumber().equals(toAccount)) {
					foundTo = true;
				}

			}

			if (!foundTo) {
				System.out.println("Invalid account number of receiver!");
			} else {
				System.out.println("Enter Amount: ");
				String amount = input.next();
				double amountDouble = Double.parseDouble(amount);
				boolean amountBalanceValid = false;
				
				
				for (Account amountValid : accountResponse.getAccounts()) {
					
					if(amountValid.getAccountNumber().equals(fromAccount)) {
//						System.out.println(amountValid.getAccountBalance() + amoutDouble);
						
						if (amountValid.getAccountBalance() >= amountDouble) {
							System.out.println(amountValid.getAccountBalance());
							amountBalanceValid = true;
						}

					}

					
				}

				if (!amountBalanceValid) {
					System.out.println("You don't have enough balance");
				} else {

					System.out.println("\nYou transfer money to: " + toAccount + ": " + amount + " successfully.");
					System.out.println("--------------------------------------------");
					
					//OPERATION FOR BOTH ACCOUNT
					//OPERATION FOR SENDER
					boolean isSuccess = false;
					for (Account fromBalance : accountResponse.getAccounts()) {

						if (fromBalance.getAccountNumber().equals(fromAccount)) {
							
							double newBalance = fromBalance.getAccountBalance() - amountDouble;
							Account account2 = new Account();
							account2.setAccountNumber(fromBalance.getAccountNumber());
							account2.setUserNameString(fromBalance.getUserName());
							account2.setAccountBalance(newBalance);
							
							final String updateBalanceURL = "http://localhost:9091/ecz/api/account/" + fromBalance.getAccountNumber();
							accountRestTemplate.put(updateBalanceURL, account2);
							
							System.out.println("Your new balance is "+newBalance);
							isSuccess = true;
							
						
						}

					}
					
					if(isSuccess) {
						//OPERATION FOR RECEIVER
						
						for (Account toBalance : accountResponse.getAccounts()) {

							if (toBalance.getAccountNumber().equals(toAccount)) {
								
								double newBalance2 = toBalance.getAccountBalance() + amountDouble;
								Account account3 = new Account();
								account3.setAccountNumber(toBalance.getAccountNumber());
								account3.setUserNameString(toBalance.getUserName());
								account3.setAccountBalance(newBalance2);
								
								final String updateBalanceURL = "http://localhost:9091/ecz/api/account/" + toBalance.getAccountNumber();
								accountRestTemplate.put(updateBalanceURL, account3);
								
								System.out.println("Receiver new balance is "+newBalance2);
								
								transactionReport(fromAccount, toAccount, amountDouble);
												
							}
					}
					
				}

			}

		}
		}
		
		
 		
		

//	

	}
	
	public static void transactionReport(String fromAccount, String toAccount, double amount) {
		
		Random rnd = new Random();
		int number = rnd.nextInt(999999999);
		String randomString = String.format("%9d", number);
		
		RestTemplate transactionRestTemplate = new RestTemplate();
		final String transactionRestApiURLString = "http://localhost:9091/ecz/api/transaction/TransactionDetails";
		Transaction transaction = new Transaction();
		transaction.setTransactionId(randomString);
		transaction.setAccountBalance(amount);
		transaction.setFromAccount(fromAccount);
		transaction.setToAccount(toAccount);
		Transaction saveTransaction = transactionRestTemplate.postForObject(transactionRestApiURLString, transaction, Transaction.class);
		
		
		System.out.println("--------------------------------------------");
		System.out.println("Transaction Report");
		System.out.println("--------------------------------------------");
		System.out.println();
		System.out.println("Transaction Id: " +randomString);
		System.out.println("From Account Number: " +fromAccount);
		System.out.println("To Accountt Number: "+toAccount);
		System.out.println("With amont of: "+amount);
		
		
		
		
		
		
	}

//	public static void displayTransaction() {
//		RestTemplate transactionRestTemplate = new RestTemplate();
//		final String responseApi = "http://localhost:9091/ecz/api/transactionResponse";
//		TransactionResponse transactionsResponse = transactionRestTemplate.getForObject(responseApi,
//				TransactionResponse.class);
//		// DISPLAYING MY TRANSACTION ID THAT IS AN AUTO GENERATED INTEGER
//		for (Transaction transaction : transactionsResponse.getTransactions()) {
//			System.out.println("Transaction Id :" + transaction.getTransactionId());
//			System.out.println("Transaction from Account Number:" + transaction.getFromAccount());
//			System.out.println("Transaction to Account Number:" + transaction.getToAccount());
//			System.out.println("Amount transferred: " + transaction.getAmount());
//		}
//	}
	public static void displayAccount(String userName) {

		RestTemplate accountRestTemplate = new RestTemplate();
		final String restApiURLString = "http://localhost:9091/ecz/api/accountsResponse";
		AccountResponse accountResponse = accountRestTemplate.getForObject(restApiURLString, AccountResponse.class);
		List<Account> accountList = accountResponse.getAccounts();
		for (Account account : accountList) {
			if (account.getUserName().equals(userName)) {

				System.out.println("******ACCOUNT******");

				System.out.println("Accounts Number: " + account.getAccountNumber());
				System.out.println("Username: " + account.getUserName());
				System.out.println("Account Balance: " + account.getAccountBalance());

				System.out.println("**************************");
				System.out.println("");
			}

		}

	}

}
