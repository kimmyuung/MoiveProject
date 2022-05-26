<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String mid = (String)session.getAttribute("login");
%>
	<%@include file="../header.jsp"%>
	<div class="container">
	<%if(mid != null){ %>
		<div class="row">
			<div class="col-md-3">
			<%@include file="infosidebar.jsp" %>
			</div>
			<div class="col-md-9">
			<h3> 회원탈퇴 확인 </h3>
			
			<input type="password" id="mpw" name="mpw">
			<button id="btncofirm"onclick="pwcheck('<%=mid%>')" name="btncofirm">확인</button>
			<span id="checkmsg"></span>
			<button id="btndelete" style="display: none;" onclick="mdelete('<%=mid%>')">탈퇴승인</button>
			
			</div>
		</div>
		<%} %>
		<%if(mid == null) { %>
		<span> 로그인후에 이용해주세요</span>
		<%} %>
	</div>
	<script src="../js/info.js" type="text/javascript"></script>
	<%@include file="../footer.jsp"%>
</body>
</html>