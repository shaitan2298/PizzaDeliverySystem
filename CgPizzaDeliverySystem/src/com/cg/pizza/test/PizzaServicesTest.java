package com.cg.pizza.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.pizza.beans.Address;
import com.cg.pizza.beans.Customer;
import com.cg.pizza.exceptions.CustomerNotFoundException;
import com.cg.pizza.services.PizzaServices;
import com.cg.pizza.services.PizzaServicesImpl;
import com.cg.pizza.util.PizzaDBUtil;

import junit.framework.Assert;

public class PizzaServicesTest {

	 private static PizzaServices pizzaServices;
	   
	   @BeforeClass
	   public static void setUpTestEnv()
	   {
		   pizzaServices = new PizzaServicesImpl();
	   }
	   @Before
	   public void setUpTestData()
	   {
		   Customer customer1 = new Customer(101, "Ankita", "Dutta", "9435592532", "ankdutta04@gmail.com", 
				   new Address("Guwahati","HDFC Bank",781012));
		   Customer customer2 = new Customer(102, "Subodra", "Banik", "9501747636", "sub999@gmail.com", 
				   new Address("Guwahati","Vishal Mega Mart",781011));
		   
		   PizzaDBUtil.customer.put(customer1.getCustId(), customer1);
		   PizzaDBUtil.customer.put(customer2.getCustId(), customer2);
		   
		   PizzaDBUtil.CUSTOMER_ID_COUNTER = 102;
	   }
	   
	   @Test(expected = CustomerNotFoundException.class)
	   public void testGetCustomerDetailsForInvalidCustomerId() throws CustomerNotFoundException
	   {
		   pizzaServices.getCustomerDetails(1234);
	   }
	   @Test
	   public void testGetCustomerDetailsForValidCustomerId() throws CustomerNotFoundException
	   {
		   Customer expectedCustomer = new Customer(101, "Ankita", "Dutta", "9435592532", "ankdutta04@gmail.com", 
				   new Address("Guwahati","HDFC Bank",781012));
		   Customer actualCustomer = pizzaServices.getCustomerDetails(101);
		   Assert.assertEquals(expectedCustomer, actualCustomer);
	   }
       @Test(expected = CustomerNotFoundException.class)
       public void testGetCalculatePriceForInvalidCustomerId() throws CustomerNotFoundException
       {
    	   pizzaServices.calculatePrice(1234, 643921, 6);
       }
       @Test
       public void testGetCalculatePriceForValidCustomerId() throws CustomerNotFoundException
       {
    	   int expectedPrice = 103;
    	   int actualPrice  = pizzaServices.calculatePrice(101, 502, 1);
    	   Assert.assertEquals(expectedPrice, actualPrice);
       }

	/*
	 * @Test public void testShowAllCustomers() throws CustomerNotFoundException {
	 * Customer customer1 = new Customer(101, "Ankita", "Dutta", "9435592532",
	 * "ankdutta04@gmail.com", new Address("Guwahati","HDFC Bank",781012)); Customer
	 * customer2 = new Customer(102, "Subodra", "Banik", "9501747636",
	 * "sub999@gmail.com", new Address("Guwahati","Vishal Mega Mart",781011));
	 * ArrayList<Customer> expectedCustomerList = new ArrayList<>();
	 * expectedCustomerList.add(customer1); expectedCustomerList.add(customer2);
	 * ArrayList<Customer> actualCustomerList =
	 * (ArrayList<Customer>)pizzaServices.showAllCustomers();
	 * Collections.sort(expectedCustomerList); Collections.sort(actualCustomerList);
	 * Assert.assertEquals(expectedCustomerList, actualCustomerList); }
	 */
       @After
       public void tearDownTestData()
       {
       	PizzaDBUtil.customer.clear();
       	PizzaDBUtil.CUSTOMER_ID_COUNTER=100;
       	PizzaDBUtil.ORDER_ID_COUNTER=500;
       }
       @AfterClass
       public static void tearDownTestEnv()
       {
       	pizzaServices = null;
       }
       
}
