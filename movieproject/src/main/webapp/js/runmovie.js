let pass = [false, false, false, false];

$("#startdate").change(function() {

var date = new Date();
date = getFormatDate(date);
var sdate = $("#startdate").val();

if(date > sdate) {
	alert("현재 시간보다 빠르게 상영은 불가능합니다.");
	pass[0] = false;
	return;
}
else {
	pass[0] = true;
}
});

$("#enddate").change(function() {
var sdate = $("#startdate").val();
var edate = $("#enddate").val();
if(edate < sdate) {
	alert("상영 시작 시간보다 빠르게 상영의 종료는 불가능합니다.");
	pass[1] = false;
	return;
} else {
	pass[1] = true;
}
});

$("#etime").change(function() {

});

$(document).ready(function() {

	$.ajax({
		url: 'getmovielist',
		success: function(json) {
			let html = '<option value="0"> 영화를 선택해주세요 </option>'
			console.log(json);
			for (let i = 0; i < json.length; i++) {
				html += '<option value="' + json[i]["mtitle"] + '"> 영화제목 : ' + json[i]["mtitle"] +' / 상영시간 : '+ json[i]["mruntime"] + " 분</option>";
			}
			$("#moviebox").html(html);
		}
	});

	$.ajax({
		url: '../theater/gettheaterlist',
		success: function(json) {
			console.log(json);
			let html = '<option value="0"> 영화관을 선택해주세요 </option>'
			for (let i = 0; i < json.length; i++) {
				html += '<option value="' + json[i]["tname"] + '"> ' + json[i]["tname"] + "</option>";
			}
			$("#theaterbox").html(html);
		}
	
	});

});

function getFormatDate(date){
    var year = date.getFullYear();              //yyyy
    var month = (1 + date.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
    var day = date.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
    return  year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}

function runtimeadd() {
	let startdate = $("#startdate").val();
	let enddate = $("#enddate").val();
	let stime = $("#stime").val();
	let etime = $("#etime").val();

	alert(startdate + enddate);
	alert(stime + etime);

}