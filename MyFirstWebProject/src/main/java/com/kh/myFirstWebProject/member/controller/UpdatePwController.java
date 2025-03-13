package com.kh.myFirstWebProject.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.myFirstWebProject.member.model.dto.MemberDTO;
import com.kh.myFirstWebProject.member.model.service.MemberService;


@WebServlet("/update-pw")
public class UpdatePwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePwController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String memberPw = request.getParameter("memberPw");
		String changePw = request.getParameter("changePw");
		
		
		MemberDTO newMember = new MemberService().updatePw(memberPw, changePw); 
		
		String path = request.getContextPath();
		
		if(newMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", newMember);
			
			
		}else {

		}
		
		response.sendRedirect(path + "/myPage");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
