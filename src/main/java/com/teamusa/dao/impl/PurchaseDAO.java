package com.teamusa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.teamusa.dao.AbstractDAO;
import com.teamusa.model.Purchase;

public class PurchaseDAO extends AbstractDAO {
	
	public void insert(Purchase purchase) {
		
		//create sql query
		String sql = this.createInsertString();
		Connection conn = null;
		
		//connect to DB
		try {
			conn = dataSource.getConnection();
			//set statement to sql
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//set instance variables of customers 
			ps.setInt(1, purchase.getTransactionID());
			ps.setDate(2, purchase.getDate());
			ps.setInt(3, purchase.getAdvertisement());
			ps.setInt(4, purchase.getNumberOfUnits());
			ps.setInt(5, purchase.getAccount());
			ps.setInt(6, purchase.getUser());
			
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
	
	public Purchase findByValue(String[] columns, String[] vals) {
		Purchase purchase = null;
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			if (rs.next()) {
				purchase = new Purchase(
					rs.getInt("Transaction_Id"),
					rs.getDate("Date"),
					rs.getInt("Advertisement"),
					rs.getInt("Number_Of_Units"),
					rs.getInt("Account"),
					rs.getInt("User")
				);
			}
			return purchase;
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
	
	public ArrayList<Purchase> findAll() {
		return this.findAllByValue(null, null);
	}
	
	public ArrayList<Purchase> findAllByValue(String[] columns, String[] vals) {
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		ResultSet rs = this.createResultSet(columns, vals);
		try {
			while (rs.next()) {
				purchases.add(new Purchase(
					rs.getInt("Transaction_Id"),
					rs.getDate("Date"),
					rs.getInt("Advertisement"),
					rs.getInt("Number_Of_Units"),
					rs.getInt("Account"),
					rs.getInt("User")
				));
			}
			return purchases;
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
