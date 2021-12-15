package com.gbs;

import java.util.List;
import java.util.Scanner;


import org.springframework.web.client.RestTemplate;

import com.gbs.entity.User;
import com.gbs.entity.UserResponse;


public class ClientApp {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		System.out.println("******************************");
		System.out.println("WELCOME TO GBS BANKING!");
		System.out.println("******************************");
		System.out.println("[1] SIGN IN");
		System.out.println("[2] SIGN UP");
		System.out.println("[3] EXIT");

		System.out.print("SELECT ACTION: ");
		int Sc = new Scanner(System.in).nextInt();
		if (Sc == 1) {
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
//				if (userName.equals(user.getUserName())) {
//					found = true;
//				}
				if (found) {
					
					System.out.println("Login Success!");
					header();
					validated(userName);
					
				} else {
					System.out.println("Login Failed!");
					main(null);
					}
					
					
				} else {
					if (Sc == 2) {
						System.out.println("******************");
						System.out.println("SIGN UP HERE");
						System.out.println("******************");
						System.out.println("Username: " );
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
						
						
					} else {
						main(null);
					}
				}
		
		
			}
	public static void validated(String userName) {
		
		System.out.println("*************************");
		System.out.println("WELCOME " + userName );
		System.out.println("[1] PERSONAL INFORMATION");
		System.out.println("[2] DISPLAY ACCOUNTS");
		System.out.println("[3] LOGOUT");
		int choice = new Scanner(System.in).nextInt();
		
		
		if (choice==1) {
			personalInfo(userName);
		} 
		else if (choice==2) {
			
		}
		else main(null); {
			
		}
	}
	
	public static void personalInfo(String userName) {
		
		RestTemplate usersRestTemplate = new RestTemplate();
		final String restApiURLString = "http://localhost:8081/ecz/api/userdetails";
		UserResponse userResponse = usersRestTemplate.getForObject(restApiURLString, UserResponse.class);
//		boolean found = false;
		List<User> users = userResponse.getUsers();
		for (User user : users) {
			if (userName.equals(user.getUserName())) {
			System.out.println("****************************");
			System.out.println("USER INFORMATION");
			System.out.println("****************************");
			System.out.println("Username: " + user.getUserName());
			System.out.println("Password: DISABLE ");
			System.out.println("Creation Date: " + user.getCreationDate());
			System.out.println("Number of Accounts: " + user.getNumberOfAccounts());
			System.out.println("List of Accounts: " + user.getListOfAccounts());
			System.out.println("Total Balance: " + user.getTotalBalance());
			System.out.println("Contact Number: " + user.getContactNumber());
			validated(userName);
			}
		}
		
	}
	public static void header() {
		System.out.println("******************************");
		System.out.println("WELCOME TO GBS BANKING!");
		System.out.println("******************************");
	}
			
		}
	

