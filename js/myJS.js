$(window).load(function() {
	Get_pdsList_Ajax();
});

$(window).load(function() {
	Get_profileList_Ajax();
});

$('#myTab a').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	})
	
$('#myTab a[href="#profile"]').tab('show') // Select tab by name
$('#myTab a:first').tab('show') // Select first tab
$('#myTab a:last').tab('show') // Select last tab
$('#myTab li:eq(2) a').tab('show') // Select third tab (0-indexed)


var r_id2;

function r_idReport(r_id){
	
	r_id2 = r_id; 
	
}

function sendR_idReport(){
	var e = $('#e_content').val();
	
	$.ajax({
		type : 'POST',
		url : './send_report.do',
		dataType : '',
		data : {"r_id" : r_id2, "e_content" : e},
		async : true,
		success : function(result) {
			alert("정상적으로 신고 되었습니다.");
			location.reload(true);
		}
	});
}

function formChk(){
	var thumbext = document.getElementById('file').getAttribute('value');

	thumbext = thumbext.slice(thumbext.indexOf(".") + 1).toLowerCase(); //파일 확장자를 잘라내고, 비교를 위해 소문자로 만듭니다.

    if(document.mForm.r_title.value==''){
      alert("제목을 입력하세요");
      document.mForm.r_title.focus();
    }else if(document.mForm.r_content.value==''){
        alert("내용을 입력하세요");    
        document.mForm.r_content.focus();
    }else if(document.mForm.fileload.value==''){
        alert("파일을 추가하세요");    
        document.mForm.fileload.focus();
    }else if(thumbext != "mp4" || thumbext != "avi" ||  thumbext != "wmv" ||  thumbext != "mkv"){
    		
    	alert('mp4, avi, wmv, mkv 타입만 가능합니다.');
    	document.mForm.fileload.focus();
	 
    }else {
    	document.mForm.submit(); 
    }
}

function formChk_picture(){
    if(document.pForm.r_title.value==''){
      alert("제목을 입력하세요");
      document.pForm.r_title.focus();
    }else if(document.pForm.r_content.value==''){
        alert("내용을 입력하세요");    
        document.pForm.r_content.focus();
    }else if(document.pForm.fileload.value==''){
        alert("파일을 추가하세요");    
        document.pForm.fileload.focus();
    }else if(thumbext != "jpg" || thumbext != "png" ||  thumbext != "gif" ||  thumbext != "bmp"){
    		
    	alert('jpg, png, gif, bmp 타입만 가능합니다.');
    	document.pForm.fileload.focus();
	 
    } else{
       document.aForm.submit(); 
    }
}

function formChk_text(){
    if(document.textForm.r_title.value==''){
      alert("제목을 입력하세요");
      document.textForm.r_title.focus();
    }else if(document.textForm.r_content.value==''){
      alert("내용을 입력하세요");    
      document.textForm.r_content.focus();
    }else{
       document.textForm.submit(); 
    }
}

function formChk_audio(){
    if(document.aForm.r_title.value==''){
      alert("제목을 입력하세요");
      document.aForm.r_title.focus();
    }else if(document.aForm.r_content.value==''){
        alert("내용을 입력하세요");    
        document.aForm.r_content.focus();
    }else if(document.aForm.fileload.value==''){
        alert("파일을 추가하세요");    
        document.aForm.fileload.focus();
    }else if(thumbext != "mp2" || thumbext != "mp3" ||  thumbext != "wav" ||  thumbext != "mpeg"){
    		
    	alert('mp2, mp3, wav, mpeg 타입만 가능합니다.');
    	document.aForm.fileload.focus();
	 
    } else{
       document.aForm.submit(); 
    }
}

var typeCheck = function() {
	var thumbext = document.getElementById('file').getAttribute('value');

	thumbext = thumbext.slice(thumbext.indexOf(".") + 1).toLowerCase(); // 파일

	if (thumbext == "jpg" || thumbext == "png" || thumbext == "gif"
			|| thumbext == "bmp") { // 확장자를
		// 확인합니다.

		// alert('이미지 파일입니다.');

		alert("${dataType}");
		return;

	} else if (thumbext == "mp4" || thumbext == "avi" || thumbext == "wmv"
			|| thumbext == "mkv") {

		// alert('동영상 파일입니다.');

		alert("${dataType}");
		return;

	} else if (thumbext == "mp2" || thumbext == "mp3" || thumbext == "wav"
			|| thumbext == "mpeg") {

		// alert('음악 파일입니다.');

		alert("${dataType}");
		return;

	} else {

		// alert('알수없는 타입의 파일입니다.');

		alert("${dataType}");
		return;

	}
};

