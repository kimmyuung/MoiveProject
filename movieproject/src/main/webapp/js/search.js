function search() {
	let id = "C42rs9pTGjajoo5tbUX7";
	let sid = "iOI4fqgIwj";
	$.ajax({
		method: "GET",
		url: "moviesearch",
		data: { query : "닥터 스트레인지" },
		success : function( result ){	
  		
			alert("x");
		}
		});
}


