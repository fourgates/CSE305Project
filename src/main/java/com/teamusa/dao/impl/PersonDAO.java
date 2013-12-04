package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Person;

public class PersonDAO extends AbstractDAO {
	
	public void insert(Person person) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, person.getSSN());
			ps.setString(2, person.getLastName());
			ps.setString(3, person.getFirstName());
			ps.setString(4, person.getAddress());
			ps.setString(5, person.getCity());
			ps.setString(6, person.getState());
			ps.setInt(7, person.getZipcode());
			ps.setInt(8, person.getTelephoneNumber());;
			ps.setString(9, person.getEmailAddress());
			
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

}
