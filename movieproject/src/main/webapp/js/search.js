
function moviesearch() {
	let query = $("#movie").val();
	
	
	$.ajax({
		method : 'get',
		url : 'moviesearch',
		data : {"query" : "어벤져스"},
		headers : {"X-Naver-Client-Id" : "C42rs9pTGjajoo5tbUX7", "X-Naver-Client-Secret" : "3CibZ9XUTn"},
		success : function(json) {
			console.log(json);
		}
	});
}

 
 function enterkey() {
	if (window.event.keyCode == 13) {
    	moviesearch();
    }
}