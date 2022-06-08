package dao;

import java.util.ArrayList;

import dto.Board;

public class BoardDao extends Dao{

	public BoardDao() {
		super(); 
	}
	public static BoardDao boardDao = new BoardDao();
	public static BoardDao getBoardDao() { return boardDao; }
	
	// 글 쓰기 메소드
	public boolean write(Board board) {
		
		String sql = "insert  board( btitle , bcontext , bwriter , bpassword )"
				+ "values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getContext());
			ps.setString(3, board.getWriter());
			ps.setString(4, board.getPassword());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	public boolean passwordcheck(String bpassword, int bno) {
		String sql = "select bno from board where bpassword = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bpassword);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
			return false;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	// 게시글 목록 호출
	public ArrayList<Board> blist() {
		ArrayList<Board> boards = new ArrayList<>();
		String sql = "select * from board";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Board board = new Board(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6) );
				boards.add(board);
			}
			return boards;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	// 글 번호를 통한 객체 호출
	public Board getBoard(int bno) {
		String sql = "select * from board where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				Board board = new Board(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6) );
				return board;
			}
			return null;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	// 게시글 수정
	public boolean update(Board board) {
		String sql = "update board set btitle = ?, bcontext = ? where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBtitle());
			ps.setString(2, board.getContext());
			ps.setInt(3, board.getBno());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	// 게시글 삭제
	public boolean delete(int bno) {
		String sql = "delete from board where bno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
}
