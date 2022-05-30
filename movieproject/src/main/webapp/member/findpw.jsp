<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/movieproject/css/login.css"
	type="text/css">
</head>
<body>
<%@include file="../header.jsp"%>
	
	<div class="login-box py-4 my-5" style="margin-top: 30px; ">
	<form name="pwfindscreen" method = "post" action="../findpw">
			<div class = "search-title">
				<h2>비밀번호 찾기 페이지</h2>
			</div>
		<section class = "form-search">
			<div class = "find-id">
				<div class="user-box">
				<input type="text" name="mid" class ="btn-name" id="mid" required="">
				<label>아이디</label>
				</div>
			<br>
			</div>
			<div class = "find-email">
				<div class="user-box">
				<input type="email" id="memail" name="memail" class = "btn-email" required="">
				<label>이메일(@을 포함하여 입력)</label>
				</div>
			<br>
			</div>
			<div class = "find-name">
				<div class="user-box">
				<input type="text" id="mname" name="mname" class = "btn-name" required="">
				<label>이름</label>
				</div>
			</div>
			<br>
	</section>
	<div class ="btnSearch">
		<input type="submit" name="enter" value="비밀번호 찾기" >
		<input type="button" name="cancle" value="뒤로 가기" onClick="history.back()">
 	</div>
 </form>
 </div>
	<div style="padding-top: 150px;">
		<a href="#"> <span></span> <span></span> <span></span> <span></span>
		</a>
	</div>
	<br>
	<br>
	<br>

	
	
	
	<script src="../js/findinfo.js" type="text/javascript"></script>
	
</body>
</html>