function runtimeadd() {
	let startdate = $("#startdate").val();
	let enddate = $("#enddate").val();
	let stime = $("#stime").val();
	let etime = $("#etime").val();
	
	alert(startdate + enddate);
	alert(stime + etime);
	
}

 $("#theaterbox").change(function() {
	
	let color = $("#color_select").val();
	// 제품번호와 칼라가 동일한 경우에 사이즈
	let pno = $("#pno").val();
	$.ajax({
		url : 'getstocksize' , 
		data : {'pno' : pno , 'color' : color},
		success : function(re){
			// JS map 객체 선언
		/*	let map = new Map(); // JS MAP 객체 선언
			map = re; // map 객체에 결과물 넣기*/
			
			let list =re.replace( "{","");
			let list2 =list.replace( "}","");
			let itemlist = list2.split(", ");
			
			let html ="";
				html +="<option value=''>-[필수]옵션 선택-</option>";
			for(let item of itemlist) {
				let color = item.split("=")[0];
				let amount = item.split("=")[1];
				html += 
					"<option value='"+color+"'>"+color+ " - "+ amount + "</option>";
			}
			
			$("#size_select").html(html);	// id.html( )  : 새로운 데이터 
			// $("#size_select").append('<option>asdasd</option>'); // id.append( ) : 데이터 추가
			
		}
	});
});