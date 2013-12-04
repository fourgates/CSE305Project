package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Comment;

public class CommentDAO extends AbstractDAO {
	
	public void insert(Comment comment) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, comment.getCommentID());
			ps.setDate(2, comment.getDate());
			ps.setString(3, comment.getContent());
			ps.setInt(4, comment.getPost());
			ps.setInt(5, comment.getAuthor());
			
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
