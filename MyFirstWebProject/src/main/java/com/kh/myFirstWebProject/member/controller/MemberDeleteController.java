package com.kh.myFirstWebProject.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.myFirstWebProject.member.model.service.MemberService;

@WebServlet("/member-delete")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemberDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String memberPw = request.getParameter("memberPw");
		
		int result = new MemberService().memberDelete(memberPw); 
		
		String path = request.getContextPath();
		
		if(result > 0) {
			HttpSession session = request.getSession();
			session.removeAttribute("loginMember");
			
			response.sendRedirect(path);
		}else {
			response.sendRedirect(path + "/myPage");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
