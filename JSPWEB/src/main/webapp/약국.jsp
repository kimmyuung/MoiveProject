<%@page import="java.time.LocalTime"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Calendar"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>

<div class="conatiner">
<%
// 공공 데이터 포털
// 1. URL 가져오기 
URL url = new URL("https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?" +
		"page=1&perPage=100&serviceKey=0v4j1SLcrMq8t%2FgDgq2XJb%2B3vrEJqZOLCU5v9QM16XoaobLF%2FXewFasV%2F6pJMuBo6a6nKzn6APZe7%2B%2B6pOF5rg%3D%3D");
// 1. URL 클래스 : JAVA에서 HTTP URL 객체화
// 2. JAVA 해당 URL읽기[바이트 스트림]
	BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8") );
// 3. 읽어오기
String result = reader.readLine(); // 스트림내 존재하는 바이트 모두 읽어오기

// 4. 읽어온 스트림을 JSON 변환
JSONObject object = new JSONObject(result);
// 5. JSON객체에서 특정 키의 해당하는 데이터 가져오기
JSONArray array = (JSONArray)object.get("data");


%> 

<form action="약국.jsp">
<input type="text" name="keyword" placeholder="주소">
<input type="submit" value="검색">
</form>

<div id="map" style="width:100%;height:350px;"></div>

<table class="table">
<tr>
<th>약국명</th>
<th>대표전화</th>
<th>주소</th>
<th>월요일운영</th>
<th>화요일운영</th>
<th>수요일운영</th>
<th>목요일운영</th>
<th>금요일운영</th>
<th>토요일운영</th>
<th>일요일운영</th>
</tr>
<%
//영업여부 [ 자바에서 요일 구하기 ]
	Calendar calendar = Calendar.getInstance();
	// 요일 배열
	String [] day = {"일", "월", "화", "수", "목", "금", "토"};
	String present = day[ calendar.get(Calendar.DAY_OF_WEEK)-1 ];
	
	int hour = calendar.get( Calendar.HOUR_OF_DAY );	// HOUR : 01시  // HOUR_OF_DAY: 13시
	int minute = calendar.get( Calendar.MINUTE );
	LocalTime 현재시간 =  LocalTime.of( hour , minute  ,  0 ); // 현재 시간 
	
for(int i =0; i < array.length(); i++) {  
	JSONObject jo = array.getJSONObject(i);
	String keyword = request.getParameter("keyword");
if(keyword != null) { // 검색
	int index = jo.get("주소").toString().indexOf(keyword);
	if(index == -1) {continue;}
	// for, while : 1. break : 반복문 종료 / 2. continue : 반복문 재실행
}
	// iteratior : 인덱스가 없는 (set) 리스트를 순회하는 인터페이스   
	/* Iterator<JSONObject> iterator = jo.keys();
	while(iterator.hasNext() ) { // hasNext() : 다음 객체가 있는지 확인
		String key = iterator.next().toString();// next : 다음 객체 호출
		if(key.equals(present+"요일 운영") ) { // 현재 요일과 동일한 키만 호출
			jo.put("영업여부", jo.get(key));
		}
	} */
//1. JSONObject.getNames( json객체 ) : 해당 json객체내 모든 key 호출
			String[] keys =  JSONObject.getNames( jo );
			
			// 2. 영업여부 저장하는 변수 선언 
			String 영업여부 = "[영업종료]";
			
			// 3. 모든 key 반복문 돌려기 
			for( String key : keys ){
				// 4. 만약에 해당 key가 현재 요일 과 같으면서 -(영업시간없다.) 아니면
				if( key.equals(present+"요일 운영") && !jo.getString(key).equals("-") ){
					
					String[] 영업시간 = jo.getString(key).split("~");	//  ~ 기준으로 open , close
					
					
					if(  Integer.parseInt(  영업시간[1].split(":")[0] ) <= 24 ){
						LocalTime 여는시간 =  LocalTime.of(  
								Integer.parseInt( 영업시간[0].split(":")[0] )    , 
								Integer.parseInt( 영업시간[0].split(":")[1] ) , 0 );
						
						LocalTime 닫는시간 =  LocalTime.of(  
								Integer.parseInt( 영업시간[1].split(":")[0] )    , 
								Integer.parseInt( 영업시간[1].split(":")[1] ) , 0 );
						
						if( 현재시간.isAfter(여는시간) ){ // 현재시간이 여는시간보다 이후이면 
							영업여부 = "영업중:"+jo.getString(key); // 5. 영업여부에 시간 넣어주기 
							// 닫는시간 
							if( 현재시간.isAfter(닫는시간) ){ // 현재시간이 닫는시간보다 이후이면
							
								영업여부 = "[영업종료]";
							}
						}else{
							영업여부 = "[영업종료]";
						}
						
					}
					
				}
			}
%>

<tr style="font-size: 8px;" onclick="map('<%=jo.get("주소") %>', '<%=jo.get("약국명") %>', '<%=영업여부 %>' )">
<td><%=jo.get("약국명") %></td>
<td><%=jo.get("대표전화") %></td>
<td><%=jo.get("주소") %></td>
<td><%=jo.get("월요일 운영") %></td>
<td><%=jo.get("화요일 운영") %></td>
<td><%=jo.get("수요일 운영") %></td>
<td><%=jo.get("목요일 운영") %></td>
<td><%=jo.get("금요일 운영") %></td>
<td><%=jo.get("토요일 운영") %></td>
<td><%=jo.get("일요일 운영") %></td>
</tr>
<%} %>
</table>




</div>


<!-- services와 clusterer, drawing 라이브러리 불러오기 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=29bcc8162e3a352fe9e8b3712e8c632d&libraries=services,clusterer,drawing"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=29bcc8162e3a352fe9e8b3712e8c632d"></script>
<script src="/JSPWEB/js/kakaomap.js" type="text/javascript"></script>

</body>
</html>