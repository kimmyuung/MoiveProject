package controller.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MovieDao;
import dao.TheaterDao;
import dto.Runmovie;

/**
 * Servlet implementation class runmovieadd
 */
@WebServlet("/movie/runmovieadd")
public class runmovieadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public runmovieadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mtitle = request.getParameter("mname");
		String tname = request.getParameter("tname");
		String Str_time = request.getParameter("starttime");	
		
		int mno = MovieDao.getmovieDao().getmno(mtitle);
		int tno = TheaterDao.getTheaterDao().gettno(tname);
		Runmovie runmovie = new Runmovie(Str_time, tno, mno);
		
		boolean result = MovieDao.getmovieDao().runmovieadd(runmovie);	
		if(result) {response.getWriter().print(1);}	
		else {response.getWriter().print(2);}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
