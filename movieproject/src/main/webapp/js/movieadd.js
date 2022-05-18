



/////////////////////////////////////////카테고리 등록 ///////////////////////////
function categorybtn() {

	$("#categoryinput").html(
		'<input type="text" id="cname">' +
		'<button onclick="categoryadd()" type="button">등록</button>'
	)

	//////////////////////////// 카테고리 중복 체크			
	$("#cname").keyup(function() {
		let cname = $("#cname").val();
		let cnamej = /^[가-힣]{2,20}$/;	// 한글 2~20 사이 문자열
		// /^ : 정규표현식 시작
		// $/ : 정규표현식 끝 
		// [a-z] : 소문자 찾음
		// [A-Z] : 대문자 찾음
		// [0-9] : 숫자 찾음
		// { 최소길이 , 최대길이 } : 문자 최소길이~최대길이 까지만 입력
		// 정규표현식.test( 변수 ) : 해당 변수가 정규표현식에 동일하면 true 다르면 false	

		if (cnamej.test(cname)) { // 정규표현식과 같으면
			// 아이디 중복체크
			// 비동기식 통신 [ 목적 : 페이지 전환이 없이 java (Controller) 통신 ]
			// $.ajax({ 속성 = 속성값 , 속성 = 속성값 }) // jquery 에서 제공해주는 메소드 
			// 중복체크 
			$.ajax({
				url: "mcategorycheck", // 보내는 위치 [ 서블릿 경로 ]
				data: { "cname": cname }, // 보내는 데이터  { "변수명" : 값 }
				success: function(result) { // 통신 성공 했을경우 (  result = 받은 값 변수 )
					if (result == 1) { // 만약에 받은 데이터가 1이면
						categorycheck.innerHTML = "사용중인 카테고리 입니다."; pass[0] = false;
					}
					else {
						categorycheck.innerHTML = "사용가능한 카테고리입니다."; pass[0] = true;
					}
				}
			});


		}
		else {
			categorycheck.innerHTML = "한글 2-20글자 사이로 입력해주세요"; pass[0] = false;
		}
	});



}

function categoryadd() {
	if (pass[0] == true) {
		$.ajax({
			url: "mcategoryadd",
			data: { "cname": cname },
			success: function(result) {
				if (result == 1) { alert("카테고리 등록 성공"); $("#categotyinput").html(""); getcategory(); }
				else { alert("카테고리 등록 실패"); }
			}
		});
	}
	else {
		categorycheck.innerHTML = "한글 2-20글자 사이로 입력해주세요"; return;
	}
}




///////////////////////////////////////////////////////// 카테고리 호출 ///////////////////////////////


function getcategory() {
	$.ajax({
		url: "mcategoryget",
		success: function(re) {
			$("#categorybox").html(re);
		}
	});

}


