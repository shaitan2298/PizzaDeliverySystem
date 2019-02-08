package com.cg.pizza.daoservices;
import java.util.List;

import com.cg.pizza.beans.Customer;

public interface PizzaDAO 
{
    Customer save(Customer customer);
    boolean update(Customer customer);
    Customer findOne(int custId);
    List<Customer> findAll();
    
}
