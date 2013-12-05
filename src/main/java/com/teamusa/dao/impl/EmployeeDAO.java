package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Employee;

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
		ResultSet rs = this.createResultSet(columns, vals);
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public ArrayList<Employee> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<Employee> findAllByValue(String[] columns, String[] vals) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		ResultSet rs = this.createResultSet(columns, vals);
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
		}
	}
}
