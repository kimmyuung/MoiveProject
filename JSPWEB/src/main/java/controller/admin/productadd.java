package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDao;
import dto.Product;

/**
 * Servlet implementation class productadd
 */
@WebServlet("/admin/productadd")
public class productadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 1. 프로젝트 폴더 저장 // 2. 서버 (톰캣) 폴더 저장 O
		
		
		MultipartRequest m = new MultipartRequest(request, // 요청 타입
				request.getSession().getServletContext().getRealPath("/admin/productimg"), //저장 폴더 위치
				1024*1024*50, // 파일 최대용량
				"UTF-8", // 파일 인코딩 타입
				new DefaultFileRenamePolicy () // 보안 방식 : 파일 명이 중복이면 파일명 뒤에 숫자를 자동으로 부여하여 식별 제공
				);
				
				
		String pname = m.getParameter("pname");
	
		int pprice = Integer.parseInt(m.getParameter("pprice"));
		
		float pdiscount = Float.parseFloat(m.getParameter("pdiscount"));
		
		int cno = Integer.parseInt(m.getParameter("cno")); 
		
		String pimg = m.getFilesystemName("pimg"); // 첨부파일 파일명은 요청시 .getfilesystemname 사용
		
	
		Product product = new Product(0, pname, pprice, pdiscount, 0, pimg, cno);
		
		boolean result = ProductDao.getproductDao().psave(product);
		if(result) {
			response.getWriter().print(1);
		}
		else {
			response.getWriter().print(2);
		}
	}

}
