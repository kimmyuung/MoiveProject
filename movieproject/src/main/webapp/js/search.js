
function moviesearch() {
	let query = $("#movie").val();
	
	
	$.ajax({
		method : 'get',
		url : 'https://openapi.naver.com/v1/search/movie.json?query=',
		data : {"query" : "닥터"},
		headers : {"X-Naver-Client-Id" : "C42rs9pTGjajoo5tbUX7", "X-Naver-Client-Secret" : "iOI4fqgIwj"},
		success : function(json) {
			let data = new JSON.parse(json);
			alert(data);
			console.log(data);
		}
	});
}

 
 function enterkey() {
	if (window.event.keyCode == 13) {
    	moviesearch();
    }
}