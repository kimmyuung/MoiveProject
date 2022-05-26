$(function(){
	timer = setInterval( function() {
	$.ajax({
		url : "../chatreceive",
		cache : false,
		success : function(result){
			var co =  result.split(",");
			var contents = "";
			 for( var i = 0 ; i<co.length-1 ; i++ ){
						contents += 
					 '<div class="box" style="style="border: 1px solid black;"">'+
						'<div class="nicname" style="color: black;">'+co[i].split("_")[0]+'</div>'+
						'<div class="content">'+co[i].split("_")[1]+'</div>'+
						'<div class="date">'+co[i].split("_")[2].split(" ")[1]+'</div>'+
					'</div>'
					
				}
				$("#contentlist").html( contents );
				$('#contentlist').scrollTop($('#contentlist')[0].scrollHeight);
		}
	});
	}, 100);
	
	
});

function send(){
	let cname = $("#nicname").val();
	let ccontent = $("#content").val();
	$.ajax({
		url : "../chatting",
		data: {"cname" : cname, "ccontent" : ccontent},
		success : function(result){
			if(result) {}
			else {}
			$("#content").val("");
		}
	});
}