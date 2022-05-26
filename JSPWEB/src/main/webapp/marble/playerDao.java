package dao;

import dto.Player;

public class playerDao extends Dao{
	public playerDao() {super();}
	public static playerDao playerdao=new playerDao();
	
	//플레이어 등록
	public boolean playerSignup(Player player) {
		String sql="insert into player values (?,?,?,?,?)";
		try {
		ps=con.prepareStatement(sql);
		ps.setInt(1, player.getPno());
		ps.setInt(2, player.getLocation());
		ps.setInt(3, player.getMoney());
		ps.setInt(4, player.getTurn());
		ps.setString(5, player.getName());
		ps.executeUpdate();
		return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	//플레이어 정보 받아오기
	public Player playerData(int pno) {
		String sql="select*from player where pno="+pno;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				Player player=new Player(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getInt(4), rs.getString(5), null); return player;}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	//플레이어 턴 변경
	public int playerTurn(int turn, int pno){
		String sql="update player set turn="+turn+" where pno="+pno;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			return pno;
		}catch(Exception e) {e.printStackTrace();}
		return 0;
	}
	//플레이어 보유 금액 업데이트
	public void playerMoney(int money, int pno) {
		String sql="update player set money="+money+" where pno="+pno;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
	}
	//플레이어 위치 업데이트
	public void playerLocate(int location, int pno) {
		String sql="update player set location="+location+" where pno="+pno;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
	}
	//플레이어 탈퇴
	public boolean playerDelete(int pno) {
		String sql="delete from player where pno="+pno;
		try {
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
}
