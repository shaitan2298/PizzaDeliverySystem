package com.cg.pizza.services;

import java.util.HashMap;
import java.util.List;

import com.cg.pizza.beans.Customer;
import com.cg.pizza.beans.Items;
import com.cg.pizza.beans.Order;
import com.cg.pizza.exceptions.CustomerNotFoundException;
import com.cg.pizza.exceptions.InvalidEmailIdException;
import com.cg.pizza.exceptions.InvalidMobileNumberException;

public interface PizzaServices 
{
	public int acceptCustomerDetails(String firstName,String lastName,String mobNumber, String emailId, String city, String landmark,
			long zipCode) throws InvalidMobileNumberException, InvalidEmailIdException;
	 
	public Customer getCustomerDetails(int custId) throws CustomerNotFoundException;
	
     public Customer acceptOrder(int custId,int itemId, int quantity) 
    		 throws CustomerNotFoundException;
     
     public int calculatePrice(int custId,int orderId, int itemId) throws CustomerNotFoundException;
     
     List<Customer> showAllCustomers();
}
