package com.cg.pizza.client;

import java.util.Scanner;

import com.cg.pizza.beans.Order;
import com.cg.pizza.exceptions.CustomerNotFoundException;
import com.cg.pizza.exceptions.InvalidEmailIdException;
import com.cg.pizza.exceptions.InvalidMobileNumberException;
import com.cg.pizza.services.PizzaServices;
import com.cg.pizza.services.PizzaServicesImpl;
import com.cg.pizza.util.PizzaDBUtil;

public class MainClass {

	
		
		static Scanner sc = new Scanner(System.in);
		static PizzaServices pizzaServices = new PizzaServicesImpl();
		Order orders = new Order();

		public static void main(String[] args) throws CustomerNotFoundException, InvalidMobileNumberException,
		InvalidEmailIdException
		{
			welcomeInterface();
			int choice = sc.nextInt();
		    selectServices(choice);
		}
		
		public static void selectServices(int choice) throws CustomerNotFoundException, InvalidMobileNumberException, InvalidEmailIdException
		{
			switch(choice)
			{
			case 1: try
			{
				System.out.println("Hello, Fill the following fields to open an account");
				System.out.println("Enter first name: ");
				String firstName = sc.next();
				System.out.println("Enter last name: ");
				String lastName = sc.next();
				System.out.println("Enter your mobile number: ");
				String mobNumber = sc.next();
				System.out.println("Enter your emailId: ");
				String emailId = sc.next();
				System.out.println("Enter your city: ");
				String city = sc.next();
				System.out.println("Enter landmark: ");
				String landmark = sc.next();
				System.out.println("Enter zipCode: ");
				long zipCode = sc.nextLong();
				System.out.println("Your Customer Id is: ");
				System.out.println(pizzaServices.acceptCustomerDetails(firstName,lastName,mobNumber,
						emailId,city,landmark,zipCode));
			    System.out.println("**********************Thank You For Registering With Us*************************");
				
			}
			catch(InvalidMobileNumberException | InvalidEmailIdException e)
			{
				e.printStackTrace();
			}
			break;
			case 2: try{
				System.out.println("Enter the Customer Id: ");
				int custId = sc.nextInt();
				System.out.println(pizzaServices.getCustomerDetails(custId));
			}
			catch(CustomerNotFoundException e)
			{
				e.printStackTrace();
			}
			break;
			
			case 3: try {
				showMenu();
				System.out.println("Enter your choice: ");
				int itemId = sc.nextInt();
				System.out.println("Enter your customeId: ");
				int custId = sc.nextInt();
				System.out.println("Enter the quantity: ");
				int quantity = sc.nextInt();
				System.out.println(pizzaServices.acceptOrder(custId, itemId, quantity));
			} catch (CustomerNotFoundException e) 
		{

				e.printStackTrace();
		}
		break;
			
			case 4: System.out.println("Have a look at our menu!!");
	        showMenu();
			break;
			
			case 5:
				System.out.println(pizzaServices.showAllCustomers());
				break;
			default: System.out.println("Invalid Choice! Please Try Again");            
			}
			System.out.println("What do you want to do now?");
			System.out.println("1. Continue \n 2. Exit");
			int select = sc.nextInt();
			if(select == 2)
				System.exit(0);
			main(null);
		}
		public static void welcomeInterface() 
		{
			System.out.println("*****************Welcome to Domino's Pizza********************");
		    System.out.println("1. New User? Open Your Account");
			System.out.println("2. Get your account details");
			System.out.println("3. Place Your Order");
			System.out.println("4. Display the Menu");
			System.out.println("5. Display all Customers.");
			
		}
		public static void showMenu()
		{
			System.out.println("1. Onion Pizza---------------------------------Rs.90");
			System.out.println("2. Cheese Pizza---------------------------------Rs.110");
			System.out.println("3. FarmHouse Pizza---------------------------------Rs.190");
			System.out.println("4. Chicken Pizza---------------------------------Rs.220");
		}
			
	}


