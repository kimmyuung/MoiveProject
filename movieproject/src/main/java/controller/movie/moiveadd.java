package controller.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MovieDao;
import dto.Movie;

/**
 * Servlet implementation class moiveadd
 */
@WebServlet("/movie/movieadd")
public class moiveadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public moiveadd() {
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
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/movie/upload") ;
		
		// 첨부파일 업로드 [ MultipartRequest : cos 라이브러리 제공 클래스 ] 
		MultipartRequest multi = new MultipartRequest(
				request ,		// 1. 요청방식 
				uploadpath , 	// 2. 파일 저장 경로 
				1024*1024*10 ,	// 3. 파일 최대 용량 허용 범위 [ 10MB ] 
				"UTF-8" ,		// 4. 인코딩타입 
				new DefaultFileRenamePolicy() 	// 4. 보안방식 : 동일한 파일명이 있을경우 자동 이름 변환 
				);	
		// 데이터 요청 
		String mtitle = multi.getParameter("mtitle");
		int mprice = Integer.parseInt(multi.getParameter("mprice")); 
		String mimg = multi.getFilesystemName("pimg"); // 첨부파일 : getFilesystemName
		int cno = Integer.parseInt( multi.getParameter("cno") );
		String mruntime = multi.getParameter("mruntime");		
		
		
		// 객체화 
		Movie movie = new Movie(0, mtitle, mruntime, mimg, mprice, cno);
		// DB 처리
		boolean result = MovieDao.getmovieDao().movieadd(movie);
		// 결과 
		if( result ) { 
			
			response.getWriter().print(1);
		}
		else { 
			response.getWriter().print(2);
		}
		
	}
		
		
		
	}


