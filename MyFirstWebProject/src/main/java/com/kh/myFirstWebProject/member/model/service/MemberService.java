package com.kh.myFirstWebProject.member.model.service;

import com.kh.myFirstWebProject.member.model.dao.MemberDAO;
import com.kh.myFirstWebProject.member.model.dto.MemberDTO;


public class MemberService {
	
	public MemberDTO signIn(MemberDTO member) {

		/*
		 * Service가 하는일
		 * - 유효성 검사하기(Validation)
		 */
		
//		if(member.getMemberId().length() > 10 ) {
//			return ;
//		}
//		if("".equals(member.getMemberId())) {
//			return false;
//		}
//		if(!member.getMemberPw().matches("/^[A-Xa-z0-1]")) {}
//		if(member.getMemberPw().length() > 20 ) {
//			return false;
//		}
//		if("".equals(member.getMemberPw())) {
//			return false;
//		}
		
		return new MemberDAO().signIn(member);
	}

}
