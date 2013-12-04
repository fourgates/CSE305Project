package com.teamusa.dao;

import com.teamusa.model.Account;

public interface AccountDAO  
{
	//Create
	public void insert(Account customer);
	//Read
	public Account findByAccountNumber(int accountNumber);
	//Update
	public void setAccountStatus(String status);
	//Delete
	public void deleteAccount(int accountNumber);
	
}
