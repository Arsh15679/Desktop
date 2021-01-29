package com.support.freshdesksupport.service;

/**
 * @author MOHAMMED FAZIL
 * 
 */

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.freshdesksupport.dao.CustomerRepository;
import com.support.freshdesksupport.dao.OrganisationRepository;

import com.support.freshdesksupport.model.Customer;
import com.support.freshdesksupport.model.Organisation;


@Service
public class Services implements ServiceInterface{

	@Autowired
	private CustomerRepository cusDao;
	@Autowired
	private OrganisationRepository orgDao;
	
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
		Iterable<Customer> itr = null;
		try {
			itr = cusDao.findAll();
			return itr;
		} catch (Exception e) {
			log.warn("Exception in showingAll Customer : " + e.getLocalizedMessage());
			return  itr;
		}
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
	
	
	@Override
	public Organisation getOrganisation(int id) {
		Organisation dat;
		try {
			
			if(orgDao.existsById(id)) {
				Optional<Organisation> data = orgDao.findById(id);
				dat = data.get();
				return dat;
			}else {
				dat = new Organisation();
				dat.setOrgName("No data Found");
				return dat;
				}
		} catch (Exception e) {
			log.warn("Exception in Registering Customer : " + e.getLocalizedMessage());
			dat = new Organisation();
			dat.setOrgName("Exception Occured");
			return dat;
		}
		
	}
	
	@Override
	public String registerOrganisation(Organisation org) {
		try {

			if(orgDao.existsById(org.getOrgId()))
				return "Customer Already Exist..!";
			else 
				orgDao.save(org);
			return "Registered";
		} catch (Exception e) {
			log.warn("Exception in Registering Customer : " + org.getOrgName());
			return "Error Occured";
		}
		
	}
	
	@Override
	public Iterable<Organisation> showAllOrganisation() {
		Iterable<Organisation> itr = null;
		try {
			itr = orgDao.findAll();
			return itr;
		} catch (Exception e) {
			log.warn("Exception in showingAll Customer : " + e.getLocalizedMessage());
			return  itr;
		}
	}
	

	@Override
	public String updateOrganisation(Organisation org) {
		
		try {
			if(orgDao.existsById(org.getOrgId())) {
				orgDao.save(org);
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
