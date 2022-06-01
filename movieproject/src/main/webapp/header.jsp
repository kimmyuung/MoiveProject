<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이젠 영화관</title>
<link href="/movieproject/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="/movieproject/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="/movieproject/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="/movieproject/css/nice-select.css"
	type="text/css">
<link rel="stylesheet" href="/movieproject/css/slicknav.min.css"
	type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/movieproject/css/main.css"
	type="text/css">
</head>
<body>

	<%
	String loginid = (String) session.getAttribute("login"); // 세션 호출 ( 기본타입 = Odject )
	%>

	<div class="container">
		<div class="row">
			<div class="col-md-2 d-flex">
				<div class="header__logo">
					<a href="/movieproject/main.jsp"> <img src="/movieproject/img/logo.jpg"
						class="img-fluid" alt="" style="width: 150px;">
					</a>
				</div>
			</div>

			<div class="col-md-10 pb-1 pt-5 px-5">
				<div class="col-md-7 offset-5 d-flex justify-content-end">
					<!-- 헤더 메뉴 오른쪽 배치 -->
					<!-- 헤더 -->
					<a href="/movieproject/main.jsp"><button class="btn btn-secondary" type="button">Home Page</button> </a>
					&nbsp;&nbsp; 
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton1" data-bs-toggle="dropdown"
							aria-expanded="false">Movie</button>
						&nbsp;&nbsp;
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<li><a class="dropdown-item" href="/movieproject/movie/movierank.jsp">영화 순위 확인</a></li>
							<li><a class="dropdown-item" href="#">상영 시간표 보기</a></li>
							<%
							if (loginid != null && !(loginid.equals("admin"))) {
							%>
							<li><a class="dropdown-item" href="#"> 영화 예매 하기</a></li>
							<%
							}
							%>
							<%
							if (loginid != null && loginid.equals("admin")) {
							%>
							<li><a class="dropdown-item" href="/movieproject/movie/movieadd.jsp"> 영화 등록</a></li>
							<li><a class="dropdown-item" href="/movieproject/movie/movielist.jsp"> 영화 관리</a></li>
							<%
							}
							%>
						</ul>
					</div>
					&nbsp;&nbsp;
					
					<a href="/movieproject/board/boardlist.jsp"><button
							class="btn btn-secondary" type="button">고객센터</button> </a>
					&nbsp;&nbsp;

					<!-- 로그인이 안된 상태 -->
					<%
					if (loginid == null) {
					%>
					<a href="/movieproject/member/login.jsp"><button
							class="btn btn-secondary" type="button">로그인</button></a> &nbsp;&nbsp;

					<a href="/movieproject/member/signup.jsp"><button
							class="btn btn-secondary" type="button">회원 가입</button></a>
					&nbsp;&nbsp;
					<%
					}
					%>
					<!--  만약에 로그인된 상태 -->
					<%
					if (loginid != null && !(loginid.equals("admin"))) {
					%>
					<h5>
						<span> <%=loginid%>님 </span>
					</h5>
					<a href="/movieproject/logout"><button
							class="btn btn-secondary" type="button">로그 아웃</button></a> <a
						href="/movieproject/member/mymovie.jsp"><button
							class="btn btn-secondary" type="button">My movie</button></a>
					<%
					}
					%>
					<%
					if (loginid != null && loginid.equals("admin")) { //관리자로 로그인시
					%>

					<h5 style="width: 100%">
						환영합니다 관리자님
					</h5>

					<a href="/movieproject/theater/theaterlist.jsp"><button class="btn btn-secondary" type="button">상영관 관리</button> </a>
					
					<a href="/movieproject/product/productlist.jsp"><button class="btn btn-secondary" type="button">제품 관리</button> </a>
					
					<a href="/movieproject/member/memberlist.jsp"><button class="btn btn-secondary" type="button">회원 관리</button> </a>
					<a href="/movieproject/chart/chart.jsp"><button class="btn btn-secondary" type="button">매출 관리</button> </a>
					<a href="/movieproject/logout"><button class="btn btn-secondary" type="button">로그 아웃</button> </a>
					
					<% } %>
					<div class="col-lg-1">
						<a href="moviesearch.jsp"><button type="button" class="btn btn-secondary icon_search" data-bs-toggle="modal" data-bs-target="#exampleModal"></button></a>
					</div>
				</div>
			</div>
		</div>
	</div>

	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- jquery 최신 cdn -->
	<script src="http://code.jquery.com/jquery-latest.min.js"
		type="text/javascript"></script>
</body>
</html>