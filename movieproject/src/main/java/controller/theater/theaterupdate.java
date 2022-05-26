package controller.theater;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TheaterDao;

/**
 * Servlet implementation class theaterupdate
 */
@WebServlet("/theater/theaterupdate")
public class theaterupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public theaterupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tno = Integer.parseInt(request.getParameter("tnum"));
		String tseat = request.getParameter("tseat");
		String select = request.getParameter("select");
		boolean result = TheaterDao.getTheaterDao().theaterupdate(tno, tseat, select);
		if(result) {
			response.getWriter().print(1);
		}
		else {
			response.getWriter().print(2);
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
