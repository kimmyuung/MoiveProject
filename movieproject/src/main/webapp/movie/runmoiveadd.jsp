<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalTime"%>
<%@page import="javax.swing.text.DateFormatter"%>
<%@page import="dao.MovieDao"%>
<%@page import="dto.Runmovie"%>
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
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
<link href="/movieproject/css/runmovieadd.css" rel="stylesheet">
</head>

<body>
	<%
	ArrayList<Theater> tlist = TheaterDao.getTheaterDao().theaterlist();
	ArrayList<Runmovie> rlist = MovieDao.getmovieDao().runmovielist();
	
	if(tlist == null || rlist == null) {
	%>
	<div> 등록된 상영관이 없습니다. 상영관을 먼저 등록해주세요</div>
	<%} %>
	<br>
  <div class="timetable my-3">
  <br>
   <table class="button-options">
    <tr>
      <th></th>
      <th id="addFilm">상영 영화 추가</th>
      <th id="deleteFilm">상영 영화 삭제</th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th></th>
      <th id="quit">나가기</th>
    </tr>
  </table>
  <div class="layoutdesign" id="layout">
    <div class="row" id="runmovie">
      <div></div>
      <div>00:00</div>
      <div>01:00</div>
      <div>02:00</div>
      <div>03:00</div>
      <div>04:00</div>
      <div>05:00</div>
      <div>06:00</div>
      <div>07:00</div>
      <div>08:00</div>
      <div>09:00</div>
      <div>10:00</div>
      <div>11:00</div>
      <div>12:00</div>
      <div>13:00</div>
      <div>14:00</div>
      <div>15:00</div>
      <div>16:00</div>
      <div>17:00</div>
      <div>18:00</div>
      <div>19:00</div>
      <div>20:00</div>
      <div>21:00</div>
      <div>22:00</div>
      <div>23:00</div>
      <div>24:00</div>

    </div>
    
    
    <%for(int i = 0; i < tlist.size(); i++){ %>
    	<div class="row">
      <div><%=tlist.get(i).getTname() %></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
      <div></div>
    </div>
    <%} %>
   
  <%for(Runmovie temp : rlist) { 
	 
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
	  LocalTime localDate = LocalTime.parse(temp.getStime(), formatter);
  %>
  <span class="film" 
  style="top:<%=temp.getTno()%>vh; left:calc(10vw + <%=MovieDao.getmovieDao().getruntime(temp.getMtitle())%>px); 
  width:<%=MovieDao.getmovieDao().getruntime(temp.getMtitle())%>px" data-start="<%=localDate%>">
   <%=temp.getMtitle() %> -<%=MovieDao.getmovieDao().getruntime(temp.getMtitle()) %>분
  </span> 
  <%} %>
  </div>
  <form>
    <select id="moviebox"> </select>
    
    <div id="run">시간단위는 분입니다.</div>
    
    <input id="timetableStart" type="text" placeholder="시작시간 (HH:MM)" />
    <select id="theaterbox"> </select>
  </form>

</div>


	<!-- jquery 최신 cdn -->
	<script src="http://code.jquery.com/jquery-latest.min.js"
		type="text/javascript"></script>
	<script src="/movieproject/js/runmovie.js" type="text/javascript"></script>
</body>
</html>