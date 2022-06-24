<%@page import="dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/movieproject/css/movieticket.css" rel="stylesheet">
</head>
<body>
<%
int rno = Integer.parseInt(request.getParameter("rno")) ; 
String date = request.getParameter("date");
int tno = Integer.parseInt(request.getParameter("tno"));
String seats = request.getParameter("seats");
int totalprice = Integer.parseInt(request.getParameter("totalprice"));
String mid = request.getParameter("mid");
int selectdate = Integer.parseInt(date);
int month = selectdate / 100;
int day = selectdate % 100;
%>
<h1 style="text-align: center; margin-top: 200px;">티켓 발급 성공!!</h1>
<div class="cardWrap">
<div>날짜 <%=month %>월 <%=day %>일</div>
  <div class="card cardLeft">
    <h1>EZEN <span>시네마</span></h1>
    <div class="title">
      <h2><%=MovieDao.getmovieDao().getRunmovieTitle(rno) %></h2>
      <span>영화제목</span>
    </div>
    <div class="name">
      <h2><%=mid %></h2>
      <span><%=mid %>님</span>
    </div>
    <div class="seat">
      <h2><%=seats %></h2>
      <span>좌석</span>
    </div>
    <div class="time">
      <h2><%=totalprice %></h2>
      <span>금액</span>
    </div>
    
  </div>
  <div class="card cardRight">
    <div class="eye"></div>
    <div class="number">
      <h3><%=seats %></h3>
      <span>좌석</span>
    </div>
    <div class="barcode"></div>
  </div>
  <div>
  <br>
<a href="/movieproject/main.jsp"><button>메인으로 돌아가기</button></a>
<a href="/movieproject/member/info.jsp"><button>예약 내역 확인</button></a>
</div>
</div>

</body>
</html>