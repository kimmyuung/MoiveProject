function search() {

	let query = $("#moviename").val();
	
	
	$.ajax({
		url: "moviesearch",
		type : 'get',
		data: { 'query' : query },
		success : function(  ){	
  		
			alert("x");
		}
		});
}


