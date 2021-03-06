function productadd() {
	
	// ajax 기본적으로 문자열 전송  기본 인코딩 URL 타입 :application/x-www-form-urlencoded(문자열만 가능)
	// -> multipart/form-data으로 변경해야 함
	
	var form = $("#addform")[0]; // 폼 태그 id 호출 [0] 인덱스 호출
	var formData = new FormData(form); // js 지원하는 FormData 클래스를 이용한 form 태그 객체화
	
	$.ajax({
		url : "productadd",
		type : 'POST', // type : 1. get(기본타입) 2. post(첨부파일 사용시, 보안용 등)
		data : formData, // form 객체를 전송
		contentType : false, 
		// contentType 전송시 내용물 타입 : RUL
		// 첨부파일 String 인코딩 X
		// contentType : true : URL 인코딩 타입 문자열 (기본타입)
		// contetnType : false : URL 인코딩 타입 문자열 X
		processData : false, // 전송시 문자열 전송 x
		success : function(re){
			if(re==1) {
			alert("상품이 등록되었습니다.");
			form.reset();
			}
			else {
				alert("상품 등록에 실패하였습니다. [ 관리자에게 문의 ]");
			}
		}
	});
}

/********* 첨부파일이 변경되면 특정태그에 첨부파일 이미지 표시 *******/
/* js : 객체지향 언어 */
$("#pimg").change( function( e ) { 
	/* 클라이언트가 업로드시 업로드파일의 경로 알기 */
	let reader = new FileReader();	/* 파일 읽어오는 클래스 */
	reader.readAsDataURL( e.target.files[0] ); /* readAsDataURL( 파일 ); 해당 파일 경로 찾기 */
	reader.onload = function( e ){	/* 찾은 파일의 경로 실행 -> 데이터 읽어오기 */
		$("#preview").attr( "src" , e.target.result );
	}
});