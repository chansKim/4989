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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js" type="text/javascript"></script>
<style>
a.dropdown-toggle:link {
	text-decoration: none;
    color: #6E6E6E;
}

/* visited link */
a.dropdown-toggle:visited {
	text-decoration: none;
    color: #6E6E6E;
}

/* mouse over link */
a.dropdown-toggle:hover {
    color: #6E6E6E;
}
</style>

<script>
        $(document).ready(function(){
            var tbl = $("#checkboxTestTbl");
             
            // 테이블 헤더에 있는 checkbox 클릭시
            $(":checkbox:first", tbl).click(function(){
                // 클릭한 체크박스가 체크상태인지 체크해제상태인지 판단
                if( $(this).is(":checked") ){
                    $(":checkbox", tbl).attr("checked", "checked");
                }
                else{
                    $(":checkbox", tbl).removeAttr("checked");
                }
 
                // 모든 체크박스에 change 이벤트 발생시키기                
                $(":checkbox", tbl).trigger("change");
            });
             
            // 헤더에 있는 체크박스외 다른 체크박스 클릭시
            $(":checkbox:not(:first)", tbl).click(function(){
                var allCnt = $(":checkbox:not(:first)", tbl).length;
                var checkedCnt = $(":checkbox:not(:first)", tbl).filter(":checked").length;
                 
                // 전체 체크박스 갯수와 현재 체크된 체크박스 갯수를 비교해서 헤더에 있는 체크박스 체크할지 말지 판단
                if( allCnt==checkedCnt ){
                    $(":checkbox:first", tbl).attr("checked", "checked");
                }
                else{
                    $(":checkbox:first", tbl).removeAttr("checked");
                }
            }).change(function(){
                if( $(this).is(":checked") ){
                    // 체크박스의 부모 > 부모 니까 tr 이 되고 tr 에 selected 라는 class 를 추가한다.
                    $(this).parent().parent().addClass("selected");
                }
                else{
                    $(this).parent().parent().removeClass("selected");
                }
            });
        });
    </script>

    <style>
        #checkboxTestTbl {border-collapse: collapse;}
        #checkboxTestTbl td, #checkboxTestTbl th{padding:20px; font-size:10pt}
        #checkboxTestTbl th{background-color: #ccc;}
         
        #checkboxTestTbl tr.selected{background-color:#F6F6F6;color: #black;}
    </style>
    
</head>
<body>
	<%@include file="loginSession.jsp"%>
	<%@include file="../menu.jsp"%>
<div class="container2">

<div class="CEN">

<div class="dashboard">
	<table width="70%" class="dashboard_table" align="center">
	<tr>
	<td>


<br><br>
<table align="center" width="100%">
<tr>
<td bgcolor="white" colspan="3">
<ul class="nav nav-tabs nav-justified">
  <li>
   <a class="dropdown-toggle" href="./mymessage.do" role="button" aria-expanded="true">
    받은 쪽지 : ${fn:length(get_myMessage)}개</a>
  </li>
  <li role="presentation" class="active">
    <a class="dropdown-toggle"  href="#" role="button" aria-expanded="true">
    보낸 쪽지 : ${fn:length(receive_message)}개
    </a>
  </li>
</ul>
</td>
</tr>


<td bgcolor="white">
 <table id="checkboxTestTbl" bordercolor="#ECEBEB">
        <caption>  </caption>
        <colgroup>
            <col width="5%"/>
            <col width="20%"/>
            <col width="40%"/>
        </colgroup>
        <tr>
            <th><input type="checkbox"/></th>
            <th>받는사람</th>
            <th>메세지 내용</th>
            <th>날짜</th>
        </tr>
        <c:forEach var="key" items="${receive_message}" varStatus="loop">
        <tr>
            <td><input type="checkbox" /></td>
            <td>${key.face_mail}</td>
            <td>${key.n_content}</td>
            <td><fmt:formatDate value="${key.ctime}" pattern="yyyy-MM-dd a hh:mm" /></td>
            
        </tr>
        </c:forEach>
   
    </table>

</td>
</table>

<br>
<br>
<%@include file="messageType.jsp"%>
<a href="#me" class="btn btn-default" data-toggle="modal">메세지 보내기</a>


	
	<td width="25%" rowspan="2" align="justify" style="PADDING-TOP: 5px; PADDING-LEFT: 15px;" bgcolor="#41d3ae">
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
		<font style="font-family : Serif; color :#D8D8D8">
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
				
				<a class="menu" href="./myScrap.do"><span class="glyphicon glyphicon-heart"></span><div class="button glow">&nbsp;스크랩  ${fn:length(get_myscrap)}개</div>
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
