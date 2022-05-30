package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Category;
import dto.Movie;
import dto.Runmovie;

public class MovieDao extends Dao{

	public MovieDao() {
		super();
	}
	public static MovieDao movieDao = new MovieDao();
	// dao 호출시 반복되는 new 연산자 
	public static MovieDao getmovieDao() {return movieDao;}
	
	
	
	// 카테고리 이름 중복 체크
	public boolean categorycheck(String cname) { // id 체크
		String sql = "select * from category where cname=?";
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, cname);
			rs = ps.executeQuery();
			if(rs.next()) {return true;} // 동일 카테고리 존재!
		} catch(Exception e) {e.printStackTrace();}
		return false; // 동일 카테고리 없음!
	}
	
	// 카테고리 등록
	public boolean csave(String cname) { 
		String sql = "insert into category(cname) values(?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cname);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
		}
	// 카테고리 호출
	public ArrayList<Category> getcategorylist(){ 
		ArrayList<Category> list = new ArrayList<Category>();
		String sql = "select * from category";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Category cat = new Category(rs.getInt(1), rs.getString(2));
				list.add(cat);
			}
			return list;
		}catch(Exception e) {e.printStackTrace();}
		return null;
		}
	public Category getcategory(int cno) {
		String sql = "select * from category where cno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cno);
			rs = ps.executeQuery();
			if(rs.next()) {
				Category cat = new Category(rs.getInt(1), rs.getString(2));
				return cat;
			}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	// 카테고리 삭제
	public boolean mcategorydelete(int cno) {
		String sql = "delete from category where cnum = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cno);
			ps.executeUpdate();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	// 영화 이름 중복 체크
		public boolean titlecheck(String mtitle) { // id 체크
			String sql = "select * from movie where mtitle=?";
			try{
				ps = con.prepareStatement(sql);
				ps.setString(1, mtitle);
				rs = ps.executeQuery();
				if(rs.next()) {return true;} // 동일 아이디 존재!
			} catch(Exception e) {e.printStackTrace();}
			return false; // 동일 아이디 없음!
		}
	
	// 영화정보 출력 [ 인수 : 리스트에서 넘겨받은 영화의 제목 ] 
			public Movie getmovie(String mtitle) {
				String sql = "select * from movie where mtitle = ?";
				
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, mtitle);
					rs = ps.executeQuery();
					if(rs.next()) {
						Movie movie = new Movie(rs.getInt(1), rs.getString(2), 
								rs.getString(3), rs.getString(4), 
								rs.getInt(5), rs.getInt(6));
						return movie;
					}
					
				} catch(Exception e) {e.printStackTrace();}
				return null;
			}
			
			public boolean movieadd(Movie movie) { // 영화등록
				try {
				String sql = "insert into movie(mtitle, mruntime, mimg, mprice, mcategory) values(?,?,?,?,?);";
				ps = con.prepareStatement(sql);
				ps.setString(1, movie.getMtitle());
				ps.setString(2, movie.getMruntime());
				ps.setString(3, movie.getMimg());
				ps.setInt(4, movie.getMprice());
				ps.setInt(5, movie.getMcategory());
				ps.executeUpdate();
				return true;
				}catch(Exception e) {e.printStackTrace();}
				return false;
			}
			
			
			// 영화 삭제 메소드
			public boolean delete(String mtitle) {
				String sql = "delete from movie where mtitle = ?";
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, mtitle);
					ps.executeUpdate();
					return true;
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				return false;
			}
			// 영화 호출
			public ArrayList<Movie> getmovielist(){ 
				ArrayList<Movie> list = new ArrayList<Movie>();
				String sql = "select * from movie";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						Movie movie = new Movie(rs.getInt(1), rs.getString(2), 
								rs.getString(3), rs.getString(4), 
								rs.getInt(5), rs.getInt(6));
						list.add(movie);
					}
					return list;
				}catch(Exception e) {e.printStackTrace();}
				return null;
				}
			// 영화 이름 통한 영화번호
			public int getmno(String mtitle) {
				try {
					String sql = "select * from movie where mtitle = ?";
					ps = con.prepareStatement(sql);
					ps.setString(1, mtitle);
					rs = ps.executeQuery();
					if(rs.next()) {
						return rs.getInt(1);
					}
				}catch(Exception e) {e.printStackTrace();}
				return 0;
			}
			
			
			
			// 영화 리스트 제이슨
			public JSONArray mlist() {
				try {
				JSONArray list = new JSONArray();
				String sql = "select * from movie";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					// 결과내 하나씩 모든 레코드를 -> 하나씩 json 객체로 변환
					JSONObject object = new JSONObject();
					object.put("mno", rs.getInt(1));
					object.put("mtitle", rs.getString(2));
					object.put("mruntime", rs.getString(3));
					object.put("mimg", rs.getString(4));
					object.put("mcategory", rs.getInt(5));
					object.put("mprice", rs.getInt(6));
					
					list.put(object);
				}
				return list;
				}catch(Exception e) {e.printStackTrace();}
				return null;
			}
			public JSONArray timelist(int tno) {
				try {
				JSONArray list = new JSONArray();
				String sql = "select * from runtimemovie where tno = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, tno);
				rs = ps.executeQuery();
				while(rs.next()) {
					// 결과내 하나씩 모든 레코드를 -> 하나씩 json 객체로 변환
					JSONObject object = new JSONObject();
					object.put("mno", rs.getInt(1));
					object.put("tno", rs.getInt(2));
					object.put("starttime", rs.getString(3));
					object.put("endtime", rs.getString(4));
					object.put("startdate", rs.getString(5));
					object.put("enddate", rs.getString(6));
					
					list.put(object);
				}
				return list;
				}catch(Exception e) {e.printStackTrace();}
				return null;
			}	
			// 상영 영화 추가
			public boolean runmovieadd(Runmovie run) { // 영화등록
				try {
				String sql = "insert into runmovie(mno, tno, starttime, endtime, startdate, enddate) values(?,?,?,?,?,?);";
				ps = con.prepareStatement(sql);
				ps.setInt(1, run.getMno());
				ps.setInt(2, run.getTno());
				ps.setString(3, run.getStime());
				ps.setString(4, run.getEtime());
				ps.setString(5, run.getSdate());
				ps.setString(6, run.getEdate());
				ps.executeUpdate();
				return true;
				}catch(Exception e) {e.printStackTrace();}
				return false;
			}
}
