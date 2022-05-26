/* 특정 select에 DB 데이터 넣기 */
$( function getcategory(){ 
	$.ajax({
		url : "getcategory" , 
		data : { "type" : "option" } ,
		success : function( re ){
			$("#categorybox").html( re );
		}
	});
});
/* 카테고리목록 select 값이 변경 될때마다 .*/
$("#categorybox").change( function(){
	let cno = $("#categorybox").val();
	$.ajax({
		url : "getproduct" ,
		data : { "type" : "option" , "cno" : cno } ,
		success : function( re ){
			if( re == ""){
				alert("해당 카테고리의 제품이 없습니다.");
				$("#productbox").html(" ");
				document.getElementById('stockaddform').attr('display' ,'none');
			}else{ 
				$("#productbox").html( re );
				$("#stockaddform").css('display', 'block');
				getstock();
			}
		}
	});
});

/* 제품 재고 추가   */ 
function stockadd() {
	let pno = $("#productbox").val(); // 제품 번호
	let ssize = $("#ssize").val(); // 제품 번호
	let samount = $("#samount").val(); // 제품 번호
	let scolor = $("#scolor").val(); // 제품 번호
	
	$.ajax({
		url : "stockadd",
		data : {"pno" : pno, "scolor" : scolor, 
		"ssize" : ssize, "saomount" : samount },
		success : function(re) {
			if(re == 1) {
				alert("제고 등록 성공");
				$("#mainbox").load('productstock.jsp');
			}
			else {
				alert("재고 등록 실패");
			}
		}
	});
		
};

function getstock(){
	let pno = $("#productbox").val();
	$.ajax({
		url : 'getstock' ,
		data : { "pno" : pno } ,
		success : function( re ){
			$("#stocklistbox").html(re);
		}
	});
}

$("#productbox").change( function(){
	getstock();
});
