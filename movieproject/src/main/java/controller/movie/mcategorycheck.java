package controller.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;

/**
 * Servlet implementation class categorycheck
 */
@WebServlet("/movie/mcategorycheck")
public class mcategorycheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mcategorycheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 	// 요청시 사용되는 인코딩타입 [ 한글 ] 
		String cname = request.getParameter("cname"); // 데이터 요청 
		// 1. dao를 통해 동일한 아이디가 있는지 체크 
		boolean result 
			=  MovieDao.getmovieDao().categorycheck(cname);
		if( result ) { // 2. 만약에 동일한 아이디가 있으면 1 없으면 2 
			response.getWriter().print( 1 );
		}else {
			response.getWriter().print( 2 );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
