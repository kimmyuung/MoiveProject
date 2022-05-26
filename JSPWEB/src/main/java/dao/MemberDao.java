package dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import dto.Member;

public class MemberDao extends Dao {
	// 자식클래스로 객체 생성시 ( 부모 클래스의 생성자 호출 )	
	public MemberDao() {
		super(); // 부모클래스 생성자 호출 
	}
	public static MemberDao memberDao = new MemberDao(); 		// dao 호출시 반복되는 new 연산자 제거 
	public static MemberDao getmemberDao() { return memberDao; } 
	
	// 아이디 중복체크 메소드
	public boolean idcheck( String mid ) {
		String sql = "select * from member where mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();	
			// 동일한 아이디가 존재하면 
			if( rs.next() ) { return true; } 
		}catch (Exception e) { System.out.println( e );} 
		// 동일한 아디디가 존재하지 않으면
		return false;
	}
	// 이메일 중복체크 메소드 
	public boolean emailcheck( String email ) {
		String sql = "select * from member where memail = ?";
		try {  ps = con.prepareStatement(sql); ps.setString(1, email); 
		ps.executeQuery(); if( rs.next() ) return true;
		}catch (Exception e) {} return false;
	}
	// 회원가입 메소드 
	public boolean signup( Member member ) {
		String sql ="insert into member(mid,mpw,mname,mphone,memail,maddress) "
				+ "value(?,?,?,?,?,?)";
		System.out.print("오 8분전");
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , member.getMid() ); 	ps.setString( 2 , member.getMpw() ); 
			ps.setString( 3 , member.getMname() );	ps.setString( 4 , member.getMphone() ); 
			ps.setString( 5 , member.getMemail()); 	ps.setString( 6 , member.getMaddress());
			ps.executeUpdate(); return true;
		}catch (Exception e) {System.out.print(e);} return false;
	}
	
	// 로그인 메소드 
	public int login( String mid , String mpw ) {
		 String sql = "select * from member where mid = ? and mpw = ?";
		// String sql = "select * from member where mid = ? and mpassword = ?";
		try {
			ps = con.prepareStatement(sql); 
			ps.setString(1, mid);
			ps.setString(2, mpw);
			//ps.setString(1, mid); ps.setString(2, mpassowrd ); // ? 사용시 ?에 데이터 대입
			rs = ps.executeQuery(); if( rs.next() ) return 1; // 동일한 값이 있으면 1성공 
			return 2; // 동일한 값이 없으면 2실패 
		}catch (Exception e) {} return 3; // DB오류이면 3실패
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
	// 패스워드 체크
	public boolean passwordcheck(String mid, String mpw) {
		String sql = "select * from member where mid = ? and mpw = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			ps.setString(2, mpw);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch(Exception e) {
			System.out.println("비밀번호 체크 실패" + e);
		}
		return false;
	}
	// 회원삭제 메소드
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
	public boolean update( Member member ) {
		try {
		if( member.getMpw() == null ) { // 패스워드 변경이 없을때 
			String sql ="update member set mname=? ,  mphone=? , memail=?,"
					+ "maddress = ? where mno=?";
				ps = con.prepareStatement(sql);
				ps.setString( 1 , member.getMname() );
				ps.setString( 2 , member.getMphone() );
				ps.setString( 3 , member.getMemail() );
				ps.setString( 4 , member.getMaddress() );
				ps.setInt( 5, member.getMno() );
		}else {	// 패스워드가 변경이 있을때 
			String sql ="update member set mname=? , mpw = ? ,  mphone=? , memail=?,"
					+ "maddress = ? where mno=?";
				ps = con.prepareStatement(sql);
				ps.setString( 1 , member.getMname() );
				ps.setString( 2 , member.getMpw() );
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
}
