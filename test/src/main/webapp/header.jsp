<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 css cdn -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="row py-3">
		<div class="col-md-1"> <a href="/test/main.jsp"><img alt="" src="/test/img/logo.png"></a></div>
		<div class="col-md-1"> <button>메뉴1</button> </div>
		<div class="col-md-1"> <button>메뉴2</button></div>
		<div class="col-md-2"> <button onclick="location.href='boardlist.jsp'">자유게시판</button></div>
		<div class="col-md-2"> <button>고객센터</button></div>
		<div class="col-md-2"> <button onclick="location.href='login.jsp'">로그인</button></div>
		<div class="col-md-2"> <button onclick="location.href='signup.jsp'">회원가입</button></div>
		<div class="col-md-1"> <button>로그아웃</button></div>
		</div>
	</div>


<!-- jquery 최신 cdn -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js cdn -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>