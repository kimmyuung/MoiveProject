function pwcheck(mid) {
	
	// 1. jquery
	let mpw = $("#mpw").val();
	
	// 2. js 
	// let mpw = document.getElementById("mpw").value;
	
	// 비동기 통신 = 제이쿼리 제공해주는 통신 메소드
		// [js(view) ---> java(controller)]
	$.ajax({
		url : "../passwordcheck",// 어디로
		data :  {"mid": mid, "mpw" : mpw},// 보낼 데이터
		type : "POST", // http 요청방식 정의 [get = 기본값, post]
		success : function( result ) { // 받을 데이터
			if(result == 1) {
				alert("같다");
				$("#checkmsg").html("정말 탈퇴하시겠습니까?");
				$("#mpw").css("display" , "none"); // 제이쿼리 css 적용  [ .css( "속성명" , "속성값") ]
				$("#btncofirm").css("display" , "none");
				$("#btndelete").css("display" , "block");
			}
			else {
				$("#checkmsg").html("동일한 패스워드가 아닙니다.");
				$("#mpw").val("");
				alert("다르다");
			}
		} 
	});
}


function mdelete(mid) {
	
	$.ajax({
		url : "../delete",
		data : {"mid" : mid},
		success : function(result) {
			alert(result);
			if(result) {
				alert("탈퇴가 완료되었습니다. 이용해주셔서 감사합니다")
				// js에서 하이퍼링크[페이지 연결]
				location.href = "/JSPWEB/logout"; // 서블릿
			}
			else {
				alert("관리자에게 문의")
				location.href = "/JSPWEB/error.jsp";
			}
		}
	});
}