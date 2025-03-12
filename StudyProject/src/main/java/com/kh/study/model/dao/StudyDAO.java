package com.kh.study.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.study.model.dto.StudyDTO;

public class StudyDAO {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<StudyDTO> selectAll(){
		
		List<StudyDTO> list = new ArrayList<StudyDTO>();
		
		String sql = """
				SELECT 
					USER_NO,
					USER_ID,
					USER_PW,
					USER_NAME,
					ENROLL_DATE
				FROM 
					TB_USER
				ORDER BY 
					USER_NO DESC
				""";
		
		try(
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@112.221.156.34:12345:XE.",
					"KH26CYS", "KH1234");
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				int userNo = rs.getInt("USER_NO");
				String userId = rs.getString("USER_ID");
				String userPw = rs.getString("USER_PW");
				String userName = rs.getString("USER_NAME");
				Date enrollDate = rs.getDate("ENROLL_DATE");
				
				list.add(new StudyDTO(userNo, userId, userPw, userName, enrollDate));
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
