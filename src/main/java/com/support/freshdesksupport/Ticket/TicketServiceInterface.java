package com.support.freshdesksupport.Ticket;

import java.util.Iterator;
import java.util.List;

import com.support.freshdesksupport.model.Ticket;

public interface TicketServiceInterface{

	public Ticket raiseTicket(String msg, int id);

	public Ticket getTicketStatus(int ticketId);

	public List<Ticket> getAllTicket();
}
