package com.kh.myFirstWebProject.member.model.dto;

import javax.xml.crypto.Data;

public class MemberDTO {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String email;
	private Data enrollDate;
	
	
	
	public MemberDTO() {
		super();
	}
	public MemberDTO(String memberId, String memberPw) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
	}
	
	
	public MemberDTO(String memberId, String memberPw, String memberName, String email, Data enrollDate) {
		super();
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.email = email;
		this.enrollDate = enrollDate;
	}
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Data getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Data enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
	@Override
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName + ", email="
				+ email + ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
