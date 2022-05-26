let selectedSeats = new Array();
let selectedSeatsMap = [];
let clicked = "";
let div = "";
let seatWrapper = document.querySelector(".seat-wrapper");
let pass = [];

function tnamecheck() {

	
	let tname = $("#tname").val();
	
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
	var tseat = $("#seatselect").val();
	let select = "";	
	
	
	for(let i = 0; i < selectedSeats.length; i++) {
		select += selectedSeats[i] + ",";
	}
	select = select.replace(/,\s*$/, "");
	if(pass == false) {
		alert("영화관 이름 중복검사를 실행해주세요.")
		return;
	}
	else {

	$.ajax({
		url : 'theateradd',
		data : {'tname' : tname, 'tseat' : tseat, 'select' : select},
		success : function(re) {
				alert(re);
				if(re == 1) {
					alert("영화관 등록 성공");
					location.href = '/movieproject/theater/theaterlist.jsp';
				}	
				else {
					alert("영화관 등록 실패");
				}
		}
	});
	}
}

function theaterupdate(tnum) {
	let tname = $("#tname").val();
	var tseat = $("#seatselect").val();
	let select = "";	
	alert(tname);
	alert(tseat);
	for(let i = 0; i < selectedSeats.length; i++) {
		select += selectedSeats[i] + ",";
	}
	select = select.replace(/,\s*$/, "");
	
	$.ajax({
		url : 'theaterupdate',
		data : {'tnum' : tnum, 'tseat' : tseat, 'select' : select},
		success : function(re) {
			if(re == 1) {
				alert("영화관 수정 완료");
				location.href = '/movieproject/theater/theaterlist.jsp';
			}
			else {
				alert("영화관 수정 실패");
				
			}
		}
 	});
	
}

function theaterdelete(tnum) {
	if(confirm("정말 삭제하시겠습니까?")){
	$.ajax({
		url : 'theaterdelete',
		data : {'tnum' : tnum},
		success : function(re) {
			if(re == 1) {
				alert("삭제가 완료되었습니다.");
				location.href = '/movieproject/theater/theaterlist.jsp';
			}
			else {
				alert("삭제 실패!");
			}
		}
	});	
	}
	else {
		alert("삭제가 취소되었습니다.");
		return;
	}
}