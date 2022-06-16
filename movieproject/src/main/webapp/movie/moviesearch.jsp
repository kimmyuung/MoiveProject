<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<link rel="stylesheet" href="/movieproject/css/search.css"
	type="text/css">
</head>
<body>

<section class="header">
  <h1>Search for a Movie</h1>

  <div class="form">
    <input type="text" id="movie" name="search" placeholder="Search by Title" onkeyup="enterkey()" />
    <button type="button" id="submit" onclick="moviesearch()"> <i class="fa fa-search"></i>
    </button>
  </div>
  <div>
  <a href="/movieproject/main.jsp"><button id="submit2" style="width: 200px;">홈페이지로 이동</button></a>
  </div>
</section>


<section class="results">
  <div class="movie-grid"></div>
</section>


	<!-- 부트스트랩  -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- jquery 최신 cdn -->
	<script src="http://code.jquery.com/jquery-latest.min.js"
		type="text/javascript"></script>
	<script src="/movieproject/js/search.js" type="text/javascript"></script>

</body>
</html>