function findid(){
	let mname = $("#mname").val();  // jquery 식
	let mphone = $("#mphone").val();  // jquery 식
	
	$.ajax({
				url : "../findid" , // 보내는 위치 [ 서블릿 경로 ]
				data : { "mname" : mname , "mphone" : mphone } , // 보내는 데이터  { "변수명" : 값 }
				success : function( result ){ // 통신 성공 했을경우 (  result = 받은 값 변수 )
					if( result != null ){ // 만약에 받은 데이터가 1이면
						alert("아이디 찾기 성공");
					}else{ // 만약에 받은 데이터가 1이 아니면
						
					}
				}
			});
	
	
}
function findid(){
	let mname = $("#mname").val();  // jquery 식
	let mphone = $("#mphone").val();  // jquery 식
	let mid = $("mid").val();
	$.ajax({
				url : "../findid" , // 보내는 위치 [ 서블릿 경로 ]
				data : { "mname" : mname , "mphone" : mphone , "mid" : mid} , // 보내는 데이터  { "변수명" : 값 }
				success : function( result ){ // 통신 성공 했을경우 (  result = 받은 값 변수 )
					if( result == 1 ){ // 만약에 받은 데이터가 1이면
					
					}else{ // 만약에 받은 데이터가 1이 아니면
						
					}
				}
			});
	
	
}