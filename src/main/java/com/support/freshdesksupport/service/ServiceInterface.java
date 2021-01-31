package com.support.freshdesksupport.service;

import com.support.freshdesksupport.model.Customer;
import com.support.freshdesksupport.model.Organisation;
import com.support.freshdesksupport.model.Response;

public interface ServiceInterface {

	public Response registerCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public Response updateCustomer(Customer customer);
	
	public Iterable<Customer> showAllCustomer();

	public Organisation getOrganisation(int id);

	public Response registerOrganisation(Organisation org);

	public Iterable<Organisation> showAllOrganisation();

	public Response updateOrganisation(Organisation org);

	public Response getOrgLogin(int orgId, String password);
}
