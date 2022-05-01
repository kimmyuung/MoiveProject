<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="main.css" rel="stylesheet">
</head>
<body>
<%@include file="header.jsp" %>
<br><br><br><br><br><br>
<div class="col-md-6 offset-4 pb-3 px-5 pt-5">
<form action="logincontroller.jsp" method="get">
<input class="mb-3" type="text" placeholder="아이디" name="id" > <br>
<input class="mb-3" type="text" placeholder="비밀번호" name="password"> <br>
<input class="mb-3" type="submit" value="로그인" style="width: 180px;"> 
</form>
</div>
<br><br><br><br><br><br>
<div>푸터</div>
</body>
</html>