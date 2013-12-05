package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public Comment findByValue(String[] columns, String[] vals) {
		Comment comment = null;
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			if (rs.next()) {
				comment = new Comment(
					rs.getInt("Comment_Id"),
					rs.getDate("Date"),
					rs.getString("Content"),
					rs.getInt("Post"),
					rs.getInt("Author")
				);
			}
			return comment;
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
	
	public ArrayList<Comment> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<Comment> findAllByValue(String[] columns, String[] vals) {
		ArrayList<Comment> comments = new ArrayList<Comment>();
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			while (rs.next()) {
				comments.add(new Comment(
					rs.getInt("Comment_Id"),
					rs.getDate("Date"),
					rs.getString("Content"),
					rs.getInt("Post"),
					rs.getInt("Author")
				));
			}
			return comments;
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
