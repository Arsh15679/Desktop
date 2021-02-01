package com.support.freshdesksupport.Ticket;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
				ticket.setPriority(Constants.LOW);
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
<<<<<<< HEAD
				if(ticket.getStatus().equalsIgnoreCase(Constants.raised) || ticket.getPriority().equalsIgnoreCase(Constants.LOW)) {
					ticket.setStatus(Constants.pending);
					long checkTime = System.currentTimeMillis()-sdf.parse(ticket.getDate()).getTime(); 
					if(checkTime>259200000) {
						ticket.setPriority(Constants.MEDIUM);
					}
=======
				if(ticket.getStatus().equalsIgnoreCase(Constants.raised) || ticket.getPriority().equalsIgnoreCase(Constants.LOW) ) {
					ticket.setStatus(Constants.pending);
					long checkTime = System.currentTimeMillis()-sdf.parse(ticket.getDate()).getTime(); 
					if(checkTime > 259200000 && checkTime < 604800000 || ticket.getResponse()==null) 
						ticket.setPriority(Constants.MEDIUM);
					else if(checkTime > 604800000 && checkTime < 864000000)
						ticket.setPriority(Constants.high);
					else if(checkTime > 864000000)
						ticket.setPriority(Constants.immediate);
>>>>>>> 2ed1677a77f2d5813b07c914e37e2db23b9da243
					tDao.save(ticket);
				}
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
	
	@Override
	public List<Ticket> getAllTicket() {
		List<Ticket> list = new ArrayList<>();
		try {
			log.warn("finding data");
			Iterator<Ticket> itr = tDao.findAll().iterator();
			log.warn("found in tables");
			Optional<Customer> data ;
			while(itr.hasNext()) {
				Ticket tData = itr.next();
				log.warn(" while data fetching  ");
				data = cusDao.findById(tData.getCusId());
				tData.setCust(data.get());
				list.add(tData);
			}
			log.warn("query done");
		} catch (Exception e) {
			Ticket tData = new Ticket();
			log.warn(e.getLocalizedMessage());
			tData.setError("Exception occured in Iterator");
			list.add(tData);
		}
		return list;
	}
}
