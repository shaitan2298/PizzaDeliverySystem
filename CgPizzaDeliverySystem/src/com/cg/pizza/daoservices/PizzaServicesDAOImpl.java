package com.cg.pizza.daoservices;

import java.util.ArrayList;
import java.util.List;

import com.cg.pizza.beans.Customer;
import com.cg.pizza.util.PizzaDBUtil;

public class PizzaServicesDAOImpl implements PizzaDAO
{

	@Override
	public Customer save(Customer customer) {
		customer.setCustId(PizzaDBUtil.getCUSTOMER_ID_COUNTER());
		 /* customer.order.setOrderId(PizzaDBUtil.getORDER_ID());
		 * PizzaDBUtil.customer.put(customer.getCustId(), customer);
		 */
		PizzaDBUtil.customer.put(customer.getCustId(),customer);
		return customer;
	}

	@Override
	public boolean update(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer findOne(int custId) {
		return PizzaDBUtil.customer.get(custId);
	}

	@Override
	public List<Customer> findAll() {
		ArrayList<Customer> customer = new ArrayList<>(PizzaDBUtil.customer.values());
		return customer;
	}

}
