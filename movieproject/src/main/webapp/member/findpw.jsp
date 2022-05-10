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
	<form name="pwfindscreen" method = "POST">
			<div class = "search-title">
				<h3>비밀번호 찾기 페이지</h3>
			</div>
		<section class = "form-search">
			<div class = "find-name">
				<label>아이디</label>
				<input type="text" name="member_id" class = "btn-name" placeholder = "등록한 아이디">
			<br>
			</div>
			<div class = "find-email">
				<label>이메일</label>
				<input type="text" name="member_email" class = "btn-email" placeholder = "@를 포함하여 이메일을 입력">
			<br>
			</div>
			
			<div class = "find-name">
				<label>이름</label>
				<input type="text" name="member_name" class = "btn-name" placeholder = "등록한 이름">
			</div>
			<br>
	</section>
	<div class ="btnSearch">
		<input type="button" name="enter" value="비밀번호 찾기"  onClick="pw_search()">
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