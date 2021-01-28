package com.support.freshdesksupport.service;

import com.support.freshdesksupport.model.Customer;
import com.support.freshdesksupport.model.Organisation;

public interface ServiceInterface {

	public String registerCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public String updateCustomer(Customer customer);
	
	public Iterable<Customer> showAllCustomer();

	public Organisation getOrganisation(int id);

	public String registerOrganisation(Organisation org);

	public Iterable<Organisation> showAllOrganisation();

	public String updateOrganisation(Organisation org);
}
