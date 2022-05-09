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
	<h3> 비밀번호 찾기 페이지</h3> <br>
		<form action="../findpw" method="post">
			<input class="mb-3" type="text" placeholder="아이디" name="id"><br> 
			<input class="mb-3" type="text" placeholder="이름" name="password"> <br> 
			<input class="mb-3" type="text" placeholder="이메일" name="password"> <br> 
			<input class="mb-3" type="submit" value="비밀번호 찾기" style="width: 180px;"> <br>
		</form>
		<a href="findid.jsp">아이디 찾기</a> <br>
		<a href="login.jsp"> 로그인</a>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<%@include file = "../footer.jsp" %>

</body>
</html>