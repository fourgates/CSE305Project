package com.teamusa.util;

import java.sql.Connection;
import java.sql.ResultSet;

public class ConnectionPair {
	
	public ResultSet rs;
	public Connection conn;
	
	public ConnectionPair(ResultSet rs, Connection conn) {
		this.rs = rs;
		this.conn = conn;
	}

}
