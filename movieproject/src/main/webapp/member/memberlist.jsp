<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@page import="java.util.ArrayList"%>
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
<br><br><br><br>
	<div class="container">
		<h3> 회원 리스트 (클릭시 탈퇴 가능) </h3>
		
		<%
			String mid = (String)session.getAttribute("login");
			
		%>
			
		
		<div class="col-md-12">
		<table class="table"> <!-- 테이블 -->
			<tr>
				<th width="150px;"> 회원아이디 </th> <th width="280px;"> 회원비밀번호 </th> <th width="900px;"> 회원주소 </th> 
				<th width="300px;"> 회원가입 날짜  </th> <th width="250px;"> 핸드폰번호 </th> <th width="350px;"> 이메일</th>
			</tr>
			<!-- for 문 -->
			<%
				// 1. 모든 게시물  호출 
				ArrayList<Member> memberlist = MemberDao.getMemberDao().mlist();
				for( Member member : memberlist ){
			%>
				<!-- 
					행을 클릭했을때[ js ]   
						<tr onclick="location.href='boardview.jsp'">
					*링크 [ 식별 번호 같이 이동 ] 
						// 1. HTML : <a href='파일명(경로).jsp?변수명=값'">
						// 2. JS : "location.href='파일명(경로).jsp?변수명=값'"
						// 3. java : response.sendRedirect("파일명(경로).jsp?변수명=값");
				-->
				<tr>
					<td> <a href="delete.jsp?mnum=<%=member.getMno()%>"><%=member.getMid() %> </a> </td>
					<td> <%=member.getMpassword() %></td>
					<td> <%=member.getMaddress()%> </td>
					<td> <%=member.getMdate() %> </td>
					<td> <%=member.getMphone() %> </td>
					<td> <%=member.getMemail() %> </td>
				</tr>
			<%
				}
			%>
			
			</div>
		</table>
	</div>
<br><br><br><br>
<%@include file="../footer.jsp" %>
</body>
</html>