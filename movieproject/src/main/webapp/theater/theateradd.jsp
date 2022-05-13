<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<br>
	<br>
	<br>
	<div class="container">
		<div class="col-md-6">
			관 이름 : <input type="text"> <br><br> 
			관 좌석 : <select id="seats">
				<option value="0">좌석 선택</option>
				<option value="50">소형(50)석</option>
				<option value="80">중형(80)석</option>
				<option value="100">대형(100)석</option>
				<option value="150">특대형(150)석</option>
			</select> <br><br> 
			<div id="div_add"></div>
			<div id="div_cancel"></div>
		</div>
	</div>
	<br>
	<br>
	<div class="container" id='div_btn'>
		
		
	</div>
	<div class="col-md-6">
		
		</div>
	
	
	


	<br>
	


  

	<br>
	<br>
	<script src="../js/theater.js" type="text/javascript"></script>
	<%@include file="../footer.jsp"%>
</body>
</html>