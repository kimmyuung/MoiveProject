package dao;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Category;
import dto.Movie;
import dto.Runmovie;
import dto.Theater;

public class MovieDao extends Dao {

	public MovieDao() {
		super();
	}

	public static MovieDao movieDao = new MovieDao();

	// dao 호출시 반복되는 new 연산자
	public static MovieDao getmovieDao() {
		return movieDao;
	}

	// 카테고리 이름 중복 체크
	public boolean categorycheck(String cname) { // id 체크
		String sql = "select * from category where cname=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, cname);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} // 동일 카테고리 존재!
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 카테고리 호출
	public ArrayList<Category> getcategorylist() {
		ArrayList<Category> list = new ArrayList<Category>();
		String sql = "select * from category";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Category cat = new Category(rs.getInt(1), rs.getString(2));
				list.add(cat);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getcategory(int cno) {
		String sql = "select cname from category where cnum = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cno);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// 영화 이름 중복 체크
	public boolean titlecheck(String mtitle) { // id 체크
		String sql = "select * from movie where mtitle=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mtitle);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} // 동일 아이디 존재!
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; // 동일 아이디 없음!
	}

	// 영화정보 출력 [ 인수 : 리스트에서 넘겨받은 영화의 제목 ]
	public Movie getmovie(String mtitle) {
		String sql = "select * from movie where mtitle = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mtitle);
			rs = ps.executeQuery();
			if (rs.next()) {
				Movie movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));
				return movie;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 영화 정보 출력 : JSON
	public JSONObject getmoviejson(String mtitle) {
		try {
			JSONObject jo = new JSONObject();
			String sql = "select * from movie where mtitle = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mtitle);
			rs = ps.executeQuery();
			if(rs.next()) {
				jo.put("mno", rs.getInt(1));
				jo.put("mtitle", rs.getString(2));
				jo.put("mruntime", rs.getString(3));
				jo.put("mimg", rs.getString(4));
				jo.put("mprice", rs.getInt(5));
				jo.put("mcategory", rs.getInt(6));	
			}
			
			return jo;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	// 영화 번호를 통한 영화 제목 출력
	public String getmtitle(int mno) {
		try {
			String sql = "select mtitle from movie where mno = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mno);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
				return rs.getString(1);
			}
		}catch(Exception e) {e.printStackTrace();}
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
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// 영화 목록 호출
	public ArrayList<Movie> getmovielist() {
		ArrayList<Movie> list = new ArrayList<Movie>();
		String sql = "select * from movie";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));
				list.add(movie);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 영화 이름 통한 영화번호
	public int getmno(String mtitle) {
		try {
			String sql = "select * from movie where mtitle = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mtitle);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 영화 리스트 제이슨
	public JSONArray mlist() {
		try {
			JSONArray list = new JSONArray();
			String sql = "select * from movie";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				// 결과내 하나씩 모든 레코드를 -> 하나씩 json 객체로 변환
				JSONObject object = new JSONObject();
				object.put("mno", rs.getInt(1));
				object.put("mtitle", rs.getString(2));
				object.put("mruntime", rs.getString(3));
				object.put("mimg", rs.getString(4));
				object.put("mprice", rs.getInt(5));
				object.put("mcategory", rs.getInt(6));

				list.put(object);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public JSONArray timelist(int tno) {
		try {
			JSONArray list = new JSONArray();
			String sql = "select * from runtimemovie where tno = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, tno);
			rs = ps.executeQuery();
			while (rs.next()) {
				// 결과내 하나씩 모든 레코드를 -> 하나씩 json 객체로 변환
				JSONObject object = new JSONObject();
				object.put("mno", rs.getInt(1));
				object.put("tno", rs.getInt(2));
				object.put("starttime", rs.getString(3));

				list.put(object);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 상영 영화 추가
	public boolean runmovieadd(Runmovie run) { // 영화등록
		try {
			String sql = "insert into runmovie(starttime, tno, mtitle) values(?,?,?);";
			ps = con.prepareStatement(sql);
			ps.setString(1, run.getStime());
			ps.setInt(2, run.getTno());
			ps.setString(3, run.getMtitle());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 상영 영화 리스트
	public JSONArray getrunmovielist() { // 상영영화 리스트 출력
		JSONArray js = new JSONArray();
		try {
			String sql = "SELECT * FROM runmovie"
			+ " left outer join movie on runmovie.mtitle = movie.mtitle GROUP BY runmovie.mtitle;";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("tno", rs.getInt(1));
				jo.put("mtitle", rs.getString(2));
				jo.put("starttime", rs.getString(3));
				jo.put("rno", rs.getInt(4));
				jo.put("mno", rs.getInt(5));
				jo.put("mruntime", rs.getString(7));
				jo.put("mprice", rs.getString(9));
				jo.put("mcategory", rs.getString(10));
				js.put(jo);
			}
				return js;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 티켓에 쓰일 상영 영화 정보 출력(영화 테이블에서 조인하여 상세 정보 획득)
	public JSONObject getrunmovie() {
		try {
			String sql = "SELECT * FROM runmovie"
					+ "left outer join movie on mtitle = movie.mtitle;";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("tname", rs.getString(1));
				jo.put("mtitle", rs.getString(2));
				jo.put("starttime", rs.getString(3));
				jo.put("rno", rs.getInt(4));
				jo.put("mno", rs.getInt(5));
				jo.put("mtitle", rs.getString(7));
				jo.put("mruntime", rs.getString(8));
				jo.put("mimg", rs.getString(9));
				jo.put("mrice", rs.getInt(10));
				jo.put("mcategory", rs.getInt(11));
				return jo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Theater> tlist() {
		ArrayList<Theater> tlist = new ArrayList<Theater>();
		String sql = "select * from theater";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Theater theater = new Theater(
						rs.getInt(1), rs.getString(2), 
						rs.getString(3), rs.getString(4));
				tlist.add(theater);
			}
			return tlist;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	// 상영 영화 제거
	public boolean runmoviedelete(int rno) {
		try {
			String sql = "delete from runmovie where rno = ?";
			ps =con.prepareStatement(sql);
			ps.setInt(1, rno);
			ps.executeUpdate();
			return true;
		}catch(Exception e) {e.printStackTrace();}
		return false;
	}
	
	// 상영 영화가 상영중인 관을 출력
	public JSONArray getruntheaterlist(String mtitle) {
		JSONArray js = new JSONArray();
		try {
			//String sql = "select tname, mtitle, starttime, rno from theater"
			//		+ "left outer join runmovie on theater.tno = runmovie.tno where mtitle = ?;" + mtitle;
			String sql = "select * from runmovie where mtitle = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mtitle);
			rs = ps.executeQuery();
			while(rs.next()) {
				JSONObject jo = new JSONObject();
				jo.put("tno", rs.getInt(1));
				jo.put("mtitle", rs.getString(2));
				jo.put("starttime", rs.getString(3));
				jo.put("rno", rs.getInt(4));
				js.put(jo);
			}
			System.out.println(js.toString());
			return js;
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	// 영화관 번호를 가지고 상영관 정보 출력
	public Theater getTheater(int tno) {
		try {
			String sql = "select * from where theater where tno = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, tno);
			rs = ps.executeQuery();
			if(rs.next()) {
				Theater theater = new Theater(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				return theater;
			}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	// 영화 제목을 가지고 영화 정보 출력
	public Movie getMovie(String mtitle) {
		try {
			String sql = "select * from movie where mtitle = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, mtitle);
			rs = ps.executeQuery();
			if(rs.next()) {
				Movie movie = new Movie(rs.getInt(1), rs.getString(2), 
						rs.getString(3), null, rs.getInt(5), rs.getInt(6) );
				System.out.println(movie.toString());		
				return movie;
						
			}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
	// 상영 영화 pk를 가지고 상영 영화정보 출력
	public String getRunmovieTitle(int rno) {
		try {
			String sql = "select mtitle from runmovie where rno = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, rno);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		return null;
	}
	
}
