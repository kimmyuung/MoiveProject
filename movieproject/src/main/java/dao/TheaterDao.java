package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

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
	
	public ArrayList<Theater> theaterlist() {
		ArrayList<Theater> theaters = new ArrayList<Theater>();
		String sql = "select * from theater";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Theater theater = new Theater(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) );
				theaters.add(theater);
			}
			return theaters;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	public boolean theaterdelete(int tno) {
		String sql = "delete from theater where tno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tno);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
		}
	
	public boolean theaterupdate(int tno, String tseat, String select) {
		String sql = "update theater set tseat = ?, tlocation = ? where tno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tseat);
			ps.setString(2, select);
			ps.setInt(3, tno);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	public Theater gettheater(int tno) {
		String sql = "select * from theater where tno = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, tno);
			rs = ps.executeQuery();
			if(rs.next()) {
				Theater theater = new Theater(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4) );
				return theater;
			}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	public int gettno(String tname) {
		String sql = "select tno from theater where tname = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tname);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}
	
	public JSONArray tlist() {
		try {
		JSONArray list = new JSONArray();
		String sql = "select * from theater";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			// 결과내 하나씩 모든 레코드를 -> 하나씩 json 객체로 변환
			JSONObject object = new JSONObject();
			object.put("tno", rs.getInt(1));
			object.put("tname", rs.getString(2));
			object.put("tseat", rs.getString(3));
			object.put("tlocation", rs.getString(4));
			list.put(object);
		}
		return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
}
