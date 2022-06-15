package controller.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class moiesearch
 */
@WebServlet("/movie/moviesearch")
public class moviesearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public moviesearch() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query");
		System.out.println(query);
		String clientId = "2Q6cnxxfBY7eixT2c20k"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "4d3kieNzyh"; //애플리케이션 클라이언트 시크릿값"
        String url = "https://openapi.naver.com/v1/search/movie.json?query="+query;
        
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	}

