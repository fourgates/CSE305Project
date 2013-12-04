package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Advertisement;

public class AdvertisementDAO extends AbstractDAO {
	
	public void insert(Advertisement advertisement) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, advertisement.getAdvertisementID());
			ps.setInt(2, advertisement.getEmployee());
			ps.setString(3, advertisement.getType());
			ps.setDate(4, advertisement.getDate());
			ps.setString(5, advertisement.getCompany());
			ps.setString(6, advertisement.getItemName());
			ps.setString(7, advertisement.getContent());
			ps.setInt(8, advertisement.getUnitPrice());
			ps.setInt(9, advertisement.getAvailableUnits());
			
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
