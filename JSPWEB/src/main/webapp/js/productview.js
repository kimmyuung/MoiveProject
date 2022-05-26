// js 메모리는 스크립트파일 재호출시[F5] 메모리 초기화
	
	// js 자료형  -> x 
		// let=변수 const=상수 
	// js 배열 
		// let 배열명 = [  ]
		// 추가 : push() 	-> 배열내 마지막인덱스에 뒤에 추가 
		// 제거 : pop() : 	-> 배열내 마지막인덱스에 삭제 
		// 특정인덱스 삭제 : splice( 시작인덱스 , 개수 ) -> 특정 시작인덱스부터 개수만큼 삭제 
			// 배열내 중간인덱스 삭제시 빈공간 인덱스 당기기  -> java 리스트 클래스 동일 
				// 예) 3번 인덱스 삭제시 : 4번 인덱스-> 3번인덱스 당겨짐 
	// js 객체 선언 -> object = {   }
		// let 객체명 = {  필드명1 : 값  , 필드명2 : 값 , 필드명3 : 값  }
		// 호출 [ .연산자 ] 
			// 객체명.필드명 
 $("#color_select").change(function() {
	
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

let select = [ ]; // js 배열
// 사이즈 목록이 변경되었을 때
$("#size_select").change(function() {
	
	let pname = $("#pname").html();
	let color = $("#color_select").val();
	if(color == "") {alert("색상을 선택해주세요"); return;}
	let size = $("#size_select").val();
	if(size == "") {alert("사이즈를 선택해주세요"); return;}
	let amount = $("#amount").val();
	if($("#amount").val() == null) amount = 1;
	let pprice = $("#price").val();
	let check = color + size; // 옵션 : 식별용
	let 객체 = {
		pname : pname , 	// 필드명(속성명) : 데이터 
		color : color ,  
		size : size , 
		amount : amount , 
		pprice : pprice ,
		totalprice :  pprice * amount  ,
		point :  ( pprice * amount ) * 0.01 ,
		check : check 
	}
	for(let i = 0; i < select.length; i++) {
		if(select[i].check == check) {
		// 배열내 i번재 객체의 필드[중복 체크] 호출
			// js 문자열 비교 == 가능 
			alert("이미 선택한 옵션입니다."); return;
		}
	}
	select.push(객체);
	
	selectoption();
	
});

function selectoption () {
	html2 = '<tr><td width="60%">상품명</td><td width="15%">상품수</td><td width="25%">가격</td></tr>';
	for(let i = 0; i < select.length; i++) {
		// 총금액 및 포인트 금액 최신화
		select[i].totalprice =  select[i].pprice *  select[i].amount ;
		select[i].point =  select[i].totalprice * 0.01 ;
		html2 += 
		'<tr>' +
			'<td>'+select[i].pname+'('+select[i].color+')/'+select[i].size+'</td>'+
			'<td>' +
			'<div class="row g-0">' +
			'<div class="col-md-7">' +	
			'<input id="amount'+i+'" type="text" value="'+select[i].amount+'" class="amount_input">' +
			// 수량입력상자 : readonly : 수정 불가
			'<button readonly class="amount_btn" onclick="aplus('+i+')">▲</button>' +		
			'<button readonly class="amount_btn" onclick="aminus('+i+')">▼</button>'	+	
			'</div>' +	
			'<div class="col-md-1">' +		
			'<button class="cancel_btn" type="button" onclick="pdelete('+i+')" >x</button>' +		
			'</div></div> </td>' +		
			'<td style="font-size: 10px;">' + 
			select[i].totalprice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+'원' + 
			'<br>'+ 
			select[i].point.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')+'원' +
			'(적)</td></tr>'
		};
	$("#select_table").html( html2 );
	let total_price = 0;
	let total_amount = 0;
	
	for(let i = 0; i < select.length; i++) {
	total_price += select[i].totalprice;
	total_amount += select[i].amount;
	}
	$("#total_price").html(  total_price.toLocaleString()+'원 ('+ total_amount +'개)' );
}

function pdelete(i) {
	select.splice(i, 1); // i번째 인덱스부터 1개의 인덱스 삭제
	selectoption();
}


function aplus(i) {
	let pno = $("#pno").val();
	
	$.ajax({
		url : "getamount",
		data : {'pno' : pno, 'color' : select[i].color, 
		'size' : select[i].size},
		success : function(re){
			if(select[i].amount >= re) {
				alert("재고가 부족합니다."); return;			
				}
			
				select[i].amount++;	
				selectoption();
			
		}
	});
	
	
	
}

function aminus(i) {
	if(select[i].amount == 1) { 
		alert("최소 수량은 1개 입니다.");
		return;
	}
	
	select[i].amount--;
	selectoption();
}

/* 천단위 구분 쉼표 -> 정규표현식(언어)  
			vs js( 내장메소드 : toLocaleString() )
					데이터.toLocaleString( undefinde , { maximumFractionDigits : 소수점 표시단위 } ) 
	*/
		/*
			\d{3} : 정수 3자리 패턴 
			(\d{3})+ : 앞 표현식 반복 대응 
			(\d{3})+(?!\d) : 표현식 뒤에 정수가 없는경우 [ 정수 끝 찾기 ]
			\B( ?= (\d{3})+(?!\d) ) : 문자가 없으면 뒤에 표현식 실행
		
			/^ : 정규표현식 시작 
			패턴 : ( 앞 = 문자 존재 ) , ( 뒤 = 문자열 3글자 )
					(\d {3}) = 정수3자리 
			\d : 정수    [0-9]{3}   <--->  (\d{3} )
			{ } : 길이
			+ : 앞 표현식 반복되는 부분 대응 
			x(?!y) : x 뒤에 y가 없는경우(false)  : (?!\d) : 앞에 패턴이 없는 경우 ( 뒤에 숫자가없는경우 )
			x(?=y) : x 뒤에 y가 있는경우(true)  : ( ?= (\d{3})+(?!\d) )
			\B : 문자 경계선  ( 문자제외 )   :  \B( ?= (\d{3})+(?!\d) )
			
			/g : 전역검색 [ 모든 곳 검색 ]
			/i : 대소문자 구분없는 검색 
		*/

			// 데이터.toString().replace( '정규표현식' , ',' );


// js (내장메소드 : toLocalString() )
// (/\B(?=(\d{3})+(?!\d))/g, ',') 정규표현식
// 데이터.toLocalString(undefinde, {maximumFractionDigits : 소수점 표시 단위})  

let comn = "/\B(?= (\d{3})+ (?!\d) )/g"; // 천단위 구분쉼표 정규표현식 변수
	// 데이터.toString().replace('정규표현식', ',');


// 관심제품 추가
function saveplike(mid) {
	if(mid == null) {alert('로그인후 등록이 가능합니다.'); return;}
	let pno = $("#pno").val();
	
	$.ajax({
		url : "saveplike",
		data : {"pno" : pno, "mid" : mid},
		success : function(re) {
			if(re==1) {alert("관심 취소했습니다.");
				
			}
			else if(re==2) {
				alert("관심 등록했습니다.");
			}
			else if(re == 3) {
				alert("관심 상품 관련 오류 발생]] 관리자에게 문의")
			}
			else {
				alert("관리자에게 문의")
			}
			$("#btnbox").load(location.href+ " #btnbox");
		}
	});	
}

function shopadd(mid) {
	if(mid == null) {
		alert('로그인 후 장바구니 등록이 가능합니다.'); 
		return;}
	if(select.length==0) {
		alert("최소 하나의 옵션을 선택해주세요");
		return;
	}	
	// 서블릿에게 배열 보내기
	// ajax <---------- json -------> 서블릿
	// js : json 라이브러리 내장 // java : json 라이브러리 다운
	
	$.ajax({
		url : "shopadd",
		data : {'json' : JSON.stringify(select), 'pno' : $("#pno").val()},
		//data : {"pno" : pno, "mid" : mid},
		// JSON.stringify() : 배열이나 객체를 JSON 형태로 보냄
		// key : value, name
		
		success : function(re) {
			if(re == -1) { alert("장바구니에 등록했습니다.");}
			else {alert("관리자에게 문의" +(re+1) +" 옵션");}
			
			$("#btnbox").load(location.href+ " #btnbox");
		}
	});	
	
}
