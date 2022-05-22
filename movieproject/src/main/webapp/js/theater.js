$("#seatselect").change(function() {
	var str_html = '';
	var seat = $("#seats").val();
	$("target_btn").css('display', 'block');
	var submit_html = '<input type="button" class="form-control" onclick="theateradd()" value="영화관등록">';
	var cancel = '<input type="reset" class"form-control" value="영화관등록 취소">';
	// 버튼을 10개 추가한다.
	for (var i = 0; i < seat; i++) {
		var html_btn = '<button type="button" class="btn btn-success m-1" id="btn{}" style="width:100px">[]</button>';
		html_btn = html_btn.replace('{}', i + 1);
		html_btn = html_btn.replace('[]', i + 1);
		str_html = str_html + html_btn;
	}



});

$('.cinema-seats .seat').on('click', function() {
  $(this).toggleClass('active');
  
});



    