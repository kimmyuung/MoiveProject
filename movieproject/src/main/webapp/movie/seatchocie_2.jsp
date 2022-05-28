<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/movieproject/css/seatchoice_2.css" rel="stylesheet">
</head>
<body>
	<section id="section">
		<div class="container">
			<!-- leftCont -->
			<div class="leftCont">
				<div class="leftMainCont">
					<div class="legendContainer">
						<ul>
							<li>
								<div class="seat legend"></div> <small>예약이 가능한 좌석</small>
							</li>
							<li>
								<div class="seat legend selected"></div> <small>선택한 좌석</small>
							</li>
							<li>
								<div class="seat legend occupied"></div> <small>예약이 불가능한 좌석</small>
							</li>
						</ul>
					</div>
					<!-- seat Container -->
					<div class="mainSeatCont">
						<div class="screen">
							<small>SCREEN</small>
						</div>
						<!-- 반목문을 통해 추출할 예정 -->
						<div class="seatCont" id="seatCont">
							<div class="seatRowCont1 seatRowCont">
								<div class="row">
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
								</div>
								<div class="row">
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
								</div>
							</div>
							<div class="seatRowCont2 seatRowCont">
								<div class="row">
									<div class="seat"></div>
									<div class="seat occupied"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
								</div>
								<div class="row">
									<div class="seat"></div>
									<div class="seat occupied"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
								</div>
								<div class="row">
									<div class="seat"></div>
									<div class="seat occupied"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
								</div>
								<div class="row">
									<div class="seat"></div>
									<div class="seat occupied"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
								</div>
							</div>
							<div class="seatRowCont3 seatRowCont">
								<div class="row">
									<div class="seat"></div>
									<div class="seat occupied"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
								</div>
								<div class="row">
									<div class="seat"></div>
									<div class="seat occupied"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
									<div class="seat"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Right Cont -->
			<div class="rightCont">
				<div class="confirmCont">
					<div class="rightTopCont">
						<!-- moviename -->

						<div class="movieInfo">
							<div class="selectMovie">
								<label>
									<p>영화를 선택해주세요</p> <select id="selectMovie"></select>
								</label>
							</div>
							<div class="movieName">
								<p>영화 제목</p>
								<h1 id="movieName">Tom and Jerry</h1>
							</div>
							<div class="moviePrice">
								<p>MOVIE PRICE</p>
								<h1 id="moviePrice">$ 7</h1>
							</div>
							<div class="dateCont">
								<p>Date</p>
								<p class="dateOn">2022-05-28</p>

							</div>
						</div>
					</div>
					<div class="rightBottomCont">
						<div class="selectedSeatCont">
							<p>SELECTED SEATS</p>
							<div class="selectedSeatsHolder" id="selectedSeatsHolder">
								<span class="noSelected">No Seat Selected</span>
							</div>
						</div>
						<!-- Seat number and price -->

						<div class="numberOfSeatsCont">
							<div class="numberOfSeatEl">
								<p>
									<span id="numberOfSeat">0</span> Seats(s)
								</p>
							</div>
							<div class="priceCont">
								<p id="totalPrice">$ 0</p>
							</div>
						</div>
						<!-- button Cont -->

						<div class="buttonCont">
							<div class="cancelBtn">
								<button id="cancelBtn">Cancel</button>
							</div>
							<div class="proceedBtnEl">
								<button id="proceedBtn">Continue</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script src="/movieproject/js/seatchocie.js" type="text/javascript"></script>
</body>
</html>