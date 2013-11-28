package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.teamusa.dao.CustomerDAO;
import com.teamusa.model.Customer;

/*
 * JDBC class that connects to mySQL server via dataSource
 * 
 * then runs SQL queries on database 
 */
public class JdbcCustomerDAO implements CustomerDAO
{
	//connection to DB
	private DataSource dataSource;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/*
	 * insert new customer into cutomer table
	 * @see com.teamusa.dao.CustomerDAO#insert(com.teamusa.model.Customer)
	 */
	public void insert(Customer customer){
		
		//create sql query
		String sql = "INSERT INTO CUSTOMER " +
				"(CUST_ID, NAME, AGE) VALUES (?, ?, ?)";
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getName());
			ps.setInt(3, customer.getAge());
			
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
 
	/*
	 * findByCustomerId
	 * find a customer by their ID
	 * @param - customer ID were looking for
	 * @return customer we were looking for 
	 * 
	 * @see com.teamusa.dao.CustomerDAO#findByCustomerId(int)
	 */
	public Customer findByCustomerId(int custId){
		
		//make query
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";
 
		Connection conn = null;
		
		//attempt to connect 
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, custId);
			
			//create new customer to return
			Customer customer = null;
			
			//create result and execture query 
			ResultSet rs = ps.executeQuery();
			
			//instiate customer based on resuluts 
			if (rs.next()) {
				customer = new Customer(
					rs.getInt("CUST_ID"),
					rs.getString("NAME"), 
					rs.getInt("Age")
				);
			}
			
			//close objs
			rs.close();
			ps.close();
			
			//return new customer 
			return customer;
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
}
