package com.kh.utb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.utb.model.dto.UserDTO;
import com.kh.utb.model.service.UserService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		UserDTO user = new UserDTO(
				request.getParameter("userId"),
				request.getParameter("userPw")
				);
		
		UserDTO resultUser = new UserService().login(user);
		
		System.out.println(resultUser);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("user", resultUser);
		
		String contextPath = request.getContextPath();		
		
		response.sendRedirect(contextPath);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
