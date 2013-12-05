package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.UserHasAccount;

public class UserHasAccountDAO extends AbstractDAO {
	
	public void insert(UserHasAccount uha) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, uha.getUserID());
			ps.setInt(2, uha.getAccountNumber());
			
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
	
	public UserHasAccount findByValue(String[] columns, String[] vals) {
		UserHasAccount uha = null;
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			if (rs.next()) {
				uha = new UserHasAccount(
					rs.getInt("User_Id"),
					rs.getInt("Account_Number")
				);
			}
			return uha;
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
	
	public ArrayList<UserHasAccount> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<UserHasAccount> findAllByValue(String[] columns, String[] vals) {
		ArrayList<UserHasAccount> uhas = new ArrayList<UserHasAccount>();
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			while (rs.next()) {
				uhas.add(new UserHasAccount(
					rs.getInt("User_Id"),
					rs.getInt("Account_Number")
				));
			}
			return uhas;
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
