function search() {
	let id = "C42rs9pTGjajoo5tbUX7";
	let sid = "iOI4fqgIwj";
	$.ajax({
		method: "GET",
		url: "https://openapi.naver.com/v1/search/movie.json",
		data: { query : "닥터 스트레인지" },
		headers: { "X-Naver-Client-Id": id, 
		"X-Naver-Client-Secret":sid}
			})
  		.done(function(msg) {
			alert("Data Saved: " + msg);
		});
}


