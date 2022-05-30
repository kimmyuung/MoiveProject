<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../header.jsp" %>
<div class="container">
        <div class="offset-4 col-md-4">
         <div>
                <select class="form-control" id="theaterbox"></select>
            </div>
            <div>
                <select class="form-control" id="moviebox"></select>
            </div>
            <div>
                상영 시작 날짜<input type="date" id="startdate" class="form-control">
                상영 종료 날짜<input type="date" id="enddate" class="form-control">
            </div>
            <div>
                영화관 상영 시작 시간<input type="time" class="form-control" id="stime">
            </div>
            <div>
                영화관 상영 종료 시간<input type="time" class="form-control" id="etime">
            </div>
           
            <div class="d-flex justify-content-end">
                <button class="btn btn-success" onclick="runtimeadd()">등록</button>
            </div>
        </div>
    </div>
    <script src="/movieproject/js/runmovie.js" type="text/javascript"></script>
</body>
</html>