

$(document).ready(function() {

	
  $('#addFilm').click(function() {
    var name = $('#moviebox').val(); // 영화 이름
    var duration = parseInt($('#runtimebox').val()) * (5 / 3); /*must be in mins*/
    var dur = $('#runtimebox').val(); 
    var startTime = $('#timetableStart').val();

    /*get the hour*/
    var hour = parseInt($('#timetableStart').val()) * 100;
    /*get the minutes*/
    var min = $('#timetableStart').val();
    var res = min.split(":");
    var minute = parseInt(res[1]) / 60 * 100;
    var t = hour + parseInt(minute);
   	
    var screen = parseInt($('#theaterbox').val()) * 10;
    
    $('.timetable .layoutdesign').append("<span class='film' style='top:" + screen + "vh;left:calc(10vw + " + t + "px); width:" + duration + "px' data-start='" + startTime + "'>" + name + " -"+dur+"mins</span>");
  });

  $('.layoutdesign').on("click", ".film", function() {
    $(this).toggleClass("activeFilm");
    $('#deleteFilm').show();
  });
  $('#deleteFilm').click(function() {
    $('.activeFilm').remove();
    $(this).hide();
  });
 
 
	$.ajax({
		url: 'getmovielist',
		success: function(json) {
			let html = '<option value="0"> 영화를 선택해주세요 </option>'
			for (let i = 0; i < json.length; i++) {
				html += '<option value="' + json[i]["mtitle"] + '"> ' + json[i]["mtitle"]+ '</option>';
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

     $("#moviebox").change(function(){
             let mtitle = $("#moviebox").val();
            
            
             $.ajax({
				url : 'getmovie',
				data : {'mtitle' : mtitle},
				success : function(json) {
					console.log(json);
					 let time = '<input id="runtimebox" type="text" readonly="readonly" value="'+json["runtime"]+'"/>';
					$("#run").html(time);
				}
			}) 
               
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

function runtimeadd() {
	 var name = $('#moviebox').val(); // 영화 이름
    var duration = parseInt($('#runtimebox').val()) * (5 / 3); /*must be in mins*/
    var dur = $('#runtimebox').val(); 
    var startTime = $('#timetableStart').val();

    /*get the hour*/
    var hour = parseInt($('#timetableStart').val()) * 100;
    /*get the minutes*/
    var min = $('#timetableStart').val();
    var res = min.split(":");
    var minute = parseInt(res[1]) / 60 * 100;
    var t = hour + parseInt(minute);
   	
    var screen = parseInt($('#theaterbox').val()) * 10;
    
 
    $.ajax({
	url : 'runmovieadd',
	data : {'mname': name, 'starttime' : startTime, 'tname' : screen},
	success : function(re) {
		if(re == 1) {
			alert("상영영화 등록 성공!");
		}
		else {
			alert("상영영화 등록 실패!")
		}
	}	
	});
}

