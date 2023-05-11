<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>

<html>
<head>
<title>4989</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/main_style.css" rel="stylesheet" />
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="http://malsup.github.com/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/js/myJS.js" /></script>
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
</head>
<body>

	<%@include file="loginSession.jsp"%>
	<%@include file="../menu.jsp"%>
<div class="container2">
<div class="CEN">

<%@include file="../uploadType.jsp"%>
<div class="dashboard">
<table align="center" width="70%">
<tr>
<td bgcolor="white">
<table align="center" width="100%">
<tr>
<td bgcolor="white" colspan="4">
<ul class="nav nav-tabs nav-justified">
  <%-- <li>
   <a class="dropdown-toggle" data-toggle="dropdown" href="./myCategory.do" role="button" aria-expanded="true">
    카테고리 : ${fn:length(category)}개</a>
  </li> --%>
  <li>
   <a class="dropdown-toggle" data-toggle="dropdown" href="./myKeyword.do" role="button" aria-expanded="true">
      키워드 : ${fn:length(keyword_my)}개</a>
  </li>
  <li role="presentation" class="active">
    <a class="dropdown-toggle" data-toggle="dropdown" href="./myFollow.do" role="button" aria-expanded="true">
      사용자 : ${fn:length(follow)}개
    </a>
  </li>
</ul>
</td>
</tr>
<tr>
<td bgcolor="white" colspan="4">
<!-- <div style="overflow:scroll; width:100%; height:500px;"> -->
<div style="padding-left:40px;">
<form class="navbar-form navbar-left" role="search" action="./search_member.do" align="center">
        <span class="glyphicon glyphicon-plus"></span>

        <div class="form-group">
          <input type="text" class="form-control" name="searchAll" size="50" placeholder="팔로우할 사용자 이름, 이메일 주소를 입력하세요." required>
        </div>
        <button type="submit" class="btn btn-primary">팔로우</button>
</form>
</td>
</div>


	<c:forEach var="key" items="${follow}" varStatus="loop">
<tr>
<td bgcolor="white" width="10%">
	<center><img src="http://blue564.cafe24.com/upload/P.jpg" alt="profile_picture" width="50" height="50" class="img-rounded"></center>
	</td>
	<td bgcolor="white" width="40%">
	<i>${key.face_mail}</i>
	<br><fmt:formatDate value="${key.ctime}" pattern="yyyy-MM-dd a hh:mm" />
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd a hh:mm" var="today" /> 
	
	
	<td bgcolor="white" width="5%">
	<div align="right"><span class="glyphicon glyphicon-user"></span><span class="caret"></span></div>
	</td>
	
	<td bgcolor="white">
	<button type="submit" class="btn btn-default" onClick="unfollow('${login.m_mail}','${key.face_mail}')"  >언팔로우</button>
	</td>
    </c:forEach>
    <tr>
    <td>
    <br>
    </td>
    </tr>

</table>
</td>
</tr>
</table>

<%@include file="../footer.jsp"%>

</div>
</div>
</div>
</body>
</html>
