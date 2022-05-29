<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/movieproject/css/moviedetail.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp"%>
	<section id="new">
		<div class="container">
			<div class="row">
				<div class="new">
					<h2>영화 상세 정보</h2>
					<div class="new_left">
						<div class="play">
							<svg version="1.1" id="Layer_1"
								xmlns="http://www.w3.org/2000/svg"
								xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
								viewBox="0 0 120 120"
								style="enable-background: new 0 0 120 120;" xml:space="preserve">
                                <circle class="st0" cx="60" cy="60.4"
									r="56" />
                                <path class="st1"
									d="M81,65.4c4.8-2.8,4.8-7.2,0-10L53.5,39.6c-4.8-2.8-8.7-0.5-8.7,5v31.7c0,5.5,3.9,7.8,8.7,5L81,65.4z" />
                            </svg>
						</div>
					</div>
					<div class="new_right">
						<h3 class="title">영화 제목</h3>
						<span class="release">2016년 10월 28일 개봉</span>
						<div class="star">
							<span class="icon star1"></span> <span class="icon star1"></span>
							<span class="icon star1"></span> <span class="icon star2"></span>
							<span class="icon star0"></span> <strong>7.5/10</strong>
						</div>
						<ul class="summary">
							<li class="genre"><span class="bar">액션</span><span>미국,
									오스트레일리아</span></li>
							<li class="age"><span class="bar">142분</span><span>12세
									이상 관람가</span></li>
							<li class="desc">단숨에 행성 하나를 파괴할 위력을 지닌 데스 스타가 완성되기 전에 설계도를
								훔쳐내야 하는 이번 작전의 성공 확률은 고작 2.4%. 생사도 모르는 아버지에 얽힌 비밀을 밝히려는 진을
								...비롯해 유능한 정보 요원 ‘카시안’(디에고 루나), 두 눈이 멀었지만 탁월한 무술 실력을 지닌
								‘치루트’(견자단), 전투 베테랑 ‘베이즈’, 파일럿 ‘보디’, 시니컬한 드로이드 ‘K-2SO’까지 합류, 거대한
								전쟁을 끝낼 ‘로그 원’이 이끄는 가장 비밀스런 작전이 시작되는데…</li>
						</ul>
						<div class="select">
							<div class="s1">
								<lable for="udate" class="ir_so">날짜</lable>
								<input type="text" id="udate" name="udate" value="2019년 1월 25일"
									class="ui_select2">
							</div>
							<div class="s2">
								<label for="utime" class="ir_so">시간</label> <select id="utime"
									name="utime" class="ui_select2">
									<option value="오전 0:00">오전 0:00</option>
									<option value="오전 1:00">오전 1:00</option>
									<option value="오전 2:00">오전 2:00</option>
									<option value="오전 3:00">오전 3:00</option>
									<option value="오전 4:00">오전 4:00</option>
									<option value="오전 5:00">오전 5:00</option>
									<option value="오전 6:00">오전 6:00</option>
									<option value="오전 7:00">오전 7:00</option>
									<option value="오전 8:00">오전 8:00</option>
									<option value="오전 9:00">오전 9:00</option>
									<option value="오전 10:00">오전 10:00</option>
									<option value="오전 11:00">오전 11:00</option>
									<option value="오전 12:00">오전 12:00</option>
									<option value="오후 1:00">오후 1:00</option>
									<option value="오후 2:00">오후 2:00</option>
									<option value="오후 3:00">오후 3:00</option>
									<option value="오후 4:00">오후 4:00</option>
									<option value="오후 5:00">오후 5:00</option>
									<option value="오후 6:00">오후 6:00</option>
									<option value="오후 7:00">오후 7:00</option>
									<option value="오후 8:00">오후 8:00</option>
									<option value="오후 9:00">오후 9:00</option>
									<option value="오후 10:00">오후 10:00</option>
									<option value="오후 11:00">오후 11:00</option>
									<option value="오후 12:00">오후 12:00</option>
								</select>
							</div>
						</div>
						<div class="btn">
							<a href="#" class="white">좌석확인</a> <a href="#" class="purple">예매하기</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	
	<div class="container">
	<h2>영화 댓글 </h2>
	<div class="row"> <!-- row : 가로배치 -->
			<div class="col-md-10">
				<textarea id="rcontent" class="form-control" rows=3></textarea>
			</div>
			<div class="col-md-2">	<!-- p : padding   /   m : margin -->
				<button class="form-control py-4 my-1" onclick="replywrite()">등록</button>
			</div>
		</div>
		<!-- ----------------------------댓글 출력 ------------------ -->
		
		<table id="replytable" class="table" > <!-- 댓글 작성 성공시 해당 태그 새로고침 => js( jquery ) -->
			<tr>
				<td class="replywriter" width="15%">
					댓글 작성자 
					<span class="replydate"> 댓글 작성 날짜 </span>
				</td>
				
				<td width="80%" colspan="2">
					댓글 내용 <br> 
				<!-- 댓글 작성 회원만 보이는 버튼 -->
					<button class="btn replybtn" onclick="replyupdateshow()"> 수정 </button>
					<button style="display: none;" id="updatecontext" class="btn replybtn" onclick="replyupdate()" >수정 완료</button>
					<textarea style="display: none;" id="updatecontent"></textarea>
					<button type="button" class="btn replybtn" onclick="replydelete()"> 삭제 </button>
				
				
					<button class="btn replybtn" onclick="rereplyview()"> 
						대댓글 목록										<!-- js메소드에 인수 넣을때 문자열 ' '처리 //  숫자형 제외 --> 
					</button>
				</td>
			</tr>
			
			<tr> <!-- 대댓글 입력창 -->
				<td> </td>
				<td colspan="2" id= > </td>   <!-- 해당 태그의 id값을 변수로 설정 = 댓글번호 ( 댓글 한개당 1개씩 ) -->
			</tr>
			
			<!-- 대댓글 출력창  -->
				<tr>
					<td></td>
					<td width="10%" class="replywriter">
						대댓글 작성회원 <br> 
						<span class="replydate"> 대댓글 작성 날짜 </span>
					</td>
					<td width="80%">
						대댓글 내용 <br> 
					<!-- 대댓글 작성 회원만 보이는 버튼 -->
						<button class="btn replybtn" onclick="rereplyupdateshow()"> 수정 </button>
						<button style="display: none;" id="reupdatecontext" class="btn replybtn" onclick="rereplyupdate()" >수정 완료</button>
						<textarea style="display: none;" id="reupdatecontent"></textarea>
						<button class="btn replybtn" onclick="replydelete()"> 삭제 </button>
					
					</td>
				</tr>
				
			
		</table>
	</div>
	<script src="/movieproject/js/moviedetail.js" type="text/javascript"></script>
	
	<%@include file="../footer.jsp"%>
</body>
</html>