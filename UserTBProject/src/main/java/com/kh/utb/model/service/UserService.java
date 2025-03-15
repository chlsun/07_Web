package com.kh.utb.model.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.utb.common.Template;
import com.kh.utb.model.dao.UserDAO;
import com.kh.utb.model.dto.UserDTO;

public class UserService {
	
	public UserDTO login(UserDTO user) {
		
		SqlSession sqlSession = new Template().getSqlSession();
		
		UserDTO resultUser = new UserDAO().login(sqlSession, user);

		
		sqlSession.close();
		
		return resultUser;
	}
	
	public int signUp(UserDTO user) {
		int result = 0;
		SqlSession sqlSession = new Template().getSqlSession();
		
		result = new UserDAO().checkId(sqlSession, user.getUserId());
		
		if(result > 0) {
			sqlSession.close();
			return result;
		}
		new UserDAO().signUp(sqlSession, user);
		
		sqlSession.close();
		
		return result;
	}

}
