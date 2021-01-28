package com.support.freshdesksupport.service;

import com.support.freshdesksupport.model.Customer;

public interface ServiceInterface {

	public String registerCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public String updateCustomer(Customer customer);
	
	public Iterable<Customer> showAllCustomer();
}
