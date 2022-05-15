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


<br><br><br><br><br><br><br><br><br><br><br> <br><br><br>
영화리스트 
<script type="text/javascript">
		$.ajax({
			method : "get",
			url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json",
			data : {
				targetDt : "20220508",
					key : "aa00e29d76f425572e382e01cfb52950",
					itemPerPage : "10",
			}
		}).done(function(msg) {
			alert("Data Saved: " + msg);
			console.log(msg);
		});	
	</script>
	<script src="/movieproject/js/KobisOpenAPIRestService.js" type="text/javascript"></script>
</body>
</html>