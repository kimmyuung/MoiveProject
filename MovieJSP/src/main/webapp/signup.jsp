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
<input class="mb-3" type="text" placeholder="���̵�" name="id" > 
<input class="mb-3" type="button" value="���̵��ߺ�üũ" style="width: 150px;" onclick="location.href='idcheck.jsp'"> <br>

<input class="mb-3" type="password" placeholder="��й�ȣ" name="password"> <br>
<input class="mb-3" type="password" placeholder="��й�ȣȮ��" name="repassword"> 
<input class="mb-3" type="button" value="��й�ȣ��ġȮ��" style="width: 150px;" onclick="location.href='pwcheck.jsp'"> <br>

<input class="mb-3" type="text" placeholder="�̸�" name="name"> <br>
<input class="mb-3" type="email" placeholder="�̸���" name="email"> <br>
<input class="mb-3" type="text" placeholder="�ڵ�����ȣ" name="phone"> <br>
<input class="mb-3" type="text" placeholder="�ּ�" name="address"> <br>
<input class="mb-3" type="submit" value="ȸ������" style="width: 350px;"> 
</form>
</div>

</body>
</html>