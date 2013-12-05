package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Circle;
import com.teamusa.util.ConnectionPair;

public class CircleDAO extends AbstractDAO {
	
	public void insert(Circle circle) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, circle.getCircleID());
			ps.setString(2, circle.getCircleName());
			ps.setInt(3, circle.getOwnerOfCircle());
			ps.setString(4, circle.getType());
			
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
	
	public Circle findByValue(String[] columns, String[] vals) {
		Circle circle = null;
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			if (rs.next()) {
				circle = new Circle(
					rs.getInt("Circle_Id"),
					rs.getString("Circle_NAME"),
					rs.getInt("Owner_Of_Circle"),
					rs.getString("Type")
				);
			}
			return circle;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
	
	public ArrayList<Circle> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<Circle> findAllByValue(String[] columns, String[] vals) {
		ArrayList<Circle> circles = new ArrayList<Circle>();
		ConnectionPair connPair = this.createResultSet(columns, vals);
		ResultSet rs = connPair.rs;
		try {
			while (rs.next()) {
				circles.add(new Circle(
					rs.getInt("Circle_Id"),
					rs.getString("Circle_NAME"),
					rs.getInt("Owner_Of_Circle"),
					rs.getString("Type")
				));
			}
			return circles;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			this.closeConnections(connPair);
		}
	}
}
