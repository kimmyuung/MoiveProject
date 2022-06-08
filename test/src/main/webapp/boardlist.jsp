<%@page import="dao.BoardDao"%>
<%@page import="dto.Board"%>
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
	<%@include file="header.jsp"%>
	<br>
	<br>
	<br>
	<h3>자유 게시판</h3>
	<br>
	
	<%ArrayList<Board> blist = BoardDao.getBoardDao().blist(); %>
	<table class="table">
		<tr>
			<th width="5%">글 번호</th>
			<th width="20%">글 제목</th>
			<th width="25%">글 내용</th>
			<th width="10%">작성자</th>
			<th width="15%">작성일</th>
		</tr>
		<%for(Board temp : blist){ %>
		<tr>
			<td width="5%"><%=temp.getBno() %></td>
			<td width="20%"><a href="boardview.jsp?bno=<%=temp.getBno()%>"><%=temp.getBtitle() %></a></td>
			<td width="25%"><%=temp.getContext() %></td>
			<td width="10%"><%=temp.getWriter() %></td>
			<td width="15%"><%=temp.getWrite_time() %></td>
		</tr>
		<%} %>
	
	</table>
	<br>
	<div class="col-md-3 offset-9">
		<button onclick="location.href='boardwrite.jsp'">글쓰기</button>
	</div>
	<br>
	<br>
	<br>
	<%@include file="footer.jsp"%>
</body>
</html>