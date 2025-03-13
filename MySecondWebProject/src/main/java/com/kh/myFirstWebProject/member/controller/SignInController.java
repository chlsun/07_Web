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
		
		MemberDTO loginMember = new MemberService().signIn(member);
		// case 1. 아이디와 비밀번호 값이 일치했다면
		//		=> 필드값에 회원정보가 담겨있는 MemberDTO객체의 주소값
		// case 2. 유효성 검증에 통과하지 못했거나, 아이디 또는 비밀번호가 일치하지 않았다면
		//		=> null값
		
		// 4) 응답화면 만들기
//		request.setAttribute("loginMember", loginMember);
//		
//		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		// Session Scope는 모든 서블릿과 모든 jsp상에서는 어디서든 사용 가능
		// 1. 서버가 꺼지면 Session에 담겨진 값이 날아감
		// 2. 사용자가 브라우저를 종료할 경우
		// 3. 세션을 강제로 끊는경우 (ex. 로그아웃)
		
		// 쿠키는 키와 벨류값을 저장하는 클라이언트 저장소
		// 서버는 쿠키의 벨류로 사용자를 구분
		
		
		/* 로그인에 성공했다면,
		 * 로그인 한 회원의 정보를
		 * 로그아웃 요청이 들어오거나, 브라우저를 종료하기 전까지는
		 * 계속 사용할 수 있어야 하기 때문에,
		 * Session이라는 저장소에 값을 담아둘 것
		 */
		
		// Session의 자료형 : HttpSession
		HttpSession session = request.getSession();
		
		session.setAttribute("loginMember", loginMember);
		// request.getRequestDispatcher("index.jsp").forward(request, response);
		
		// http://localhost/mfw
		// sendRedirect : Client에게 재 요청할 URL을 알려줘서 Client가 다시 요청을 보내게 만드는 방법
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
