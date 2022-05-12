



 $("#seats").change(function(){
            var str_html = '';
            var seat = $("#seats").val();
            // 버튼을 10개 추가한다.
            for (var i = 1; i < seat; i++) {
                var html_btn = '<button type="button" class="btn btn-success m-1" id="btn" style="width:100px">버튼{}</button>';
                html_btn = html_btn.replace('{}', i);
                str_html = str_html + html_btn;
            }
            
            $('#div_btn').html(str_html);
            
            // 버튼을 동적연결한다.
            $(document).on("click", "#btn", function(){
                var idx = $(this).index();
                
                alert('버튼 {}을 눌렀습니다.'.replace('{}', idx))
            });
            
        });
   



