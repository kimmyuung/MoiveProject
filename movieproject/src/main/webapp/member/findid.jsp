<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../header.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="col-md-6 offset-4 pb-3 px-5 pt-5">
	<h3> 아이디 찾기 페이지</h3> <br>
		<form action="../findid" method="post">
			<input class="mb-3" type="text" placeholder="이름" name="mname" id="mname"><br> 
			<input class="mb-3" type="text" placeholder="핸드폰번호 (-빼고 입력)" name="mphone" id="mphone"> <br> 
			<input class="mb-3" type="submit" value="아이디 찾기" style="width: 180px;"> <br>
		</form>
		
		<a href="findpw.jsp">비밀번호 찾기</a> <br>
		<a href="login.jsp"> 로그인</a>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<script src="../js/info.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>

</body>
</html>