package com.kh.burgerking.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.burgerking.model.dto.UserDTO;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/sign-up.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost에서 doGet을 호출");
		
		/* 
		 * 컨트롤러
		 * 
		 * 1. request 객체로부터 값을 뽑아서 DTO로 가공
		 * 
		 * 2. 요청 처리
		 *
		 * 3. VIEW 처리
		 */
		// POST방식일 경우 인코딩 설정 ISO-8859-1방식으로 바뀌기 때문에 한글문자 깨짐
		// 값을 뽑기 전에 미리 UTF-8방식으로 변경해줘야함
		request.setCharacterEncoding("UTF-8");
		
		// 1) 값 뽑기
		// request.getParameter("input요소의 name속성값");
		
		String userId = request.getParameter("userId");
		System.out.println(userId);
		String userPw = request.getParameter("userPw");
		System.out.println(userPw);
		String userName = request.getParameter("userName");
		System.out.println(userName);
		
		UserDTO user = new UserDTO(userId, userPw, userName);
		
		// service.insertMember(user);
		// 잘다녀왔다고 가정
		
		// VIEW 처리
		
		// JSP를 이용해서 응담데이터 만들기
		
		// JSP : Java기반의 서버 사이드 스크립트 언어
		// 그 외) ASP, PHP 
		
		
		// -----------------------------------------------------
		// 응답화면(JSP)에서 필요한 데이터를 넘겨줄 것 -> request에 담아서
		
		// Attribute => 키 : 밸류 세트로 묶어서 값을 담을 수 있음
		request.setAttribute("user", user);
		request.setAttribute("message", "요청 처리에 성공했습니다");
		
		// -----------------------------------------------------
		
		
		
		// 응답페이지를 JSP에게 위임(배정)
		
		// RequestDispatcher
		// 매개변수도 들어가는 파일 경로는 webapp에서 부터 시작
		RequestDispatcher view = request.getRequestDispatcher("./views/response_page.jsp");
		
		// view에 request, response를 전달
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출됨");
		doGet(request, response);
	}

}
