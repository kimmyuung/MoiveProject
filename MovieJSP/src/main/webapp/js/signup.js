// jquery : js 프레임워크
// $ : jquery
//$(function() {;}) : 문서 실행시 무조건 실행되는 함수
// js 식 : id 불러오기 .getElementById(id명)
// jquery 식 : $("#id명")
//.keyup() : 해당 id에 키보드가 눌렸을때 = [입력 되었을때]

let pass = [ false , false , false , false , false , false]; // 배열 = [  ]

$("#btnOK").click(function(){  
       
    var url="test.aspx";  
    var params="name="+name+"&age="+age+"&nickName=손흥민";
   
    $.ajax({      
        type:"POST",  
        url:url,      
        data:params,      
        success:function(args){   
            $("#result").html(args);      
        },   
        beforeSend:showRequest,  
        error:function(e){  
            alert(e.responseText);  
        }  
    });  
       
}); 
	function idcheck() {
		
		// 1. HTML 태그내 값 가져오기 
		let mid=document.getElementById("mid").value;
		// 2. HTML 태그id 가져오기
		let idcheck = document.getElementById("idcheck");
		
		let idj =/^[a-zA-Z0-9]{5,20}$/;
		if(idj.test(mid)) {
			$.ajax({
				url : "../idcheck" , // 보내는 위치 [ 서블릿 경로 ]
				data : { "mid" : mid } , // 보내는 데이터  { "변수명" : 값 }
				success : function( result ){ // 통신 성공 했을경우 (  result = 받은 값 변수 )
					if( result == 1 ){ // 만약에 받은 데이터가 1이면
						idcheck.innerHTML="사용중인 아이디 입니다."; pass[0] = false;
					}else{ // 만약에 받은 데이터가 1이 아니면
						idcheck.innerHTML="사용가능한 아이디 입니다.";  pass[0] = true;
					}
				}
			});
		}
		else {
			alert("test");
			alert("영문, 숫자 포함 5~15길이로 입력해주세요");
			$("#idcheck").html("영문, 숫자 포함 5~15길이로 입력해주세요");
			pass[0] = false;
		}
	}
	function passwordcheck() {
		let mpw = $("#mpw").val();  // jquery 식
		let rempw = $("#rempw").val();
		let passswordj = /^[a-zA-Z0-9]{5,15}$/; // 정규표현식
		if( passswordj.test( mpw ) ){ // 정규표현식 같으면
			if( mpw != rempw ){ // 비밀번호 와 비밀번호체크 와 다르면
				// equals(x)  //  != ( o )
			$("#pwcheck").html("패스워드가 서로 다릅니다.");		pass[1] = false;
			}else{
				$("#pwcheck").html("사용 가능한 비밀번호 입니다."); pass[1] = true; pass[2] = true;
			}
		}else{ // 정규현식 다르면
			$("#pwcheck").html("영문, 숫자 5~15 사이로 입력해주세요!"); pass[1] = false;
		}
	}
	// 전화번호 체크 
	$("#mphone").keyup( function(){ 
		let mphone = $("#mphone").val();
		let phonej = /^([0-9]{2,3})-([0-9]{3,4})-([0-9]{3,4})$/;
		if( phonej.test(mphone) ){
			$("#phonecheck").html( "사용가능한 번호 입니다." );		pass[3] = true;
		}else{
			$("#phonecheck").html( "지역번호-0000-0000 형식으로 입력해주세요." ); pass[3] = false;
		}
	}); // keyup end 
	
	function emailcheck() {
		let memail = $("#memail").val();
		let memailaddress = $("#memailaddress").val();
		
		if( memailaddress == "" ){ 
			$("#emailcheck").html("이메일 주소 입력해주세요~");  
		}else{
			let emailj = /^[a-zA-Z0-9]{3,20}$/;
			if( emailj.test(memail) ){
				// 이메일 중복체크 
				let email = memail+"@"+memailaddress;
				$.ajax({
					url : "../emailcheck",
					data : { "email" : email } , 
					success : function( result ){
						if( result == 1 ){
							$("#emailcheck").html("사용중인 이메일 입니다."); pass[5] = false;
						}else{
							$("#emailcheck").html("사용가능한 이메일 입니다."); pass[5] = true; pass[4] = true;
						}
					}
				}); // ajax end 
				
			}else{
				$("#emailcheck").html("이메일 형식이 아닙니다.");  pass[4] = false;
			}
	}
	}
	$( function(){ // 문서가 켜지만 실행되는 함수
			$("#addressbox").change( function(){ // 목록상자내 값이 변경 되었을때 이벤트
		
		let addressbox = $("#addressbox").val();
		if( addressbox == "" ){
			$("#memailaddress").val("");
			$("#memailaddress").attr("readonly" , false); // 읽기모드 취소
			
		}else{
			$("#memailaddress").val(addressbox);	// val() -> value 값
			$("#memailaddress").attr("readonly" , true); // attr -> attribute 속성
		}
	});
	}); // 문서 열리면 해당 코드가 종료 
	
	function signup() {
		let check = true;
	if(pass[0] == false) {
		$("#signupcheck").html("아이디 중복체크를 하셔야 가입이 가능합니다.");
		check = false; return;
	}
	else if(pass[1] == false || pass[2] == false) {
		$("#signupcheck").html("비밀번호 일치체크를 해야 가입이 가능합니다."); 
		check = false; return;
	}
	else if(pass[3] == false) {
		$("#signupcheck").html("전화번호 형식이 잘못되었습니다.");
		check = false; return;
	}
	else if(pass[4] == false) {
		$("#signupcheck").html("이메일 형식이 잘못되었습니다.");
		check = false; return;
	}
	else if(pass[5] == false) {
		$("#signupcheck").html("사용중인 이메일입니다 이메일을 다시 입력해주세요.");
		check = false; return;
	}
	else {
	// js에서 form 전송하는 방법**
		if( check ) document.getElementById("signupform").submit();
		else{ alert("필수입력 사항이 입력되지 않습니다."); }
	}
	}
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("sample4_extraAddress").value = '';
                }

                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open(); 
    }