function Get_pdsList_Ajax() {
	$.ajax({
		type : 'POST',
		url : './pdslistGET.do',
		dataType : 'json',
		data : '',
		async : true,
		success : function(result) {
			$.each(result, function(key) {
				var list = result[key];
				var content = "<table>";
				for (var i = 0; i < list.length; i++) {
					content += "<tr>";
					content += "<td>" + list[i].r_id + "</td>";
					content += "<td>" + list[i].m_mail + "</td>";
					content += "<td>" + list[i].r_name + "</td>";
					content += "<td>" + list[i].r_link + "</td>";
					content += "<td>" + list[i].r_title + "</td>";
					content += "<td>" + list[i].r_type + "</td>";
					content += "<td>" + list[i].r_content + "</td>";
					content += "</tr>";
				}
				content += "<table>";
				$("#pdslist").html(content);
			});
		}
	});
}

$(window).scroll(function() {
	if ($(window).scrollTop() == $(document).height() - $(window).height()) {
		$('<h1>infinity Scroll</h1>').appendTo('H2#pagebottom');
	}
});

//('.like')
//		.die('click')
//		.live(
//				"click",
//				function() {
//					var ID = $(this).attr("id");
//					var sid = ID.split("like");
//					var New_ID = sid[1];
//					var REL = $(this).attr("rel");
//					var URL = 'resource_like_ajax.do';
//					var dataString = 'msg_id=' + New_ID + '&rel=' + REL;
//					$
//							.ajax({
//								type : "POST",
//								url : URL,
//								data : dataString,
//								cache : false,
//								success : function(html) {
//
//									if (REL == 'Like') {
//										$("#youlike" + New_ID)
//												.slideDown('slow')
//												.prepend(
//														"<span id='you"
//																+ New_ID
//																+ "'><a href='#'>You</a> like this.</span>.");
//										$("#likes" + New_ID)
//												.prepend(
//														"<span id='you"
//																+ New_ID
//																+ "'><a href='#'>You</a>, </span>");
//										$('#' + ID).html('Unlike').attr('rel',
//												'Unlike').attr('title',
//												'Unlike');
//									} else {
//										$("#youlike" + New_ID).slideUp('slow');
//										$("#you" + New_ID).remove();
//										$('#' + ID).attr('rel', 'Like').attr(
//												'title', 'Like').html('Like');
//									}
//
//								}
//							});
//				});

function deletePost(a, b) {
	if (confirm("포스트를 삭제 하시겠습니? ") == true) {
		location.href = "./deletePost.do?r_name=" + a + "&r_id=" + b;
	} else {
		return;
	}
}

function unfollow(a, b) {
	var json = 'm_mail=' + a + 'face_mail=' + b;

	if (confirm("정말 언팔로우 하시겠습니까? ") == true) {
		$.ajax({
			type : 'POST',
			url : './unfollow.do' + "?m_mail=" + a + "&face_mail=" + b,
			data : '',
			async : true,
			success : function(result) {
				// location.reload(true);
				alert("a");
			},
			error : function(xhr, status, e) { // 에러 발생시 처리함수
				// alert('Error');
				location.reload(true);
			},
		});
	} else {
		return;
	}
}


function follow2(a, b) {
	$.ajax({
		type : 'GET',
		url : './follow2.do' + "?m_mail=" + a + "&k_name=" + b,
		dataType : 'json',
		data : '',
		async : true,
		success : function(result) {
			// location.reload(true);
			alert("b");

		},
		error : function(xhr, status, e) { // 에러 발생시 처리함수
			// alert('Error');
			location.reload(true);
		}
	});
}


function unfollow2(a, b) {
	if (confirm("정말 언팔로우 하시겠습니까? ") == true) {
		$.ajax({
			type : 'POST',
			url : './unfollow2.do' + "?m_mail=" + a + "&k_name=" + b,
			data : '',
			async : true,
			success : function(result) {
				// location.reload(true);
				alert("a");
			},
			error : function(xhr, status, e) { // 에러 발생시 처리함수
//				alert('Error');
				location.reload(true);
			},
		});
	} else {
		return;
	}
}

$(function() {
	$(".delete").click(function() {
		var element = $(this);
		var I = element.attr("id");
		$('li#list' + I).fadeOut('slow', function() {
			$(this).remove();
		});
		return false;
	});
});

