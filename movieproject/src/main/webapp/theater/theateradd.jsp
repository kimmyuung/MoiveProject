<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
.seat {
	width: 30px;
	height: 30px;
}
.clicked {
	background-color: red;
	color: white;
}
</style>
</head>
<body>
	<%@include file="../header.jsp"%>
	<br>




	<div class="container" style="margin-top: 200px;">
		<div class="col-md-6">
			관 이름 : <input type="text" id="tname"> <button type="button" onclick="tnamecheck()">이름 중복 체크</button><br>
			<span id="tnamecheck"></span>
			 <br> 
			관 좌석 : <select id="seatselect">
				<option value="0">좌석 선택</option>
				<option value="50">소형(25)석</option>
				<option value="80">중형(65)석</option>
				<option value="100">대형(100)석</option>
			</select> <br> <br>
		</div>
		
		<div class="col-md-6">
		<div class="seat-wrapper"></div> <!-- 영화관 좌석 표시 -->

		</div>
		</div>
		<div class="col-md-3 offset-5">
		<button class="form-control" onclick="theateradd()">영화관 등록</button>
		<button type="reset" class="form-control" onclick="readd()">영화관 등록 초기화</button>
		</div>
	<br>
	<br>
	<br>
	<br>
	<script src="../js/theater.js" type="text/javascript"></script>
	<%@include file="../footer.jsp"%>
</body>
</html>