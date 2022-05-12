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
        <div class="row">
            <a class="col-md-2"><button class="btn btn-secondary"> 시간등록 </button></a>
            <div class="col-md-2 offset-8 d-flex justify-content-end"><a ><button >뒤로가기</button></a></div>
        </div>
        <table class="table p-5" id="spreadsheet3">
            <tr>
                <td>스케줄번호</td><td>날짜</td><td>시간</td><td>관</td><td>영화아이디</td><td>좌석수</td>
            </tr>
            <tr >
                <td ></td><td ></td><td ></td>
                <td ></td><td ></td><td ></td>
                <td><a href="#" class="button" >X</a></td>
            </tr>
        </table>

        <ul class="pagination justify-content-center">
          
            <!--첫페이지 -->
            <li class="page-item">
                
            </li>

            <li class="page-item" >
               
            </li>

            <li class="page-item" >
              
            </li>

            <li class="page-item">
               
            </li>

            <li class="page-item">
               
            </li>

        </ul>

    </div>

    <form action="/admin/datelist" method="get" class="col-md-5 offset-4 input-group my-3 g-0" >
        <div class="col-md-1">
            <select name="keyword" class="form-select">
                <option value="ddate">날짜</option>
                <option value="dno">스케줄번호</option>
            </select>
        </div>
        <div class="col-md-2">
            <input type="search" name="search" class="form-control">
        </div>
        <div class="col-md-1">
            <input type="submit" value="검색" class="form-control">
        </div>
    </form>

    </div>

</body>
</html>