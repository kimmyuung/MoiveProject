
function moviesearch() {
	let query = $("#movie").val();
	
	
	$.ajax({
		method : 'get',
		url : 'moviesearch',
		data : {"query" : query},
		headers : {"X-Naver-Client-Id" : "C42rs9pTGjajoo5tbUX7", "X-Naver-Client-Secret" : "3CibZ9XUTn"},
		success : function(json) {
			console.log(json);
			let html = '<tr><th>영화 제목</th> 	<th>영화 포스터</th>'  +
						'<th>감독</th> 		<th>주연 배우</th>'  +
						'<th>개봉년도</div> 	<th>평점</th> <th>상세 보기</th> </tr>';
			for(let i = 0; i < json.items.length; i++) {
				html += '<tr><td>'+ json.items[i]["title"] +'</td>' +
						'<td><img src="'+json.items[i]["image"]+'">'+'</td>' +
						'<td>'+ json.items[i]["director"] +'</td>' +
						'<td>'+ json.items[i]["actor"] +'</td>' +
						'<td>'+ json.items[i]["pubDate"] +'</td>' +
						'<td>'+ json.items[i]["userRating"] +'</td>' +
						'<td><a href="'+json.items[i]["link"] +'">상세보기'+'</a></td></tr>';
			}
			$("#searchresult").html(html);
		}
	});
}

 
 function enterkey() {
	if (window.event.keyCode == 13) {
    	moviesearch();
    }
}