<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
	<%@include file = "../header.jsp" %>
		<%
			String mid  = (String)session.getAttribute("login");
		%>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<div class="container"> <!-- 박스권 -->
		<div class="row"> <!-- 가로배치 -->
		<%if(mid == null) { %>
		<span> 로그인후에 이용해주세요</span>
		 <%} %>
		<%if( mid != null && (!mid.equals("admin")) ) {%>
			<div class="col-md-3"> <!-- 사이드바 -->
				<%@include file ="infosidebar.jsp" %>
			</div>	
			<%} %>
			
			<%if(mid != null){ %>
			<div class="col-md-9"> <!-- 본문 -->
			
				<h3> 회원탈퇴 확인 </h3>
				<h4> 탈퇴하려는 회원의 비밀번호를 입력해주세요</h4> <br>
				<input type="password" id=mpw name="mpw">
				<button id="btncofirm"onclick="passwordcheck('<%=mid%>')">확인</button>
				<span id="checkmsg"></span>
				
				<button id="btndelete" style="display: none;" onclick="mdelete('<%=mid%>')">탈퇴승인</button>
			
			</div>
		</div>
		<%} %>
		
	</div>
	<!-- 사용자정의 js파일 포함  -->
	<script src="../js/info.js" type="text/javascript"></script>
	<br><br><br><br><br><br><br><br><br><br>
	<%@include file = "../footer.jsp" %>

</body>
</html>