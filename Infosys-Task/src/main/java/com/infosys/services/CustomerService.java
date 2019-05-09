package com.infosys.services;

import org.apache.log4j.Logger;

import com.infosys.dao.CustomerDAO;
import com.infosys.models.Customer;

public class CustomerService {

	private static Logger log = Logger.getLogger(CustomerService.class);
	
	
	private CustomerDAO custDao = new CustomerDAO();
	
	public Customer getCustomerById(int id) {
		
		return custDao.getById(id);
		
	}
	
}
