package dao;

import java.util.ArrayList;

import dto.Reply;

public class ReplyDao extends Dao{
	
	public ReplyDao() {
		super();
	}
	public static ReplyDao replyDao = new ReplyDao();
	// dao 호출시 반복되는 new 연산자 
	public static ReplyDao getReplyDao() {return replyDao;}
	
	public boolean replywrite(Reply reply) { 
		String sql = "insert into reply(rcontent, rindex, bno, mno) values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setInt(2, reply.getRindex());
			ps.setInt(3, reply.getBno());
			ps.setInt(4, reply.getMno());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
		}
	// 8. 댓글 출력 메소드 		[ 인수 : 게시물 번호 ]
	public ArrayList<Reply> replylist(int bno) {
		ArrayList<Reply> replylist = new ArrayList<Reply>();
		String sql = "select * from reply where bno = "+bno+" and rindex = 0"; // rindex = 0  : 댓글만 출력 [ 대댓글 제외 ] 
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while( rs.next() ) { 
				Reply reply = new Reply( 
						rs.getInt(1) , rs.getString(2) , 
						rs.getString(3) , rs.getInt(4) , 
						rs.getInt(5), rs.getInt(6), null);
				replylist.add(reply);
			}
			return replylist;
		}catch (Exception e) { System.out.println( e ); } return null; 
		
	
	}
	
	// 9. 댓글 수정 메소드 		[ 인수 : 수정할 댓글 번호 ]
	public boolean replyupdate(Reply reply) { 
		String sql = "update reply set rcontent = ? where rno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getRcontent());
			ps.setInt(2, reply.getRno());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false; }
	
	// 10. 댓글 삭제 메소드 		[ 인수 : 삭제할 댓글 번호 ] 
	public boolean replydelete(int rno) { 
		String sql = "delete from reply where rno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, rno);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
		}
	
	// 대댓글 출력 메소드 [인수 : 게시물 번호, 댓글 식별번호)
	public ArrayList<Reply> rereply(int bno, int rno) {
		ArrayList<Reply> rereplylist = new ArrayList<Reply>();
		String sql = "select * from reply where bno = "+bno+" and rindex = "+rno;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply( 
						rs.getInt(1) , rs.getString(2) , 
						rs.getString(3) , rs.getInt(4) , 
						rs.getInt(5), rs.getInt(6), null);
				rereplylist.add(reply);
			}
			return rereplylist;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	// 대댓글 수정 메소드 [인수 : 댓글 객체)
		public boolean rereplyupdate(Reply reply) {
			String sql = "update reply set rcontent = ? where bno = ? and rno = ?";
			System.out.println(reply.toString());
			try {
				ps = con.prepareStatement(sql);
				
				ps.setString(1, reply.getRcontent());
				ps.setInt(2, reply.getBno());
				ps.setInt(3, reply.getRno());
				ps.executeUpdate();
				
				return true;
			}catch(Exception e) {e.printStackTrace();}
			return false;
		}
	// 댓글 카운트
	public int replycount(int bno) {
		String sql = "select count(*) from reply where bno=?";
		int count = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
		
			if(rs.next()) count = rs.getInt(1);
			
			return count;
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}
}
