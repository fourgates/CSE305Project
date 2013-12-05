package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.UserLikesPost;
import com.teamusa.util.ConnectionPair;

public class UserLikesPostDAO extends AbstractDAO {
	
	public void insert(UserLikesPost ulp) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, ulp.getUser());
			ps.setInt(2, ulp.getPost());
			
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
	
	public UserLikesPost findByValue(String[] columns, String[] vals) {
		UserLikesPost ulp = null;
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			if (rs.next()) {
				ulp = new UserLikesPost(
					rs.getInt("User"),
					rs.getInt("Post")
				);
			}
			return ulp;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
	
	public ArrayList<UserLikesPost> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<UserLikesPost> findAllByValue(String[] columns, String[] vals) {
		ArrayList<UserLikesPost> ulps = new ArrayList<UserLikesPost>();
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			while (rs.next()) {
				ulps.add(new UserLikesPost(
					rs.getInt("User"),
					rs.getInt("Post")
				));
			}
			return ulps;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
}
