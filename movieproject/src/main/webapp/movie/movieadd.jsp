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
	<br>
	<br>
	<br>
	<h3 class="admin_title">영화 등록</h3>


	<!-- 폼에서 첨부파일 전송시에는 enctype="multipart/form-data" -->
	<div>
		<div class="row">
			<form id="addform" class="col-md-10" enctype="multipart/form-data">
				<div class="row ">
					<div class="col-md-3 ">
						<span> 영화명 </span>
					</div>
					<div class="col-md-4">
						<input class="form-control" type="text" id="mtitle" name="mtitle"
							placeholder="영화 이름">
					</div>
					<div id="titlecheck" class="col-md-3"></div>
				</div>

				<div class="row">
					<div class="col-md-3 ">
						<span> 가격 </span>
					</div>
					<div class="col-md-4">
						<input class="form-control" type="text" id="mprice" name="mprice"
							placeholder="가격">
					</div>
				</div>
				<div id="mpricecheck" class="col-md-3"></div>
					
				<div class="row">
					<div class="col-md-3 ">
						<span> 러닝타임 </span>
					</div>
					<div class="col-md-4">
						<input class="form-control" type="text" id="mruntime" name="mruntime"
							placeholder="러닝타임 분단위로 입력하세요">
					</div>
				</div>
				<div id="mtimecheck" class="col-md-3"></div>	
					
					
					
					
					
				<div class="row">
					<div class="col-md-2 ">
						<span> 카테고리 </span>
					</div>
					<div class="col-md-2">
						<button class="form-control" onclick="categorybtn()" type="button">카테고리 관리</button>
					</div>
					<div class="col-md-5" id="categoryinput"></div>
				</div>
				<div class="row">
					<!-- 버튼 클릭시 카테고리 입력창 표시되는 구역  -->
					<div id="categorybox">
						
					</div>
					<!-- DB내 카테고리 개수만큼 radio 버튼이 표시되는 구역 -->
					<div id="categorycheck"></div>
					<!-- 카테고리 유효성 검사 결과가 표시되는 구역 -->
				</div>
				<div class="row">
					<div class="col-md-2 ">
						<span> 영화 포스터 </span>
					</div>
					<div class="col-md-5">
						<input class="form-control" type="file" id="pimg" name="pimg">
					</div>
				</div>

				<div class="row">
					<div class="col-md-5">
						<button class="form-control" type="button" onclick="movieadd()">영화
							등록</button>
						<!-- js에서 form 비동기 통신  -->
					</div>
					<div class="col-md-5">
						<input class="form-control" type="reset" value="초기화">
					</div>
				</div>

			</form>
			<div class="col-md-4">
				<h5>대표이미지 미리보기</h5>
				<img id="preview" width="100%">
			</div>
		</div>
	</div>
	<script src="/movieproject/js/movieadd.js" type="text/javascript"></script>

</body>
</html>