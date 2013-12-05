package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.UserLikesComment;
import com.teamusa.util.ConnectionPair;

public class UserLikesCommentDAO extends AbstractDAO {
	
	public void insert(UserLikesComment ulc) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, ulc.getUser());
			ps.setInt(2, ulc.getComment());
			
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
	
	public UserLikesComment findByValue(String[] columns, String[] vals) {
		UserLikesComment ulc = null;
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			if (rs.next()) {
				ulc = new UserLikesComment(
					rs.getInt("User"),
					rs.getInt("Comment")
				);
			}
			return ulc;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
	
	public ArrayList<UserLikesComment> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<UserLikesComment> findAllByValue(String[] columns, String[] vals) {
		ArrayList<UserLikesComment> ulcs = new ArrayList<UserLikesComment>();
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			while (rs.next()) {
				ulcs.add(new UserLikesComment(
					rs.getInt("User"),
					rs.getInt("Comment")
				));
			}
			return ulcs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
}
