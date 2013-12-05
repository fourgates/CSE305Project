package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Message;
import com.teamusa.util.ConnectionPair;

public class MessageDAO extends AbstractDAO {
	
	public void insert(Message message) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, message.getMessageID());
			ps.setDate(2, message.getDate());
			ps.setString(3, message.getSubject());
			ps.setString(4, message.getContent());
			ps.setInt(5, message.getSender());
			ps.setInt(6, message.getReceiver());
			
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
	
	public Message findByValue(String[] columns, String[] vals) {
		Message message = null;
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		Connection conn = connPair.conn;
		try {
			if (rs.next()) {
				message = new Message(
					rs.getInt("Message_Id"),
					rs.getDate("Date"),
					rs.getString("Subject"),
					rs.getString("Content"),
					rs.getInt("Sender"),
					rs.getInt("Receiver")
				);
			}
			return message;
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
	
	public ArrayList<Message> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<Message> findAllByValue(String[] columns, String[] vals) {
		ArrayList<Message> messages = new ArrayList<Message>();
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		Connection conn = connPair.conn;
		try {
			while (rs.next()) {
				messages.add(new Message(
					rs.getInt("Message_Id"),
					rs.getDate("Date"),
					rs.getString("Subject"),
					rs.getString("Content"),
					rs.getInt("Sender"),
					rs.getInt("Receiver")
				));
			}
			return messages;
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
