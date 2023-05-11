
//Reply List 받아오기
var r_id2;
var p_m_mail2;
var l_m_mail2;

function replyList(r_id, p_m_mail, l_m_mail){
	   r_id2 = r_id;
	   p_m_mail2 = p_m_mail;
	   l_m_mail2 = l_m_mail;
	   
	   $.ajax({
	      type : 'POST',
	      url : './replyList.do',
	      dataType : 'json',
	      data : {"r_id" : r_id},
	      async : true,
	      success : function(replyList) {
	         var content = '<table>';
	         for(var i=0; i<replyList.length;i++){
	            
	            if(replyList[i].secretType==0){   //비밀댓글이 아니다.
	               content += '<tr>';
	               content += '<th width="100px">' + replyList[i].m_mail + '</th>';
	               
	               if(replyList[i].m_mail == l_m_mail){
//	                  content += '<td width="50px">'+'<input type="button" onclick="replyDelete('+replyList[i].id+')"/>' + '</td>';;
	                  content += '<td>'+'<a href="#" style="float:right;" onclick="return replyDelete('+replyList[i].id+');"><span class="glyphicon glyphicon-remove"></span></a>' + '</td>';;
	               }
	               content += '</tr>';
	               content += '<tr>';
	               content += '<td width="80%">' + replyList[i].content + '</td>';
//	               content += '</tr>';
//	               content += '<tr height="30px">';
	               content += '<td width="10px"><font color="#A4A4A4">' + replyList[i].mtime + '</font></td>';
	            }else{
	               
	                  content += '<tr>';
	                  content += '<th width="500px">' + replyList[i].m_mail + '</th>';
	                  
	                  if(replyList[i].m_mail == l_m_mail){
	                     content += '<td>'+'<div style="float:right;" onclick="return replyDelete('+replyList[i].id+');"><span class="glyphicon glyphicon-remove"></span></div>' + '</td>';;
	                  }
	                  content += '</tr>';
	                  content += '<tr>';
	                  //if 써서 포스트 메일주소랑 현재 로그인된 메일주소는 가능. 아니면 못봄.
	                  if(l_m_mail==replyList[i].m_mail || l_m_mail==p_m_mail){
	                     content += '<td width="80%"><span class="glyphicon glyphicon-lock"></span>&nbsp;' + replyList[i].content + '</td>';
	                  }else{
	                     content += '<td width="80%"><font color="#828282"><span class="glyphicon glyphicon-lock"></span>&nbsp;' + "비밀댓글입니다."+ '</font></td>';                     
	                  }
//	                  content += '</tr>';
//	                  content += '<tr height="30px">';
	                  content += '<td width="50px"><font color="#A4A4A4">' + replyList[i].mtime + '</font></td>';
	               content += '</tr>';
	            }
	         }
	         content += '</table>';
	         $("#replyList").html(content);
	         
	      }
	   });
	}

//Reply Data 넘기기
function sendReply(){
	
	var r_content = document.rForm.r_content.value;
	var flag = document.rForm.secret_reply.checked;
	
	if(r_content==""||r_content==null){
		alert("내용을 입력하세요.");
		return;
	}else{
	
	$.ajax({
		type : 'POST',
		url : './replyAdd.do',
		dataType : '',
		data : {"r_content" : r_content, "r_id" : r_id2, "r_flag" : flag},
		async : true,
		success : function(result) {
			replyList(r_id2, p_m_mail2, l_m_mail2);

		}
	});
	document.rForm.r_content.value = null;
	
	}
}

function replyDelete(id){//댓글아이디
	if (confirm("정말 삭제하시겠습니까??") == true){    //확인
		$.ajax({
			type : 'POST',
			url : './replyDelete.do',
			dataType : '',
			data : {"id" : id},
			async : true,
			success : function(result) {
				replyList(r_id2, p_m_mail2, l_m_mail2);
			}
		});
		
	}else{   //취소
	    return;
	}
	
}

