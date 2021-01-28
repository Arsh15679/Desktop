package com.support.freshdesksupport.dao;

import org.springframework.data.repository.CrudRepository;

import com.support.freshdesksupport.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
