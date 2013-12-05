package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Post;

public class PostDAO extends AbstractDAO {
	
	public void insert(Post post) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, post.getPostID());
			ps.setDate(2, post.getDate());
			ps.setString(3, post.getContent());
			ps.setInt(4, post.getCommentCount());
			ps.setInt(5, post.getCircle());
			ps.setInt(6, post.getAuthor());
			
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
	
	public Post findByValue(String[] columns, String[] vals) {
		Post post = null;
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			if (rs.next()) {
				post = new Post(
					rs.getInt("Post_Id"),
					rs.getDate("Date"),
					rs.getString("Content"),
					rs.getInt("Comment_Count"),
					rs.getInt("Circle"),
					rs.getInt("Author")
				);
			}
			return post;
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
	
	public ArrayList<Post> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<Post> findAllByValue(String[] columns, String[] vals) {
		ArrayList<Post> posts = new ArrayList<Post>();
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			while (rs.next()) {
				posts.add(new Post(
					rs.getInt("Post_Id"),
					rs.getDate("Date"),
					rs.getString("Content"),
					rs.getInt("Comment_Count"),
					rs.getInt("Circle"),
					rs.getInt("Author")
				));
			}
			return posts;
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
