<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
        <div class="offset-4 col-md-4">
            <div>
                날짜<input type="date" id="ddate">
            </div>
            <div>
                시작시간<input type="time" class="form-control" id="dtime">
            </div>
            <div>
                종료시간<input type="time" class="form-control" id="endtime">
            </div>
            <div>
                <select class="form-control" id="dcnema">
                    <option>관선택</option>
                    
                    
                </select>
            </div>
            <div>
                <select class="form-control" id="dmovie">
                    <option>영화선택</option>
                  
                   
                </select>
            </div>
            <div class="d-flex justify-content-end">
                <button class="btn btn-success" onclick="screenregister()">등록</button>
            </div>
        </div>
    </div>
</body>
</html>