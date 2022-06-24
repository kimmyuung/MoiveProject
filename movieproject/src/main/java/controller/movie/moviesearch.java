package controller.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;


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
		String text = request.getParameter("query");
		
		String clientId = "C42rs9pTGjajoo5tbUX7"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "3CibZ9XUTn"; //애플리케이션 클라이언트 시크릿값"
        String display = request.getParameter("display");
        try {
        	String apiURL = "https://openapi.naver.com/v1/search/movie.json?query="+ text; // json 결과
 
        	URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
        	
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode == 200) {
            	br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            else {
            	br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
        	
            String inputLine;
            StringBuffer sb = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {//br.readLine()가 널이 아닐때만 inputLine에 br.readLine()값 집어넣고 while문 실행                   sb.append(inputLine);               }
            	sb.append(inputLine);
            }
            JSONArray js = new JSONArray();
            JSONObject jo = new JSONObject();
            	jo.put("result", sb);
            js.put(jo);
            br.close();
            
        	response.setCharacterEncoding("UTF-8");
        	response.setContentType("application/json");
        	response.getWriter().print(js);
        	
        }catch(Exception e) {e.printStackTrace();}
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	}

