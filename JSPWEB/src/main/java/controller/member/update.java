package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDao;
import dao.MemberDao;
import dto.Board;
import dto.Member;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		
	
}	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 식별 속성
		// name = "태그이름명" : request 요청시 사용되는 이름
		// id = "태그id"
		// class = "태그class명"
		
		request.setCharacterEncoding("UTF-8");
		
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		
		int mno = Integer.parseInt(request.getParameter("mno")); // 수정
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
		String memail = request.getParameter("memail");
		String memailaddress = request.getParameter("memailaddress");
		String email = memail + "@" + memailaddress;
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String address4 = request.getParameter("address4");
		String address = address1 + "_" + address2 + "_" + address3 + "_" + address4;
	
		Member member = null;
		
		if(oldpassword.equals("") || newpassword.equals("")) {
			// 패스워드 변경이 없을때
			member = new Member(mno, null, null, mname, mphone, email , address, 0 , null);
		}
		else {
			// 패스워드 변경시
			// 기존 패스워드 체크
			HttpSession session = request.getSession();
			String mid = (String)session.getAttribute("login");
			boolean result = MemberDao.getmemberDao().passwordcheck(mid, oldpassword);
			if(result) {
				member = new Member(mno, null, newpassword, mname, mphone, email, address, 0, null);
			}
			else {
				response.sendRedirect("/JSPWEB/member/update.jsp?result=3"); return;
			}
		}
		
		boolean result = MemberDao.getmemberDao().update(member);
		if(result) {
			response.sendRedirect("/JSPWEB/member/update.jsp?result=1");
		}
		else {
			response.sendRedirect("/JSPWEB/member/update.jsp?result=2");
		}
	}

}
