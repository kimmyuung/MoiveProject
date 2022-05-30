package controller.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.MovieDao;
import dao.TheaterDao;
import dto.Runmovie;

/**
 * Servlet implementation class addrunmovie
 */
@WebServlet("/movie/addrunmovie")
public class addrunmovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addrunmovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String json = request.getParameter("runmoviejson");
		try {
			JSONObject jo = new JSONObject(json);
			String mname= jo.getString("mname");
			
			String tname = jo.getString("tname");
			
			int mno = MovieDao.getmovieDao().getmno(mname);
			
			int tno = TheaterDao.getTheaterDao().gettno(tname);
			
			String stime = jo.getString("stime");
			
			String etime = jo.getString("etime");
			
			String startdate = jo.getString("startdate");
			
			String enddate = jo.getString("enddate");
			
			Runmovie runmovie = new Runmovie(stime, etime, startdate, enddate, tno, mno);
			boolean result = MovieDao.getmovieDao().runmovieadd(runmovie);
			if(result) {response.getWriter().print(1);}
			else {response.getWriter().print(2);}
		}catch(Exception e) {e.printStackTrace();}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
