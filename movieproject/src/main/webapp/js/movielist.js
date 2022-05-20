function moviedelete(mtitle){
	
	
	if(confirm("정말 영화를 삭제하시겠습니까?")) {
	$.ajax({
		url : "mdelete",
		data : { "mtitle" : mtitle } , 
		success : function( re ){
			if(re == 1){
			alert("영화 삭제가 완료되었습니다.");
			   $("#movielist").load(window.location.href + " #movielist");
			}
			else {
				alert("영화 삭제가 실패하였습니다.");
				
			}
			}
	});
	}
	else {
		return;
	}
}