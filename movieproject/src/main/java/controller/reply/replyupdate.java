package controller.reply;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.ReplyDao;
import dto.Reply;

/**
 * Servlet implementation class replyupdate
 */
@WebServlet("/reply/replyupdate")
public class replyupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public replyupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int rno = Integer.parseInt(request.getParameter("rno") ) ;
		
		String rcontent = request.getParameter("updatecontent");
		
		String mid = (String)request.getSession().getAttribute("login");
		
		int mno = MemberDao.getMemberDao().getmno(mid);
		
		Reply reply = new Reply(rno, rcontent, null, 0, 0, mno, null);
		
		boolean reuslt = ReplyDao.getReplyDao().replyupdate(reply);
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
