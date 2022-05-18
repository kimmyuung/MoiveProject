package controller.movie;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.MovieDao;
import dto.Movie;

/**
 * Servlet implementation class movieupdate
 */
@WebServlet("/movieupdate")
public class movieupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public movieupdate() {
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
int bno =  Integer.parseInt( request.getParameter("bno") );
		
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload");
		MultipartRequest multi = new MultipartRequest( request,uploadpath ,1024*1024*10 ,"UTF-8" ,new DefaultFileRenamePolicy());
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
			//기존파일명
			Movie temp = MovieDao.getmovieDao().getmovie(btitle);
			String oldfile = temp.getMimg();
			if( bfile == null ) {// 새로운 첨부파일 없다 . 
				bfile = oldfile;
			}else { // 새로운 첨부파일 있다. 
				// * 기존파일은 서버내에서 삭제처리
				String upload = request.getSession().getServletContext().getRealPath("/movie/upload/"+oldfile);
				File file = new File(upload);
				file.delete();
			}
		
			//객체화 
			Movie movie = new Movie();
			// DB
		boolean result = MovieDao.getmovieDao().update(movie);
		if( result ) { response.sendRedirect("boardview.jsp?bno="+bno ); }
		else { response.sendRedirect("boardview.jsp?bno="+bno );}
	}

}
