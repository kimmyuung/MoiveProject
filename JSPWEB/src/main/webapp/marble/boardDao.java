package dao;

import java.util.ArrayList;

public class boardDao extends Dao{
	public boardDao() {super();}
	public static boardDao boarddao=new boardDao();
	
	//보드 생성 생략(DB에서)
	//보드 삭제 생략(삭제안함)
	
	//도시 이름 받아오기
	public ArrayList<String> cityList(){
		ArrayList<String> cities=new ArrayList<String>();
		String sql="select cname from board";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				cities.add(rs.getString(1));
			}return cities;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	//도시 구매값 받아오기
	public int boardBuy(int bno) {
		String sql="select buyprice from board where bno="+bno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}
	
	//도시 통행료 받아오기
	public int boardPay(int bno) {
		String sql="select payprice from board where bno="+bno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}
	//도시 주인 변경
	public boolean ownerChange(int pno, int bno) {
		String sql="update board set pno="+pno+" where bno="+bno;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
}
