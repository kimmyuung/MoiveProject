<%@page import="dto.Theater"%>
<%@page import="dao.TheaterDao"%>
<%@page import="controller.movie.moiveadd"%>
<%@page import="dto.Movie"%>
<%@page import="dto.Runmovie"%>
<%@page import="dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/movieproject/css/seatchoice_2.css" rel="stylesheet">
</head>
<body>
<%
int rno = Integer.parseInt(request.getParameter("rno")) ; 
String date = request.getParameter("date");
int tno = Integer.parseInt(request.getParameter("tno"));
if(rno == 0 || date == null || tno == 0) { %>
<%@include file="../error.jsp" %>
<% }else { 
int selectdate = Integer.parseInt(date);
int month = selectdate / 100;
int day = selectdate % 100;

%>
 

<input type="hidden" id="tno" value="<%=tno%>">
<input type="hidden" id="rno" value="<%=rno%>">
<input type="hidden" id="date" value="<%=date%>">
	<section id="section">
		<div class="container">
			<!-- leftCont -->
			<div class="leftCont">
				<div class="leftMainCont">
					<div class="legendContainer">
						<ul>
							<li>
								<div class="seat legend"></div> <small>예약이 가능한 좌석</small>
							</li>
							<li>
								<div class="seat legend selected"></div> <small>선택한 좌석</small>
							</li>
							<li>
								<div class="seat legend occupied"></div> <small>예약이 불가능한 좌석</small>
							</li>
						</ul>
					</div>
					<!-- seat Container -->
					<div class="mainSeatCont">
						<div class="screen">
							<small>SCREEN</small>
						</div>
						<!-- 반목문을 통해 추출할 예정 -->
						<div class="seatCont" id="seatCont">
						</div>
					</div>
				</div>
			</div>
			<!-- Right Cont -->
			<div class="rightCont">
				<div class="confirmCont">
					<div class="rightTopCont">
						<!-- moviename -->
						<div class="movieInfo">
							<div class="movieName">
								<p>영화 제목</p>
								<h3 id="movieName"><%=MovieDao.getmovieDao().getRunmovieTitle(rno) %></h3>
							</div>
							<div class="moviePrice">
								<p>영화가격</p>
								<h1 id="moviePrice"></h1>
							</div>
							<div class="dateCont">
								<p>날짜</p>
								<p class="dateOn"><%=month %>월 <%=day %> 일</p>

							</div>
						</div>
					</div>
					<div class="rightBottomCont">
						<div class="selectedSeatCont">
							<p>선택한 좌석</p>
							<div class="selectedSeatsHolder" id="selectedSeatsHolder">
								<span class="noSelected">좌석을 선택해주세요</span>
							</div>
						</div>
						<!-- Seat number and price -->

						<div class="numberOfSeatsCont">
							<div class="numberOfSeatEl">
								<p>
									<span id="numberOfSeat">0</span> Seats(s)
								</p>
							</div>
							<div class="priceCont">
								<p id="totalPrice">0원</p>
							</div>
						</div>
						<!-- button Cont -->

						<div class="buttonCont">
							<div class="cancelBtn">
								<button id="cancelBtn">Cancel</button>
							</div>
							<div class="proceedBtnEl">
								<button id="proceedBtn">Continue</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- jquery 최신 cdn -->
	<script src="http://code.jquery.com/jquery-latest.min.js"
		type="text/javascript"></script>
	<script src="/movieproject/js/seatchocie.js" type="text/javascript"></script>
<%} %>
</body>
</html>