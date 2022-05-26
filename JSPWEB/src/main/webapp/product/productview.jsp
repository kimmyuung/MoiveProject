<%@page import="dao.MemberDao"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeSet"%>
<%@page import="dto.Stock"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/JSPWEB/css/productview.css">
</head>
<body>

 	<!-- g-0 : div간의 여백 제거 -->
	<%@include file="../header.jsp"%>
	<br><br><br>
	<%
	int pno = Integer.parseInt(request.getParameter("pno"));
	String mid = (String)session.getAttribute("login");
	Product p = ProductDao.getproductDao().getproduct(pno);
	ArrayList<Stock> slist = ProductDao.getproductDao().getStock(pno);
	Set<String> sizelist = new TreeSet<>();
	Set<String> colorlist = new TreeSet<>();
	DecimalFormat df = new DecimalFormat("###,###원"); // 천단위 구분 쉼표
	Float price = p.getPprice() - ( p.getPprice()*p.getPdiscount() ) ; 	// 할인된금액 계산 
	Float point = price * 0.01f ; // java 기본타입 : 정수형=int 실수=double	// 포인금액 계산 
	for(Stock s : slist) {
		sizelist.add(s.getSsize());
	}
	for(Stock c : slist) {
		colorlist.add(c.getScolor());
	}
	
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="imgArea" id="viewbox">
					<div class="thumbnail">
						<a href="#"
							onclick="window.open(this.href, 'image_zoom2', 'toolbar=no,scrollbars=auto,resizable=yes,width=450,height=693,left=0,top=0', this);return false;">
							<img
							src="../admin/productimg/<%=p.getPimg()%>"
							class="BigImage " />
						</a>

					</div>
				</div>
			</div>

		
			<div id="infobox" class="productinfo col-md-6 px-5">
					
				<table border="1" summary="" class="table">
					<!--
                                출력 갯수 지정 변수, 없으면 설정된 전체가 나옵니다.
                                count = 10
                            -->
                            
					<tbody>
					
						<tr>
							<th scope="row"><span
								style="font-size: 20px; color: #555555;">PRODUCT</span></th>
							<td scope="row"><span id="pname"
						style="font-size: 20px; color: #555555;"> <%=p.getPname()%></span></td>
						</tr>
						<tr>
							<th scope="row"><span
								style="font-size: 18px; color: #888888; font-weight: bold;">상품간략설명</span></th>
							<td>
							<%for(String temp : sizelist) {%>
							<span style="font-size: 13px; color: #888888; font-weight: bold;"><%=temp + "   "%></span>
							<%} %>	
							</td>				
							</tr>
						<tr>
						
							<th scope="row"><span
								style="font-size: 20px; color: #222222; font-weight: bold;">PRICE</span></th>
							<td><% if( p.getPdiscount() == 0 ){ %> <!-- 할인이 없을때 -->
							<span class="price_dis"> <%= df.format(p.getPprice() ) %></span>
						<%	}else{ %> <!-- 할인이 있을때  -->
							<span class="price_rat"><%=Math.round( p.getPdiscount()*100 ) +"% 할인" %></span>
							<span id="pprice" class="price_dis">할인 가격 : <%=df.format( price ) %></span> <br>
							<span class="price">원 가격 : <%= df.format(p.getPprice() ) %></span>
						<%	} %></td>
						</tr>
						<tr>
							<th scope="row">
							<span style="font-size: 20px; color: #555555;">DELIVERY</span></th>
							<td><span style="font-size: 15px; color: #555555;"><span
									class="delv_price_B"><input id="delivery_cost_prepaid"
										name="delivery_cost_prepaid" value="P" type="hidden" /><strong>2,500원</strong>
										(70,000원 이상 구매 시 무료)</span></span></td>
						</tr>
						<tr>
							<th scope="row"><span
								style="font-size: 20px; color: #555555;">SAVE</span></th>
							<td><span style="font-size: 15px; color: #555555;"><span
									id="span_mileage_text"><%=df.format( (p.getPprice()- price) / 100 )%> (1% 적립)</span></span></td>
						</tr>
						<tr>
							<th scope="row"><span
								style="font-size: 20px; color: #555555;">COLOR</span></th>
							<td>

							<select class="form-select info_t" id="color_select">
									<option class="info_t">-[필수]옵션 선택</option>
									<%for(String temp2 : colorlist){ %>
									<option class="info_t"><%=temp2 %></option>
									<%} %>
							</select></td>
						</tr>
						<tr>
							<th scope="row">
							<input type="hidden" value="<%=pno%>" id="pno">
							<input type="hidden" value="<%=price%>" id="price">
							
							<span
								style="font-size: 20px; color: #555555;">SIZE</span></th>
							<td><select class="form-select info_t" id="size_select">
									
							</select></td>
						</tr>
					</tbody>
				</table>
				<br>
				<table class="table my-3 " id="select_table">
					
					
				</table>
				<br>
				<br>
				<div class="row">
					<div class="col-md-6">총 상품금액</div>
					<div id="total_price" class="col-md-6 total_price"></div>
				</div>
				<br>
				<div class="row" id="btnbox">
					
						<button id="btn1" class=" p-4">바로 구매하기</button>
					
						<button id="btn2" class=" p-4" onclick="shopadd('<%=mid%>')">장바구니 담기</button>
						
					
						
					
					
					<% 
							int mno = MemberDao.getmemberDao().getmno(mid);
					if(mid !=null && ProductDao.getproductDao().getplike(pno, mno)) { 	%>
						
						<br><button id="btn3" class=" p-4" onclick="saveplike('<%=mid%>')">관심상품 취소</button>
						
					<%}else{ %>
						
						<button id="btn3" class=" p-4" onclick="saveplike('<%=mid%>')">관심상품 등록</button>
						
					<%} %>
					
				</div>
			</div>
		</div>
	</div>
	
	<br>
	<br>
<script src="../js/productview.js" type="text/javascript"></script>
	<%@include file="../footer.jsp"%>
</body>
</html>