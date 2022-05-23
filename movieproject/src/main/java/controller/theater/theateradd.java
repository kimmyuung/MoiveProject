package controller.theater;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.TheaterDao;
import dto.Theater;

/**
 * Servlet implementation class theateradd
 */
@WebServlet("/theater/theateradd")
public class theateradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public theateradd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String json = request.getParameter("tjosn");
			JSONObject jo = new JSONObject(json); // json 객체형 변환	
			String tname= jo.getString("tname");
			String tseat = jo.getString("tseat");
			String location = jo.getString("location").toString();
			
			Theater theater = new Theater(0, tname, tseat, location);
			System.out.println(theater.toString());
			boolean result = TheaterDao.getTheaterDao().theateradd(theater);
			
			if(result) {
				response.getWriter().print(1);
			}
			else {
				response.getWriter().print(2);
			}
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
