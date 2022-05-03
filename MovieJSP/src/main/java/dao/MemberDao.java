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
	
	public boolean idcheck(String mid) {
		String sql = "select * from member where mid=" + mid;
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {return true;} // 동일 아이디 존재!
		} catch(Exception e) {System.out.println("아이디 찾기 실패 : " + e);}
		return false; // 동일 아이디 없음!
	}
	
}
