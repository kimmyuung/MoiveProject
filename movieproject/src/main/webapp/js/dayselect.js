let datelist;
$(document).ready(function() {

	const date = new Date();
	// console.log(date.getFullYear());
	const lastDay = new Date(date.getFullYear(), date.getMonth() + 1, 0);
	const reserveDate = document.querySelector(".reserve-date");


	const weekOfDay = ["일", "월", "화", "수", "목", "금", "토"]
	const year = date.getFullYear();
	const month = date.getMonth();
	for (i = date.getDate(); i <= lastDay.getDate(); i++) {

		const button = document.createElement("button");
		const spanWeekOfDay = document.createElement("span");
		const spanDay = document.createElement("span");

		//class넣기
		button.classList = "movie-date-wrapper"
		spanWeekOfDay.classList = "movie-week-of-day";
		spanDay.classList = "movie-day";

		//weekOfDay[new Date(2020-03-날짜)]
		const dayOfWeek = weekOfDay[new Date(year + "-" + month + "-" + i).getDay()];

		//요일 넣기
		if (dayOfWeek === "토") {
			spanWeekOfDay.classList.add("saturday");
			spanDay.classList.add("saturday");
		} else if (dayOfWeek === "일") {
			spanWeekOfDay.classList.add("sunday");
			spanDay.classList.add("sunday");
		}
		spanWeekOfDay.innerHTML = dayOfWeek;
		button.append(spanWeekOfDay);
		//날짜 넣기
		spanDay.innerHTML = i;
		button.append(spanDay);
		//button.append(i);
		reserveDate.append(button);

		dayClickEvent(button);
	}
	function dayClickEvent(button) { // 일을 클릭했을 때
		button.addEventListener("click", function() { // 이벤트
			const movieDateWrapperActive = document.querySelectorAll(".movie-date-wrapper-active");
				
			movieDateWrapperActive.forEach((list) => {
				list.classList.remove("movie-date-wrapper-active");
			
			})
			console.log( movieDateWrapperActive );
			button.classList.add("movie-date-wrapper-active");
		})
		
		
	}
    getrunmovielist();
});


function getrunmovielist() {
	  $.ajax({
		url: 'runmovielist',
		success: function(json) {
			if(json != null) {
			console.log(json);
			let html = '<tr>' +
			'<th>영화 이름</th>' +
			'<th>러닝 타임</th>' +
			'</tr>';
			
			for(let i = 0; i < json.length; i++) {
				html += 
				'<tr>' +
				'<td onclick="movieselect('+json[i]["mno"]+')">' + json[i]["mtitle"] + '</td>' +
				'<td>' + json[i]["mruntime"] + '</td>' +
				'</tr>';				
				}
				$('#moviebox').html(html);
			}
			else {
				
			}
		}
	});
}
let mnum;
let tnum;
let rnum;
function movieselect(mno) {
	mtitle = mno;
	
	
	$.ajax({
		url : 'runtheaterlist',
		data : {"mno" : mno},
		success : function(js){
			console.log(js);
			let html = "";
			let html2 = "";
			if(js != null) {
			for(let i = 0; i < js.length; i++) {
				html += '<div onclick="theaterselect('+js[i]["tno"]+')"> '+js[i]["tname"]+'</div>'
				html += '<div onclick="timeselect('+js[i]["rno"]+')"> 시작시간 : '+js[i]["starttime"]+'</div>';
				}
			}
			else {
				html += '<div> 현재 상영 중인 관이 없습니다.</div>'
			}
			$("#theaterbox").html(html);
			$("#timebox").html(html2);
		}
	});	
}
function theaterselect(tno){
	tnum = tno;
}
function timeselect(rno) {
	rnum = rno;	
}
function seatchoice() {
	if(mnum = "") {
		alert("영화를 선택해주세요");
		return;
	}
	if(tnum = "") {
		alert("영화관을 선택해주세요");
		return;
	}
	location.href = "/movieproject/movie/seatchoice_2.jsp?rno="+rnum;
}