<%@page import="dao.ProductDao"%>
<%@page import="dto.OrderDetail"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#chartdiv1, #chartdiv2, #chartdiv3 {
	width: 100%;
	height: 500px;
	max-width: 100%
}
</style>

</head>
<body>
	<h3>매출 관리</h3>



	<div class="containter">
		<div>
			<!-- 일 매출 차트  -->
			<div id="chartdiv1"></div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<!-- 일 매출 막태 차트  -->


				<table class="table table-hover">
					<%
					ArrayList<OrderDetail> list = ProductDao.getproductDao().getorderdetail();
					%>
					<tr>
						<th>오늘의 주문</th>
					</tr>
					<tr>
						<th>주문상세번호</th>
						<th>주문수량</th>
						<th>주문가격</th>
						<th>주문번호</th>
						<th>재고번호</th>
					</tr>
					<%
					for (OrderDetail temp : list) {
					%>
					<tr onclick="getchart(<%=temp.getSno()%>)">
						<td><%=temp.getOrderdetailno()%></td>
						<td><%=temp.getSamount()%></td>
						<td><%=temp.getTotalprice()%></td>
						<td><%=temp.getOrderno()%></td>
						<td><%=temp.getSno()%></td>
					</tr>
					<%
					}
					%>
				</table>

			</div>
			<div class="col-sm-6">
				<!-- 카테고리별 도넛차트  -->
				<div id="chartdiv2"></div>
			</div>
		</div>	
			<div>
				<!-- 제품별 판매추이 선차트  -->
				<div id="chartdiv3"></div>
			</div>
		
	</div>

	<script type="text/javascript" src="/JSPWEB/js/productsales.js"></script>

</body>
</html>