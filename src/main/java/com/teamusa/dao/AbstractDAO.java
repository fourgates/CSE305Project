package com.teamusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.teamusa.util.SqlString;
import com.teamusa.util.SqlUtil;

public class AbstractDAO {
	
	protected DataSource dataSource;
	protected SqlUtil sqlUtil = new SqlUtil();
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	protected String createInsertString() {
		SqlString sqlString = this.sqlUtil.createInsertString(this);
		String sql = "INSERT INTO " + sqlString.name + " " + sqlString.columns + " VALUES " + sqlString.values;
		return sql;
	}
	
	protected void delete(String column, String val) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			SqlString sqlString = this.sqlUtil.createInsertString(this);
			String sql = "DELETE FROM " + sqlString.name + " WHERE " + column + " = " + val;
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
}
