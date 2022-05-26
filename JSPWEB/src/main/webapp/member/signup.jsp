<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<%@include file = "../header.jsp" %>
<div class="container" style="background-image: url('../img/signup.jpg'); background-repeat: no-repeat; width: 100%">
	<br><br>
	<h3 style="text-align: center; color: white;"> 회원 가입 페이지 </h3> <br> <br>
	<form id="signupform" action="../signup" method="post">
		<input type="text" id="mid" name="mid" placeholder="user id" >  <br> <br>
		<span id="idcheck" class="text-white"></span> 
		<br>
		<input type="password" id="mpassword" name="mpassword" placeholder="user password"> <br><br>
		<input type="password" id="mpasswordcheck" placeholder="password check"> <br><br>
		<span id="passwordcheck" class="text-white"></span> <br> <br>
		<input type="text" id="mname" name="mname" placeholder="user name"> <br><br>
		<span id="namecheck" class="text-white"></span> <br>
		<input type="text" id="mphone" name="mphone" placeholder="user phone"> <br><br>
		<span id="phonecheck" class="text-white"></span> <br><br>
		<br>
		<input type="text" id="memail" name="memail" placeholder="user email"> 
		<p class="text-white">@</p>
		<input type="text" id="memailaddress" name="memailaddress" > 
		<select id="emailselect">
			<option value=""> 직접입력 </option>
			<option value="naver.com"> naver.com </option>
			<option value="nate.com"> nate.com </option>
			<option value="daum.com"> daum.com </option>
		</select> <br><br>
		<span id="emailcheck" class="text-white"></span> 
		<br>
			<input type="text" id="sample4_postcode" name="address1" placeholder="우편번호"> <br><br>
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소">
			<input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소">
			<span id="guide" style="color:#999;display:none" class="text-white"></span>
			<input type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소">
		<br>
		<span id="addresscheck"></span>  <br>
		<button onclick="signup()" type="button" class="form-control">가입하기</button>
	</form>
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../js/signup.js" type="text/javascript"></script>

<%@include file = "../footer.jsp" %>




</body>
</html>