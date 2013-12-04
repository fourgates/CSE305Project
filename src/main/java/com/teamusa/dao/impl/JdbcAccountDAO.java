/**
 * 
 */
package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.teamusa.dao.AccountDAO;
import com.teamusa.model.Account;
import com.teamusa.model.Customer;

/**
 * @author teamusa
 * 
 */
public class JdbcAccountDAO implements AccountDAO {
	
	//connection to DB
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void insert(Account customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Account findByAccountNumber(int accountNumber) {
		String sql = "SELECT * FROM account WHERE Account_Number = ?";

		Connection conn = null;

		// attempt to connect
		try {
			conn = dataSource.getConnection();
			// set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, accountNumber);

			// create new customer to return
			Account account = null;

			// create result and execture query
			ResultSet rs = ps.executeQuery();

			// instiate customer based on resuluts
			if (rs.next()) {
				account = new Account(rs.getInt("Account_Number"),rs.getDate("Account_Creation_Date"),
						rs.getInt("Credit_Card_Number"),rs.getString("Status"));
			}

			// close objs
			rs.close();
			ps.close();

			// return new customer
			return account;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void setAccountStatus(String status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAccount(int accountNumber) {
		// TODO Auto-generated method stub

	}

}
