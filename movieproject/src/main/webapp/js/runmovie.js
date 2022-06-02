
$("#datepicker1").change(function() {

	var date = new Date();
	date = getFormatDate(date);
	var sdate = $("#datepicker1").val();

	if (date > sdate) {
		alert("현재 시간보다 빠르게 상영은 불가능합니다.");
		$('#datepicker1').datepicker('setDate', 'today');
		pass[0] = false;
		return;
	}
	else {
		pass[0] = true;
	}
});

$("#datepicker2").change(function() {
	var sdate = $("#datepicker1").val();
	var edate = $("#datepicker2").val();
	if (edate < sdate) {
		alert("상영 시작 시간보다 빠르게 상영의 종료는 불가능합니다.");
		pass[1] = false;

		return;
	} else {
		pass[1] = true;
	}
});

let starttime; // 다른 시간과의 비교를 위한 변수
$("#stime").change(function() {
	var tname = $("#theaterbox option:selected").val();
	let stime = $("#stime").val();

	$.ajax({
		url: 'gettimelist',
		data: { "tname": tname },
		success: function(json) {
			console.log(json);
			for (let i = 0; i < json.length; i++) {
				starttime += json[i]['starttime'];
			}
			alert(starttime);
		}
	})
});

$("#etime").change(function() {
	let stime = $("#stime").val();
	let etime = $("#etime").val();
	if (stime >= etime) {
		alert("영화 상영 시작 시간보다 종료 시간을 빨리 설정할 수 없습니다.");
		pass[2] = false;
	}
	else {
		pass[2] = true;
	}
});

$(document).ready(function() {

	new tempusDominus.TempusDominus(document.getElementById('datetimepicker1'), {
    display: { 
        components: {
            seconds: false,
            useTwentyfourHour: false,
        },
        icons: {
            type: 'icons',
            time: 'fa fa-solid fa-clock',
            date: 'fa fa-solid fa-calendar',
            up: 'fa fa-solid fa-arrow-up',
            down: 'fa fa-solid fa-arrow-down',
            previous: 'fa fa-solid fa-chevron-left',
            next: 'fa fa-solid fa-chevron-right',
            today: 'fa fa-solid fa-calendar-check',
            clear: 'fa fa-solid fa-trash',
            close: 'fas fa-solid fa-xmark'
        },
    },
});

new tempusDominus.TempusDominus(document.getElementById('datetimepicker2'), {
    display: { 
        components: {
            seconds: false,
            useTwentyfourHour: false,
        },
        icons: {
            type: 'icons',
            time: 'fa fa-solid fa-clock',
            date: 'fa fa-solid fa-calendar',
            up: 'fa fa-solid fa-arrow-up',
            down: 'fa fa-solid fa-arrow-down',
            previous: 'fa fa-solid fa-chevron-left',
            next: 'fa fa-solid fa-chevron-right',
            today: 'fa fa-solid fa-calendar-check',
            clear: 'fa fa-solid fa-trash',
            close: 'fas fa-solid fa-xmark'
        },
    },
});


	$.ajax({
		url: 'getmovielist',
		success: function(json) {
			let html = '<option value="0"> 영화를 선택해주세요 </option>'
			console.log(json);
			for (let i = 0; i < json.length; i++) {
				html += '<option value="' + json[i]["mtitle"] + '"> 영화제목 : ' + json[i]["mtitle"] + ' / 상영시간 : ' + json[i]["mruntime"] + " 분</option>";
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

function getFormatDate(date) {
	var year = date.getFullYear();              //yyyy
	var month = (1 + date.getMonth());          //M
	month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
	var day = date.getDate();                   //d
	day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
	return year + '-' + month + '-' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}

let pass = [false, false, false, false]; // 상영영화 유효성 검사 변수
function runtimeadd() {
	let startdate = $("#startdate").val();
	let enddate = $("#enddate").val();
	let stime = $("#stime").val();
	let etime = $("#etime").val();
	let tname = $("#theaterbox option:selected").val();
	let mname = $("#moviebox option:selected").val();

	for (let i = 0; i < 4; i++) {
		if (pass[i] == false) {
			alert("입력하지 않았거나 유효성 검사를 통과하지 못했습니다.");
			return;
		}
	}

	let runmoviejson = {
		startdate: startdate,
		enddate: enddate,
		stime: stime,
		etime: etime,
		tname: tname,
		mname: mname
	}

	alert(runmoviejson);
	$.ajax({
		url: 'addrunmovie',
		data: { 'runmoviejson': JSON.stringify(runmoviejson) },
		success: function(re) {
			alert(re);
			if (re == 1) {
				alert("상영 영화 등록 성공");
			}
			else { alert("상영 영화 등록 실패"); }
		}
	});

}