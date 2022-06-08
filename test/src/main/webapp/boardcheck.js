
	
$( function(){  // 문서 열리면 해당 코드가 실행 
	$("#boardtitle").keyup( function(){ 	// mid 가 입력될때마다 해당 함수 실행
		
		let boardtitle=document.getElementById("boardtitle").value;
		
		let btitlej = /^[a-zA-Z가-힣0-9]{1,20}$/;	// 1~20 사이 문자열
			
		if( btitlej.test( boardtitle ) ){ // 정규표현식과 같으면
			titlecheck.innerHTML = "작성 가능합니다."; pass[0] = true;
		}else{
			titlecheck.innerHTML = "영문 한글 숫자 포함 1~20 길이로 입력해주세요."; pass[0] = false;
		}
	}); // keyup end 
	//////////////////////////////////////제목 체크 end //////////////////////////////////////////////////////
	
	// 내용 체크 
	$("#boardcontent").keyup( function(){  // 비밀번호 입력할때마다
		// let mpassword = document.getElementById("mpassword").value;  // js식
		let mpassword = $("#boardcontent").val();  // jquery 식
		let passswordj = /^[a-zA-Z0-9가-힣]{1,50}$/; // 정규표현식
		
		if( passswordj.test( mpassword ) ){ // 정규표현식 같으면
			$("#contextcheck").html("등록 가능한 내용입니다"); pass[1] = true;
		}else{ // 정규현식 다르면
			$("#contextcheck").html("영문 한글 숫자 포함 1~50 사이로 입력해주세요!"); pass[1] = false;
		}
	}); // keyup end 
	
	
	});
let pass = [ false , false]; // 배열 = [  ]	
function bwrite() {
	
	let title = $("#boardtitle").val();
	let context = $("#boardcontent").val();
	let writer = $("#writer").val();
	let bpassword = $("#bpassword").val();
	
	if(pass[0] == false) {
	alert("제목을 입력해주세요");
	return;
	}
	if(pass[1] == false) {
	alert("내용을 입력해주세요");
	return;	
	}
	
	if(writer == '' ) {
		alert("작성자를 입력해주세요");
		return;
	}
	if(bpassword == '') {
		alert("비밀번호를 입력해주세요");
		return;
	}
	
	console.log(title, context, writer, bpassword);
	
	if(pass[0] == true && pass[1] == true) {
	
	$.ajax({
		url : 'write',
		data : {'btitle' : title, 'bcontext' : context, 
		'writer' : writer, 
		'bpassword' : bpassword},
		success : function(re) {
			
			if(re == 1) {
				alert("게시글 등록 성공");
				location.href = "boardlist.jsp";
			}
			else {alert("게시글 등록 오류");}
		}
	});
	
	
	}
}	