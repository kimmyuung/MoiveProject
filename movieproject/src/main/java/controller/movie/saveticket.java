package controller.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDao;
import dto.Ticket;

/**
 * Servlet implementation class saveticket
 */
@WebServlet("/movie/saveticket")
public class saveticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveticket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int tno = Integer.parseInt(request.getParameter("tno"));
		int rno = Integer.parseInt(request.getParameter("rno"));
		String date = request.getParameter("date");
		String seat = request.getParameter("seat");
		String mid = request.getParameter("mid");
		Ticket ticket = new Ticket(0, tno, rno, date, seat, mid);
		boolean result = MovieDao.getmovieDao().saveticket(ticket);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
