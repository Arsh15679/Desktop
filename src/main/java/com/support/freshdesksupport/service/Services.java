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

import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import com.support.freshdesksupport.dao.CustomerRepository;
import com.support.freshdesksupport.dao.OrganisationRepository;
import com.support.freshdesksupport.data.Constants;
import com.support.freshdesksupport.model.Customer;
import com.support.freshdesksupport.model.Organisation;
import com.support.freshdesksupport.model.Response;


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
			dat.setName(Constants.EXCEPTION);
			return dat;
		}
		
	}
	
	@Override
	public Response registerCustomer(Customer customer) {
		Response res = new Response();
		try {

			if(cusDao.existsById(customer.getId())) {
				res.setResponse(Constants.FAILURE);
				res.setError("Customer Already Exist..!");
			}else { 
				cusDao.save(customer);
				res.setResponse(Constants.REGISTERED);
			}
		} catch (Exception e) {
			log.warn("Exception in Registering Customer : " + customer.getName());
			res.setResponse(Constants.ERROR);
			res.setError(Constants.EXCEPTION);
		}
		return res;
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
	public Response updateCustomer(Customer customer) {
		Response res = new Response();
		try {
			if(cusDao.existsById(customer.getId())) {
				cusDao.save(customer);
				res.setResponse(Constants.UPDATED);
			}
			else { 
				res.setResponse(Constants.FAILURE);
				res.setError("No customer found in this Name");
			}
		} catch (Exception e) {
			log.warn("Exception in Updating Customer : " + e.getLocalizedMessage());
			res.setResponse(Constants.ERROR);
			res.setError(Constants.EXCEPTION);
		}
		return res;
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
			dat.setOrgName(Constants.EXCEPTION);
			return dat;
		}
		
	}
	
	@Override
	public Response registerOrganisation(Organisation org) {
		Response res = new Response();
		try {

			if(orgDao.existsById(org.getOrgId())) {
				res.setResponse(Constants.FAILURE);
				res.setError("Organisation Already Exist..!");
			}else { 
				orgDao.save(org);
				res.setResponse(Constants.REGISTERED);
			}
		} catch (Exception e) {
			log.warn("Exception in Registering Customer : " + org.getOrgName());
			res.setResponse(Constants.ERROR);
			res.setError(Constants.EXCEPTION);
		}
		return res;
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
	public Response updateOrganisation(Organisation org) {
		Response res = new Response();
		try {
			if(orgDao.existsById(org.getOrgId())) {
				orgDao.save(org);
				res.setResponse(Constants.UPDATED);
			}
			else {
				res.setResponse(Constants.FAILURE);
				res.setError("No organisation found in this Name");
			}
		} catch (Exception e) {
			log.warn("Exception in Updating Customer : " + e.getLocalizedMessage());
			res.setResponse(Constants.ERROR);
			res.setError(Constants.EXCEPTION);

		}
		return res;
	}
	
	@Override
	public Response getOrgLogin(int orgId, String password) {
		Response res = new Response();
		try {
			if(orgDao.existsById(orgId)) {
				if(orgDao.findById(orgId).get().getPassword().equals(password)) {
					res.setResponse(Constants.SUCCESS);
				}else {
					res.setResponse(Constants.FAILURE);
					res.setError("wrong password");
				}
			}else {
				res.setResponse(Constants.FAILURE);
				res.setError("No Organisation found in this Id :" + orgId);
			}
		} catch (Exception e) {
			log.warn("Exception in Login Organisa : " + e.getLocalizedMessage());
			res.setResponse(Constants.ERROR);
			res.setError(Constants.EXCEPTION);
		}
		return res;
	}
	
}
