gettheater();
getrunmovie();


function gettheater() {
	let tno = $("#tno").val();
	$.ajax({
		url: '../theater/gettheater',
		data: { "tno": tno },
		success: function(json) {
			console.log(json);
			let html = '';
			for (let i = 1; i < (json.tseat / 10); i++) {

				html +=
					'<div class="seatRowCont' + i + ' seatRowCont">' +
					'<div class="row" >' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'</div>' +
					'<div class="row">' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'<div class="seat" ></div>' +
					'</div>' +
					'</div>';
			}
			$("#seatCont").html(html);
			
			const allSeatCont = document.querySelectorAll("#seatCont .seat");
			let initialSeatValue = 0;
			allSeatCont.forEach((seat) => {
				const attr = document.createAttribute("data-seatid");
				attr.value = ++initialSeatValue;
				seat.setAttributeNode(attr);
			});

			const selectedSeatsHolderEl = document.getElementById("selectedSeatsHolder");

			const moviePriceEl = document.getElementById("moviePrice");

			const cancelBtnEL = document.getElementById("cancelBtn");

			const proceedBtnEl = document.getElementById("proceedBtn");

			const seatContEl = document.querySelectorAll("#seatCont .seat:not(.occupied)");

			let takenSeats = [];

			seatContEl.forEach((seat) => {
				seat.addEventListener("click", (e) => {
					let isSelected = seat.classList.contains("selected");

					let seatId = JSON.parse(seat.dataset.seatid);

					if (!isSelected) {
						seat.classList.add("selected");
						takenSeats.push(seatId);
						takenSeats = [...new Set(takenSeats)];
					} else if (isSelected) {
						seat.classList.remove("selected");

						takenSeats = takenSeats.filter((seat) => {
							if (seat !== seatId) {
								return seat;
							}
						});
					}
					updateSeats();
					updatePrice(moviePrice, takenSeats.length);
				});
			});

			function updateSeats() {
				selectedSeatsHolderEl.innerHTML = ``;

				takenSeats.forEach((seat) => {
					const seatHolder = document.createElement("div");
					seatHolder.classList.add("selectedSeat");
					selectedSeatsHolderEl.appendChild(seatHolder);

					seatHolder.innerHTML = seat;
				});

				if (!takenSeats.length) {
					const spanEl = document.createElement("span");
					spanEl.classList.add("noSelected");
					spanEl.innerHTML = `좌석이 선택되지 않았습니다.`;
					selectedSeatsHolderEl.appendChild(spanEl);
				}

				seatCount();
			}

			function seatCount() {
				const numberOfSeatEl = document.getElementById("numberOfSeat");
				numberOfSeatEl.innerHTML = takenSeats.length;
			}
			let totalprice;
			function updatePrice(price, seats) {
				const totalPriceEl = document.getElementById("totalPrice");
				let total = seats * mprice;
				totalprice = total;
				totalPriceEl.innerHTML = `${total} 원`;
			}

			cancelBtn.addEventListener("click", (e) => {
				cancelSeats();
			});

			function cancelSeats() {
				takenSeats = [];
				seatContEl.forEach((seat) => {
					seat.classList.remove("selected");
				});
				updatePrice(0, 0);
				updateSeats();
			}

			proceedBtnEl.addEventListener("click", (e) => {
				if (takenSeats.length) {
					location.href = "/movieproject/movie/orderpay.jsp?rno="+ $("#rno").val() + 
										"&date=" + $("#date").val() + "&tno=" + $("#tno").val() +
										"&seats=" + takenSeats + "&totalprice=" + totalprice;
				} else {
					alert("좌석을 선택해주세요");
				}
			});
			
		
			
		}
	});
}
let mprice;
function getrunmovie() {
	let rno = $("#rno").val();
	$.ajax({
		url: 'getrunmovie',
		data: { "rno": rno },
		success: function(json) {
			console.log(json);
			mprice = json.mprice;
			let html = json.mprice + '원';
			$("#moviePrice").html(html);
		}
	});
}
