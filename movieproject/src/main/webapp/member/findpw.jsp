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
	<form name="pwfindscreen" method = "post" action="../findpw">
			<div class = "search-title">
				<h3>비밀번호 찾기 페이지</h3>
			</div>
		<section class = "form-search">
			<div class = "find-id">
				<label>아이디</label>
				<input type="text" name="mid" class = "btn-name" placeholder = "등록한 아이디" id="mid">
			<br>
			</div>
			<div class = "find-email">
				<label>이메일</label>
				<input type="email" id="memail" name="memail" class = "btn-email" placeholder = "@를 포함하여 이메일을 입력">
			<br>
			</div>
			
			<div class = "find-name">
				<label>이름</label>
				<input type="text" id="mname" name="mname" class = "btn-name" placeholder = "등록한 이름">
			</div>
			<br>
	</section>
	<div class ="btnSearch">
		<input type="submit" name="enter" value="비밀번호 찾기" >
		<input type="button" name="cancle" value="취소" onClick="history.back()">
 	</div>
 </form>
 </div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<script src="../js/findinfo.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>

</body>
</html>