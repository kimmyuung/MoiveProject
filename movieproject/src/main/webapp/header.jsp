<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이젠 영화관</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
<link href="/MovieJSP/css/main.css" rel="stylesheet">
<style type="text/css">
@font-face {
    font-family: 'Donoun-Medium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2205@1.0/Donoun-Medium.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
* {
	font-family: Donoun-Medium;
}
</style>
</head>
<body>

<%
		String loginid 
			= (String)session.getAttribute("login"); // 세션 호출 ( 기본타입 = Odject )
	%>

<div class="row">
		<div class="col-md-10 offset-2 fixed-top pb-1 pt-5 px-5">
			<div class="col-md-7 offset-5 d-flex justify-content-end">
				<!-- 헤더 메뉴 오른쪽 배치 -->
				<!-- 헤더 -->
				<ul class="nav">
					<li class="tophead"><a href="/MovieJSP/main.jsp">HOME</a> &nbsp &nbsp</li>
					<li class="tophead"><a href="#">고객센터 </a>&nbsp &nbsp</li>
					
					<% if( loginid == null ){ %>
					<li class="tophead"><a href="/MovieJSP/member/login.jsp">LOGIN </a> &nbsp &nbsp</li>
					<li class="tophead"><a href="/MovieJSP/member/signup.jsp">회원 가입 </a>&nbsp &nbsp</li>
					<%} %>
		<!--  만약에 로그인된 상태 -->
					<% if( loginid != null ){ %>
						<span> <%=loginid %>님 </span>
					<li class="tophead"><a href="/MovieJSP/member/logout">로그아웃</a></li>
					<li class="tophead"><a href="#">MY MOVIE </a>&nbsp &nbsp</li>
					<%} %>
					<% if( loginid != null && loginid.equals("admin") ){ //관리자로 로그인시%> 
						<span> <%=loginid %>님 </span>
					<li class="tophead"><a href="/MovieJSP/member/logout">영화 관리</a>&nbsp &nbsp</li>
					<li class="tophead"><a href="#"> 상영관 관리 </a>&nbsp &nbsp</li>
					<li class="tophead"><a href="/MovieJSP/member/logout">제품관리</a>&nbsp &nbsp</li>
					<li class="tophead"><a href="#">회원 관리 </a>&nbsp &nbsp</li>
					<li class="tophead"><a href="/MovieJSP/member/logout">매출 관리</a></li>
					<li class="tophead"><a href="#">로그 아웃 </a>&nbsp &nbsp</li>
					<%} %>
				</ul>
			</div>
		</div>
</div>
<!-- 부트스트랩  -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- jquery 최신 cdn -->
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
</body>
</html>