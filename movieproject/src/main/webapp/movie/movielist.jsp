<%@page import="dto.Category"%>
<%@page import="controller.movie.moiveadd"%>
<%@page import="dao.MovieDao"%>
<%@page import="dto.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp"%>


	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="container">
		<div id="movielist">
			<table class="table">
				<tr>
					<th>영화 제목</th>
					<th>영화 포스터</th>
					<th>영화 러닝타임</th>
					<th>영화 가격</th>
					<th>영화 카테고리</th>
				</tr>

				<%
				ArrayList<Movie> mlist = MovieDao.getmovieDao().getmovielist();
				for (Movie m : mlist) {
				%>
				<tr>
					<td><a href="#" onclick="moviedelete('<%=m.getMtitle()%>')"><%=m.getMtitle()%></a></td>
					<td><img alt=""
						style="width: 20%" src="../movie/upload/<%=m.getMimg()%>"></td>
					<td><%=m.getMruntime()%></td>
					<td><%=m.getMprice()%></td>
					<td><%=m.getMcategory()%></td>
				</tr>
				<%
				}
				%>

			</table>
		</div>
			<div class="">
			
			</div>
	</div>
<div class='container'>
  <div class='container_inner'>
    <div class='container_inner__list'>
      <div class='list_item'>
        <input checked='checked' id='movie-Daredevil' name='movie' type='radio'>
        <label for='movie-Daredevil'>
          <div class='icon ion-ios-videocam'></div>
          <span>Daredevil</span>
          <div class='list_item__placeholder'></div>
          <div class='list_item__image'></div>
          <div class='list_item__bg'></div>
          <section class='list_item__feature'>
            <img class='gif' src='https://www.jamiecoulter.co.uk/dev/codepen/dd_gif.gif'>
            <div class='gif_overlay'></div>
            <div class='information'>
              <h1>Daredevil</h1>
              <h2>26 episodes</h2>
              <div class='stars'>
                <div class='ion-android-star'></div>
                <div class='ion-android-star'></div>
                <div class='ion-android-star'></div>
                <div class='ion-android-star'></div>
                <div class='ion-android-star'></div>
              </div>
            </div>
            <div class='description'>
              <p>The first in a planned series of shows detailing the Marvel universe, "Daredevil" follows Matt Murdock, attorney by day and vigilante by night. Blinded in an accident as a child, Murdock uses his heightened senses as Daredevil, fighting crime on the streets of New York after the sun goes down. His efforts are not welcomed by powerful businessman Wilson Fisk -- aka Kingpin -- and others whose interests collide with those of Daredevil</p>
            </div>
            <div class='watch'>
              <div class='ion-android-star'></div>
              Watch now
            </div>
          </section>
        </label>
      </div>
    

    </div>
  </div>
</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<%@include file="../footer.jsp"%>
	<script src='//production-assets.codepen.io/assets/common/stopExecutionOnTimeout-b2a7b3fe212eaa732349046d8416e00a9dec26eb7fd347590fbced3ab38af52e.js'></script>
	<script src="../js/movielist.js" type="text/javascript"></script>
</body>
</html>