<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="#">
<link href="/JSPWEB/css/chatting.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp"%>

<%
String mid = (String)session.getAttribute("login");
%>

	<div class="container my-5">
		<!-- 박스권 -->
		<div class="col-sm-6 offset-3 chattingbox">
			<!-- 채팅 관련 구역 -->
			<div class="row">
			<%if( mid != null) { %>
				<div class="col-sm-4">
					<!--  접속자 목록 표시 -->
					<h5 class="member">접속자 목록</h5>
					<div class="memberlist" id="enterlist"> <!-- 접속자 명단 -->
					</div>
				</div>
				<%}  else {%>
				<div class="col-sm-4">
				<span> 로그인 후에 채팅방 유저 목록 확인이 가능합니다.</span>
				</div>
				<%} %>
				<div class="col-sm-8">
					<!-- 채팅창 -->
					<div class="contentbox" id="contentbox">
						<div class="send">
							<!-- 보낼 때 -->
							<span class="date">오전 00:00</span> <span class="content">내용</span>
						</div>
						<div class="alarm">
							<span> 강호동 님이 입장 하셨습니다.</span>
						</div>

						<div class="row g-0">
							<div class="col-sm-1 mx-2">
								<img alt="" src="../img/profile.jpg" class="rounded-circle"
									width="100%">
							</div>

							<div class="col-sm-9">
								<div class="receive">
									<!-- 받을 때 메시지 -->
									<div class="mname">강호동</div>
									<span class="content">내용</span> <span class="date">오전
										00:00</span>
								</div>
							</div>
						</div>

					</div>
					<input type="hidden" value="<%=mid %>" id="mid">
					<div class="row g-0">
						<!-- 입력 상자 혹은 전송 버튼 -->
						<div class="col-sm-10">
							<textarea id="incontent" rows="3" cols="" class="form-control" onkeyup="enterkey('<%=mid%>')"></textarea>
						</div>
						<div class="col-sm-2">
							<!-- 전송 버튼 -->
							<button class="sendbtn" onclick="sendbtn('<%=mid%>')">전송</button>
						</div>
					</div>
					<div>
					<span>이모티콘</span>
					<span>첨부파일</span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="../footer.jsp"%>
	<script src="/JSPWEB/js/chatting.js" type="text/javascript"></script>
</body>
</html>