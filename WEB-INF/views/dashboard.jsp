<%@page import="java.nio.file.Files"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@include file="./uploadType.jsp"%>
<%@include file="./replyType.jsp"%>
<%@include file="./reportType.jsp"%>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
</style>


<div class="dashboard" >
	<table width="70%" class="dashboard_table" align="center">
	<tr>
	<td>

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
  <li role="presentation" style="padding-top:10px;"> 
    <div class="btn-group" align="right">
    <a class="menu2" href="./home_list.do"><span class="glyphicon glyphicon-th-list"></span></a> &nbsp;&nbsp;
    <a class="menu2" href="./home_baduk.do"><span class="glyphicon glyphicon-th"></span></a> &nbsp;&nbsp;
    <a class="menu2" href="./home.do"><span class="glyphicon glyphicon-th-large"></span></a>
    </div>
    </li>
    <li role="presentation"><a class="main_menu" href="./home.do?param=complete">거래완료</a></li>
    <li role="presentation"><a class="main_menu" href="./home.do?param=buy">구매</a></li>
    <li role="presentation"><a class="main_menu" href="./home.do?param=sell">판매</a></li>
    <li role="presentation"><a class="main_menu" href="./home.do?param=all">전체</a></li>
    
  </ul>

	<%-- <div role="tabpanel">
 <%@include file="./tabpanel.jsp"%> --%>
 
 
