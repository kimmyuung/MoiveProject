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
<%@include file="../header.jsp" %>

<%
ArrayList<Movie> mlist = MovieDao.getmovieDao().getmovielist();
%>

<br><br><br><br><br><br><br><br><br><br>
<table class="table">
<tr>
<th>영화 제목</th>
<th>영화 포스터</th>
<th>영화 러닝타임</th>
<th>영화 가격</th>
<th>영화 카테고리</th>
</tr>
<%for(Movie m : mlist) {%>
<tr>
<td><a href="#"><%=m.getMtitle() %></a></td>
<td><img alt="" src="/moiveproject/movie/<%=m.getMimg()%>"></td>
<td><%=m.getMruntime() %></td>
<td><%=m.getMprice() %></td>
<td><%=m.getMcategory() %></td>
</tr>
<%} %>
</table>


<br><br><br><br><br><br><br><br><br><br>

<%@include file="../footer.jsp" %>
<script src="../js/movielist.js" type="text/javascript"></script>
</body>
</html>