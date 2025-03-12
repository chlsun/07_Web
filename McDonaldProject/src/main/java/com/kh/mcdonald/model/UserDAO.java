package com.kh.mcdonald.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.mcdonald.model.dto.UserDTO;

public class UserDAO {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public List<UserDTO> findAll(){
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		
		String sql = """
				SELECT 
					USER_NO, USER_ID, USER_PW, USER_NAME, ENROLL_DATE
				FROM
					TB_USER
				ORDER BY
					ENROLL_DATE DESC
				""";
		
		try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345:XE", 
															"KH26_CYS", "KH1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()) {
				
				list.add(new UserDTO(
						rs.getInt("USER_NO"),
						rs.getString("USER_ID"),
						rs.getString("USER_PW"),
						rs.getString("USER_NAME"),
						rs.getDate("ENROLL_DATE")
						));
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	
	
	public int setUser(String userId, String userPw, String userName) {
		
		String sql = """
				
				""";
		try(
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34::12345:XE", 
															"KH26_CYS", "KH1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
		}catch(SQLException e) {
			
		}
		
		return 1;
	}
}
