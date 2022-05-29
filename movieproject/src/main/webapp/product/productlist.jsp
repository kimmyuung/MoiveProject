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
</head>
<body>
<h3> 제품 목록 페이지 </h3>
	<table id="producttable" class="table table-hover">
		<tr>
			<th width="5%">제품번호</th>	<th width="5%">대표이미지</th> 		<th width="5%">제품명</th> 		<th width="5%">가격</th>
			<th width="5%">판매금액</th>	<th width="5%"> 비고 </th>
		</tr>
		<%
			ArrayList<Product> products = ProductDao.getproductDao().getproductlist();
			for( Product p : products  ){ // 모든 제품 반복문
				
				//////////////////////////////////////////////////
		%>
			<tr>
				<th><%=p.getPno() %></th>		<th><img width="100%" src="/JSPWEB/admin/productimg/<%=p.getPimg()%>"></th> 	
				<th><%=p.getPname() %></th> 	<th><%=p.getPprice()%></th>
				 	
				<th> 
					<button class="">제품 삭제</button> 
					<button class="">제품 수정</button> 
					<button onclick="pnomove(<%=p.getPno() %>)" data-bs-toggle="modal" data-bs-target="#activemodal">상태 변경</button> 
					<button onclick="getstock(<%=p.getPno() %>)" data-bs-toggle="modal" data-bs-target="#stockmodal" >재고 변경</button> 
				</th>
			</tr>
		<%
		
			}
		%>
		
	</table>
	
	
	<script src="/movieproject/js/productlist.js" type="text/javascript"></script>

</body>
</html>
</body>
</html>