package com.support.freshdesksupport.dao;


import org.springframework.data.repository.CrudRepository;

import com.support.freshdesksupport.model.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer>{
	
}
