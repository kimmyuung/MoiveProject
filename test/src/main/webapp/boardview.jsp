<%@page import="dto.Board"%>
<%@page import="dao.BoardDao"%>
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
	<h3 align="center">상세보기 페이지</h3>
	<%int bno = Integer.parseInt(request.getParameter("bno")) ; 
	Board board = BoardDao.getBoardDao().getBoard(bno);
	%>

	<table style="text-align: center; width: 100%">
		<tr>
			<td width="5%"> 글번호 <%=bno %></td>
		</tr>
		<tr>
				<td>제목 <input type="text" name="boardtitle" id="boardtitle" placeholder="<%=board.getBtitle()%>">
				<span id="titlecheck"></span> </td>
			</tr>
			 
			<tr>
				<td>내용 <textarea cols="20" rows="2" name="boardcontent" id="boardcontent" placeholder="<%=board.getContext()%>"></textarea>
				<span id="contextcheck"></span> </td>
			</tr>
			<tr>
			<td> 비밀번호 <input type="text" name="bpassword" id="bpassword" placeholder="글작성시 입력한 비밀번호" style="width: 200px;">
			</tr>
	</table>
	<div align="center">
		<input type="button" class="btn btn-primary" value="수정하기" onclick="bupdate('<%=bno%>')"/> 
		<input type="button" class="btn btn-primary" value="삭제하기" onclick="bdelete('<%=bno%>')"/> <a
			href="/test/boardlist.jsp" class="btn btn-info">게시글 페이지로</a>
	</div>

	<br>
	<%@include file="footer.jsp"%>
	<script src="reboardcheck.js" type="text/javascript"></script>
</body>
</html>