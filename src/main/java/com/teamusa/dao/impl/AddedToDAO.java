package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.AddedTo;
import com.teamusa.util.ConnectionPair;

public class AddedToDAO extends AbstractDAO {
	
	public void insert(AddedTo addedTo) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, addedTo.getUserID());
			ps.setInt(2, addedTo.getCircleID());
			
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
	
	public AddedTo findByValue(String[] columns, String[] vals) {
		AddedTo addedTo = null;
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			if (rs.next()) {
				addedTo = new AddedTo(
					rs.getInt("User_Id"),
					rs.getInt("Circle_Id")
				);
			}
			return addedTo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
	
	public ArrayList<AddedTo> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<AddedTo> findAllByValue(String[] columns, String[] vals) {
		ArrayList<AddedTo> addedTos = new ArrayList<AddedTo>();
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		Connection conn = connPair.conn;
		try {
			while (rs.next()) {
				addedTos.add(new AddedTo(
					rs.getInt("User_Id"),
					rs.getInt("Circle_Id")
				));
			}
			return addedTos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
}
