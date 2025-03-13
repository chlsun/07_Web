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

/**
 * Servlet implementation class UpdateInfoController
 */
@WebServlet("/update-info")
public class UpdateInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateInfoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		MemberDTO member = new MemberDTO(
				request.getParameter("memberId"),
				request.getParameter("memberName"),
				request.getParameter("email")
				);
		
		MemberDTO updateMember = new MemberService().updateInfo(member);
		
		String path = request.getContextPath();
		
		System.out.println("Controller" + updateMember);
		
		if(updateMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", updateMember);
			response.sendRedirect(path);
		}else {
			response.sendRedirect(path + "/myPage");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
