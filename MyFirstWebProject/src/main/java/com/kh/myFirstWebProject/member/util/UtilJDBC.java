package com.kh.myFirstWebProject.member.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilJDBC {
	
	private final String URL = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
	private final String USERNAME = "KH26_CYS";
	private final String USERPW = "KH1234";
	
	
	public Connection getConn() {
		Connection conn = null;
		
		try{
			conn = DriverManager.getConnection(URL, USERNAME, USERPW);
			
			conn.setAutoCommit(false);
			
			return conn ;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
}
