package com.kh.myFirstWebProject.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.myFirstWebProject.member.model.dto.MemberDTO;
import com.kh.myFirstWebProject.member.util.UtilJDBC;

public class MemberDAO {
	

	UtilJDBC utilJDBC = new UtilJDBC();
	
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
		
		try(Connection conn = utilJDBC.getConn();
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
	
	
	public int checkId(String memberId) {
		
		int result = 0;
		
		String sql = """
				SELECT 
					COUNT(*) AS count
				FROM 
					KH_MEMBER
				WHERE 
				 	MEMBER_ID = ?
				""";
		
		try(Connection conn = utilJDBC.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, memberId);
			
			/*
			 * case 1 : count(*) 그룹함수를 사용했을 때
			 * 			무조건 ResultSet이 1행이 존재함
			 * 			컬럼 값이 0 / 1인것으로 조회결과 판별
			 * 
			 * try(ResultSet rs = pstmt.executeQuery()){
			 * 		rs.next();
			 * 		result =rs.getInt("count");
			 * }catch(SQLException e) {
			 * 		e.printStackTrace();
			 * }
			 * 
			 * 
			 * case 2 : MEMBER_ID 컬럼을 조회한 경우
			 * 			
			 * 	return pstmt.executeQuery().next();
			 * 			OR
			 * 	return rset.getString("MEMBER_ID");
			 * 
			 */
			
			 try(ResultSet rs = pstmt.executeQuery()){
			 	rs.next();
			 	result = rs.getInt("count");
			 }catch(SQLException e) {
			 	e.printStackTrace();
			 }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	public int signUp(MemberDTO member) {
		
		String sql = """
				INSERT INTO 
					KH_MEMBER
				VALUES
					(?, ?, ?, ?, DEFAULT)
				""";
		
		int result = 0;
		
		try(Connection conn = utilJDBC.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getEmail());
			
			result = pstmt.executeUpdate();
			conn.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public void updateInfo(MemberDTO member) {
		
		String sql = """
				UPDATE  
					KH_MEMBER
				SET
					MEMBER_NAME = ?,
					EMAIL = ?
				WHERE 
					MEMBER_ID = ?
				""";
		
		
		try(Connection conn = utilJDBC.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getMemberId());
			
			pstmt.executeUpdate();
			conn.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public MemberDTO getMember(String memberId) {
		
		String sql = """
				SELECT 
					MEMBER_ID, MEMBER_PW, MEMBER_NAME, EMAIL, ENROLL_DATE
				FROM KH_MEMBER
				WHERE 
					MEMBER_ID = ?
				""";
		
		MemberDTO resultMember = null;
		
		try(Connection conn = utilJDBC.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			) {
			
			pstmt.setString(1, memberId);
			
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
	
	public String checkPw(String memberPw) {
		
		String result = null;
		
		String sql = """
				SELECT 
					MEMBER_ID
				FROM 
					KH_MEMBER
				WHERE 
				 	MEMBER_PW = ?
				""";
		
		try(Connection conn = utilJDBC.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, memberPw);

			
			 try(ResultSet rs = pstmt.executeQuery()){
			 	rs.next();
			 	result = rs.getString("MEMBER_ID");
			 }catch(SQLException e) {
			 	e.printStackTrace();
			 }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public void updatePw(String memberPw, String chageMember) {
		
		String sql = """
				UPDATE  
					KH_MEMBER
				SET
					MEMBER_PW = ?
				WHERE 
					MEMBER_PW = ?
				""";
		
		
		try(Connection conn = utilJDBC.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, chageMember);
			pstmt.setString(2, memberPw);
			
			pstmt.executeUpdate();
			conn.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	public int memberDelete(String memberPw){
		
		int result = 0;
		
		String sql = """
				DELETE
				FROM 
					KH_MEMBER
				WHERE 
					MEMBER_PW = ?
				""";
		
		
		try(Connection conn = utilJDBC.getConn();
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, memberPw);
			
			result = pstmt.executeUpdate();
			conn.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
