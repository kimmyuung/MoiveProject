package controller.board;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;



// @WebServlet : URL 매핑
//@WebServlet("클래스내로 들어오는 경로 정의")
//@ServerEndpoint("서버 소켓 클래스로 들어오는 경로 정의")
@ServerEndpoint("/chatting2")
public class Chatting_ver2 {
	//0. 접속자명단
	public static List<Session> clients = new Vector<>(); // 동기화 [ 한명씩 처리 ]
	
	// 1. 소켓 오픈
	@OnOpen
	public void OnOpen(Session session) {
		clients.add(session); // 해당 세션을 접속 명단에 추가
		
	}
	// 2. 소켓 닫기
	@OnClose
	public void OnClose(Session session) {
		clients.remove(session);
	}
	
	// 3. 소켓 메시지 보내기 -> 모든 유저에게 보내기
	@OnMessage
	public void OnMessage(String msg, Session session) throws IOException{
		System.out.println(session + "가 " + msg + "를 전송하였습니다.");
		
		for(Session temp : clients) {// 리스트에 존재하는 세션들에게 메시지 보내기
			temp.getBasicRemote().sendText(msg);
		}
	}
}
