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
		<h3> 회원 리스트 </h3>
		
		<%
			String mid = (String)session.getAttribute("login");
			if( mid != null ){
		%>
			<a href="boardwrite.jsp">  </a>
		<%} %>
		
		<table class="table"> <!-- 테이블 -->
			<tr>
				<th> 회원번호 </th> <th> 회원이름 </th> <th> 회원주소 </th> 
				<th> 회원가입 날짜  </th> <th> 핸드폰번호 </th> <th> 이메일</th>
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
					<td> <%=member.getMnum() %> </td>
					<td> 
							<a href="info.jsp?mnum=<%=member.getMnum()%>">
								<%=member.getMname() %>
							</a> 
					</td>
					<td> <%=member.getMaddress()%> </td>
					<td> <%=member.getMdate() %> </td>
					<td> <%=member.getMphone() %> </td>
					<td> <%=member.getMemail() %> </td>
				</tr>
			<%
				}
			%>
			
			
		</table>
	</div>
<br><br><br><br>
<%@include file="../footer.jsp" %>
</body>
</html>