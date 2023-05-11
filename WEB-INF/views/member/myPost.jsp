<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<html>
<head>
<title>4989.</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/main_style.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/myJS.js" /></script>

</head>
<body>
	<%@include file="loginSession.jsp"%>
	<%@include file="../menu.jsp"%>
<div class="container2">

<div class="CEN">

<%@include file="../uploadType.jsp"%>
<div class="dashboard">
	
	<table width="70%"   class="dashboard_table" align="center">
	<tr>
	<td>
	  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation"><a class="main_menu" href="./myPost.do?param=complete">거래완료</a></li>
    <li role="presentation"><a class="main_menu" href="./myPost.do?param=buy">구매</a></li>
    <li role="presentation"><a class="main_menu" href="./myPost.do?param=sell">판매</a></li>
    <li role="presentation"><a class="main_menu" href="./myPost.do?param=all">전체</a></li>
  </ul>

	<table class="dashboard_table"   width="100%" align="center">

		<tr>
		<td width="1%" align="center" height="40px" margin-top="auto" bgcolor="#48cfae">
<%-- 		<c:choose>
		<c:when test="${login.m_main_photo eq -1}">
		<img src="http://blue564.cafe24.com/upload/default.jpg" alt="profile_picture" width="80" height="80" class="img-circle">
		</c:when>
		<c:otherwise>
		<img src="${pageContext.request.contextPath}/upload/${r_name}" alt="profile_picture" width="80" height="80" class="img-circle">
		</c:otherwise>
		</c:choose> --%>
		</td>
		<td width="65%" align="center" height="50px">
