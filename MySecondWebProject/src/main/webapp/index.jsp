<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WelcomePage</title>
</head>
<body>
	<!-- 
		* WEB환경에서의 CRUD를 구현
		
		* 회원서비스
		로그인(R), 회원가입(C)
	 -->
	 
	 <h1>index</h1>
	 
	 <jsp:include page="WEB-INF/views/include/header.jsp"/>
	 <jsp:include page="WEB-INF/views/include/main.jsp"/>
	 <jsp:include page="WEB-INF/views/include/footer.jsp"/>
	 
</body>
</html>