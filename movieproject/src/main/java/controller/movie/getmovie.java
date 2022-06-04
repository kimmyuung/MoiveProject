package controller.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MovieDao;
import dto.Movie;

/**
 * Servlet implementation class getmovie
 */
@WebServlet("/movie/getmovie")
public class getmovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getmovie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		String mtitle = request.getParameter("mtitle");
		
		Movie movie = MovieDao.getmovieDao().getmovie(mtitle);
		try {
			JSONObject jo = new JSONObject();
			jo.put("runtime", movie.getMruntime());
			jo.put("mtitle", movie.getMtitle());
			jo.put("mprice", movie.getMprice()); // 필요한 거 있을 시 더 추가
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("applicaton/json");
			response.getWriter().print(jo);
		} catch(Exception e) {e.printStackTrace();} 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
