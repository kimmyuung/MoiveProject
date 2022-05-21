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
<br><br><br><br><br><br><br><br><br><br><br>



<h3 id="chart"> 영화 차트 종류 : </h3>

<p style="text-align: center; font-size: 25px;">현재 날짜 및 시간</p>
<div class="conatiner"> 
<div class="row">
<div class="col-md-3 offset-3" id="currentdate" style="font-size: 30px;"></div>
<div class="col-md-3 offset-3" id="clock" style="font-size: 30px;">00:00:00</div>
</div>
<div>
<p>랭킹 집계 기간</p>
<h3 id="date"></h3>
</div>
</div>

<br><br><br>

		<table class="table table-hover text-center"> <!-- 테이블 -->
			<tr>
				<th width="10%"> 영화 순위 </th> 
				<th width="50%"> 영화 제목 </th> 
				<th width="15%"> 순위 변동 </th> 
				<th width="15%"> 개봉일 </th> 
				<th width="10%"> 예매율  </th> 
			</tr>
			<!-- for 문 -->
			<% for( int i = 0; i < 10; i++ ){ %>
				<tr>
					<td id="rank<%=i%>" width="10%"> </td>
					<td style="text-align: left;" id="title<%=i%>" width="50%"> 
						
					</td>
					<td id="rankchange<%=i%>" width="15%">  </td>
					<td id="open<%=i%>" width="15%">  </td>
					<td id="rate<%=i%>" width="10%">  </td>
				</tr>
			<%
				}
			%>
		</table>


<br><br><br><br><br><br><br><br><br><br>

<%@include file="../footer.jsp" %>
	<script src="/movieproject/js/KobisOpenAPIRestService.js" type="text/javascript"></script>
</body>
</html>