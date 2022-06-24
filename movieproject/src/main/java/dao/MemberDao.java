package dao;

import java.util.ArrayList;

import org.json.JSONObject;

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
		String sql = "insert into member(mid, mpassword, mname, mphone, memail, maddress) values(?,?,?,?,?,?);";
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getMid());
		ps.setString(2, member.getMpassword());
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
	
	public int login(String mid, String mpw) {
		try {
			String sql = "select * from member where mid =? and mpassword = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs = ps.executeQuery();
			if(rs.next()) {return 1;}
		}catch(Exception e) {System.out.println("로그인 실패 : " + e);  return 3;}
		return 2;
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
	public String findid(String mname, String mphone) {
		String sql = "select mid from member where mname = ? and mphone = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mname);
			ps.setString(2, mphone);
			rs = ps.executeQuery();
			if(rs.next()) {
				String mid = rs.getString(1);
				return mid;}
		}catch(Exception e) {e.printStackTrace();}
		return null; 
	}
	// 비밀번호 찾기
	public String findpw(String mid, String mname, String email) {
		String sql = "select mpassword from member where mid = ? and mname = ? and memail = ?";
		String mpw = "";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mname);
			ps.setString(3, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				mpw = rs.getString(1);
			}
			return mpw;
		}catch(Exception e) {System.out.println("비밀번호 찾기 오류" + e);}
		return null;
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
		
	
	// 회원정보 목록
	public ArrayList<Member> mlist() {
		String sql = "select * from member";
		ArrayList<Member> mlist = new ArrayList<Member>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Member member = new Member(rs.getInt(1), rs.getString(2), null, rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)  ); 
				mlist.add(member);
			}
			return mlist;
		}catch(Exception e) {e.printStackTrace();}
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
		// 비밀번호 체크
		public boolean passwordcheck(String mid, String mpw) {
			String sql = "select * from member where mid = ? and mpassword = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, mid);
				ps.setString(2, mpw);
				rs = ps.executeQuery();
				if(rs.next()) {
					return true;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		public boolean update( Member member ) {
			try {
			if( member.getMpassword() == null ) { // 패스워드 변경이 없을때 
				String sql ="update member set mname=? ,  mphone=? , memail=?,"
						+ "maddress = ? where mno=?";
					ps = con.prepareStatement(sql);
					ps.setString( 1 , member.getMname() );
					ps.setString( 2 , member.getMphone() );
					ps.setString( 3 , member.getMemail() );
					ps.setString( 4 , member.getMaddress() );
					ps.setInt( 5, member.getMno() );
			}else {	// 패스워드가 변경이 있을때 
				String sql ="update member set mname=? , mpassword = ? ,  mphone=? , memail=?,"
						+ "maddress = ? where mno=?";
					ps = con.prepareStatement(sql);
					ps.setString( 1 , member.getMname() );
					ps.setString( 2 , member.getMpassword() );
					ps.setString( 3 , member.getMphone() );
					ps.setString( 4 , member.getMemail() );
					ps.setString( 5 , member.getMaddress() );
					ps.setInt( 6 , member.getMno() );
			}
				ps.executeUpdate(); return true;
			}catch (Exception e) {} return false;
		}
		// 회원번호 출력 
		public int getmno(String mid) {
			String sql = "select mno from member where mid =?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, mid);
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
			}catch(Exception e) {System.out.println("회원번호 출력 오류" + e);}
			return 0;
		}
		// 회원ID 출력
		public String getmid(int mno) {
			String sql = "select mid from member where mno = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setInt(1, mno);
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getString(1);
				}
			}catch(Exception e) {System.out.println("회원아이디 출력 오류" + e);}
			return null;
		}
		public JSONObject getmemberjson(String mid) {
			JSONObject jo = new JSONObject();
			try {
				String sql = "select * from member where mid = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, mid);
				rs = ps.executeQuery();
				if(rs.next()) {
					jo.put("mno", rs.getInt(1));
					jo.put("mid", rs.getString(2));
					jo.put("mname", rs.getString(4));
					jo.put("mphone", rs.getString(5));
					jo.put("memail", rs.getString(6));
					
					return jo;
				}
			}catch(Exception e) {e.printStackTrace();}
			return null;
		}
}
