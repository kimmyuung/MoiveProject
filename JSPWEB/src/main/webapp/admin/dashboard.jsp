<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="shortcut icon" href="#">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 css cdn -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- 사용자정의 css -->
<link href="/JSPWEB/css/main.css" rel="stylesheet">
<link href="/JSPWEB/css/admin.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
</head>
<body>
	<marquee scrollamount="10" style="font-size: 30px;">공지사항 표시
		위치 [ 제품 관리 철저 ]</marquee>
	<div id="sidebar">
		<ul>
			<!-- 사이드바 목록 -->
			<li><h6>
					EZEN SHOP<br> 관리자 모드
				</h6></li>
			<li><button onclick="pagechange('productlist')">제품 목록</button></li>
			<li><button onclick="pagechange('productadd')">제품 등록</button></li>
			<li><button onclick="pagechange('productstock')">제품 재고</button>
			</li>
			<li><button onclick="#">주문 현황</button></li>
			<li><button onclick="#">주문 배송</button></li>
			<li><button onclick="pagechange('productsales' )">매출 관리</button></li>
			<li><a href="/JSPWEB/main.jsp">홈페이지로 이동</a></li>
			<li><a href="/JSPWEB/logout">로그 아웃</a></li>
		</ul>
		<!-- 사이드바 열기/닫기 사용 -->
		<span class="sidebarbtn" id="sidebarbtn"> ||| </span>
	</div>
	<!-- 페이지 전환시 페이지가 포함되는 구역 -->
	<div class="container" id="mainbox">
		<h3>관리자 메인페이지</h3>
	</div>
	<!-- 관리자 메인페이지 구역 -->
	<div id="dashboard"></div>
	<!-- jquery 최신 cdn -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- 부트스트랩 js cdn -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- 차트 cdn -->
	<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/locales/de_DE.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/geodata/germanyLow.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/fonts/notosans-sc.js"></script>
	
	<script src="https://cdn.amcharts.com/lib/5/percent.js"></script>
	
	<!-- 사용자정의 js -->
	<script src="/JSPWEB/js/dashboard.js" type="text/javascript"></script>
	<script src="/JSPWEB/js/main.js" type="text/javascript"></script>


</body>
</html>