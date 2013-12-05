package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.UserPreferences;
import com.teamusa.util.ConnectionPair;

public class UserPreferencesDAO extends AbstractDAO {
	
	public void insert(UserPreferences up) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, up.getID());
			ps.setString(2, up.getPreference());
			
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
	
	public UserPreferences findByValue(String[] columns, String[] vals) {
		UserPreferences up = null;
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		Connection conn = connPair.conn;
		try {
			if (rs.next()) {
				up = new UserPreferences(
					rs.getInt("Id"),
					rs.getString("Preferences")
				);
			}
			return up;
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
	
	public ArrayList<UserPreferences> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<UserPreferences> findAllByValue(String[] columns, String[] vals) {
		ArrayList<UserPreferences> ups = new ArrayList<UserPreferences>();
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		Connection conn = connPair.conn;
		try {
			while (rs.next()) {
				ups.add(new UserPreferences(
					rs.getInt("Id"),
					rs.getString("Preferences")
				));
			}
			return ups;
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
