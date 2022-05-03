// jquery : js 프레임워크
// $ : jquery
//$(function() {;}) : 문서 실행시 무조건 실행되는 함수
// js 식 : id 불러오기 .getElementById(id명)
// jquery 식 : $("#id명")
//.keyup() : 해당 id에 키보드가 눌렸을때 = [입력 되었을때]
var check1 = new Boolean(false);
var check2 = new Boolean(false);
var check3 = new Boolean(false);
var check4 = new Boolean(false);
var check5 = new Boolean(false);
var check6 = new Boolean(false);

$(function() { // 문서 열리는 해당 코드가 실행
	// 아이디 체크
	$("#mid").keyup(function() { // mid가 입력될때마다 해당 함수 실행
		

		let mid = $("#mid").val();
		let idj = /^[a-zA-Z0-9]{5,15}$/; // 한글을 제외한 영문+숫자 5~15 사이 문자열
		// 정규표현식 : 특정한 규칙을 가지는 문자열의 집합 언어
		// /^ : 정규표현식 시작
		// $/ : 정규표현식 끝
		// [a-z] : 소문자 찾음
		// [A-Z] : 대문자 찾음
		// [0-9] : 숫자 찾음
		// {최소길이, 최대길이} : 문자 최소길이~최대길이 까지만 입력
		// 정규표현식.test ( 변수 ) : 해당 변수가 정규표현식에 동일하면 true 아니면 false

		if (idj.test(mid)) {
			// 비동기식 통신 : 페이지 전환 없이 java 통신이 목적
			// $.ajax({ 속성 = 속성값, 속성 = 속성값 }) // jquery에서 제공해주는 메소드
			$.ajax({
				url : "../idcheck" , // 통신할 경로 (서블릿 파일)
				data : {"mid" : mid }, // 통신할 때 보내는 데이터 {"변수명" : 데이터}
				success : function(result) { // 통신 성공후 받는 데이터
					alert("java에서 받은 데이터 : " + result );
					if( result == 1 ){ // 만약에 받은 데이터가 1이면
						idcheck.innerHTML="사용중인 아이디 입니다.";
						check1 = false;
					}else{ // 만약에 받은 데이터가 1이 아니면
						idcheck.innerHTML="사용가능한 아이디 입니다.";
						check1 = true;
					}
				}
			}); // ajax end
		} else {
			idcheck.innerHTML = "영문, 숫자 포함 5-15길이로 입력해주세요";
		}
	}); // keyup end


	// 비밀번호 체크
	//let mpassword = document.getElementById("mpw").value; // js식
	$("#mpw").keyup(function() {


		let mpassword = $("#mpw").val(); // jquery 식
		let pwj = /^[a-zA-Z0-9]{5,15}$/;
		if (pwj.test(mpassword)) {
			$("#passwordcheck").html("사용가능한 비밀번호입니다.");
			
		}
		else {
			$("#passwordcheck").html("비밀번호는 영어와 숫자를 조합한 5-15자리의 글자입니다.");
			
		}
	}); $("#mpwcheck").keyup(function() {


		let mpassword = $("#mpw").val(); // jquery 식

		let mpasswordcheck = $("#mpwcheck").val();
		let pwj = /^[a-zA-Z0-9]{5,15}$/;
		if (pwj.test(mpassword)) {
			if (mpassword != mpasswordcheck) {
				// 비밀번호와 비밀번호체크와 다르다면
				// equals(x) // !=(O)
				$("#passwordcheck").html("패스워드가 틀립니다. 다시 입력해주세요");
				check2 = false;
			} else {
				$("#passwordcheck").html("패스워드가 일치합니다.");
				check2 = true;
			}
		}
	});
	//이름 체크
	$("#mname").keyup(function() {
		let mname = $("#mname").val(); // 해당 id의 데이터 가져오기
		let namej = /^[가-힣a-zA-Z]{2,10}$/; // 한글만 2~10 정규표현식
		if(namej.test(mname)) {
			$("#namecheck").html("사용 가능합니다.");
			check3 = true;
		}else
			$("#namecheck").html("2-10글자를 입력해야 합니다.");
			check3 = false;
	});
	// 전화번호 체크
	$("#mphone").keyup(function() {
		let mphone = $("#mphone").val(); // 해당 id의 데이터 가져오기
		let phonej = /^([0-9]{2,3})-([0-9]{4})-([0-9]{4})$/; // 010
		if(phonej.test(mphone)) {
			$("#phonecheck").html("등록 가능한 번호입니다.");
			check4 = true;
		}else
			$("#phonecheck").html("010-0000-0000 형식으로 입력해주세요");
			check4 = false;
	});
	$("#memail").keyup(function() {
		let memail = $("#memail").val(); // 해당 id의 데이터 가져오기
		let emailj = /^[a-zA-Z0-9]+@$/; // 010
		if(emailj.test(memail)) {
			$("#emailcheck").html("사용 가능합니다.");
			check5 = true;
		}else
			$("#emailcheck").html("이메일 주소 형식으로 입력해주세요(@ 포함)");
			check5 = false;
	});
	
}); // 문서 열리면 해당 코드가 종료
function signup() {
if(check1 == true && check2 == true && check3 == true && check4 == true && check5 == true && check6 == true) {
			let mid = $("#mid").val();
			let mpw = $("#mpw").val();
			let memail = $("#memail").val();
			let mphone = $("#mphone").val();
			let mname = $("#mname").val();
			let maddress = $("#sample4_roadAddress").val(); 
			let maddress1 = $("#sample4_detailAddress").val(); 
			let address = maddress + maddress1;
			$.ajax({
				url : "../signup" , // 통신할 경로 (서블릿 파일)
				data : {"mid" : mid, "mpw" : mpw ,"memail" : memail, "mphone" : mphone,
				"mname" : mname, "address" : address}, // 통신할 때 보내는 데이터 {"변수명" : 데이터}
				success : function(result) { // 통신 성공후 받는 데이터
					alert("java에서 받은 데이터 : " + result );
					if( result == 1 ){ // 만약에 받은 데이터가 1이면
						idcheck.innerHTML="사용중인 아이디 입니다.";
						check1 = false;
					}else{ // 만약에 받은 데이터가 1이 아니면
						idcheck.innerHTML="사용가능한 아이디 입니다.";
						check1 = true;
					}
				}
			}); // ajax end
} else{
	alert("회원가입에 실패하였습니다. 입력하지 않은 칸이 없는지 확인해주세요")
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
        }).open(); check6 = true;
    }