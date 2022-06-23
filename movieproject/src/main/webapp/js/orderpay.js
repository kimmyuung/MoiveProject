



let pay_method;	// 결제수단을 저장하는 변수 
// 결제수단 선택 메소드 
function paymethod( method ){
	$("#paymethod").html( method ); // html에 인수 출력 
	pay_method = method; // 결제수단 변수에 인수 넣기
}

// 아임포트 실행 메소드 /* 아임포트 API = 결제API */
function payment(){
	let totalpay = $("#totalprice").val();
	if( pay_method == null ){ // 만약에 결제수단을 선택를 안했으면
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
	    buyer_email: member["mid"],
	    buyer_name: member["mname"],
	    buyer_tel: member["mphone"],
	    buyer_addr: member["maddress"],
	    buyer_postcode: member["maddress"].split("_")[0],	// 우편번호
		  }, function (rsp) { // callback
		      if (rsp.success) { // 결제 성공했을때 -> 주문 완료 페이지로 이동 []
		      } else {
				saveorder(); // 결제 실패 했을때 -> 테스트 할시에는 이부분 활용
		      }
	  });
}
// 6. 주문 처리 메소드 
function saveorder(){
	alert("DB처리시작");
	let ordername = $("#ordername").val();
	let orderphone = $("#orderphone").val();
	let orderaddress = $("#sample4_postcode").val() + "_" + $("#sample4_roadAddress").val() + "_" +  $("#sample4_jibunAddress").val() + "_" + $("#sample4_detailAddress").val();
	let ordertotalpay = totalpay;
	let orderrequest = $("#orderrequest").val();
	
	let orderjson = {
		ordername : ordername,
		orderphone :orderphone,
		orderaddress : orderaddress,
		ordertotalpay : ordertotalpay,
		orderrequest : orderrequest
	}
	$.ajax({
		url : "saveorder",
		data : {'orderjson' : JSON.stringify(orderjson)},
		success : function( re ){
			alert(re);
			if(re == "true"){
				var link = '/JSPWEB/product/ordersuccess.jsp';
				window.open(link);
			}
			else {
				alert("주문 실패");
			}
		}
	});
}

