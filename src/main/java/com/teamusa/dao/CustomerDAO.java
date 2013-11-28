package com.teamusa.dao;

import com.teamusa.model.Customer;

/*
 * interface that JDBC will implement
 * 
 * need to all all CRUD methods 
 */
public interface CustomerDAO 
{
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}
