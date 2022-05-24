<%@page import="dao.TheaterDao"%>
<%@page import="dto.Theater"%>
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
ArrayList<Theater> tlist = TheaterDao.getTheaterDao().theaterlist(); 

%>

<table>
<tr>
<th>영화관 번호</th>
<th>영화관 이름</th>
<th>영화관 좌석 수</th>
</tr>
<%if(tlist == null) {%>
<tr>
<td colspan="3">영화관을 먼저 생성해주세요</td>
</tr>
<%} %>
<% if( tlist != null) %>
<%for(int i = 0; i < tlist.size(); i++)  { %>
<tr>
<td><a href="theaterupdate.jsp?tno=<%=tlist.get(i).getTnum()%>"><%=tlist.get(i).getTnum() %></a></td>
<td><%=tlist.get(i).getTname() %></td>
<td><%=tlist.get(i).getTseat() %></td>
</tr>
<%} %>


</table>

<div class="container">
<br><br><br>
<div>
상영관목록 (반복문)
</div>
<a href="theateradd.jsp">상영관등록</a>
<a href="theaterdelete.jsp">상영관삭제</a>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br>

<%@include file="../footer.jsp" %>
</body>
</html>