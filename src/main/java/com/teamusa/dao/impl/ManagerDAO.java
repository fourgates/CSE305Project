package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Manager;
import com.teamusa.util.ConnectionPair;

public class ManagerDAO extends AbstractDAO {
	
	public void insert(Manager manager) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, manager.getSSN());
			ps.setDate(2, manager.getStartDate());
			ps.setInt(3, manager.getHourlyRate());
			
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
	
	public Manager findByValue(String[] columns, String[] vals) {
		Manager manager = null;
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			if (rs.next()) {
				manager = new Manager(
					rs.getInt("SSN"),
					rs.getDate("Start_Date"),
					rs.getInt("Hourly_Rate")
				);
			}
			return manager;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
	
	public ArrayList<Manager> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<Manager> findAllByValue(String[] columns, String[] vals) {
		ArrayList<Manager> managers = new ArrayList<Manager>();
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			while (rs.next()) {
				managers.add(new Manager(
					rs.getInt("SSN"),
					rs.getDate("Start_Date"),
					rs.getInt("Hourly_Rate")
				));
			}
			return managers;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
}
