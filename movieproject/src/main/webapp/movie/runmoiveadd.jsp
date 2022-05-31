<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />

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
              <div class="form-group">
        <label for="date_start" class="control-label">시작일시</label>
       
  
       
       <input id="fromDate" type="text">
		<input id="toDate" type="text">

        <label for="date_end" class="control-label">마감일시</label>
        <div id="date_end">
            <input type="text" class="form-control" name="date_end">
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar"></span>
            </span>
        </div>
    </div>

   <div class="d-flex justify-content-end">
                <button class="btn btn-success" onclick="runtimeadd()">등록</button>
            </div>
        </div>
    </div>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script>
    
    <script src="/movieproject/js/runmovie.js" type="text/javascript"></script>
</body>
</html>