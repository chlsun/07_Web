<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/header.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>


  <header class="header active">
    <div class="logo">
        <img src="resources/img/mainlogo.png" alt="Main Logo" />
    </div>
    <nav class="navigation">
        <p class="col active">홈</p>
        <p class="col">테마</p>
        <p class="col">지역</p>
        <p class="col">나의 행사</p>
        <p class="col">행사정보</p>
        <p class="col lastcol">공지사항</p>
    </nav>
    <div class="right">
        <div class="search-logo">
            <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="#5f6368"><path d="M784-120 532-372q-30 24-69 38t-83 14q-109 0-184.5-75.5T120-580q0-109 75.5-184.5T380-840q109 0 184.5 75.5T640-580q0 44-14 83t-38 69l252 252-56 56ZM380-400q75 0 127.5-52.5T560-580q0-75-52.5-127.5T380-760q-75 0-127.5 52.5T200-580q0 75 52.5 127.5T380-400Z"/></svg>
        </div>
        <c:choose>
        	<c:when test="${ empty user }">
        		<div class="login-form">
  					<a class="login" data-bs-toggle="modal" data-bs-target="#myModal">로그인</a>
  					<a class="sign-up" data-bs-toggle="modal" data-bs-target="#myModalPw">회원가입</a>
				</div>
        	</c:when>
        	<c:otherwise>
        		<div class="logout-form">
  					<div class="user-link">
              			<svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 -960 960 960" width="24px" fill="#333333">
                    		<path d="M480-480q-66 0-113-47t-47-113q0-66 47-113t113-47q66 0 113 47t47 113q0 66-47 113t-113 47ZM160-160v-112q0-34 17.5-62.5T224-378q62-31 126-46.5T480-440q66 0 130 15.5T736-378q29 15 46.5 43.5T800-272v112H160Zm80-80h480v-32q0-11-5.5-20T700-306q-54-27-109-40.5T480-360q-56 0-111 13.5T260-306q-9 5-14.5 14t-5.5 20v32Zm240-320q33 0 56.5-23.5T560-640q0-33-23.5-56.5T480-720q-33 0-56.5 23.5T400-640q0 33 23.5 56.5T480-560Zm0-80Zm0 400Z"/>
              			</svg>
          			</div>
          			<p class="logout" onclick="location.href='logout'">로그아웃</p>
				</div> 
        	</c:otherwise>
        </c:choose>
    </div>
</header>


<div class="modal" id="myModal">
<div class="modal-dialog">
  <div class="modal-content login-content">
    <div class="logo">
    </div>
    <div class="top-box">
      <div class="logo">
        <img src="resources/img/login.png" alt="login">
      </div>
      <p class="txt">로그인 </p>
    </div>
    <div class="login-main">
      <form action="login" method="POST">
        <div class="input-box">
          <input type="text" name="userId" class="id-input input" placeholder="아이디">
          <input type="password" name="userPw" class="pw-input input" placeholder="비밀번호">
        </div>
        <button type="submit" class="login-btn">로그인</button>
      </form>
    </div>
    <div class="helpBtn-wrapper">
      <div class="findPw">비밀번호 찾기</div>
      <div class="findId">아이디 찾기</div>
      <div class="signUp">회원가입</div>
    </div>
        
  </div>
</div>
</div>


<div class="modal" id="myModalPw">
<div class="modal-dialog">
  <div class="modal-content login-content">
    <div class="logo">
    </div>
    <div class="top-box">
      <div class="logo">
        <img src="resources/img/login.png" alt="login">
      </div>
      <p class="txt">회원가입 </p>
    </div>
    <div class="signup-main">
      <form action="sign-up" method="POST">
        <div class="input-box">
          <label for="id-label">아이디</label>
          <input type="text" name="userId" class="id-input input" id="id-label" placeholder="아이디">

          <label for="pw-label">비밀번호</label>
          <input type="password" name="userPw" class="pw-input input" id="pw-label" placeholder="비밀번호">
          
          <label for="check-pw-label">비밀번호</label>
          <input type="password" name="userPw" class="pw-input input" id="check-pw-label" placeholder="비밀번호확인">
		  <p class="error-msg"></p>
          <label for="name-label">이름</label>
          <input type="text" name="userName" class="name-input input" id="name-label" placeholder="이름">
        </div>
        <button type="submit" class="signup-btn" onclick="return checkPw();">회원가입</button>
      </form>
    </div>
  </div>
</div>
</div>


<c:if test="${ not empty sessionScope.message }">
	<script>
		alert('${sessionScope.message}');
	</script>
	<c:remove var="message" scope="session"/>
</c:if>
<script>

	
	
	const signupBtn = document.querySelector(".signup-btn");
	
	const password = document.querySelector("#pw-label");
	const passwordCheck = document.querySelector("#check-pw-label");
	const errorMsg = document.querySelector(".error-msg");
	
	var passwordValue = "";
	var passwordCheckValue = "";
	
	
	function checkPw(){
		if(passwordValue !== passwordCheckValue){
			alert('비밀번호를 동일하게 입력해주세요!');
			return false;

		}else{
			return true;
		}
	}
	
	password.addEventListener("keyup", ()=>{
		passwordValue = password.value;
		
		if(passwordValue !== passwordCheckValue){
			errorMsg.textContent = "비밀번호가 일치하지 않습니다.";
		}else{
			errorMsg.textContent = "";
		}
	});
	
	passwordCheck.addEventListener("keyup", ()=>{
		passwordCheckValue = passwordCheck.value;
		
		if(passwordValue !== passwordCheckValue){
			errorMsg.textContent = "비밀번호가 일치하지 않습니다.";
		}else{
			errorMsg.textContent = "";
		}
	});
	
	</script>
</body>
</html>