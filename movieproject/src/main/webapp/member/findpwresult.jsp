<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../header.jsp" %>


<%
 request.setCharacterEncoding("UTF-8");
    	String name = request.getParameter("member_name");
     	String email = request.getParameter("member_email");
     	String id = request.getParameter("member_id");
		MemberDao dao = new MemberDao();
 		String member_mpw = dao.findpw(id, name, email); //아이디를 디비에서 가져옴..실패시 널
 		System.out.println(name);
 		System.out.println(email);
 		System.out.println(id);
 		System.out.println(member_mpw);
%>

<br><br><br><br><br>
  <form name="pwsearch" method="post">
      <%
       
      if (member_mpw != null) {
      %>
      
      <div class = "container">
      	<div class = "found-success">
	      <h4>  회원님의 비밀번호는 </h4>  
	      <div class ="found-pw"><%=member_mpw%></div>
	      <h4>  입니다 </h4>
	     </div>
	     <div class = "found-login">
 		    <a href="login.jsp">로그인</a>
       	</div>
       </div>
      <%
  } else {
 %>
        <div class = "container">
      	<div class = "found-fail">
	      <h4>  등록된 정보가 없습니다 </h4>  
	     </div>
	     <div class = "found-login">
 		    <input type="button" id="btnback" value="다시 찾기" onClick="history.back()"/>
 		    <a href="signup.jsp">회원가입</a>
       	</div>
       </div>
       
    <div class = "adcontainer">
	<a href="#" ><img src = "../images/casead.png" /></a>                
</div>   
       <%
  }
 %> 
      </form>
     
      <%@include file="../footer.jsp" %>
</body>
</html>