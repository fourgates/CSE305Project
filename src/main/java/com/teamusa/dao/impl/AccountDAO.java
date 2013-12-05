package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Account;

public class AccountDAO extends AbstractDAO {
	
	public void insert(Account account) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, account.getAccountNumber());
			ps.setDate(2, account.getAccountCreationDate());
			ps.setInt(3, account.getCreditCardNumber());
			ps.setString(4, account.getStatus());
			
			//update table with query
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public Account findByValue(String[] columns, String[] vals) {
		Account account = null;
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			if (rs.next()) {
				account = new Account(
					rs.getInt("Account_Number"),
					rs.getDate("Account_Creation_Date"),
					rs.getInt("Credit_Card_Number"),
					rs.getString("Status")
				);
			}
			return account;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public ArrayList<Account> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<Account> findAllByValue(String[] columns, String[] vals) {
		ArrayList<Account> accounts = new ArrayList<Account>();
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			while (rs.next()) {
				accounts.add(new Account(
					rs.getInt("Account_Number"),
					rs.getDate("Account_Creation_Date"),
					rs.getInt("Credit_Card_Number"),
					rs.getString("Status")
				));
			}
			return accounts;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
		}
	}
}
