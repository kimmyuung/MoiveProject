<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset='UTF-8'>
<meta name="robots" content="noindex">
<link rel="canonical"
	href="https://codepen.io/ryanparag/pen/LLrVbo?depth=everything&order=popularity&page=10&q=movie&show_forks=false" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel='stylesheet prefetch'
	href='https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css'>
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/icon?family=Material+Icons'>
<style class="cp-pen-styles">
@import url("https://fonts.googleapis.com/css?family=Arimo:400,700");
.imax-logo {
  width: 50px;
  height: 15px;
  background: url("https://6a25bbd04bd33b8a843e-9626a8b6c7858057941524bfdad5f5b0.ssl.cf5.rackcdn.com/media_kit/3e27ede823afbf139c57f1c78a03c870.jpg") no-repeat;
  background-size: contain;
  display: table-cell;
  float: right;
  position: relative;
  margin-top: 5px;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>
	<%@include file="header.jsp"%>

	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="container">
		<div class="row" style="text-align: center;">
			<div id="movie" class="carousel carousel-dark slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#movie" data-bs-slide-to="0"
						class="active" aria-current="true" aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#movie" data-bs-slide-to="1"
						aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#movie" data-bs-slide-to="2"
						aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active" data-bs-interval="10000">
						<a href="/movieproject/movie/moviedetail.jsp"><img src="/movieproject/img/movie/movie1.jpg"
							class="img-fluid" alt="..." style="height: 600px; width: 800px;"></a>
						
					</div>
					<div class="carousel-item" data-bs-interval="2000">
						<a href="/movieproject/movie/moviedetail.jsp"><img src="/movieproject/img/movie/movie2.jpg"
							class="img-fluid" alt="..." style="height: 600px;  width: 800px;"></a>
						
					</div>
					<div class="carousel-item">
						<a href="/movieproject/movie/moviedetail.jsp"><img src="/movieproject/img/movie/movie3.jpg"
							class="img-fluid" alt="..." style="height: 600px;  width: 800px;"></a>
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#movie" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#movie" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>

		<br>
		<br>
		<br>
		<br>
		<br>
		<div class="card" style="width: 18rem;">
			<a href="#"><img src="/movieproject/img/movie/movie3.jpg" class="card-img-top img-fluid"
				alt="..."></a>
			<div class="card-body">
				<h5 class="card-title">영화 리스트 카드들이 들어갈 공간</h5>
				<p class="card-text"></p>
				<a href="movie/dayselect.jsp" class="btn btn-primary">영화 보러 가기</a>
				<div class="imax-logo"></div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>




		<%@include file="footer.jsp"%>
	</div>
</body>
</html>