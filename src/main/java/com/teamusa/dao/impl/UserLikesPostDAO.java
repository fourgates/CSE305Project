package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.UserLikesPost;

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

}
