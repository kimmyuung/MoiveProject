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
		String query = request.getParameter("query");
		
		String clientId = "C42rs9pTGjajoo5tbUX7"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "3CibZ9XUTn"; //애플리케이션 클라이언트 시크릿값"
       
        try {
        	String text = URLEncoder.encode(query, "UTF-8");
        	String apiURL = "https://openapi.naver.com/v1/search/movie.json?query="+ text; // json 결과
        	  Map<String, String> requestHeaders = new HashMap<>();       	  
        	  requestHeaders.put("X-Naver-Client-Id", clientId);
              requestHeaders.put("X-Naver-Client-Secret", clientSecret);
              String responseBody = get(apiURL,requestHeaders);


              
              JSONObject jo = new JSONObject(responseBody);
              response.setCharacterEncoding("UTF-8");
              response.setContentType("application/json");
              response.getWriter().print(jo);
        	}catch(Exception e) {e.printStackTrace();}
          }


          private static String get(String apiUrl, Map<String, String> requestHeaders){
              HttpURLConnection con = connect(apiUrl);
              try {
                  con.setRequestMethod("GET");
                  for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                      con.setRequestProperty(header.getKey(), header.getValue());
                  }


                  int responseCode = con.getResponseCode();
                  if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                      return readBody(con.getInputStream());
                  } else { // 에러 발생
                      return readBody(con.getErrorStream());
                  }
              } catch (IOException e) {
                  throw new RuntimeException("API 요청과 응답 실패", e);
              } finally {
                  con.disconnect();
              }
          }


          private static HttpURLConnection connect(String apiUrl){
              try {
                  URL url = new URL(apiUrl);
                  return (HttpURLConnection)url.openConnection();
              } catch (MalformedURLException e) {
                  throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
              } catch (IOException e) {
                  throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
              }
          }


          private static String readBody(InputStream body){
              InputStreamReader streamReader = new InputStreamReader(body);


              try (BufferedReader lineReader = new BufferedReader(streamReader)) {
                  StringBuilder responseBody = new StringBuilder();


                  String line;
                  while ((line = lineReader.readLine()) != null) {
                      responseBody.append(line);
                  }


                  return responseBody.toString();
              } catch (IOException e) {
                  throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
              }
          }
	}
