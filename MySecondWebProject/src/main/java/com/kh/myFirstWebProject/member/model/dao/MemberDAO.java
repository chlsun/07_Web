package com.kh.myFirstWebProject.member.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.myFirstWebProject.member.model.dto.MemberDTO;
import com.kh.myFirstWebProject.member.util.UtilJDBC;

public class MemberDAO {
	
	public MemberDTO login(SqlSession sqlSession, MemberDTO member) {
		
		/*
		 * sqlSession.selectOne();
		 * 
		 * sqlSession.selectList();
		 * */
		
		// SqlSession이 제공하는 메소드를 통해 SQL문을 찾아서 실행하고 결과를 받을 수 있음
		
		// sqlSession.sql문 종류에 맞는 메소드("mapper파일의 namespace.SQL문의id속성값");
		// MemberDTO loginMember = sqlSession.selectOne("memberMapper.login", member);
		
		return sqlSession.selectOne("memberMapper.login", member);

	}
	
	public boolean checkId(SqlSession sqlSession, String memberId) {
		
		return (Integer)sqlSession.selectOne("memberMapper.checkId", memberId) > 0 ? true : false;
	}
	
	public int signUp(SqlSession sqlSession, MemberDTO member) {
		
		
		
		return sqlSession.insert("memberMapper.signUp" ,member);
	}
	

}
