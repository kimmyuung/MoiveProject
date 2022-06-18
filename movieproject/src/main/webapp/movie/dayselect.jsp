<%@page import="dao.TheaterDao"%>
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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel='stylesheet'
	href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
<script
	src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>
<link rel="stylesheet" href="/movieproject/css/dayselect.css">
</head>

<body>
	<div class="reserve-container">
		<div class="movie-part">
			<div class="reserve-title">Movie</div>
			<div class="sort-wrapper">
				<div class="sort-rate sort-selected" onclick="ranklist()">예매율순</div>
			</div>
			<table id="moviebox"></table>
		</div>
		<div class="theater-part">
			<div class="reserve-title">Theater</div>
			<div>상영관 목록 (tno)로 설정되어 있어 tname으로 바꾸어야 함</div>

			<div id="theaterbox"></div>
		</div>
		<div class="day-part">
			<div class="reserve-title">Date</div>
			<div class="reserve-date" id="reserve-date"></div>
		</div>
		<div class="time-part">
			<div class="reserve-title">Time</div>
			<div id="timebox"></div>
			
		</div>
		<div style="border: none;">
		<button class="btn btn-info" type="button" onclick="seatchoice()">좌석 선택</button>
		</div>
	</div>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
	<script src="/movieproject/js/dayselect.js" type="text/javascript"></script>
</body>

</html>