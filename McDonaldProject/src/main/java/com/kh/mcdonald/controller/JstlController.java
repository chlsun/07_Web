package com.kh.mcdonald.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mcdonald.model.dto.UserDTO;
import com.kh.mcdonald.model.service.UserService;

@WebServlet("/jstl")
public class JstlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JstlController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int point = 300;
		request.setAttribute("point", point);
		
		String[] colors = {"red", "orange", "orangered", "yellow", "yellowgreen", "greenyellow", "green"};
		request.setAttribute("colors", colors);
		
		
		//TB_USER가지고 할 것
		List<UserDTO> list = new UserService().findAll();
		
		System.out.println(list);
 		
		request.setAttribute("users", list);
		
		if(list.isEmpty()) {
			request.setAttribute("msg", "조회성공");
		}
		
		
		request.getRequestDispatcher("/WEB-INF/views/jstl.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
