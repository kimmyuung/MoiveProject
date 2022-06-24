getmember();
let list = [];
function getmember() {
	$.ajax({
		url: 'getmember',
		success: function(json) {
			console.log(json);
			list = json;
		}
	});
}

let pay_method;	// 결제수단을 저장하는 변수 
// 결제수단 선택 메소드 
function paymethod(method) {
	$("#paymethod").html(method); // html에 인수 출력 
	pay_method = method; // 결제수단 변수에 인수 넣기
}

// 아임포트 실행 메소드 /* 아임포트 API = 결제API */
function payment() {
	let totalpay = $("#totalprice").val();
	if (pay_method == null) { // 만약에 결제수단을 선택를 안했으면
		alert('결제수단을 선택해주세요.!'); return;
	}

	var IMP = window.IMP;
	IMP.init("imp35631338"); // [본인]관리자 식별코드 [ 관리자 계정마다 다름] 
	IMP.request_pay({ // 결제 요청변수 
		pg: "html5_inicis",	// pg사 [ 아임포트 관리자페이지에서 선택한 pg사 ]
		pay_method: pay_method,	// 결제방식
		merchant_uid: "ORD20220623-0000001", // 주문번호[별도]
		name: "EZEN MOVIE", // 결제창에 나오는 결제이름
		amount: totalpay,	// 결제금액
		buyer_email: list["mid"],
		buyer_name: list["mname"],
		buyer_tel: list["mphone"]
	}, function(rsp) { // callback
		if (rsp.success) { // 결제 성공했을때 -> 주문 완료 페이지로 이동 []
		} else {
			let tno = $("#tno").val();
			let rno = $("#rno").val();
			let date = $("#date").val();
			let seats = $("#seats").val();

			$.ajax({
				url: 'saveticket',
				data: { "tno": tno, "rno": rno, "date": date, "seat": seats, "mid" : list["mid"] },
				success: function(re) {
					console.log(re);
					alert("영화 결제가 완료되었습니다.");
					location.href = '/movieproject/movie/movieticket.jsp?' +
						'rno=' + rno + '&date=' + date + '&tno=' + tno + '&seats=' + seats + '&totalprice=' +
						totalpay + '&mid=' + list["mid"];

				}
			});



		}
	});

}


