package com.kh.utb.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.utb.model.dto.UserDTO;

public class UserDAO {
	
	private final String URL = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
	private final String USERNAME = "KH26_CYS";
	private final String USERPW = "KH1234";
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public UserDTO login(UserDTO user) {
		
		String sql = """
				SELECT 
					USER_NO, USER_ID, USER_PW, USER_NAME, ENROLL_DATE
				FROM 
					TB_USER
				WHERE 
					USER_ID = ?
				AND 
					USER_PW = ?
				""";
		UserDTO resultUser = null;
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, USERPW);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			
			
			try(ResultSet rs = pstmt.executeQuery()) {
				
				if(rs.next()) {
					resultUser = new UserDTO(
							rs.getInt("USER_NO"),
							rs.getString("USER_ID"),
							rs.getString("USER_PW"),
							rs.getString("USER_NAME"),
							rs.getDate("ENROLL_DATE")
							);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return resultUser;
	}
	
	
	public int signUp(UserDTO user) {
		
		int result = 0;
		
		String sql = """
				INSERT INTO 
					TB_USER
				VALUES
					(SEQ_USER_NO.NEXTVAL, ?, ?, ?, DEFAULT)
				""";
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, USERPW);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}
