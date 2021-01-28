package com.support.freshdesksupport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.support.freshdesksupport.model.Customer;
import com.support.freshdesksupport.service.ServiceInterface;
//import com.support.freshdesksupport.service.Services;

@RestController
public class RestControllerDB {

	@Autowired
	private ServiceInterface service;
	
	@GetMapping("/getCustomerDetails")
	@ResponseBody
	public Customer getCustomerDetails(@RequestParam(name = "id")int id) {
		return service.getCustomer(id);
	}
	
	@GetMapping("/registerCustomer")
	@ResponseBody
	public String registerCustomer(@RequestBody Customer customer) {
		return service.registerCustomer(customer);
	}
	
	@GetMapping("/updateCustomer")
	@ResponseBody
	public String updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	@GetMapping("/getAllCustomerDetails")
	@ResponseBody
	public Iterable<Customer> getAllCustomerDetails() {
		return service.showAllCustomer();
	}
}
