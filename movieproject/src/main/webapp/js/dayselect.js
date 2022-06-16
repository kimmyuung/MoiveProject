let datelist = [];
var date = new Date(); // 현재 날짜를 구함
$(document).ready(function() {


	
	var y = date.getFullYear();              //yyyy
    var m = (1 + date.getMonth());          //M
    var day = date.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
	
	
	
	
	var last = [31,28,31,30,31,30,31,31,30,31,30,31]; // 12월
	
	var lastDate = last[m]; // 현재 달의 날짜 수 판단
	
	if(y%4 && y % 100 != 0 || y % 400 == 0) { // 윤년
		lastDate = last[1] = 29; 
	}
	
	//var row=Math.ceil((theDay+lastDate)/ 7 );  필요한 행의 갯수
	
	let html = "";
	var dNum = 1;
	
	for(var i = day; i <=lastDate; i++) {
		html += '<button onclick="dayselect('+i+')" value="'+i+'">'+
				i + '일 ' + 
				'</button>';
	}
	
	$("#reserve-date").html(html);
	
	
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
function dayselect(i) {
	alert(i);
	 var m = (1 + date.getMonth());
	 
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