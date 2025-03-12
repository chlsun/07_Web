package com.kh.myFirstWebProject.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.myFirstWebProject.member.model.dto.MemberDTO;

@WebServlet("/sign-in")
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignInController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 절차
		// 1) GET / POST => 요청 전송방식이 POST라면 인코딩 작업
		request.setCharacterEncoding("UTF-8");
		
		// 2) 요청값이 있나? 없나? => 있다면 값을 뽑아서 가공
		// request.getParameter("input요소의 name속성값");
		// 						 ㄴ 이게 100% 무조건 input요소의 name속성 값을 적는것은 아님
		
		
		// 3) 값이 두 개 이상일 경우 어딘가에 담기
		MemberDTO member = new MemberDTO(
				request.getParameter("memberId"),
				request.getParameter("memberPw")
				);
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
