<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.2/dist/umd/popper.min.js"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/gh/Eonasdan/tempus-dominus@master/dist/js/tempus-dominus.js"
	crossorigin="anonymous"></script>


<link
	href="https://cdn.jsdelivr.net/gh/Eonasdan/tempus-dominus@master/dist/css/tempus-dominus.css"
	rel="stylesheet" crossorigin="anonymous">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp"%>
	<div class="container">
		<div class="offset-4 col-md-4">
			<div class="py-2 my-2">
			상영관 목록 	<select class="form-control" id="theaterbox"></select>
			</div>
			<div class="py-2 my-2">
			영화 목록	<select class="form-control" id="moviebox"></select>
			</div>

		</div>
	
		<div class="my-2 py-2">
			<h4 style="text-align: center;">영화 상영 시작 날짜 및 시간</h4>
			
			<div class='input-group' id='datetimepicker1'
				data-td-target-input='nearest' data-td-target-toggle='nearest'>
				<input id='datetimepicker1Input' type='text' class='form-control'
					data-td-target='#datetimepicker1' /> <span
					class='input-group-text' data-td-target='#datetimepicker1'
					data-td-toggle='datetimepicker'> <span
					class='fa fa-solid fa-calendar'></span>
				</span>
			</div>
		</div>
		
		<div class="my-2 py-2">
			<h4 style="text-align: center;">영화 상영 종료 날짜 및 시간</h4>
			
			<div class='input-group' id='datetimepicker1'
				data-td-target-input='nearest' data-td-target-toggle='nearest'>
				<input id='datetimepicker1Input' type='text' class='form-control'
					data-td-target='#datetimepicker1' /> <span
					class='input-group-text' data-td-target='#datetimepicker1'
					data-td-toggle='datetimepicker'> <span
					class='fa fa-solid fa-calendar'></span>
				</span>
			</div>
		</div>
		
	</div>







	<div class="d-flex justify-content-end">
		<button class="btn btn-success" onclick="runtimeadd()">등록</button>
	</div>
	</div>
	</div>


	<script src="/movieproject/js/runmovie.js" type="text/javascript"></script>
</body>
</html>