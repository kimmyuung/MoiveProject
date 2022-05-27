package controller.theater;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.MovieDao;
import dao.TheaterDao;

/**
 * Servlet implementation class gettheaterlist
 */
@WebServlet("/theater/gettheaterlist")
public class gettheaterlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gettheaterlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray tlist = TheaterDao.getTheaterDao().tlist();
		// request, response -> 전송 인코딩 타입 -> 문자열
		// 1. 응답객체내 한글 인코딩 타입 설정
		response.setCharacterEncoding("UTF-8");
		// 2. 응답객체의 자료형 [ 문자열 -> json ] 
		response.setContentType("application/json");
		// 3. 응답 전송
		response.getWriter().print(tlist);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
