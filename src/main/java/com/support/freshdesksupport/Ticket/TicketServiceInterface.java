package com.support.freshdesksupport.Ticket;

import java.util.Iterator;

import com.support.freshdesksupport.model.Ticket;

public interface TicketServiceInterface{

	public Ticket raiseTicket(String msg, int id);

	public Ticket getTicketStatus(int ticketId);

	public Iterator<Ticket> getAllTicket();
}
