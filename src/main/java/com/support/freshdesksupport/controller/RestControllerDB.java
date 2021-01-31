package com.support.freshdesksupport.controller;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author MOHAMMED FAZIL
 * 
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.support.freshdesksupport.Ticket.TicketServiceInterface;
import com.support.freshdesksupport.model.Customer;
import com.support.freshdesksupport.model.Organisation;
import com.support.freshdesksupport.model.Ticket;
import com.support.freshdesksupport.service.ServiceInterface;



@RestController
public class RestControllerDB {

	
	private static final Logger log = LoggerFactory.getLogger(RestControllerDB.class);
	
	@Autowired
	private ServiceInterface customerService;
	@Autowired
	private TicketServiceInterface ticketService;
	
	@GetMapping("/getCustomerDetails")
	@ResponseBody
	public Customer getCustomerDetails(@RequestParam(name = "id")int id) {
		return customerService.getCustomer(id);
	}
	
	@GetMapping("/registerCustomer")
	@ResponseBody
	public String registerCustomer(@RequestBody Customer customer) {
		return customerService.registerCustomer(customer);
	}
	
	@GetMapping("/updateCustomer")
	@ResponseBody
	public String updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	@GetMapping("/getAllCustomerDetails")
	@ResponseBody
	public Iterable<Customer> getAllCustomerDetails() {
		return customerService.showAllCustomer();
	}
	
	
	@GetMapping("/getOrganisationDetails")
	@ResponseBody
	public Organisation getOrganisationDetails(@RequestParam(name = "id")int id) {
		return customerService.getOrganisation(id);
	}
	
	@GetMapping("/registerOrganisation")
	@ResponseBody
	public String registerOrgnisation(@RequestBody Organisation org) {
		return customerService.registerOrganisation(org);
	}
	
	@GetMapping("/updateOrganisation")
	@ResponseBody
	public String updateOrganisation(@RequestBody Organisation org) {
		return customerService.updateOrganisation(org);
	}
	
	@GetMapping("/getAllOrgDetails")
	@ResponseBody
	public Iterable<Organisation> getAllOrgDetails() {
		return customerService.showAllOrganisation();
	}
	
	@GetMapping("/raiseTicket")
	@ResponseBody
	public Ticket raiseTicket(@RequestParam(name = "msg")String msg, @RequestParam(name = "id")int id) {
		
		return ticketService.raiseTicket(msg,id);
	}
	
	@GetMapping("/getTicketStatus")
	@ResponseBody
	public Ticket getTicketStatus(@RequestParam(name = "ticketId")int ticketId) {
		
		return ticketService.getTicketStatus(ticketId);
	}
	
	@GetMapping("/getAllTicket")
	@ResponseBody
	public List<Ticket> getAllTicket(){
		log.warn("getAllTicket API hit...");
		return ticketService.getAllTicket();
	}
}
