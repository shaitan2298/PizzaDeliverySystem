package com.cg.pizza.util;

import java.util.HashMap;
import java.util.Random;

import com.cg.pizza.beans.Customer;

public class PizzaDBUtil 
{
	public static HashMap<Integer, Customer> customer = new HashMap<>();
	public static int ORDER_ID_COUNTER = 500;
	public static int CUSTOMER_ID_COUNTER = 100;
	public static int getCUSTOMER_ID_COUNTER()
	{
		return ++CUSTOMER_ID_COUNTER;
	}
	public static int  getORDER_ID() 
	{
		return ++ORDER_ID_COUNTER;	
	}

}
