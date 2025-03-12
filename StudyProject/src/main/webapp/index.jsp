<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="selectAll">유저정보 전체조회</a>
	<form action="selectNo" method="GET">
		<input type="text" placeholder="유저아이디 조회"> 
	</form>
	<form action="add" method="POST">
		<input type="text" placeholder="이름">
		<input type="text" placeholder="유저아이디">
		<input type="password" placeholder="비밀번호">
	</form>
	
</body>
</html>