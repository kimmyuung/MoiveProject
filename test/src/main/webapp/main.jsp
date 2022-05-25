<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	
	<br><br>
	
	<div class="conatiner">
		<div id="mainsilde" class="carousel slide" data-bs-ride="carousel"> <!-- 캐러셀 -->
			<div class="carousel-indicators">
				<button type="button" data-bs-target="#mainsilde" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				<button type="button" data-bs-target="#mainsilde" data-bs-slide-to="1" aria-label="Slide 2"></button>
				<button type="button" data-bs-target="#mainsilde" data-bs-slide-to="2" aria-label="Slide 3"></button>
			</div>
			<div class="carousel-inner"> <!-- 이미지 목록 -->
				<div class="carousel-item active"> <!-- 이미지 -->
					<img src="/test/img/mainpageimg1.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="/test/img/mainpageimg2.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="/test/img/mainpageimg3.jpg" class="d-block w-100" alt="...">
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
		<br>
		<div class="row" style="text-align: ">
			<!-- 메인이미지 -->
			<div class="col-md-5 offset-1">
			<img alt="" src="/test/img/mainad1.gif">
			</div>
			<div class="col-md-5 offset-1">
			<img alt="" src="/test/img/mainad2.jpg">
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>

</body>
</html>