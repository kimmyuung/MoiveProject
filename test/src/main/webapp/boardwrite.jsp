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
		<h3 align="center">글쓰기 페이지</h3>
	
		<table style="text-align: center; width: 100% " >
			<tr>
				<td>제목 <input type="text" name="boardtitle" id="boardtitle"/>
				<span id="titlecheck"></span> </td>
			</tr>
			 
			<tr>
				<td>내용 <textarea cols="20" rows="2" name="boardcontent" id="boardcontent" placeholder="내용을 입력하세요!"></textarea>
				<span id="contextcheck"></span> </td>
			</tr>
		</table>
		<div align="center">
		<input type="button" class="btn btn-primary" value="작성하기" onclick="bwrite()"/> <a href="/test/boardlist.jsp" class="btn btn-info" >게시글 페이지로</a>
		</div>
	
	<br>
<%@include file="footer.jsp"%>	
<script src="/test/boardcheck.js" type="text/javascript"></script>
</body>
</html>