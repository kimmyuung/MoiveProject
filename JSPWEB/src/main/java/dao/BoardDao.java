package dao;

import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import dto.Board;
import dto.Reply;

public class BoardDao extends Dao {
	
	public BoardDao() {
		super(); // 슈퍼클래스 호출 ( db연동 )
			// super.메소드()  super.필드명	   super() : 생성자
	}
	public static BoardDao boardDao = new BoardDao();
	public static BoardDao getBoardDao() { return boardDao; }
	
	// 1. 게시물 쓰기 메소드 	[ 인수 : 작성된 데이터들 = dto  ]
	public boolean write( Board board ) { 
	
		String sql = "insert into board( btitle , bcontent , mno , bfile, mid )values(?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , board.getBtitle() );	ps.setString( 2 , board.getBcontent() );
			ps.setInt( 3 , board.getMno() );		ps.setString( 4 , board.getBfile() );
			ps.setString(5, board.getMid());
			ps.executeUpdate(); return true;
		}catch (Exception e) { System.out.println( e ); }	return false; 
	}
	
	// 2-2 게시물 전체/검색 개수 출력 메소드 
		public int gettotalrow( String key , String keyword  ) {
			
			String sql = null;
			if( key.equals("") && keyword.equals("") ) { sql ="select count(*) from board";} //검색이 없을경우 
			else { sql ="select count(*) from board where "+key+" like '%"+keyword+"%'";} // 검색이 있을경우
			
			try { ps = con.prepareStatement(sql); rs = ps.executeQuery(); 
				if( rs.next() ) return rs.getInt(1); 
			}
			catch( Exception e ) { System.out.println( e );} return 0;
		}
		
		// 2. 모든 게시물 출력 메소드 [ 인수 : x  // 추후기능 = 검색 : 조건 ]
		public ArrayList<Board> getboardlist(int startrow , int listsize , String key , String keyword ) { 
			ArrayList<Board> boardlist = new ArrayList<Board>();
			String sql =  null;
			if(key.equals("mid")) {key = "mno"; keyword = MemberDao.getmemberDao().getmno(keyword)+"";}
			if( key.equals("") && keyword.equals("") ) { //검색이 없을경우 
				sql = "select * from board order by bno desc limit "+startrow+","+listsize; /* limit 시작 인덱스 , 표시 개수 */
			}else {
				sql ="select * from board where "+key+" like '%"+keyword+"%' order by bno desc limit "+startrow+","+listsize;
			}
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					Board board = new Board( 
							rs.getInt(1),rs.getString(2), 
							rs.getString(3),rs.getInt(4),
							rs.getString(5), rs.getInt(6),
							rs.getString(7), null );
					boardlist.add(board);
				}
				return boardlist;
			}catch (Exception e) { System.out.println( e );} return null; 
			
		}
		//모든게시물출력
		public ArrayList<Board> getboardlist() { 
			ArrayList<Board> boardlist = new ArrayList<Board>();
			// 내림차순 
			String sql = "select * from board order by bno desc";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while( rs.next() ) {
					Board board = new Board( 
							rs.getInt(1),rs.getString(2), 
							rs.getString(3),rs.getInt(4),
							rs.getString(5), rs.getInt(6),
							rs.getString(7), rs.getString(8) );
					boardlist.add(board);
				}
				return boardlist;
			}catch (Exception e) { System.out.println( e );} return null; 
			
		}
	// 3. 개별 게시물 출력 메소드 [ 인수 : 게시물번호 ]
	public Board getboard(int bno) { 
		String sql = "select * from board where bno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				Board board = new Board ( 	rs.getInt(1), rs.getString(2), 
						rs.getString(3),	rs.getInt(4),
						rs.getString(5), 	rs.getInt(6),
						rs.getString(7), 	null );
				return board;
			}
		}catch(Exception e) {System.out.println("개별 게시물 출력 실패" + e);}
		
		return null; }
	// 4. 게시물 수정 메소드 	[ 인수 : 수정할 게시물번호  / 수정된 내용 ]
	public boolean update( Board board ) { 
		try {
		String sql ="update board set btitle=? ,  bcontent=? , bfile=? where bno = ?";
					ps = con.prepareStatement(sql);
					ps.setString( 1 , board.getBtitle() );
					ps.setString( 2 , board.getBcontent() );
					ps.setString( 3 , board.getBfile() );
					ps.setInt(4, board.getBno());
				ps.executeUpdate(); return true;
				}catch (Exception e) {} return false;
	}
	// 5. 게시물 삭제 메소드 	[ 인수 : 삭제할 게시물번호 
	public boolean delete( int bno ) { 
		String sql = "delete from board where bno="+bno;
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println(e);}
		
		return false; 
		}
	// 6. 게시물 조회 증가 메소드 	[ 인수 : 증가할 게시물번호 ]
	public boolean increview( int bno ) { 
		String sql = "update board set bview = bview+1 where bno =?";
		try {ps = con.prepareStatement(sql); ps.setInt(1, bno);
		ps.executeUpdate();
		return true;
		}catch(Exception e){System.out.println("게시물 조회 증가 실패" + e);}
		return false;
		}
	// 7. 댓글 작성 메소드 		[ 인수 : 작성된 데이터들 = dto ]
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
	// 11. 게시물 번호 출력 메소드
	public boolean getbnum() {
		return false;
	}
	public boolean filedelete(int bno) {
		String sql = "update board set bfile = null where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("파일 지우기 오류 " + e);}
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
