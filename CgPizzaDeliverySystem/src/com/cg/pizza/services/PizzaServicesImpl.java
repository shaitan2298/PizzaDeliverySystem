package com.cg.pizza.services;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.pizza.beans.Address;
import com.cg.pizza.beans.Customer;
import com.cg.pizza.beans.Items;
import com.cg.pizza.beans.Order;
import com.cg.pizza.daoservices.PizzaDAO;
import com.cg.pizza.daoservices.PizzaServicesDAOImpl;
import com.cg.pizza.exceptions.CustomerNotFoundException;
import com.cg.pizza.exceptions.InvalidEmailIdException;
import com.cg.pizza.exceptions.InvalidMobileNumberException;
import com.cg.pizza.util.PizzaDBUtil;

public class PizzaServicesImpl implements PizzaServices
{
	private PizzaDAO pizzaDAO;
	public PizzaServicesImpl() {
		pizzaDAO = new PizzaServicesDAOImpl();
	}
    public PizzaServicesImpl(PizzaDAO pizzaDAO)
    {
    	super();
    	this.pizzaDAO = pizzaDAO;
    }
    public  boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
    
    @Override
	public int acceptCustomerDetails(String firstName, String lastName, String mobNumber, String emailId,String city,
			String landmark, long zipCode) throws InvalidMobileNumberException, InvalidEmailIdException {
		Customer customer = new Customer(firstName, lastName, mobNumber, emailId, new Address(city,landmark,zipCode));
		String email = customer.getEmailId();
		if(customer.getMobNumber().length() < 10)
			throw new InvalidMobileNumberException("Invalid Mobile Number!");
		if(!isValid(email))
			throw new InvalidEmailIdException("Invalid Email Id!");
		customer = pizzaDAO.save(customer);
		return customer.getCustId();
	}
    
    @Override
	public Customer getCustomerDetails(int custId) throws CustomerNotFoundException {
		Customer customer = pizzaDAO.findOne(custId);
		if(customer == null)
			throw new CustomerNotFoundException("Sorry Customer Not Found!");
		return customer;
	}
	@Override
	public Customer acceptOrder(int custId, int itemId, int quantity) throws CustomerNotFoundException {
		Customer customer = pizzaDAO.findOne(custId);
		if(customer == null)
		   throw new CustomerNotFoundException("Sorry Customer Not Found!");
		//Order orders = new Order();
		Integer orderId = PizzaDBUtil.getORDER_ID();
		int oId = orderId;
		customer.order.setOrderId(oId);
		customer.order.setQuantity(quantity);
		int totalPrice =calculatePrice(custId, orderId, itemId);
		customer.order.setTotalPrice(totalPrice);
		return customer;
	}

	@Override
	public int calculatePrice(int custId,int orderId, int itemId) throws CustomerNotFoundException {
		Customer customer = getCustomerDetails(custId);
		customer.order.setOrderId(PizzaDBUtil.getORDER_ID());
		Order order = new Order();
		int quantity = customer.order.getQuantity();
		int basicPrice = (int)order.items.get(itemId);
		int withQuantity = (int)basicPrice * quantity;
		int cGST = (int)((withQuantity*10)/100);
		int sGST =(int)((withQuantity*5)/100);
		int totalPrice = (int)(withQuantity + cGST + sGST); 
		return totalPrice;
	}

	@Override
	public List<Customer> showAllCustomers() 
	{
		List<Customer> customer = pizzaDAO.findAll();
		return customer;
	}
	
	
	
}