<!-- 		<br>
		<br>
			<a href="#media" class="btn btn-primary" data-toggle="modal">동영상</a> 
			<a href="#photo" class="btn btn-success" data-toggle="modal">사진</a> 
			<a href="#context" class="btn btn-info" data-toggle="modal">텍스트</a>
			<a href="#audio" class="btn btn-warning" data-toggle="modal">오디오</a> -->
		</td>
		
		<c:choose>
		<c:when test="${fn:length(resource) eq 0}" >
		
		<tr>
		<td width="10%" align="center" height="50px" margin-top="auto" bgcolor="#48cfae" >
		<c:choose>
		<c:when test="${login.m_main_photo eq -1}">
		<img src="http://blue564.cafe24.com/upload/default.jpg" alt="profile_picture" width="80" height="80" class="img-circle">
		</c:when>
		<c:otherwise>
		<img src="${pageContext.request.contextPath}/upload/${r_name}" alt="profile_picture" width="80" height="80" class="img-circle">
		</c:otherwise>
		</c:choose>
		
		</td>
		<td align="center">
		<br><br><br>등록한 포스트가 없습니다.
		</td>
		</tr>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
		</c:choose>
	</table>
	
	<table class="dashboard_table" width="100%" align="center">
	<tr>
	<td>
	<c:forEach var="key" items="${resource}" varStatus="loop">
	<div class="col-sm-6 col-md-3">
      <div class="thumbnail">
         <p><font color="black"><center>${key.m_mail}</center></font></p>
         
         	<c:choose>
			<c:when test="${key.post_type == 1}">
			<font color="red"><center>판매중</center></font>
			</c:when>
			<c:when test="${key.post_type == 2}">
			<font color="green"><center>구매중</center></font>
			</c:when>
			<c:when test="${key.post_type == 3}">
			<font color="blue"><center>거래완료</center></font>
			</c:when>
			</c:choose>
			
         <c:choose>
			<c:when test="${key.r_type == 1}">
			<div class="button curl-top-right">
			<video controls="controls" width="100%" height="100" autoplay>
				<source type="video/mp4"
						src="${pageContext.request.contextPath}/upload/${key.r_name}" /><br>
				</video>
				</div>
				<br>
			</c:when>
			<c:when test="${key.r_type == 2}">
			<div class="button curl-top-right">
			<img src="${pageContext.request.contextPath}/upload/${key.r_name}" width="100%" height="200">
			</div>
			<br>
			</c:when>
			<c:when test="${key.r_type == 3}">
			
			</c:when>
			<c:when test="${key.r_type == 4}">
			<audio controls="controls" width="80%">
			  <source src="${pageContext.request.contextPath}/upload/${key.r_name}" type="audio/mpeg"><br>
			</audio>
			<br>
			</c:when>
			</c:choose>
         
      </div>
      
      <div class="caption">
      <hr>
         <center><h3>${key.r_title}</h3></center>
         <p>${key.r_content}</p>
                  <div align="right">
         
         <p>
            <div align="right"  align="justify" style="PADDING-RIGHT: 20px;">
            
             <a onclick="return updatePost(${key.r_id});"><span class="glyphicon glyphicon-ok"></span></a>&nbsp;&nbsp;
			 <span class="glyphicon glyphicon-wrench" aria-hidden="true"></span>
			 &nbsp;&nbsp;
	 		  <span class="glyphicon glyphicon-trash" onclick="deletePost('${key.r_name}','${key.r_id}')"></span>
			 &nbsp;&nbsp;
			<a href="#reply" onclick="return replyList(${key.r_id});" data-toggle="modal"><span class="glyphicon glyphicon-retweet"></span></a>&nbsp;&nbsp;
	 		 </div>
         </p>
         <hr>
         </div>
      </div>
   </div>
		
	</c:forEach>
	</td>
	</tr>
	</table>
	
	
	<td width="25%" rowspan="2" align="justify" style="PADDING-TOP: 5px; PADDING-LEFT: 15px;" bgcolor="#48cfae">
		<table>
		<tr>
		<td>
		<c:choose>
		<c:when test="${login.m_main_photo eq -1}">
		<img src="http://blue564.cafe24.com/upload/default.jpg" alt="profile_picture" width="80" height="80" class="img-circle">
		</c:when>
		<c:otherwise>
		<img src="${pageContext.request.contextPath}/upload/${r_name}" alt="profile_picture" width="80" height="80" class="img-circle">
		</c:otherwise>
		</c:choose>
		</td>
		<td>
		<font style="font-family : Serif; color :white">
				<br> &nbsp;&nbsp;${login.m_mail}
				<br>&nbsp;&nbsp;${login.m_name}
		</td>
		</tr>
		</table>
				<br>
				${login.m_main_mention}<hr></div>
				
				
				<div class="btn-group">
				<a href="./mymessage.do" class="btn btn-default" data-toggle="modal">쪽지</a>
				<a href="./mypage.do" class="btn btn-default" data-toggle="modal">설정</a> 
				<a href="./logout.do" class="btn btn-default" data-toggle="modal">로그아웃</a> 
				<br><br><hr>
				</div>
				
				<div class="btn-group">
                <button class="btn btn-inverse dropdown-toggle" style="width:188;"data-toggle="dropdown"><font color="black">
                포스트 &nbsp;</span><span class="caret"></span></font> </button>
                <ul class="dropdown-menu">
                  <li><a href="#media" data-toggle="modal">동영상</a></li>
                  <li><a href="#photo" data-toggle="modal">사진</a></li>
                  <li><a href="#audio" data-toggle="modal">오디오</a></li>
                  <li class="divider"></li>
                  <li><a href="#context" data-toggle="modal">텍스트</a></li>
                </ul>
              </div><!-- /btn-group -->
            </div><!-- /btn-toolbar -->
				<hr>
				
				<a class="menu" href="./myPost.do"><span class="glyphicon glyphicon-file"></span><div class="button glow">&nbsp; 포스트  ${fn:length(resource)}개</div>
				<span style="position:absolute; right:180px;"><span class="glyphicon glyphicon-chevron-right"> </span></span></a> 
 				
 				<br>
				<br> 계정 
				<br>  
				
				<a class="menu" href="./myScrap.do"><span class="glyphicon glyphicon-heart"></span><div class="button glow">&nbsp;스크랩 ${fn:length(get_myscrap)}개</div>
				<span style="position:absolute; right:180px;"><span class="glyphicon glyphicon-chevron-right"> </span></span></a>
				
				<br><a class="menu" href="./myFollow.do"><span class="glyphicon glyphicon-user"></span>
				<div class="button glow">
				 팔로우  ${fn:length(follow)}개
				 </div>
				<span style="position:absolute; right:180px;"><span class="glyphicon glyphicon-chevron-right"> </span></span></a>
				<br> 
				<!-- <div class="button glow">블로그 찾기</div><span style="position:absolute; right:180px;"><span class="glyphicon glyphicon-chevron-right"> </span></span><br> <br> -->
				<br> 추천 판매자<br><br>
				<c:forEach var="key9" items="${recommand}" varStatus="loop">
				<a href="#" class="menu">
				<img src="http://blue564.cafe24.com/upload/P.jpg" alt="profile_picture" width="50" height="50" class="img-rounded">
				<div class="button glow">${key9.m_name} </div>
				<span style="position:absolute; right:180px; margin-top:16;"><span onClick="follow('${login.m_mail}','${key9.m_mail}')" class="glyphicon glyphicon-plus" aria-hidden="true"></span></a><br><br>
				</c:forEach>
				</font>
	</td>
	
	</tr>
	</table>
	
	
<%@include file="../footer.jsp"%>

</div>
</div>
</div>

</body>
</html>
