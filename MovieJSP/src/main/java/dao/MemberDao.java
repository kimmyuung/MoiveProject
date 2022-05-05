package dao;

import dto.Member;

public class MemberDao extends Dao{
	
	public MemberDao() {
		super();
	}
	public static MemberDao memberDao = new MemberDao();
	// dao 호출시 반복되는 new 연산자 
	public static MemberDao getMemberDao() {return memberDao;}
	public boolean signup(Member member) { // 회원가입
		try {
		String sql = "insert into member(mid, mpw, mname, mphone, memail, maddress) values(?,?,?,?,?,?);";
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getMid());
		ps.setString(2, member.getMpw());
		ps.setString(3, member.getMname());
		ps.setString(4, member.getMphone());
		ps.setString(5, member.getMemail());
		ps.setString(6, member.getMaddress());
		ps.executeUpdate();
		return true;
		}catch(Exception e) {System.out.println("등록 실패!" + e);}
		return false;
	}
	
	public boolean idcheck(String mid) { // id 체크
		String sql = "select * from member where mid=?";
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {return true;} // 동일 아이디 존재!
		} catch(Exception e) {System.out.println("아이디 찾기 실패 : " + e);}
		return false; // 동일 아이디 없음!
	}
	
	public boolean login(String mid, String mpw) {
		try {
			String sql = "select * from member where mid =? and mpw = ?";
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs = ps.executeQuery();
			if(rs.next()) {return true;}
		}catch(Exception e) {System.out.println("로그인 실패 : " + e);}
		return false;
	}
	
	public boolean emailcheck(String memail) { // id 체크
		String sql = "select * from member where memail=?";
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			rs = ps.executeQuery();
			if(rs.next()) {return true;} // 동일 아이디 존재!
		} catch(Exception e) {System.out.println("이메일 중복 체크 실패 : " + e);}
		return false; // 동일 아이디 없음!
	}
	// 아이디 찾기
	public boolean findid(String mname, String mphone) {
		String sql = "select mid from member where mname = ? and mphone = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, mphone);
			rs = ps.executeQuery();
			if(rs.next()) return true;
		}catch(Exception e) {System.out.println("아이디 찾기 오류" + e);}
		return false; 
	}
	// 비밀번호 찾기
	public boolean findpw(String mid, String mname, String email) {
		String sql = "select mpw from member where mname = ? and memail = ? and mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, email);
			ps.setString(3, mid);
			rs = ps.executeQuery();
			if(rs.next()) return true;
		}catch(Exception e) {System.out.println("비밀번호 찾기 오류" + e);}
		return false;
	}
	// 회원 삭제 메소드
		public boolean delete(String mid) {
			String sql = "delete from member where mid = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, mid);
				ps.executeUpdate();
				return true;
			} catch(Exception e) {
				System.out.println("회원정보 삭제 실패 " + e);
			}
			
			return false;
		}
		// 회원 수정 메소드
		public boolean update(Member member) {
			
					try {
						String sql = "update member set mname = ? , memail = ?,"
								+ "maddress = ?, mphone = ? where mno = ?";
						ps = con.prepareStatement(sql);
						ps.setString(1, member.getMname());
						ps.setString(2, member.getMemail());
						ps.setString(3, member.getMaddress());
						ps.setString(4, member.getMphone());
						ps.setInt(5, member.getMnum());
						ps.executeUpdate();
						return true;
					}catch(Exception e) {
						System.out.println("회원 정보 수정 오류" + e);
					}
			return false;
		}
	
	// 회원정보 목록
	public Member mlist() {
		return null;
	}
	// 회원정보 출력 [ 인수 : 세션에 저장된 회원의 id ] 
		public Member getmember(String mid) {
			String sql = "select * from member where mid = ?";
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, mid);
				rs = ps.executeQuery();
				if(rs.next()) {
					Member member = new Member(rs.getInt(1), rs.getString(2), null, rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)  ); 
							
					return member;
				}
				
			} catch(Exception e) {System.out.println("회원정보 찾기 실패 : " + e);}
			return null;
		}
}
