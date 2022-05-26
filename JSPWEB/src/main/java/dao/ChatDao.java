package dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import dto.Chat;

public class ChatDao extends Dao{

	public ChatDao() {
		super(); // 슈퍼클래스 호출 ( db연동 )
			// super.메소드()  super.필드명	   super() : 생성자
	}
	public static ChatDao ChatDao = new ChatDao();
	public static ChatDao getChatDao() { return ChatDao; }
	
	public ArrayList<Chat> Chatlist(){
		String sql = "SELECT * FROM chat  ORDER BY cdate asc";
		ArrayList<Chat> chList = new ArrayList<Chat>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				chList.add( new Chat(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)) );
			}
			return chList;
		} catch (Exception e) {
			System.out.println("[SQL 오류]" + e);
		}
		return null;
	}
	
	public boolean chat_result(String cname, String ccontent) {
		String sql = "insert into chat(cname, ccontent) values(?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cname);
			ps.setString(2, ccontent);
			ps.executeUpdate();
			return true;
			}catch(Exception e) {e.printStackTrace(); }
		return false;
	}
}
