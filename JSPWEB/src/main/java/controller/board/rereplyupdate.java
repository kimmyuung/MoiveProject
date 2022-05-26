package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.MemberDao;
import dto.Reply;

/**
 * Servlet implementation class rereplyupdate
 */
@WebServlet("/board/rereplyupdate")
public class rereplyupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rereplyupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int rno = Integer.parseInt(request.getParameter("rno") ) ;
		
		// rindex : 누구 댓글의 대댓글인지 식별하기 위해 설정 (상위 댓글번호)
		int bno = Integer.parseInt(request.getParameter("bno") ) ;
		
		String rrcontent = request.getParameter("reupdatecontent");
		
		String mid = (String)request.getSession().getAttribute("login");
		
		int mno = MemberDao.getmemberDao().getmno(mid);
		
		
		Reply reply = new Reply(rno, rrcontent, null, 0, 0, mno, null);
		
		
		boolean reuslt = BoardDao.getBoardDao().replyupdate(reply);
		if(reuslt) {response.getWriter().print(1);}
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
