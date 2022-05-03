<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../header.jsp" %>
<br><br><br><br><br><br>
<div class="col-md-6 offset-4 pb-3 px-5 pt-5">
<form action="signup" method="post">
<input class="mb-3" type="text" placeholder="아이디" name="id" id="mid"> 
<input class="mb-3" type="button" value="아이디중복체크" style="width: 150px;" onclick="idcheck()"> <br>

<input class="mb-3" type="password" placeholder="비밀번호" name="password" id="mpw"> <br>
<input class="mb-3" type="password" placeholder="비밀번호확인" name="repassword" id="rempw"> 
<input class="mb-3" type="button" value="비밀번호일치확인" style="width: 150px;" onclick="pwcheck()"> <br>

<input class="mb-3" type="text" placeholder="이름" name="name" id="mname"> <br>
<span id="namecheck"></span> <br>
<input class="mb-3" type="email" placeholder="이메일" name="email" id="memail"> <br>
<span id="emailcheck"></span> <br>
<input class="mb-3" type="text" placeholder="핸드폰번호" name="phone" id="mphone"> <br>
<span id="phonecheck"></span> <br>
<input type="text" id="sample4_postcode" placeholder="우편번호">
<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br> 
<input type="text" id="sample4_roadAddress" placeholder="도로명주소"> 
<input type="text" id="sample4_jibunAddress" placeholder="지번주소"> 
<span id="guide" style="color: #999; display: none"></span> 
<input type="text" id="sample4_detailAddress" placeholder="상세주소"> <br><br>

<button type="submit" value="회원가입" class="btn-contoller" name="회원가입"></button>
</form>
</div>
<script src="js/signup.js" type="text/javascript"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>