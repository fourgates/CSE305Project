package com.teamusa.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionPair {
	
	public ResultSet rs;
	public Connection conn;
	public PreparedStatement ps;
	
	public ConnectionPair(ResultSet rs, Connection conn, PreparedStatement ps) {
		this.rs = rs;
		this.conn = conn;
		this.ps = ps;
	}

}
