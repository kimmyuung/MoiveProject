<%@page import="dto.Category"%>
<%@page import="controller.movie.moiveadd"%>
<%@page import="dao.MovieDao"%>
<%@page import="dto.Movie"%>
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


	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="container">
		<div id="movielist">
			<table class="table">
				<tr>
					<th>영화 제목</th>
					<th>영화 포스터</th>
					<th>영화 러닝타임</th>
					<th>영화 가격</th>
					<th>영화 카테고리</th>
				</tr>

				<%
				ArrayList<Movie> mlist = MovieDao.getmovieDao().getmovielist();
				for (Movie m : mlist) {
				%>
				<tr>
					<td><a href="#" onclick="moviedelete('<%=m.getMtitle()%>')"><%=m.getMtitle()%></a></td>
					<td><img alt=""
						style="width: 20%" src="../movie/upload/<%=m.getMimg()%>"></td>
					<td><%=m.getMruntime()%></td>
					<td><%=m.getMprice()%></td>
					<td><%=m.getMcategory()%></td>
				</tr>
				<%
				}
				%>

			</table>
		</div>
			<div class="">
			
			</div>
	</div>

    

  

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<%@include file="../footer.jsp"%>
	<script src="../js/movielist.js" type="text/javascript"></script>
</body>
</html>