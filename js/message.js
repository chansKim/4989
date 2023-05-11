var error_email = "이메일을 입력하세요";

function searchMail(){
	var face_mail = document.textForm.face_mail.value;
	$.ajax({
		type : 'POST',
		url : './search_email.do',
		dataType : 'json',
		data : {"face_mail" : face_mail},
		async : true,
		success : function(result) {
			
			var content=' ';
			var a='';
			if(result==0){
				content+='<div name="mail"><font color="#AA1212">'+"미등록 메일입니다."+'</font></div>';	
				a += '<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>';
			}else{
				content+='<font color="#050099">'+"등록된 메일입니다."+'</font>';
				a += '<button type="submit" class="btn btn-primary">보내기</button><button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>';
			}
			
			$("#submit_button").html(a);
			$("#m_message").html(content);
		}
	});
}

$(document).ready(function(){
    $("#n").hide();
});
