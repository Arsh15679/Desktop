package com.support.freshdesksupport.Ticket;

import com.support.freshdesksupport.model.Ticket;

public interface TicketServiceInterface{

	public Ticket raiseTicket(String msg, int id);

	public Ticket getTicketStatus(int ticketId);
}
