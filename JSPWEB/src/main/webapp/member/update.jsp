<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp"%>
	<%String mid = (String)session.getAttribute("login");
			Member member = MemberDao.getmemberDao().getmember(mid);
			%>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
			<%@include file="infosidebar.jsp" %>
			</div>
			<div class="col-md-9">
			<%
					if( request.getParameter("result") != null 
							&& request.getParameter("result").equals("1") ){
				%>
					<div> 회원정보가 수정 되었습니다.!!! </div>
				<%
					}else if( request.getParameter("result") != null 
					&& request.getParameter("result").equals("2")  ){
				%>	
					<div> 회원정보가 실패!! 관리자에게문의 </div>
				
				<%
					}else if( request.getParameter("result") != null 
					&& request.getParameter("result").equals("2")  ){
				%>	
					<div> 회원정보가 실패!! 관리자에게문의 </div>
				<% 	
					}
				%>
				
			<h3>회원 수정</h3>
			<form action="../update" method="post"> <!-- update 서블릿 파일로 post 전송 -->
			<input type="hidden" value="<%=member.getMno()%>" name="mno">
			아이디 : <%=member.getMid() %> <br>
			비밀번호 : <button type="button" onclick="passwordchange()">비밀번호 변경</button>
			<div id="passwordbox" style="display: none;"> 
			기존 비밀번호 : <input type="password" name="oldpassword"><br>
			새로운 비밀번호 : <input type="password" name="newpassword">
			</div>
			이름 : <input type="text" value="<%=member.getMname() %>" name="mname">  <br>
			연락처 : <input type="text" value="<%=member.getMphone() %>" name="mphone">  <br>
			이메일 : <input type="text" value="<%=member.getMemail().split("@")[0] %>" name="memail"> @
			<select id="emailselect" name="memailaddress">
			<option value="">직접 입력</option>
			<option value="naver.com">naver.com</option>
			<option value="daum.net">daum.net</option>
			<option value="nate.com">nate.com</option>
			</select> <br><br>
			배송주소 :
			<input type="text" value="<%=member.getMaddress().split("_")[0] %>" id="sample4_postcode" name="address1" placeholder="우편번호"> <br><br>
			<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
			<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소" value="<%=member.getMaddress().split("_")[1] %>"> 
			<input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소" value="<%=member.getMaddress().split("_")[2] %>">
			<span id="guide" style="color:#999;display:none" class="text-white"></span>
			<input type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소" value="<%=member.getMaddress().split("_")[3] %>">
			<br>
			<button type="submit">변경적용</button>
			<a href="/JSPWEB/member/update.jsp"> 변경취소</a>
			</form>
			</div>
		</div>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../js/signup.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>
</body>
</html>