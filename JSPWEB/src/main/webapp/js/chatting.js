// 웹소켓 클래스 : new Websocket

// 1. websocket.onopen : 서버소켓 연결이 되었을 때 이벤트
// 2. websocket.onmessage : 클라이언트가 메시지를 받을 때 C -> S
// 3. websocket.send : 서버소켓 메시지 보내기 S -> C


// java : @ServerEndpoint("/서버소켓경로정의") : 서버 소켓
// @Onopen : 클라이언트 -> 서버소켓으로 들어왔을 때
// @Onclose : 
// @Onmessage :

$("#incontent").focus(); // 스크립트 실행시 입력창에 커서 이동
let socket = null;

start();

function enterkey(mid) {

	if (window.event.keyCode == 13) {
		if (mid == 'null') {
			alert("로그인 후 채팅이 가능합니다.");
			return;
		}

		send(mid);
	}
}

function sendbtn(mid) {
	if (mid == 'null') {
		alert("로그인 후 채팅이 가능합니다.");
		return;
	}
	send(mid);
}


// 채팅 소켓 실행
function start() {
	let mid = $("#mid").val();
	if(mid == "null") {
	alert("로그인 후에 채팅방 이용이 가능합니다.");
	return;
	}
	socket = new WebSocket("ws://localhost:8080/JSPWEB/chatting2/"+mid);
	// js에서 사용하는 웹소켓 클래스 (ws://ip번호/port번호/프로젝트명/서버소켓이름)
	socket.onopen = function(e) { onOpen(e); }
	socket.onmessage = function(e) { onmessage(e); }
	socket.onclose = function(e) { onclose(e); }
	socket.onerror = function(e) { onerror(e); }
	
}
function onclose(e) {
	alert("채팅방을 나갑니다. " + e)
console.log(e);
}
function onerror(e) {
	alert("서버 소켓 오류 입니다. " + e);
	console.log(e);
}

function onOpen(e) {
console.log(e);
}
function onmessage(e) {

let msg = JSON.parse(e.data);



if(msg["type"] != "1") {
	
	let html = "";
	for(let i = 0; i < msg.length; i++) {
		html += 
			'<div class="row p-2"> '+ // <!-- 접속자 정보 표시 구역 -->
					'<div class="col-sm-4"> '+ // <!-- 프로필 이미지 표시 구역 -->
						'<img alt="" src="../img/프로필1.jpg" class="rounded-circle" width="100%" >'+
					'</div>'+
					'<div class="col-sm-8">'+ // <!-- 접속자 이름, 기능 -->
						'<div class="username"> '+msg[i]["mid"]+' </div>'+
						'<div class="btnbox">'+
							'<span > 귓말 </span>'+
							'<span > 친추 </span>'+
						'</div>'+
					'</div>'+
				'</div>';
	}
	$("#enterlist").html(html);

}
else { // 사용자 목록
		
	let from = msg["from"];
	let content = msg["msg"];
	let img = msg["img"];
	let date = msg["date"];

	let html = $("#contentbox").html(); // 기존 html 가져오기
	if (from == $("#mid").val()) { // 현재 로그인된 아이디와 보낸사람이 같으면
		// 내가 보냈을때 
		html +=
			'<div class="send my-3">' +
			'<span class="date"> ' + date + ' </span>' +
			'<span class="content"> ' + content + ' </span>' +
			'</div>';
	} else {
		// 다른 사람이 보냈을때 
		html +=	// 기존 html 추가 
			'<div class="row g-0 my-3"> ' +
			'<div class="col-sm-1 mx-2">' +
			'<img alt="" src="../img/' + img + ';" class="rounded-circle" width="100%" >' +
			'</div>' +
			'<div class="col-sm-9">' +
			'	<div class="receive">	 ' +
			'<div class="mname"> ' + from + ' </div>' +
			'<span class="content"> ' + content + ' </span>' +
			'<span class="date"> ' + date + ' </span>' +
			'</div>' +
			'</div>' +
			'</div>';
	}

	$("#contentbox").html(html); // 추가된 html 넣어주기
	$("#contentbox").scrollTop($("#contentbox")[0].scrollHeight);
	
}
}

function send(mid) {
	let msg = $("#incontent").val();

	// json 형식으로 통신 [ DB X, only use JS + JAVA]
	let content = {
		type : "1", // 문자전송, 접속자명단 구분용
		from: mid, // 보내는 사람명 
		msg: msg, // 채팅 내용
		img: "profile.jpg", // 프로필
		date: new Date().toLocaleTimeString() // 채팅 보낸 날짜
	}
	// json 통신할때 json 모양의 문자열 변환
	// JSON -> 문자열 : JSON.stringify
	// 문자열 -> JSON : JSON.parse()

	socket.send(JSON.stringify(content));
	$("#incontent").val("");
	$("#incontent").focus();
}