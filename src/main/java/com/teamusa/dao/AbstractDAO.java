package com.teamusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.teamusa.util.ConnectionPair;
import com.teamusa.util.SqlString;
import com.teamusa.util.SqlUtil;

public class AbstractDAO {
	
	public DataSource dataSource;
	public SqlUtil sqlUtil = new SqlUtil();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	protected String createInsertString() {
		SqlString sqlString = this.sqlUtil.createInsertString(this);
		String sql = "INSERT INTO " + sqlString.name + " " + sqlString.columns + " VALUES " + sqlString.values;
		return sql;
	}
	
	protected ConnectionPair createResultSet(String[] columns, String[] vals) {
		String condition = "";
		if (columns != null && vals != null) {
			condition += " WHERE ";
			if (columns.length != vals.length) {
				System.err.println("ERROR: Select failed. Must have a value for each column.");
			} else {
				for (int i=0; i<columns.length-1; i++) {
					for (int j=0; j<vals.length-1; i++) {
						condition += columns[i];
						condition += vals[0];
						condition += " AND ";
					}
				}
				condition += columns[columns.length-1];
				condition += vals[vals.length-1];
			}
		}
		
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			SqlString sqlString = this.sqlUtil.createInsertString(this);
			String sql = "SELECT * FROM " + sqlString.name + condition;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ConnectionPair connPair = new ConnectionPair(rs, conn, ps);
			return connPair;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(String column, String val, String condition) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			SqlString sqlString = this.sqlUtil.createInsertString(this);
			String sql = "UPDATE " + sqlString.name + " SET " + column + " = " + val + " WHERE " + condition;
			PreparedStatement ps = conn.prepareStatement(sql);
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
	
	public void delete(String condition) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			SqlString sqlString = this.sqlUtil.createInsertString(this);
			String sql = "DELETE FROM " + sqlString.name + " WHERE " + condition;
			PreparedStatement ps = conn.prepareStatement(sql);
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
	
	public void closeConnections(ConnectionPair connPair) {
		if (connPair.rs != null) {
			try {
				connPair.rs.close();
			} catch (SQLException e) {}
		}
		if (connPair.ps != null) {
			try {
				connPair.ps.close();
			} catch (SQLException e) {}
		}
		if (connPair.conn != null) {
			try {
				connPair.conn.close();
			} catch (SQLException e) {}
		}
	}
}
