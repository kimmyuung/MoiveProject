
function moviesearch() {
	let mtitle = $("#movie").val();
	alert(mtitle);
	
	$.ajax({
		method : 'get',
		url : 'moviesearch',
		query : mtitle,
		display : 20,
		country : "KR",
	});
}
