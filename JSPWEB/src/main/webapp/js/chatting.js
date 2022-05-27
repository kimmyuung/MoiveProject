// 웹소켓 클래스 : new Websocket

// 1. websocket.onopen : 서버소켓 연결이 되었을 때 이벤트
// 2. websocket.onmessage : 클라이언트가 메시지를 받을 때 C -> S
// 3. websocket.send : 서버소켓 메시지 보내기 S -> C


// java : @ServerEndpoint("/서버소켓경로정의") : 서버 소켓
// @Onopen :
// @Onclose :
// @Onmessage :

$("#incontent").focus(); // 스크립트 실행시 입력창에 커서 이동
let socket = null;

start();
function enterkey() {
	if(window.event.keyCode == 13) {
		send();
	}
}

function sendbtn() {
		send();
}


// 채팅 소켓 실행
function start() {
	socket = new WebSocket("ws://localhost:8080/JSPWEB/chatting2");
	// js에서 사용하는 웹소켓 클래스 (ws://ip번호/port번호/프로젝트명/서버소켓이름)
	socket.onopen = function (e) {	onOpen(e); }
	socket.onmessage = function(e) {onmessage(e);}
}

function onOpen(e) {
	console.log(e);
}
function onmessage(e) {
	alert("메시지를 보냅니다" + e + "내용물" + e.data);
	console.log(e)
}

function send() {
	alert("메시지를 보냅니다.");
	let msg = $("#incontent").val();
	
	socket.send(msg);
	$("#incontent").val("");
	$("#incontent").focus();
}