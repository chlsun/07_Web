package com.kh.myFirstWebProject.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.myFirstWebProject.member.model.dto.MemberDTO;

public class MemberDAO {
	
	private final String URL = "jdbc.oracle.thin:@112.221.156.34:12345:XE";
	private final String USERNAME = "KH26CYS";
	private final String USERPW = "KH1234";
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void login(MemberDTO member) {
		
		String sql = """
				SELECT 
					USER_ID, USER_PW
				FROM KH_MEMBER
				WHERE 
					USER_ID = ?
				AND 
					USER_PW = ?
				""";
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, USERPW);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()
			) {
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());

			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
