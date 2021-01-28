package com.support.freshdesksupport.dao;


import org.springframework.data.repository.CrudRepository;

import com.support.freshdesksupport.model.Ticket;

public interface SupportRepository extends CrudRepository<Ticket, Integer>{
	
}
