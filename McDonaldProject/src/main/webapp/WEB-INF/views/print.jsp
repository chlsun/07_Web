<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String brand = (String)request.getAttribute("brand");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL구문</title>
</head>
<body>

	${ brand }
	${ bestSeller }
	
	<!-- EL구문으로 bestSeller.brand << 에 접근 할 수 있는 이유?
		 DTO에 getter가 작성되어 있어서 가능
		 => getter가 작성되어 있지 않다면 코드오류!!  
	-->
	<ul>
		<li>${ bestSeller.brand }</li>
		<li>${ bestSeller.name }</li>
		<li>${ bestSeller.price }</li>
	</ul>
	
	두 개 이상의 Scope에 같은 키값으로 값을 담은 경우 <br/>
	
	<!-- 
		page => request => session => application 순으로 키값을 검색	
	-->
	
	Scope에 직접 접근하는 방법 !! <br/>
	
	requestScope : ${ requestScope.brand } <br/>
	sessionScope : ${ sessionScope.brand } <br/>
	
	만약에 없는 키값 EL구문으로 출력하려고하면 어떻게될까?? <br/><br/>
	
	없는 값 : ${ sessionScope.abc }	<!-- ==> 빈문자열로 출력 
										 ==> 500에러 나지 않음 -->
										
	<hr />


	연산하기 가장 좋은곳<br/>
	1. SQL문 DB단<br/>
	2. Java => Service단(유효성검사 / transaction)<br/>
	3. View <br/>
	
	<hr/>
	
	<h3>1. 산술연산</h3>
	
	<p>
		* EL 구문을 이용한 산술연산 <br/>
		big + small = ${ big + small }<br/>
		big - small = ${ big - small }<br/>
		big x small = ${ big * small }<br/>
		big / small = ${ big / small } ${big div small }<br/>
		big % small = ${ big % small } ${big mod small } 
	</p>
	
	<h3>2. 논리연산</h3>
	
	<p>
		AND : ${ true && true } 또는 ${ true and true } <br>
		OR : ${ true || true } 또는 ${ true or true }
	</p>
	
	
	<h3>3. 비교연산</h3>
	<br>
	<h3>대소비교</h3>
	<p>
		big이 small보다 작니? : ${ big < small } 또는 ${ big lt small }<br/>
		big이 small보다 크니? : ${ big gt small }<br/>
		big이 small보다 작거나 같니? : ${ big le small }<br/>
		big이 small보다 크거나 같니? : ${ big ge small }<br/>
	</p>
	<br>
	<h3>동등비교</h3>
	
	<p>
		big이 small과 같습니까? : ${ big == small } 또는 ${ big eq small } <br/>
		big이 10과 같습니까? : ${ big eq 10 } <br/>
		str과 좋아하는문구가 일치합니까? : ${ str == "조아하는문구" } 또는 ${ str eq '조아하는문구' } 
							<!-- true가 나오는 이유 ==> equals()처럼 계산됨 -->
		big이 10과 일치하지 않습니까? : ${ big ne 10 }
	</p>
	
	<h4>비어있는지 체크</h4>
	
	<p>
		bestSeller가 null과 일치합니까 <br/>
		${ bestSeller == null } 또는 ${ bestSeller eq null } 또는 ${ empty bestSeller }<br>
		
		list가 비어있지 않습니까? <br/>
		${ !empty list }
	</p>
	
	<br>
	
</body>
</html>