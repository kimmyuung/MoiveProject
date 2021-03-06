
$(function() {
		
	var date = new Date();
	var date2 = new Date();
	date = getFormatDate(date);
	date2 = nogetFormatDate(date2);
	
		$.ajax({
		method: "get",
		url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
		data: {
			targetDt: date,
			key: "aa00e29d76f425572e382e01cfb52950",
			itemPerPage: "10",
		}
	}).done(function(msg) {
		console.log(msg);
		$("#chart").append("<strong>" + msg.boxOfficeResult.boxofficeType + "</strong>");
		$("#date").append("<strong>" + msg.boxOfficeResult.showRange + "</strong>");
		for (var i = 0; i < msg.boxOfficeResult.dailyBoxOfficeList.length; i++) {
			console.log(msg);
			$("#rank"+i).append("<strong>" + msg.boxOfficeResult.dailyBoxOfficeList[i].rank + "</strong>");
			$("#title"+i).append("<strong>" + msg.boxOfficeResult.dailyBoxOfficeList[i].movieNm + "</strong>");
			$("#rankchange"+i).append("<strong>" + msg.boxOfficeResult.dailyBoxOfficeList[i].rankInten + "</strong>");
			$("#open"+i).append("<strong>" + msg.boxOfficeResult.dailyBoxOfficeList[i].openDt + "</strong>");
			$("#rate"+i).append("<strong>" + msg.boxOfficeResult.dailyBoxOfficeList[i].salesShare + "</strong>");
		}
	});
	getclock();
	currentdate.innerText = date2;
  	setInterval(getclock, 1000);
});
function KobisOpenAPIRestService(key, host) {
	this.key = key;
	this.host = host ? host : "http://www.kobis.or.kr";
	this.DAILY_BOXOFFICE_URI = "/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList";
	this.WEEKLY_BOXOFFICE_URI = "/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList";
	this.COM_CODE_LIST_URI = "/kobisopenapi/webservice/rest/code/searchCodeList";
	this.MOVIE_LIST_URI = "/kobisopenapi/webservice/rest/movie/searchMovieList";
	this.MOVIE_INFO_URI = "/kobisopenapi/webservice/rest/movie/searchMovieInfo";
	this.COMPANY_LIST_URI = "/kobisopenapi/webservice/rest/company/searchCompanyList";
	this.COMPANY_INFO_URI = "/kobisopenapi/webservice/rest/company/searchCompanyInfo";
	this.PEOPLE_LIST_URI = "/kobisopenapi/webservice/rest/people/searchPeopleList";
	this.PEOPLE_INFO_URI = "/kobisopenapi/webservice/rest/people/searchPeopleInfo";
}
function KobisOpenAPIError(message) {
	this.message = message;
}
KobisOpenAPIError.prototype = new Error;
KobisOpenAPIRestService.prototype.requestGet
	= function(key, host, serviceURI, isJson, paramMap) {
		var urlStr = host + serviceURI + (isJson ? '.json' : '.xml');
		var retVal = null;
		$.extend(paramMap, { key: this.key });
		$.ajax({
			type: "get",
			url: urlStr,
			data: paramMap,
			success: function(responseData) {
				retVal = responseData;
			},
			error: function(jqXHR, textStatus, err) {
				throw new KobisOpenAPIError(jqXHR.responseText);
			},
			dataType: isJson ? "json" : "xml",
			async: false
		});
		return retVal;
	};
KobisOpenAPIRestService.prototype.getDailyBoxOffice
	= function(isJson, paramMap) {
		return this.requestGet(this.key, this.host, this.DAILY_BOXOFFICE_URI, isJson, paramMap);

	};
KobisOpenAPIRestService.prototype.getWeeklyBoxOffice
	= function(isJson, paramMap) {
		return this.requestGet(this.key, this.host, this.WEEKLY_BOXOFFICE_URI, isJson, paramMap);

	};
KobisOpenAPIRestService.prototype.getComCodeList
	= function(isJson, paramMap) {
		return this.requestGet(this.key, this.host, this.COM_CODE_LIST_URI, isJson, paramMap);

	};
KobisOpenAPIRestService.prototype.getMovieList
	= function(isJson, paramMap) {
		return this.requestGet(this.key, this.host, this.MOVIE_LIST_URI, isJson, paramMap);

	};

KobisOpenAPIRestService.prototype.getMovieInfo
	= function(isJson, paramMap) {
		return this.requestGet(this.key, this.host, this.MOVIE_INFO_URI, isJson, paramMap);

	};
KobisOpenAPIRestService.prototype.getCompanyList
	= function(isJson, paramMap) {
		return this.requestGet(this.key, this.host, this.COMPANY_LIST_URI, isJson, paramMap);

	};

KobisOpenAPIRestService.prototype.getCompnayInfo
	= function(isJson, paramMap) {
		return this.requestGet(this.key, this.host, this.COMPANY_INFO_URI, isJson, paramMap);

	};
KobisOpenAPIRestService.prototype.getPeopleList
	= function(isJson, paramMap) {
		return this.requestGet(this.key, this.host, this.PEOPLE_LIST_URI, isJson, paramMap);

	};

KobisOpenAPIRestService.prototype.getPeopleInfo
	= function(isJson, paramMap) {
		return this.requestGet(this.key, this.host, this.PEOPLE_INFO_URI, isJson, paramMap);

	};
function getclock() {
  const date = new Date();
  const hour = String(date.getHours()).padStart(2,"0");
  const minutes = String(date.getMinutes()).padStart(2,"0");
  const second = String(date.getSeconds()).padStart(2,"0");//number?????? ????????? padStart ?????? ??? ??????. String ????????????????????????.
  clock.innerText = `${hour}:${minutes}:${second}`;
  
}	

function getFormatDate(date){
    var year = date.getFullYear();              //yyyy
    var month = (1 + date.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month ???????????? ??????
    var day = date.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day ???????????? ??????
    return  year + '' + month + '' + day-1;       //'-' ???????????? yyyy-mm-dd ?????? ?????? ??????
}


function nogetFormatDate(date){
    var year = date.getFullYear();              //yyyy
    var month = (1 + date.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month ???????????? ??????
    var day = date.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day ???????????? ??????
    return  year + '-' + month + '-' + day;       //'-' ???????????? yyyy-mm-dd ?????? ?????? ??????
}