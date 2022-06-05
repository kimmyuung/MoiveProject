<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
</head>
<link rel="stylesheet" href="/movieproject/css/login.css"
	type="text/css">
<body>

	<%@include file="../header.jsp"%>
	<%
	request.setCharacterEncoding("UTF-8");
	String result = request.getParameter("result");
	%>
	
	

	<%
	if (result == null || (!(result.equals("2")))) {
	%>
	<div class="container">
	<div class="my-5">
		<div class="login-box" style="margin-top: 300px;">
			<h2 class="my-3">로그인 페이지</h2>
			
			<form action="../login" method="post">
				<div class="user-box my-5">
					<input class="mb-3" type="text" placeholder="아이디" name="id"
						required="">
						<label>UserId</label>
				</div>
				<div class="user-box">
					<input class="mb-3" type="text" placeholder="비밀번호" name="password"
						required=""> <label>Password</label>
				</div>
				<br> <span><input class="mb-3" type="submit" value="로그인"
					style="width: 100%;"></span> <br>
			</form>
			<a href="findid.jsp" style="color: white;"> 
				아이디 찾기
			</a> <a href="findpw.jsp" style="color: white;"> 
				<span></span> 비밀번호 찾기
			</a>
			<%
			} else {
			%>
			<h3>로그인 페이지</h3>
			<br>
			<form action="../login" method="post">
				<div class="user-box">
					<input type="text" placeholder="아이디" name="id"><br>
					<label>UserId</label>
				</div>
				<div class="user-box">
					<input type="text" placeholder="비밀번호" name="password">
					<label>Password</label>
				</div>
				<br>
				<div class="user-box">
					<input class="mb-3" type="submit" value="로그인" style="width: 180px;">
				</div>
			</form>
			<a href="findid.jsp" style="color: white;"> 
				아이디 찾기 
			</a> <br><a href="findpw.jsp" style="color: white;"> 
				<span></span> 비밀번호 찾기
			</a> <span>아이디 혹은 비밀번호를 잘못입력하셨습니다.</span>
			<%
			}
			%>
		</div>
		</div>
	</div>
<%@include file="../footer.jsp" %>
</body>
</html>