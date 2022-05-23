let selectedSeats = new Array();
let selectedSeatsMap = [];
let clicked = "";
let div = "";
let seatWrapper = document.querySelector(".seat-wrapper");
let pass = [];

function tnamecheck() {

	
	let tname = $("#tname").val();
	alert(tname);
	$.ajax({
		url : 'tnamecheck',
		data : {'tname' : tname},
		success (re) {
			if(re == 1) {
				$("#tnamecheck").html("사용중인 영화관 이름입니다.");
				 pass = false;
			}
			else {
				$("#tnamecheck").html("사용가능한 영화관 이름입니다.");
				pass= true;
			}
		}
		
	});
	
}	


$("#seatselect").change(function() {

	  
	var value = $(this).val();	
	for (let i = 0; i < value / 10; i++) { // 영화관 줄
		div = document.createElement("div");
		seatWrapper.append(div);
		for (let j = 0; j < value / 10; j++) { // 영화관 열
			const input = document.createElement('input');
			input.type = "button";
			input.name = "seats"
			input.classList = "seat";
			//3중포문을 사용하지 않기위해 
			mapping(input, i, j);
			div.append(input);
			input.addEventListener('click', function(e) {
				console.log(e.target.value);
				//중복방지 함수
				selectedSeats = selectedSeats.filter((element, index) => selectedSeats.indexOf(element) != index);

				//click class가 존재할때(제거해주는 toggle)
				if (input.classList.contains("clicked")) {
					input.classList.remove("clicked");
					clicked = document.querySelectorAll(".clicked");
					selectedSeats.splice(selectedSeats.indexOf(e.target.value), 1);
					clicked.forEach((data) => {
						selectedSeats.push(data.value);
					});
					//click class가 존재하지 않을때 (추가해주는 toggle)
				} else {
					input.classList.add("clicked");
					clicked = document.querySelectorAll(".clicked");
					clicked.forEach((data) => {
						selectedSeats.push(data.value);
					});
				}
				console.log(selectedSeats);
			})
		}
	}

	function mapping(input, i, j) {
		if (i === 0) {
			input.value = "A" + j;
		} else if (i === 1) {
			input.value = "B" + j;
		} else if (i === 2) {
			input.value = "C" + j;
		} else if (i === 3) {
			input.value = "D" + j;
		} else if (i === 4) {
			input.value = "E" + j;
		} else if (i === 5) {
			input.value = "F" + j;
		} else if (i === 6) {
			input.value = "G" + j;
		}
		else if (i === 7) {
			input.value = "H" + j;
		}
		else if (i === 8) {
			input.value = "I" + j;
		}
		else if (i === 9) {
			input.value = "J" + j;
		}
	}

	$("#seat-wrapper").load(window.location.href + " #seat-wrapper");
	
});

$('.cinema-seats .seat').on('click', function() {
	$(this).toggleClass('active');
});

function readd() {
	location.reload();
}

function theateradd() {
	let tname = $("#tname").val();
	var value = $("#seatselect").val();
	let tjson = {
		tname : tname,
		value :value,
		location : selectedSeats
	}
	if(pass == false) {
		alert("영화관 이름 중복검사를 실행해주세요.")
		return;
		
	}
	else {
		
		
		
	$.ajax({
		url : 'theateradd',
		data : {'tjson' : JSON.stringify(tjson)},
		success : function(re) {
				alert("통신");
				if(re == 1) {
					alert("영화관 등록 성공");
				}	
				else {
					alert("영화관 등록 실패");
				}
		}
	});
	}
}
