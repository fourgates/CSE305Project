package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Employee;
import com.teamusa.util.ConnectionPair;

public class EmployeeDAO extends AbstractDAO {
	
	public void insert(Employee employee) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, employee.getSSN());
			ps.setDate(2, employee.getStartDate());
			ps.setInt(3, employee.getHourlyRate());
			ps.setInt(4, employee.getManager());
			
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
	
	public Employee findByValue(String[] columns, String[] vals) {
		Employee employee = null;
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			if (rs.next()) {
				employee = new Employee(
					rs.getInt("SSN"),
					rs.getDate("Start_Date"),
					rs.getInt("Hourly_Rate"),
					rs.getInt("Manager")
				);
			}
			return employee;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
	
	public ArrayList<Employee> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<Employee> findAllByValue(String[] columns, String[] vals) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			while (rs.next()) {
				employees.add(new Employee(
					rs.getInt("SSN"),
					rs.getDate("Start_Date"),
					rs.getInt("Hourly_Rate"),
					rs.getInt("Manager")
				));
			}
			return employees;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
}
