<%@page import="dao.TheaterDao"%>
<%@page import="dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<%
int rno = Integer.parseInt(request.getParameter("rno")) ; 
String date = request.getParameter("date");
int tno = Integer.parseInt(request.getParameter("tno"));
String seats = request.getParameter("seats");
int totalprice = Integer.parseInt(request.getParameter("totalprice"));
if(rno == 0 || date == null || tno == 0 || seats == null || totalprice == 0) { %>
<%@include file="../error.jsp" %>
<% }else { 
int selectdate = Integer.parseInt(date);
int month = selectdate / 100;
int day = selectdate % 100;
%>
<input type="hidden" id="tno" value="<%=tno%>">
<input type="hidden" id="rno" value="<%=rno%>">
<input type="hidden" id="date" value="<%=date%>">
<input type="hidden" id="seats" value="<%=seats%>">
<input type="hidden" id="totalprice" value="<%=totalprice%>">
		


	<%@include file="../header.jsp"%>
	<div class="container">
		<h1 style="text-align: center;">영화관 결제</h1>
			<div class="row">
				<div class="col-sm-12">
					<div> <!--  선택한 영화제목, 선택한 시간, 선택한 관과 좌석, 결제 금액 출력  -->
						<table class="table my-5" id="carttable">
						<tr><th>영화제목</th> <th>시작 시간</th> <th>선택한 관</th>
						<th>선택한 좌석(들)</th> <th>금액</th>
						</tr>
						<tr>
						<td><%=MovieDao.getmovieDao().getRunmovieTitle(rno) %></td>
						<td><%=MovieDao.getmovieDao().getStarttime(rno) %></td>
						<td><%=TheaterDao.getTheaterDao().gettname(tno) %></td>
						<td><%=seats %></td>
						<td><%=totalprice %></td>
						</tr>
						</table>
					</div>		
					<h1 style="text-align: center;">결제 금액 : <%=totalprice %>원</h1>
				</div>
				<br><br>
				<div class="col-sm-6 offset-3">
					<div class="paybox">
						
						<div> <!-- 결제 정보 -->
							
							<div> 결제 수단 : <span id ="paymethod"></span>
								<button onclick="paymethod('samsung')"> 삼성페이 </button>
								<button onclick="paymethod('card')"> 카드 </button>
								<button onclick="paymethod('trans')"> 계좌이체 </button>
								<button onclick="paymethod('vbank')"> 무통장 </button>
								<button onclick="paymethod('phone')"> 핸드폰 </button>
							</div> 
							<br>
							<div class="row">
								<div class="col-sm-6">
									<a href="/movieproject/main.jsp">
										<button class="form-control  py-4"> 메인으로 돌아가기 </button>
									</a> 
								</div>
								<div class="col-sm-6">
									<button onclick="payment()" style="background-color: blue; color: white;" class="form-control py-4"> 결제하기 </button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
<br><br>
<%} %>
	<%@include file="../footer.jsp"%>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	<script src="/movieproject/js/orderpay.js" type="text/javascript"></script>
</body>
</html>