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
	
	<form name="idfindscreen" method = "POST">
			<div class = "search-title">
				<h3>아이디 찾기 페이지</h3>
			</div>
		<section class = "form-search">
			<div class = "find-name">
				<label>이름</label>
				<input type="text" name="member_name" class = "btn-name" placeholder = "등록한 이름">
			<br>
			</div>
			<div class = "find-phone">
				<label>번호</label>
				<input type="text" onKeyup = "addHypen(this);" name="member_phone" class = "btn-phone" placeholder = "휴대폰번호를 '-'없이 입력">
			</div>
			<br>
	</section>
	<div class ="btnSearch">
		<input type="button" name="enter" value="찾기"  onClick="id_search()">
		<input type="button" name="cancle" value="취소" onClick="history.back()">
 	</div>
 </form>
 </div>
 	<script src="../js/findinfo.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>

</body>
</html>