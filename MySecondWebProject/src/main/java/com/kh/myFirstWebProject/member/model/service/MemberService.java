package com.kh.myFirstWebProject.member.model.service;

import org.apache.ibatis.session.SqlSession;

import static com.kh.myFirstWebProject.common.Template.getSqlSession;
import com.kh.myFirstWebProject.member.model.dao.MemberDAO;
import com.kh.myFirstWebProject.member.model.dto.MemberDTO;


public class MemberService {
	
	public MemberDTO login(MemberDTO member) {
		// JDBCUtil클래스로부터
		// static Method로 구현해놓은
		// getConnection 메서드를 호출하여
		// Connection객체를 반환
		
		
		// import static com.kh.myFirstWebProject.common.Template.getSqlSession;
		// static 메서드는 위에 방법처럼 import하면 클래스명 선언 안하고 메서드 사용 가능!!
		SqlSession sqlSession = getSqlSession();
		
		return null;
	}
	

}
