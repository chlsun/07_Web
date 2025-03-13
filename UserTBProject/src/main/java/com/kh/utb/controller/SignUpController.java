package com.kh.utb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.utb.model.dto.UserDTO;
import com.kh.utb.model.service.UserService;

@WebServlet("/sign-up")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		UserDTO user = new UserDTO(
				request.getParameter("userId"),
				request.getParameter("userPw"),
				request.getParameter("userName")
				);
		
		int result = new UserService().signUp(user);
		
		String path = request.getContextPath();
		
		if(result > 0 ) {
			response.sendRedirect(path);
		}else {
			response.sendRedirect(path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
