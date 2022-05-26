<%@page import="java.util.Set"%>
<%@page import="java.util.TreeSet"%>
<%@page import="dto.Stock"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

	<%@include file="header.jsp"%>
	<div class="container">
		<div id="mainsilde" class="carousel slide" data-bs-ride="carousel">
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#mainsilde" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#mainsilde" data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#mainsilde" data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner"> <!-- 이미지 목록 -->
				<div class="carousel-item active"> <!-- 이미지 -->
					<img src="img/mainpageimg1.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/mainpageimg2.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="img/mainpageimg3.jpg" class="d-block w-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button" data-bs-target="#mainsilde" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#mainsilde" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	<div class="row adbox"> <!-- 광고 / 이벤트 -->
			<div class="col-md-6">
				<img alt="" src="img/mainad1.gif">
			</div>
			<div class="col-md-6">
				<img alt="" src="img/mainad2.jpg">
			</div>
		</div>
		<div class="main_box">	<!--베스트-->
			<h6 class="main_title"> BEST </h6>
			<div class="row">
				<div class="col-md-3 best_box">
					<img alt="" src="img/img1.webp">
				</div>
				<div class="col-md-3 best_box">
					<img alt="" src="img/img1.webp">
				</div>
				<div class="col-md-3 best_box">
					<img alt="" src="img/img1.webp">
				</div>
				<div class="col-md-3 best_box">
					<img alt="" src="img/img1.webp">
				</div>
			</div>
		</div>
		<div class="main_box"> <!--  신상품 -->
			<h6 class="main_title"> NEW ARRIVAL </h6>
			<div class="row">
			<%
			ArrayList<Product> list =
			ProductDao.getproductDao().getproductlist();
				for(Product p : list) {
			%>
			<div class="col-md-4 new_box">
					<a href="product/productview.jsp?pno=<%=p.getPno() %>"><img class="img-fluid" alt="" src="admin/productimg/<%=p.getPimg()%>"></a>
					<div class="p_item">
					<%
					ArrayList<Stock> slist = ProductDao.getproductDao().getStock(p.getPno());
					Set<String> sizelist = new TreeSet<>();
					for(Stock s : slist) {
						sizelist.add(s.getSsize());
					}
					%>
						<div class="p_title"><%=p.getPname() %></div>
						<%for(String temp : sizelist) {%>
						<div class="p_size"><%=temp +" " %> </div>
						<%} %>
						<div class="row">
						<% DecimalFormat df = new DecimalFormat("###,### 원"); 
						if(p.getPdiscount()==0) { %>// 할인 없음
							<div class="p_price row py-3"> <%=df.format( p.getPprice() ) %></div>
							
						<%}else { Float price = p.getPprice() * p.getPdiscount(); %>
							<div class="p_discount"> 원 가격 <%=df.format( p.getPprice() ) %> </div>
							<div class="p_price col-md-3"> 할인된 가격<%=df.format( p.getPprice()- price ) %></div>
						<% } %>
							<div class="p_review col-md-3 offset-6" style="float: right;"> 리뷰 : 412</div>
						</div>
					</div>
				</div>
				<%} %>
			</div>
			
			</div>
		
		<div>	<!-- 실시간 구매후기 -->
		
	</div>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>