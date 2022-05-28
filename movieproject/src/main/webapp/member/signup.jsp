<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.control-group input{
margin-top: 10px;
}
</style>
</head>
<body>
	<%@include file="../header.jsp"%>
	<div class="container">
		<div class="row-fluid">
			<div class="span12">
				<div class="span6">
					<div class="area">
						<form id="signupform" action="../signup" method="post">
							<div class="heading" style="text-align: center;">
								<h4 class="form-heading">회원 가입 페이지</h4> <br>
							</div>

							<div class="control-group" style="padding-left: 300px;">
								<label class="control-label">아이디(영문, 숫자 포함 5~15길이로 입력해주세요)</label>

								<div class="controls">
									<input type="text" id="mid" name="mid" placeholder="user id">
									<span id="idcheck"></span> 
								</div>
							</div>

							<div class="control-group" style="padding-left: 300px;">
								<br><label class="control-label" for="mpw">비밀번호 (영문, 숫자 5~15 사이로 입력)</label>

								<div class="controls">
									<input type="password" id="mpassword" name="mpassword" placeholder="user password"> 
								</div>
							</div>

							<div class="control-group" style="padding-left: 300px;">
								 <br> <label class="control-label" for="rempw">비밀번호 확인</label>

								<div class="controls">
									<input type="password" id="mpasswordcheck" placeholder="password check"> 
									<span id="passwordcheck"></span>
								</div>
							</div>
							
							<div class="control-group" style="padding-left: 300px;">
								<br><label class="control-label" for="mname">이름</label>

								<div class="controls">
									<input type="text" id="mname" name="mname" placeholder="user name">
									<span id="namecheck"></span>
								</div>
							</div>
							
							
							<div class="control-group" style="padding-left: 300px;">
								<br><label class="control-label" for="inputEmail">이메일</label>

								<div class="controls">
									<input type="text" id="memail" name="memail" placeholder="user email">
									@
									<input type="text" id="memailaddress" name="memailaddress" >
								<select id="emailselect">
									<option value=""> 직접입력 </option>
									<option value="naver.com"> naver.com </option>
									<option value="nate.com"> nate.com </option>
									<option value="daum.com"> daum.com </option>
									</select>
									<span id="emailcheck"></span>
								</div>
							</div>

							<div class="control-group" style="padding-left: 300px;">
							 <br>	<label class="control-label" for="inputUser">연락처</label>

								<div class="controls">
									<input type="text" id="mphone" name="mphone" placeholder="user phone">
									<span id="phonecheck"></span>
								</div>
							</div>
							<br>
							<div class="control-group" style="padding-left: 300px;"> 
							<br>
							<input type="text" id="sample4_postcode" name="address1" placeholder="우편번호">
							<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
							<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소">
							<input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소">
							<span id="guide" style="color:#999;display:none"></span> <br>
							<input type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소">
							<br>
							<span id="addresscheck"></span>
							</div>

							<div class="control-group" style="padding-left: 300px;">
								<div class="controls">
									<br><label class="checkbox"><input type="checkbox" name="accept" id="accept">
										나는 이젠 영화관의 <a href="../promise.jsp">이용약관</a>에 동의합니다.</label>
									<button onclick="signup()" type="button">가입하기</button>
									
									<span id="signupcheck"></span>
								</div>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="../js/signup.js" type="text/javascript"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> <br><br><br>
	<%@include file="../footer.jsp" %>
</body>
</html>