package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.User;

public class UserDAO extends AbstractDAO {
	
	public void insert(User user) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, user.getSSN());
			ps.setInt(2, user.getUserID());
			ps.setDate(3, user.getAccountCreationDate());
			ps.setInt(4, user.getRating());
			
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
	
	public User findByValue(String[] columns, String[] vals) {
		User user = null;
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			if (rs.next()) {
				user = new User(
					rs.getInt("SSN"),
					rs.getInt("User_Id"),
					rs.getDate("Account_Creation_Date"),
					rs.getInt("Rating")
				);
			}
			return user;
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
	
	public ArrayList<User> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<User> findAllByValue(String[] columns, String[] vals) {
		ArrayList<User> users = new ArrayList<User>();
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			while (rs.next()) {
				users.add(new User(
					rs.getInt("SSN"),
					rs.getInt("User_Id"),
					rs.getDate("Account_Creation_Date"),
					rs.getInt("Rating")
				));
			}
			return users;
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
