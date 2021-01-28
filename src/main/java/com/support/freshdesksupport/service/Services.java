package com.support.freshdesksupport.service;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.freshdesksupport.dao.CustomerRepository;
import com.support.freshdesksupport.dao.SupportRepository;
import com.support.freshdesksupport.model.Customer;

@Service
public class Services implements ServiceInterface{

	@Autowired
	private SupportRepository dao;
	@Autowired
	private CustomerRepository cusDao;
	
	private static final Logger log = LoggerFactory.getLogger(Services.class);
	
	@Override
	public Customer getCustomer(int id) {
		Customer dat;
		try {
			
			if(cusDao.existsById(id)) {
				Optional<Customer> data = cusDao.findById(id);
				dat = data.get();
				return dat;
			}else {
				dat = new Customer();
				dat.setName("No data Found");
				return dat;
				}
		} catch (Exception e) {
			log.warn("Exception in Registering Customer : " + e.getLocalizedMessage());
			dat = new Customer();
			dat.setName("Exception Occured");
			return dat;
		}
		
	}
	
	@Override
	public String registerCustomer(Customer customer) {
		try {

			if(cusDao.existsById(customer.getId()))
				return "Customer Already Exist..!";
			else 
				cusDao.save(customer);
			return "Registered";
		} catch (Exception e) {
			log.warn("Exception in Registering Customer : " + customer.getName());
			return "Error Occured";
		}
		
	}
	
	@Override
	public Iterable<Customer> showAllCustomer() {
		Iterable<Customer> itr = cusDao.findAll();
		return itr;
	}
	
	@Override
	public String updateCustomer(Customer customer) {
		
		try {
			if(cusDao.existsById(customer.getId())) {
				cusDao.save(customer);
				return "Updated Successfully";
			}
			else 
				return "No customer found in this Name";
		} catch (Exception e) {
			log.warn("Exception in Updating Customer : " + e.getLocalizedMessage());
			return "Exception Occured";

		}
	}
}
