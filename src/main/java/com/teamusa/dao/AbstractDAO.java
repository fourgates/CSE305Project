package com.teamusa.dao;

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
}