$(function() {  // 문서 열리면 해당 코드가 실행 

	getcategory(); // 카테고리 호출

	//////////////////////////////////////아이디 체크//////////////////////////////////////////////////////
	$("#mtitle").keyup(function() { 	// mid 가 입력될때마다 해당 함수 실행
		// 1. HTML 태그내 값 가져오기 
		let mtitle = document.getElementById("mtitle").value;
		// 2. HTML 태그id 가져오기
		// 정규표현식 : 특정한 규칙을 가지는 문자열의 집합 언어
		let mtitlej = /^[가-힣a-zA-Z0-9]{1,20}$/;	// 한글+영문+숫자 1~20 사이 문자열
		// /^ : 정규표현식 시작
		// $/ : 정규표현식 끝 
		// [a-z] : 소문자 찾음
		// [A-Z] : 대문자 찾음
		// [0-9] : 숫자 찾음
		// { 최소길이 , 최대길이 } : 문자 최소길이~최대길이 까지만 입력
		// 정규표현식.test( 변수 ) : 해당 변수가 정규표현식에 동일하면 true 다르면 false	

		if (mtitlej.test(mtitle)) { // 정규표현식과 같으면
			// 아이디 중복체크
			// 비동기식 통신 [ 목적 : 페이지 전환이 없이 java (Controller) 통신 ]
			// $.ajax({ 속성 = 속성값 , 속성 = 속성값 }) // jquery 에서 제공해주는 메소드 
			// 중복체크 
			$.ajax({
				url: "movietitlecheck", // 보내는 위치 [ 서블릿 경로 ]
				data: { "mtitle": mtitle }, // 보내는 데이터  { "변수명" : 값 }
				success: function(result) { // 통신 성공 했을경우 (  result = 받은 값 변수 )
					if (result == 1) { // 만약에 받은 데이터가 1이면
						titlecheck.innerHTML = "사용중인 영화제목 입니다."; pass[1] = false;
					} else { // 만약에 받은 데이터가 1이 아니면
						titlecheck.innerHTML = "사용가능한 영화제목 입니다."; pass[1] = true;
					}
				}
			});
		} else {
			titlecheck.innerHTML = "한글, 영문 , 숫자 포함 1~20길이로 입력해주세요."; pass[1] = false;
		}
	}); // keyup end 


	$("#mprice").keyup(function() {
		let mprice = document.getElementById("mprice").value;
		// 2. HTML 태그id 가져오기
		// 정규표현식 : 특정한 규칙을 가지는 문자열의 집합 언어
		let mpricej = /^[0-9]{4,6}$/;	// 숫자 4~6 사이 문자열
		// /^ : 정규표현식 시작
		// $/ : 정규표현식 끝 
		// [a-z] : 소문자 찾음
		// [A-Z] : 대문자 찾음
		// [0-9] : 숫자 찾음
		// { 최소길이 , 최대길이 } : 문자 최소길이~최대길이 까지만 입력
		// 정규표현식.test( 변수 ) : 해당 변수가 정규표현식에 동일하면 true 다르면 false	

		if (mpricej.test(mprice)) {
			mpricecheck.innerHTML = "등록가능한 가격입니다."; pass[2] = true;
		} else {
			mpricecheck.innerHTML = "가격은 최소 1000원부터 등록이 가능합니다."; pass[2] = false;
		}
	});

	$("#mruntime").keyup(function() {
		let mruntime = document.getElementById("mruntime").value;
		// 2. HTML 태그id 가져오기
		// 정규표현식 : 특정한 규칙을 가지는 문자열의 집합 언어
		let mruntimej = /^[0-9]{3,4}$/;	// 숫자 100-1000분글자 사이 문자열
		// /^ : 정규표현식 시작
		// $/ : 정규표현식 끝 
		// [a-z] : 소문자 찾음
		// [A-Z] : 대문자 찾음
		// [0-9] : 숫자 찾음
		// { 최소길이 , 최대길이 } : 문자 최소길이~최대길이 까지만 입력
		// 정규표현식.test( 변수 ) : 해당 변수가 정규표현식에 동일하면 true 다르면 false	

		if (mruntimej.test(mruntime)) {
			mtimecheck.innerHTML = "등록 가능한 시간입니다."; pass[4] = true;
		} else {
			mtimecheck.innerHTML = "등록 불가능한 시간입니다."; pass[4] = false;
		}
	});

});



let pass = [true, false, false, false, false]; // 배열 = [  ] // 유효성 검사
// 0번 : 카테고리 유효성 
// 1번 : 영화 이름 유효성 
// 2번 : 영화 가격 유효성
// 3번 : 포스터 유효성

////////////////////////////////////// form 전송
function movieadd() {

	// ajax 기본적으로 문자열 전송  기본 인코딩 URL 타입 :application/x-www-form-urlencoded(문자열만 가능)
	// -> multipart/form-data으로 변경해야 함
	for (let i = 0; i <= pass.length; i++) {
		if (pass[i] != true) {
			alert("입력하지 않았거나 등록가능하지 않은 부분이 있습니다. 다시 시도해주세요");
			return;
		}
		else {
			var form = $("#addform")[0]; // 폼 태그 id 호출 [0] 인덱스 호출
			var formData = new FormData(form); // js 지원하는 FormData 클래스를 이용한 form 태그 객체화

			$.ajax({
				url: "movieadd",
				type: 'POST', // type : 1. get(기본타입) 2. post(첨부파일 사용시, 보안용 등)
				data: formData, // form 객체를 전송
				contentType: false,
				// contentType 전송시 내용물 타입 : RUL
				// 첨부파일 String 인코딩 X
				// contentType : true : URL 인코딩 타입 문자열 (기본타입)
				// contetnType : false : URL 인코딩 타입 문자열 X
				processData: false, // 전송시 문자열 전송 x
				success: function(re) {
					if (re == 1) {
						alert("영화가 등록되었습니다.");
						form.reset();
					}
					else {
						alert("영화 등록에 실패하였습니다. [ 관리자에게 문의 ]");
					}
				}
			});
				
		}
	}


}

/********* 첨부파일이 변경되면 특정태그에 첨부파일 이미지 표시 *******/
/* js : 객체지향 언어 */
$("#pimg").change(function(e) {

	let image = $("#pimg").val();
	let imagej = /([^\s]+(?=\.(jpg|gif|png))\.\2)/
	if (imagej.test(image)) {
		/* 클라이언트가 업로드시 업로드파일의 경로 알기 */
		pass[3] = true;
		let reader = new FileReader();	/* 파일 읽어오는 클래스 */
		reader.readAsDataURL(e.target.files[0]); /* readAsDataURL( 파일 ); 해당 파일 경로 찾기 */
		reader.onload = function(e) {	/* 찾은 파일의 경로 실행 -> 데이터 읽어오기 */
			$("#preview").attr("src", e.target.result);
		}
	} else {
		alert("확장자 이름이 .jpg .png .gif 중 하나를 가져야 합니다.");
		$("#pimg").val = "";
		$("#pimg").html = "";
		pass[3] = false;
		return;
	}
});

