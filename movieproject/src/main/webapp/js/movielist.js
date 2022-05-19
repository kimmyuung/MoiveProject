function moviedelete( mtitle ){
	
	$.ajax({
		url : "delete",
		data : { "mtitle" : mtitle } , 
		success : function( result ){
			if( result == 1 ){
				alert("영화삭제가 완료 되었습니다.");
				// js에서 하이퍼링크 [ 페이지연결 ]
				// html :  <a href="경로">
				// js : location.href="경로">
				location.href="/movieproject/movie/movielist.jsp"; // 서블릿 
			}else{
				location.href="/movieproject/error.jsp"; // 페이지
			}
		}
	});
	
}