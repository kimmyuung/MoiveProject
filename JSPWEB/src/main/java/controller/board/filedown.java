package controller.board;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class filedown
 */
@WebServlet("/board/filedown")
public class filedown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public filedown() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String bfile = request.getParameter("bfile");
		System.out.println(bfile);
		
		// 해당 서버에서 파일 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/board/upload/" + bfile);
		// 프로젝트 경로 찾기
		
		// 3. 파일 객체화
		File file = new File(uploadpath);
		
		// 4. 다운로드 형식
		response.setHeader("Content-Disposition", "attachment;filename=" 
		+ URLEncoder.encode(bfile, "UTF-8") );
								// 다운로드형식 : html // 다운로드 화면에서 표시할 파일명
							
		// 5. 바이트형식으로 내보내기(통신)
		BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
		byte[] bytes = new byte[(int)file.length()]; // 파일길이(=크기=용량) 만큼 배열 선언
		fin.read(bytes);
		
		// 2. 출력스트림 [ 서버가 PC내 파일을 내보내기 단계 ]
			// reponse: (서블릿)웹 응답 객체
		BufferedOutputStream fout = new BufferedOutputStream(response.getOutputStream());
		fout.write(bytes);
		// 3. 스트림 닫기 (용량 )
		fout.close();
		fin.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
