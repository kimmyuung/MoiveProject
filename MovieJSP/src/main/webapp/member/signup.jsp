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
	<div class="container">
		<div class="row-fluid">
			<div class="span12">
				<div class="span6">
					<div class="area">
						<form class="form-horizontal" id="signupform" name="signupform" action="../signup" method="post">
							<div class="heading">
								<h4 class="form-heading">회원 가입 페이지</h4>
							</div>

							<div class="control-group">
								<label class="control-label" for="mid">아이디(영문, 숫자 포함 5~15길이로 입력해주세요)</label>

								<div class="controls">
									<input type="text" id="mid" name="mid" placeholder="user id" >   
									<button type="button" onclick="idcheck()">아이디 중복 확인</button>
									<span id="idcheck"></span>
								</div>
							</div>

							<div class="control-group">
								<br><label class="control-label" for="mpw">비밀번호 (영문, 숫자 5~15 사이로 입력)</label>

								<div class="controls">
									<input id="mpw" name="mpw" placeholder="비밀번호" type="password">
								</div>
							</div>

							<div class="control-group">
								 <br> <label class="control-label" for="rempw">비밀번호 확인</label>

								<div class="controls">
									<input id="rempw" name="rempw" placeholder="비밀번호 확인" type="password"> <button onclick="passwordcheck()" type="button" >비밀번호 일치 확인</button>
									<span id="pwcheck"></span>
								</div>
							</div>
							
							<div class="control-group">
								<br><label class="control-label" for="mname">이름</label>

								<div class="controls">
									<input id="mname" name="mname" placeholder="이름" type="text">
								</div>
							</div>
							
							
							<div class="control-group">
								<br><label class="control-label" for="inputEmail">Email</label>

								<div class="controls">
									<input id="memail" name="memail" placeholder="이메일" type="email"> 
									@
									<input type="text" id = "memailaddress" name="memailaddress">
									<select id="addressbox" name="addressbox">
									<option value="">직접 입력</option>
									<option value="naver.com">naver.com</option>
									<option value="daum.net">daum.net</option>
									<option value="gmail.com">gmail.com</option>
									<option value="kakao.com">kakao.com</option>
									<option value="nate.com">nate.com</option>
									</select>
									<button onclick="emailcheck()" type="button">이메일 중복 체크</button>
								</div>
							</div>

							<div class="control-group">
							 <br>	<label class="control-label" for="inputUser">핸드폰</label>

								<div class="controls">
									<input id="mphone" name="mphone" placeholder="연락처" type="text"> 
									<span id="phonecheck"></span>
								</div>
							</div>
							<br>
							<div class="control-group">
								<div class="controls">
									<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br> <br>
									<input type="text" id="sample4_postcode" name="address1" placeholder="우편번호"> <br><br>
									<input type="text" id="sample4_roadAddress" name="address2" placeholder="도로명주소">
									<input type="text" id="sample4_jibunAddress" name="address3" placeholder="지번주소">
									<span id="guide" style="color:#999;display:none" class="text-white"></span>
									<input type="text" id="sample4_detailAddress" name="address4" placeholder="상세주소">
								</div>
							</div>

							<div class="control-group">
								<div class="controls">
									<br><label class="checkbox"><input type="checkbox" name="accept" id="accept">
										나는 이젠 영화관의 <a href="../promise.jsp">이용약관</a>에 동의합니다.</label>
									<button class="btn btn-success" type="submit">Sign Up</button>
									<button class="btn" type="button">Help</button>
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