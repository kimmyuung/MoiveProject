function replywrite( bno ){
	let rcontent = $("#rcontent").val();
	$.ajax({
		url: "replywrite" ,
		data: { "bno": bno , "rcontent" : rcontent  } ,
		success : function( result ){
			if( result == 1 ){
				 alert("댓글작성 되었습니다."); // 성공 메시지 알림 
				 $("#rcontent").val(""); // 작성 input 공백으로 초기화 
				 $("#replytable").load( location.href+" #replytable"); // 특정 태그 새로고침
				 /* 해당 replytable 의 불러오기 = replytable */
			}
			else{ alert("댓글작성이 실패했습니다."); }
		}
	});
	
}

function rereplyview( rno , bno , mid ){ // 대댓글 입력창 표시 메소드 
	// ' '  or " "	: 문자처리 	// '문자열' + 변수 + '문자열'
	if( mid == "null" ){ // 로그인 안되어 있으면
		alert("로그인후 작성이 가능합니다."); 
		return;
	}
	// JS 작성 공간 에서는 HTML 작성 불가능 --> HTML 문자처리 
		$("#"+rno).html(
			'<div class="row">'+
				'<div class="col-md-10">'+
					'<textarea id="rrcontent" class="form-control" rows=3></textarea>'+
				'</div>'+
				'<div class="col-md-2">'+
					'<button class="form-control py-4 my-1" onclick="rereplywrite('+rno+','+bno+')">대댓글 등록</button>'+
				'</div>'+
			'</div>'
		);	
}
function rereplywrite( rno , bno ){ // 대댓글 쓰기 메소드 
	let rrcontent = $("#rrcontent").val();
	$.ajax({
		url : "rereplywrite" , 
		data : { "rno" : rno , "bno" : bno  , "rrcontent" : rrcontent} ,
		success : function( result ){
			if( result == 1 ){
				 alert("대댓글 작성 되었습니다."); // 성공 메시지 알림 
				 $("#rrcontent").val(""); // 작성 input 공백으로 초기화 
				 $("#replytable").load( location.href+" #replytable"); // 특정 태그 새로고침
			}
			else{ alert("대댓글작성이 실패했습니다."); }
		}
	});
}

function replydelete( rno ){
	$.ajax({
		url : "rdelete" , 
		data : { "rno" : rno } , 
		success : function( result ){
			if( result == 1 ){
				alert("댓글 삭제 되었습니다.");
				$("#replytable").load( location.href+" #replytable"); // 특정 태그 새로고침
			}
			else{ alert("삭제 실패(관리자에게 문의)"); } 
		}
	});
}
function replyupdateshow() {
	$("#updatecontent").css("display", "block");
	$("#updatecontext").css("display", "block");
}
function rereplyupdateshow() {
	$("#reupdatecontext").css("display", "block");
	$("#reupdatecontent").css("display", "block");
}
function replyupdate(rno, bno) {
	
	let updatecontent = $("#updatecontent").val();
	$.ajax({
		url : "replyupdate" , 
		data : { "rno" : rno , "updatecontent" : updatecontent, "bno" : bno} , 
		success : function( result ){
			if( result == 1 ){
				alert("댓글 수정 되었습니다.");
				$("#replytable").load( location.href+" #replytable"); // 특정 태그 새로고침
			}
			else{ alert("수정 실패(관리자에게 문의)"); } 
		}
	});
	
}
function rereplyupdate(rno, bno) {
	let reupdatecontent = $("#reupdatecontent").val();
	alert(reupdatecontent);
	$.ajax({
		url : "rereplyupdate" , 
		data : { "rno" : rno , "reupdatecontent" : reupdatecontent, "bno" : bno} , 
		success : function( result ){
			if( result == 1 ){
				alert("댓글 수정 되었습니다.");
				$("#replytable").load( location.href+" #replytable"); // 특정 태그 새로고침
			}
			else{ alert("수정 실패(관리자에게 문의)"); } 
		}
	});
}