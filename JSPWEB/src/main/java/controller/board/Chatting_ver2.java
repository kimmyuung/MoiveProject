package controller.board;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONArray;
import org.json.JSONObject;

// @WebServlet : URL 매핑
//@WebServlet("클래스내로 들어오는 경로 정의")
//@ServerEndpoint("서버 소켓 클래스로 들어오는 경로 정의")
@ServerEndpoint("/chatting2/{mid}") // {변수명} : URL 변수 받을 수 있음
public class Chatting_ver2 {
	// 0. 접속자명단
	public static Map<Session, String> clients = new Hashtable<>(); // 동기화 [ 한명씩 처리 ]

	// 1. 소켓 오픈
	@OnOpen
	public void OnOpen(Session session, @PathParam("mid") String mid) {
		
		clients.put(session, mid); // 해당 세션을 접속 명단에 추가
		try {
		JSONArray array = new JSONArray();
		
		for (Session temp2 : clients.keySet()) {// 리스트에 존재하는 세션들에게 메시지 보내기
			// map객체.keyset() : 모든 키를 호출
			JSONObject object = new JSONObject();
			object.put("type", "2");
			object.put("mid", clients.get(temp2));
			//Map객체.keyset() : map 객체내 모든 키 호출
			//Map객체.get(키) : map 객체 내 해당 키에 해당하는 값 호출
			array.put(object); }
		
		for(Session s : clients.keySet()) { // 리스트에 존재하는 세션들에게 메시지 보내기
			s.getBasicRemote().sendText(array.toString());
		}
		
		}
		catch(Exception e) {e.printStackTrace();} 
	}

	// 2. 소켓 닫기
	@OnClose
	public void OnClose(Session session) {

		clients.remove(session); // 해당 세션을 접속 명단에서 제거
		
		try {
			JSONArray array = new JSONArray();
			
			for (Session temp2 : clients.keySet()) {// 리스트에 존재하는 세션들에게 메시지 보내기
				// map객체.keyset() : 모든 키를 호출
				JSONObject object = new JSONObject();
				object.put("mid", clients.get(temp2));
				//Map객체.keyset() : map 객체내 모든 키 호출
				//Map객체.get(키) : map 객체 내 해당 키에 해당하는 값 호출
				array.put(object); }
			
			for(Session s : clients.keySet()) { // 리스트에 존재하는 세션들에게 메시지 보내기
				s.getBasicRemote().sendText(array.toString());
			}
			
			}
			catch(Exception e) {e.printStackTrace();} 
	}

	// 3. 소켓 메시지 보내기 -> 모든 유저에게 보내기
	@OnMessage
	public void OnMessage(String msg, Session session) throws IOException {

		for (Session temp : clients.keySet()) {// 리스트에 존재하는 세션들에게 메시지 보내기
			// map객체.keyset() : 모든 키를 호출
			temp.getBasicRemote().sendText(msg);
		}
	}

}