function follow(a, b) {
	$.ajax({
		type : 'GET',
		url : './follow.do' + "?m_mail=" + a + "&face_mail=" + b,
		dataType : 'json',
		data : '',
		async : true,
		success : function(result) {
			// location.reload(true);
			alert("b");

		},
		error : function(xhr, status, e) { // 에러 발생시 처리함수
			// alert('Error');
			location.reload(true);
		}
	});
}

function withdrawal(a) {
	if (confirm("정말 계정을 삭제 하시겠습니까? ") == true) {
		
		$.ajax({
			type : 'GET',
			url : './withdrawal.do' + "?m_mail=" + a,
			dataType : 'json',
			data : '',
			async : true,
			success : function(result) {
				// location.reload(true);
				alert("a");

			},
			error : function(xhr, status, e) { // 에러 발생시 처리함수
				location.reload(true);
			}
		});

	}
}

function previewImage(targetObj, View_area) {
	var preview = document.getElementById(View_area); //div id
	var ua = window.navigator.userAgent;

  //ie일때(IE8 이하에서만 작동)
	if (ua.indexOf("MSIE") > -1) {
		targetObj.select();
		try {
			var src = document.selection.createRange().text; // get file full path(IE9, IE10에서 사용 불가)
			var ie_preview_error = document.getElementById("ie_preview_error_" + View_area);


			if (ie_preview_error) {
				preview.removeChild(ie_preview_error); //error가 있으면 delete
			}

			var img = document.getElementById(View_area); //이미지가 뿌려질 곳

			//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동조절 하는 역할
			img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
		} catch (e) {
			if (!document.getElementById("ie_preview_error_" + View_area)) {
				var info = document.createElement("<p>");
				info.id = "ie_preview_error_" + View_area;
				info.innerHTML = e.name;
				preview.insertBefore(info, null);
			}
		}
  //ie가 아닐때(크롬, 사파리, FF)
	} else {
		var files = targetObj.files;
		for ( var i = 0; i < files.length; i++) {
			var file = files[i];
			var imageType = /image.*/; //이미지 파일일경우만.. 뿌려준다.
			if (!file.type.match(imageType))
				continue;
			var prevImg = document.getElementById("prev_" + View_area); //이전에 미리보기가 있다면 삭제
			if (prevImg) {
				preview.removeChild(prevImg);
			}
			var img = document.createElement("img"); 
			img.id = "prev_" + View_area;
			img.classList.add("obj");
			img.file = file;
			img.style.width = '300px'; 
			img.style.height = '300px';
			preview.appendChild(img);
			if (window.FileReader) { // FireFox, Chrome, Opera 확인.
				var reader = new FileReader();
				reader.onloadend = (function(aImg) {
					return function(e) {
						aImg.src = e.target.result;
				
					};
				})(img);
				reader.readAsDataURL(file);
			} else { // safari is not supported FileReader
				//alert('not supported FileReader');
				if (!document.getElementById("sfr_preview_error_"
						+ View_area)) {
					var info = document.createElement("p");
					info.id = "sfr_preview_error_" + View_area;
					info.innerHTML = "not supported FileReader";
					preview.insertBefore(info, null);
				}
			}
		}
	}
}

function updatePost(a){
	if (confirm("물품 상태를 거래완료로 변경 하시겠습니까? ") == true) {
		$.ajax({
			type : 'GET',
			url : './updatePost.do' + "?r_id=" + a,
			dataType : 'json',
			data : '',
			async : true,
			success : function(result) {
				// location.reload(true);
			},
			error : function(xhr, status, e) { // 에러 발생시 처리함수
				// alert('Error');
				location.reload(true);
			}
		});
	}
}

function joinCheck(){
	
	if(document.joinForm.m_mail.value==''||document.joinForm.m_mail.value==null){
		alert("이메일을 입력하세요");
		document.joinForm.m_mail.focus();
		return false;
	}else if(document.joinForm.m_password.value==''||document.joinForm.m_password.value==null){
		alert("이메일을 입력하세요");
		document.joinForm.m_password.focus();
		return false;
	}else if(document.joinForm.m_name.value==''||document.joinForm.m_name.value==null){
		alert("이름을 입력하세요");
		document.joinForm.m_name.focus();
		return false;
	}else if(document.joinForm.m_phone.value==''||document.joinForm.m_phone.value==null){
		alert("번호를 입력하세요");
		document.joinForm.m_phone.focus();
		return false;
	}else{		
		return true;
	}
	
}
