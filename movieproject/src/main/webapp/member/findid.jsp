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
	<br>
	<br>


	<div class="login-box py-4">
		<form name="idfindscreen" method="POST">
			<div class="search-title">
				<h2>아이디 찾기 페이지</h2>
			</div>
			<section class="form-search">
				<div class="user-box">
					<input type="text" name="member_name" class="btn-name" required="">
					<label>등록한 이름</label> <br>
				</div>
				<div class="user-box">

					<input type="text" onKeyup="addHypen(this);" name="member_phone"
						class="btn-phone" required=""> <label>휴대폰번호를 '-'없이
						입력</label>
				</div>
				<br>
			</section>
			<div class="btnSearch">
				<input type="button" name="enter" value="찾기" onClick="id_search()"
					style="width: 180px;"> <input type="button" name="cancle"
					value="뒤로 가기" onClick="history.back()" style="width: 180px;">
			</div>
		</form>
	</div>

	<div style="padding-top: 150px;">
		<a href="#"> <span></span> <span></span> <span></span> <span></span>
		</a>
	</div>
	<br>
	


	<script src="../js/findinfo.js" type="text/javascript"></script>


</body>
</html>