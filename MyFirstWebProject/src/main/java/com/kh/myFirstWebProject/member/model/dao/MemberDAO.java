package com.kh.myFirstWebProject.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.myFirstWebProject.member.model.dto.MemberDTO;

public class MemberDAO {
	
	private final String URL = "jdbc:oracle:thin:@112.221.156.34:12345:XE";
	private final String USERNAME = "KH26_CYS";
	private final String USERPW = "KH1234";
	
	static {
		try {
			/* FullClassName : "경로 + 클래스"
			 * ex) "oracle.jdbc.OracleDriver"  */
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public MemberDTO signIn(MemberDTO member) {
		
		String sql = """
				SELECT 
					MEMBER_ID, MEMBER_PW, MEMBER_NAME, EMAIL, ENROLL_DATE
				FROM KH_MEMBER
				WHERE 
					MEMBER_ID = ?
				AND 
					MEMBER_PW = ?
				""";
		
		MemberDTO resultMember = null;
		
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, USERPW);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			) {
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					resultMember = new MemberDTO(
							rs.getString("MEMBER_ID"),
							rs.getString("MEMBER_PW"),
							rs.getString("MEMBER_NAME"),
							rs.getString("EMAIL"),
							rs.getDate("ENROLL_DATE")
							);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return resultMember;
	}

}
