package com.support.freshdesksupport.dao;

import org.springframework.data.repository.CrudRepository;

import com.support.freshdesksupport.model.Customer;
import com.support.freshdesksupport.model.Organisation;

public interface OrganisationRepository extends CrudRepository<Organisation, Integer>{

}
