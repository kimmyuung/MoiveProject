<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<br><br><br><br><br><br>
<div class="col-md-6 offset-4 pb-3 px-5 pt-5">
<form action="signupcontroller.jsp" method="post">
<input class="mb-3" type="text" placeholder="아이디" name="id" > 
<input class="mb-3" type="button" value="아이디중복체크" style="width: 150px;" onclick="location.href='idcheck.jsp'"> <br>

<input class="mb-3" type="password" placeholder="비밀번호" name="password"> <br>
<input class="mb-3" type="password" placeholder="비밀번호확인" name="repassword"> 
<input class="mb-3" type="button" value="비밀번호일치확인" style="width: 150px;" onclick="location.href='pwcheck.jsp'"> <br>

<input class="mb-3" type="text" placeholder="이름" name="name"> <br>
<input class="mb-3" type="email" placeholder="이메일" name="email"> <br>
<input class="mb-3" type="text" placeholder="핸드폰번호" name="phone"> <br>
<input class="mb-3" type="text" placeholder="주소" name="address"> <br>
<input class="mb-3" type="submit" value="회원가입" style="width: 350px;"> 
</form>
</div>

</body>
</html>