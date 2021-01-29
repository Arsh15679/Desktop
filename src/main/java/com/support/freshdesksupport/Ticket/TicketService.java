package com.support.freshdesksupport.Ticket;

import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.support.freshdesksupport.dao.CustomerRepository;
import com.support.freshdesksupport.dao.TicketRepository;
import com.support.freshdesksupport.data.Constants;
import com.support.freshdesksupport.model.Customer;
import com.support.freshdesksupport.model.Ticket;
import com.support.freshdesksupport.service.Services;

@Service
public class TicketService implements TicketServiceInterface{
	
	private static final Logger log = LoggerFactory.getLogger(Services.class);
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	@Autowired
	private CustomerRepository cusDao;
	@Autowired
	private TicketRepository tDao;
	
	@Override
	public Ticket raiseTicket(String msg, int id) {
		Ticket ticket = new Ticket();
		try {
			if(cusDao.existsById(id)) {
				Random rand = new Random();
				ticket.setTicketId(rand.nextInt(10000));
				ticket.setPriority(Constants.low);
				ticket.setStatus(Constants.raised);
				ticket.setIssue(msg);
				Optional<Customer> data = cusDao.findById(id);
				ticket.setCust(data.get());
				ticket.setCusId(data.get().getId());
				ticket.setDate(sdf.format(System.currentTimeMillis()));
				tDao.save(ticket);
			}else {
				ticket.setError("No Customer Found in this Id :" + id);
			}
		} catch (Exception e) {
			log.warn(e.getLocalizedMessage());
			ticket.setError("Exception occured :" + id);
			return ticket;
		}
		return ticket;
	}
	
	@Override
	public Ticket getTicketStatus(int ticketId) {
		Ticket ticket = new Ticket();
		try {
			if(tDao.existsById(ticketId)) {
				Optional<Ticket> data = tDao.findById(ticketId);
				ticket = data.get();
				Optional<Customer> cData = cusDao.findById(ticket.getCusId());
				
				ticket.setCust(cData.get());
			}
			else {
				ticket.setError("No ticket found id this ticket Id : " + ticketId );
			}
		} catch (Exception e) {
			log.warn(e.getLocalizedMessage());
			ticket.setError("Exception occured :" + ticketId);
		}
		return ticket;
	}
}
