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
	<table class="table">
		<tr>
			<th width="5%">글 번호</th>
			<th width="20%">글 제목</th>
			<th width="25%">글 내용</th>
			<th width="10%">작성자</th>
			<th width="15%">작성일</th>
		</tr>
		<tr>
			<td width="5%">1</td>
			<td width="20%"><a href="boardview.jsp?bno=1">안녕하세요1</a></td>
			<td width="25%">안녕하세요</td>
			<td width="10%">운영자</td>
			<td width="15%">2022-05-18</td>
		</tr>
		<tr>
			<td width="5%">2</td>
			<td width="20%"><a href="boardview.jsp?bno=2">안녕하세요2</a></td>
			<td width="25%">안녕하세요2</td>
			<td width="10%">운영자</td>
			<td width="15%">2022-05-18</td>
		</tr>
		<tr>
			<td width="5%">3</td>
			<td width="20%"><a href="boardview.jsp?bno=3">안녕하세요3</a></td>
			<td width="25%">안녕하세요3</td>
			<td width="10%">운영자</td>
			<td width="15%">2022-05-18</td>
		</tr>
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