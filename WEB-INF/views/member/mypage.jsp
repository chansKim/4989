<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>4989.</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/main_style.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/search_style.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/js/myJS.js"></script>

<style>
td{
padding:5px;
font-family : Serif;
color :#585858;
}
</style>

</head>
<body>
	<%@include file="loginSession.jsp"%>
	<%@include file="../menu.jsp"%>
<div class="container2">
<div class="CEN">
<div class="dashboard">
	
	<table width="70%" class="dashboard_table" align="center" >
	<tr>
	<td bgcolor="white">
	
	<table class="dashboard_table" width="100%" align="center">

		<tr>
		<td width="65%" align="center" height="300px" bgcolor="#48cfae" colspan="2">
		<font color="white">${login.m_mail }</font>
		<a href="#profile_back_photo" class="btn btn-defult" data-toggle="modal">
		<c:choose>
		<c:when test="${login.m_back_photo eq -1}">
		<img src="http://blue564.cafe24.com/upload/default_background.jpeg" alt="profile_back_picture" width="100%" height="100%" class="img-rounded">
		</c:when>
		<c:otherwise>
		<img src="${pageContext.request.contextPath}/upload/${login.m_back_photo}" alt="profile_back_picture" width="100%" height="100%" class="img-circle">
		</c:otherwise>
		</c:choose>
		</a></choose>
		
		</td>
		</tr>
		<tr>
		<td colspan="2">
		<center>
		<a href="#profile_photo" class="btn btn-defult" data-toggle="modal">
		<c:choose>
		<c:when test="${login.m_main_photo eq -1}">
		<img src="http://blue564.cafe24.com/upload/default.jpg" alt="profile_picture" width="80" height="80" class="img-circle">
		</c:when>
		<c:otherwise>
		<img src="${pageContext.request.contextPath}/upload/${r_name}" alt="profile_picture" width="80" height="80" class="img-circle">
		</c:otherwise>
		</c:choose>
		</a> </center>
		<hr>
		</td>
		</tr>
		<tr>
		<td colspan="2">
		<center>
		<h3>${login.m_main_mention }</h3>
		</center>
		<hr>
		</td>
		</tr>
		
		<tr><td width="20%">
		사용자 이름</td><td>${login.m_name }</a><br></tr>
		<tr><td width="20%"> 
		페이스북</td><td><a href="#facebook" class="btn btn-primary" data-toggle="modal">Facebook에 공유</font></a><br></tr>
		<tr><td width="20%">
		페이스북
		</td><td><a href="#twitter" class="btn btn-info" data-toggle="modal">Twitter에 공유</font></a><br></tr>
		<tr><td width="20%"> 
		이메일 포스팅</font></td><td>  이메일 </font><br></tr>
		<tr><td width="20%"></td><td>
		<hr>
			<div align="right"><button type="submit" class="btn btn-default" onClick="withdrawal('${login.m_mail}')"  >계정 폐쇄</button>
		</div><br></td></tr>
		</font>
	</table>
	<br>
	
	
	</td>
	<td width="25%" rowspan="3" align="justify" style="PADDING-TOP: 5px; PADDING-LEFT: 15px;" bgcolor="#48cfae">
				<font style="font-family : Serif; color :#D8D8D8">
				<br>계정<br>
				기본 사항 <span class="caret"></span>
				<hr>
				대시보드<br>
				블로그 스타일 옵션 <span class="caret"></span><br>
				<hr>
				알림<br>
				이메일 & 모바일 알림 <span class="caret"></span>
	</td>
	</tr>
	</table>
	
<!-- Modal HTML -->
<div id="profile_photo" class="modal fade">
	<div class="modal-dialog">
		<form id="pdsupload" action="./mainPicturd_upload.do" method="post" name="pForm" 
			modelAttribute="resDto" enctype="multipart/form-data" onSubmit="formChk_picture();return false">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">
						<font color="#A4A4A4">프로필 사진</font>
					</h4>
				</div>
				<div class="modal-body">
					<table>
						<col width="200" />
						<col width="500" />
						<div class="form-group">
							<label for="m_mail"> <font color="#A4A4A4">${login.m_mail}</font></label>
						</div>
							
						<div class="fileload">
						<input type="file" name="fileload" id="profile_pt" onchange="previewImage(this,'View_area')">
						<center><div id='View_area' style='position:relative; width: 100%px;
						height: 300px; color: black; border: 0px solid black; dispaly: inline; '></div></center>
						
						</div>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">POST</button>
				</div>
			</div>
		</form>
	</div>
</div>

<!-- Modal HTML -->
<div id="profile_back_photo" class="modal fade">
	<div class="modal-dialog">
		<form id="pdsupload" action="./pdsupload_photo.do" method="post" name="pForm" 
			modelAttribute="pdsdto" enctype="multipart/form-data" onSubmit="formChk_picture();return false">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">
						<font color="#A4A4A4">프로필 배경 사진</font>
					</h4>
				</div>
				<div class="modal-body">
					<table>
						<col width="200" />
						<col width="500" />
						<div class="form-group">
							<label for="m_mail"> <font color="#A4A4A4">${login.m_mail}</font></label>
						</div>
							
						<div class="fileload">
						<input type="file" name="fileload" id="profile_pt" onchange="previewImage(this,'View_area')">
						<center><div id='View_area' style='position:relative; width: 100%px;
						height: 300px; color: black; border: 0px solid black; dispaly: inline; '></div></center>
						
						</div>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="submit" class="btn btn-primary">POST</button>
				</div>
			</div>
		</form>
	</div>
</div>

<%@include file="../footer.jsp"%>

</div>
</div>
</div>
</body>
</html>
