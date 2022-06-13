<%@page import="dto.Movie"%>
<%@page import="dto.Theater"%>
<%@page import="dao.MovieDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>영화 선택</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/reserve.css">
<link rel="stylesheet" href="css/header.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel='stylesheet'
	href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
<script
	src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>
<link rel="stylesheet"
	href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
<link rel="stylesheet" href="/movieproject/css/dayselect.css">
</head>

<body>
	<div class="reserve-container">
		<div class="movie-part">
			<div class="reserve-title">Movie</div>
			<div class="sort-wrapper">
				<div class="sort-rate sort-selected" onclick="ranklist()">예매율순</div>
			</div>
			<div class="movie-list">영화 목록 가져오기</div>
			
			<div id="moviebox"></div>
		</div>
		<div class="theater-part">
			<div class="reserve-title">Theater</div>
			<div>상영관 목록 가져오기</div>

			<table id="theaterbox"></table>
		</div>
		<div class="day-part">
			<div class="reserve-title">Date</div>
			<div class="reserve-date"></div>
		</div>
		<div class="time-part">
			<div class="reserve-title">Time</div>
		</div>

	</div>

	<script src="/movieproject/js/dayselect.js" type="text/javascript"></script>
</body>

</html>