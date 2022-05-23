package dao;

import java.util.ArrayList;

import dto.Theater;

public class TheaterDao extends Dao{
	
	public TheaterDao() {
		super();
	}
	public static TheaterDao theaterdao = new TheaterDao();
	// dao 호출시 반복되는 new 연산자 
	public static TheaterDao getTheaterDao() {return theaterdao;}

	
	public boolean tnamecheck(String tname) {
		String sql = "select * from theater where tname = ?";
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, tname);
		rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		}	
		return false;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	public boolean theateradd(Theater th) {
		String sql = "insert into theater (tname, tseat, tlocation) values(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, th.getTname());
			ps.setString(2, th.getTseat());
			ps.setString(3, th.getTlocation());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		
		
		return false;
		}
	
	public ArrayList<Theater> theaterlist() {return null;}
	
	public boolean theaterdelete() {return false;}
	
	
}
