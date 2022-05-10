package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;

/**
 * Servlet implementation class findpw
 */
@WebServlet("/findpw")
public class findpw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findpw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 	// 요청시 사용되는 인코딩타입 [ 한글 ] 
		String mname = request.getParameter("name"); // 데이터 요청 
		String mphone = request.getParameter("phone");
		String mid = request.getParameter("id");
		// 1. dao를 통해 동일한 아이디가 있는지 체크 
		String result 
			=  MemberDao.getMemberDao().findpw(mid ,mname, mphone);
		if( result != null ) { // 2. 만약에 동일한 아이디가 있으면 1 없으면 2 
			response.getWriter().print( 1 );
			response.sendRedirect("/movieproject/member/findpwresult.jsp");
		}else {
			response.getWriter().print( 2 );
		}
	}

}