</div>
	<table class="dashboard_table"  width="100%" align="center">
		<tr>
		<td width="1%" align="center" height="40px" margin-top="auto" bgcolor="#48cfae">
		</td>
		<td width="65%" align="center" height="20px">
		</td>
		</tr>
		<c:choose>
		<c:when test="${fn:length(follow_resource) eq 0}" >
		
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
		<br><br><br>등록한 팔로우 or 키워드가 없습니다.
		</td>
		</tr>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
		</c:choose>
		
	</table>
	
	<c:forEach var="key" items="${follow_resource}" varStatus="loop">
	<table class="dashboard_table"   width="100%" align="center">
	<tr>
			<c:choose>
			<c:when test="${fn:length(key.r_name) != 0}">
			<c:choose>
			<c:when test="${key.r_type == 1}">
			<td width="10%" align="center" height="100px" bgcolor="#48cfae">
    	<a href="#reply" onclick="return replyList('${key.r_id}', '${key.m_mail}', '${login.m_mail}');"  data-toggle="modal"><img src="http://blue564.cafe24.com/upload/default.jpg" alt="profile_picture" width="80" height="80" class="img-circle"
			onmouseover="moseoverFunction()"></a>
    	</td>
		<td width="65%" align="left" height="100px" bgcolor="white">
		<br>
			<center><h2>${key.r_title}</h2></center>
			<c:choose>
			<c:when test="${key.post_type == 1}">
			<font color="#FF0040"><center>판매중</center></font>
			</c:when>
			<c:when test="${key.post_type == 2}">
			<font color="#04B431"><center>구매중</center></font>
			</c:when>
			<c:when test="${key.post_type == 3}">
			<font color="#4000FF"><center>거래완료</center></font>
			</c:when>
			</c:choose>
			
			<div class="button curl-top-right">
			<video controls="controls" width="560px" height="300" autoplay>
				<source type="video/mp4"
						src="${pageContext.request.contextPath}/upload/${key.r_name}" /><br>
				</video>
				</div>
				<br>
			<center><font color="#48cfae" size="10">${key.r_title}</font></center>
			<div style="float:right">
			<c:choose>
			<c:when test="${key.number_type == 1}">
				<font color="green">핸드폰 번호 비공개</font>
			</c:when>
			<c:when test="${key.number_type == 2}">
			<script type="text/javascript">
			$.ajax({
				type : 'POST',
				url : './open_phone.do',
				dataType : 'json',
				data : {"m_mail" : "${key.m_mail}"},
				async : true,
				success : function(list) {
					for(var i=0; i<list.length;i++){
						content = list[i].m_phone;
					}
					$("#${key.r_id}").html(content);
				}
			});
            
			</script>
			<font color="#FF0040"><div id="${key.r_id}"></div></font>
			</c:when>
			</c:choose>
			<i><font color="black">${key.r_content}</font></i>
			<hr>
			<font color="black">
			</font>
			<div align="right" align="justify" style="PADDING-RIGHT: 20px;">
			<div><a href="javascript:scrap(${key.r_id});" class="like" data-toggle="modal"><span class="glyphicon glyphicon-heart"></span>스크랩			&nbsp;&nbsp;
			<script>
			function scrap(a){
			location.replace("./myScrap.do?r_id="+a);
			}
			</script>
			<a href="#reply" onclick="return replyList(${key.r_id});"  data-toggle="modal"><span class="glyphicon glyphicon-share-alt"></span>댓글</a>			&nbsp;&nbsp;
			<a href="#re" data-toggle="modal"><span class="glyphicon glyphicon-ban-circle"></span>신고</a>
			</font>
			</div>
			</c:when>
			
			
			<c:when test="${key.r_type == 2}">
			<td width="10%" align="center" height="100px" margin-top="auto" bgcolor="#48cfae">
    	<img src="http://blue564.cafe24.com/upload/default.jpg" alt="profile_picture" width="80" height="80" class="img-circle"
			onmouseover="moseoverFunction()">  
    	</td>
		<td width="65%" align="left" height="100px" bgcolor="white">
		<br>
			<a href="./myPost.do?face_mail=${key.m_mail}"><center>${key.m_mail}</center></a><br>
			
			<c:choose>
			<c:when test="${key.post_type == 1}">
			<font color="#FF0040"><center>판매중</center></font>
			</c:when>
			<c:when test="${key.post_type == 2}">
			<font color="#04B431"><center>구매중</center></font>
			</c:when>
			<c:when test="${key.post_type == 3}">
			<font color="#4000FF"><center>거래완료</center></font>
			</c:when>
			</c:choose>
			<div class="button curl-top-right">
			<div style="align:center;">
			<a href="#reply" onclick="return replyList('${key.r_id}', '${key.m_mail}', '${login.m_mail}');"  data-toggle="modal"><img src="${pageContext.request.contextPath}/upload/${key.r_name}" width="100%" height="500px"></a></div>
			<hr>
			<center><font color="#48cfae" size="10">${key.r_title}</font></center>
			
			<div style="float:right">
			<c:choose>
			<c:when test="${key.number_type == 1}">
				<font color="green">핸드폰 번호 비공개</font>
			</c:when>
			<c:when test="${key.number_type == 2}">
			<script type="text/javascript">
			$.ajax({
				type : 'POST',
				url : './open_phone.do',
				dataType : 'json',
				data : {"m_mail" : "${key.m_mail}"},
				async : true,
				success : function(list) {
					for(var i=0; i<list.length;i++){
						content = list[i].m_phone;
					}
					$("#${key.r_id}").html(content);
				}
			});
            
			</script>
			<font color="#FF0040"><div id="${key.r_id}"></div></font>
			</c:when>
			</c:choose>
			</div>
			<br><br>
			<i><font color="black">${key.r_content}</font></i>
 			<hr>
			<font color="black">
			
			<div align="right" align="justify" style="PADDING-RIGHT: 20px;">
			<div><a href="javascript:scrap(${key.r_id});" class="like" data-toggle="modal"><span class="glyphicon glyphicon-heart"></span>스크랩			&nbsp;&nbsp;
			<script>
			function scrap(a){
			location.replace("./myScrap.do?r_id="+a);
			}
			</script>
			<a href="#reply" onclick="return replyList(${key.r_id});"  data-toggle="modal"><span class="glyphicon glyphicon-share-alt"></span>댓글</a>			&nbsp;&nbsp;
			<a href="#re" data-toggle="modal"><span class="glyphicon glyphicon-ban-circle"></span>신고</a>
			</font>
			</div>
			</c:when>
			<c:when test="${key.r_type == 3}">
			
			<td width="10%" align="center" height="100px" margin-top="auto" bgcolor="#48cfae">
    	<img src="http://blue564.cafe24.com/upload/default.jpg" alt="profile_picture" width="80" height="80" class="img-circle"
			onmouseover="moseoverFunction()">  
    	</td>
		<td width="65%" align="left" height="100px" bgcolor="white">
		<br>
			<a href="./myPost.do?face_mail=${key.m_mail}"><center>${key.m_mail}</center></a><br>
			
			<c:choose>
			<c:when test="${key.post_type == 1}">
			<font color="#FF0040"><center>판매중</center></font>
			</c:when>
			<c:when test="${key.post_type == 2}">
			<font color="#04B431"><center>구매중</center></font>
			</c:when>
			<c:when test="${key.post_type == 3}">
			<font color="#4000FF"><center>거래완료</center></font>
			</c:when>
			</c:choose>
			
			<hr>
			<center><font color="#48cfae" size="10">${key.r_title}</font></center>
			<div style="float:right">
			<c:choose>
			<c:when test="${key.number_type == 1}">
				<font color="green">핸드폰 번호 비공개</font>
			</c:when>
			<c:when test="${key.number_type == 2}">
			<script type="text/javascript">
			$.ajax({
				type : 'POST',
				url : './open_phone.do',
				dataType : 'json',
				data : {"m_mail" : "${key.m_mail}"},
				async : true,
				success : function(list) {
					for(var i=0; i<list.length;i++){
						content = list[i].m_phone;
					}
					$("#${key.r_id}").html(content);
				}
			});
            
			</script>
			<font color="#FF0040"><div id="${key.r_id}"></div></font>
			</c:when>
			</c:choose>
			<i><font color="black">${key.r_content}</font></i>
			<hr>
			<font color="black">
			<div align="right" align="justify" style="PADDING-RIGHT: 20px;">
			<div><a href="javascript:scrap(${key.r_id});" class="like" data-toggle="modal"><span class="glyphicon glyphicon-heart"></span>스크랩			&nbsp;&nbsp;
			<script>
			function scrap(a){
			location.replace("./myScrap.do?r_id="+a);
			}
			</script>
			<a href="#reply" onclick="return replyList(${key.r_id});"  data-toggle="modal"><span class="glyphicon glyphicon-share-alt"></span>댓글</a>			&nbsp;&nbsp;
			<a href="#re" data-toggle="modal"><span class="glyphicon glyphicon-ban-circle"></span>신고</a>
			</font>
			</div>
			</c:when>
			<c:when test="${key.r_type == 4}">
			
			<td width="10%" align="center" height="100px" margin-top="auto" bgcolor="#48cfae">
    	<img src="http://blue564.cafe24.com/upload/default.jpg" alt="profile_picture" width="80" height="80" class="img-circle"
			onmouseover="moseoverFunction()">  
    	</td>
		<td width="65%" align="left" height="100px" bgcolor="white">
		<br>
			<a href="./myPost.do?face_mail=${key.m_mail}"><center>${key.m_mail}</center></a><br>
			
			<c:choose>
			<c:when test="${key.post_type == 1}">
			<font color="#FF0040"><center>판매중</center></font>
			</c:when>
			<c:when test="${key.post_type == 2}">
			<font color="#04B431"><center>구매중</center></font>
			</c:when>
			<c:when test="${key.post_type == 3}">
			<font color="#4000FF"><center>거래완료</center></font>
			</c:when>
			</c:choose>
			
			<audio controls="controls" width="100%">
			  <source src="${pageContext.request.contextPath}/upload/${key.r_name}" type="audio/mpeg" ><br>
			</audio>
			<br>
			<hr>
			<center><font color="#48cfae" size="10">${key.r_title}</font></center>
			<div style="float:right">
			<c:choose>
			<c:when test="${key.number_type == 1}">
				<font color="green">핸드폰 번호 비공개</font>
			</c:when>
			<c:when test="${key.number_type == 2}">
			<script type="text/javascript">
			$.ajax({
				type : 'POST',
				url : './open_phone.do',
				dataType : 'json',
				data : {"m_mail" : "${key.m_mail}"},
				async : true,
				success : function(list) {
					for(var i=0; i<list.length;i++){
						content = list[i].m_phone;
					}
					$("#${key.r_id}").html(content);
				}
			});
            
			</script>
			<font color="#FF0040"><div id="${key.r_id}"></div></font>
			</c:when>
			</c:choose>
			<i><font color="black">${key.r_content}</font></i>
			<hr>
			<div align="right" align="justify" style="PADDING-RIGHT: 20px;">
			<div><a href="javascript:scrap(${key.r_id});" class="like" data-toggle="modal"><span class="glyphicon glyphicon-heart"></span>스크랩			&nbsp;&nbsp;
			<script>
			function scrap(a){
			location.replace("./myScrap.do?r_id="+a);
			}
			</script>
			<a href="#reply" onclick="return replyList(${key.r_id});"  data-toggle="modal"><span class="glyphicon glyphicon-share-alt"></span>댓글</a>			&nbsp;&nbsp;
			<a href="#re" data-toggle="modal"><span class="glyphicon glyphicon-ban-circle"></span>신고</a>
			</font>
			</div>
			</c:when>
			</c:choose>
			</c:when>
			</c:choose>
			
		</font>
		</td>
	</tr>
	</table>
	<br>
	</c:forEach>
	</td>
	
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
                중고 거래 상품 등록 &nbsp;</span><span class="caret"></span></font> </button>
                <ul class="dropdown-menu">
                  <li><a href="#media" data-toggle="modal">거래 상품 동영상 등록</a></li>
                  <li><a href="#photo" data-toggle="modal">거래 상품 이미지 등록</a></li>
                  <li><a href="#audio" data-toggle="modal">거래 상품 오디오 등록</a></li>
                  <li class="divider"></li>
                  <li><a href="#context" data-toggle="modal">거래 상품 텍스트 등록</a></li>
                </ul>
              </div><!-- /btn-group -->
            </div><!-- /btn-toolbar -->
				<hr>
				<a class="menu" href="./myPost.do"><span class="glyphicon glyphicon-file"></span><div class="button glow">&nbsp; 포스트  ${fn:length(resource)}개</div>
				<span style="position:absolute; right:180px;"><span class="glyphicon glyphicon-chevron-right"> </span></span></a> 
 				
 				<br>
				<br> 계정 
				<br> 
				
				<a class="menu" href="./myScrap.do"><span class="glyphicon glyphicon-heart"></span><div class="button glow">&nbsp; 스크랩 ${fn:length(get_myscrap)}개</div>
				<span style="position:absolute; right:180px;"><span class="glyphicon glyphicon-chevron-right"> </span></span></a>
				
				<br><a class="menu" href="./myFollow.do"><span class="glyphicon glyphicon-user"></span>
				<div class="button glow">
				 팔로우  ${fn:length(keyword_my)+fn:length(follow)}개
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
	
	<!-- <h2 id='pagebottom'></h2> -->
	
<%@include file="./footer.jsp"%>

</div>