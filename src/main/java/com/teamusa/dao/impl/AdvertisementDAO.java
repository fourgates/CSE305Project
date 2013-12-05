package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Advertisement;
import com.teamusa.util.ConnectionPair;

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
	
	public Advertisement findByValue(String[] columns, String[] vals) {
		Advertisement advertisement = null;
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		Connection conn = connPair.conn;
		try {
			if (rs.next()) {
				advertisement = new Advertisement(
					rs.getInt("Advertisement_Id"),
					rs.getInt("Employee"),
					rs.getString("Type"),
					rs.getDate("Date"),
					rs.getString("Company"),
					rs.getString("Item_Name"),
					rs.getString("Content"),
					rs.getInt("Unit_Price"),
					rs.getInt("Availabe_Units")
				);
			}
			return advertisement;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
	
	public ArrayList<Advertisement> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<Advertisement> findAllByValue(String[] columns, String[] vals) {
		ArrayList<Advertisement> advertisements = new ArrayList<Advertisement>();
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		Connection conn = connPair.conn;
		try {
			while (rs.next()) {
				advertisements.add(new Advertisement(
					rs.getInt("Advertisement_Id"),
					rs.getInt("Employee"),
					rs.getString("Type"),
					rs.getDate("Date"),
					rs.getString("Company"),
					rs.getString("Item_Name"),
					rs.getString("Content"),
					rs.getInt("Unit_Price"),
					rs.getInt("Availabe_Units")
				));
			}
			return advertisements;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
}
