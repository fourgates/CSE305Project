package com.teamusa.dao;

import com.teamusa.model.Account;
import com.teamusa.model.Customer;

public interface AccountDAO {
	public void insert(Account customer);

	public Account findByAccountNumber(int accountNumber);
}
