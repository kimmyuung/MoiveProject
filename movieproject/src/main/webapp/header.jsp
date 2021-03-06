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
						
							<%
							if (loginid != null && !(loginid.equals("admin"))) {
							%>
							<li><a class="dropdown-item" href="/movieproject/movie/dayselect.jsp">영화 예매 </a></li>
							<%
							}
							%>
							<%
							if (loginid != null && loginid.equals("admin")) {
							%>
							<li><a class="dropdown-item" href="/movieproject/movie/movieadd.jsp"> 영화 등록</a></li>
							<li><a class="dropdown-item" href="/movieproject/movie/movielist.jsp"> 영화 관리</a></li>
							<li><a class="dropdown-item" href="/movieproject/movie/.jsp"> 상영 영화 관리</a></li>
							<%
							}
							%>
						</ul>
					</div>
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

					<h5 class="col-md-6">
						환영합니다 관리자님
					</h5>
					<div class="dropdown">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
    관리 메뉴
  </a>

  <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <li><a class="dropdown-item" href="/movieproject/theater/theaterlist.jsp">상영관 관리</a></li>
    <li><a class="dropdown-item" href="/movieproject/member/memberlist.jsp">회원 관리</a></li>
    
    <li></li>
  </ul>
 
</div>	
 <a href="/movieproject/logout" class="mx-2"><button
							class="btn btn-secondary" type="button">로그 아웃</button></a>
					<% } %>
					<div class="col-lg-3">
					<a href="/movieproject/board/boardlist.jsp"><button
							class="btn btn-secondary" type="button">고객센터</button> </a>
					
					</div>
					<div class="col-lg-1">
						<a href="/movieproject/movie/moviesearch.jsp"><button type="button" class="btn btn-secondary icon_search" data-bs-toggle="modal" data-bs-target="#exampleModal"></button></a>
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