package com.kh.utb.model.service;

import com.kh.utb.model.dao.UserDAO;
import com.kh.utb.model.dto.UserDTO;

public class UserService {
	
	public UserDTO login(UserDTO user) {
		
		return new UserDAO().login(user);
	}

}
