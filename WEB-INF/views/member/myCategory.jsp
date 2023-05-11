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
<td bgcolor="white" colspan="3">
<ul class="nav nav-tabs nav-justified">
  <li role="presentation" class="active">
   <a class="dropdown-toggle" data-toggle="dropdown" href="./myCategory.do" role="button" aria-expanded="true">
    카테고리 : ${fn:length(category_post)}개</a>
  </li>
  <li>
   <a class="dropdown-toggle" data-toggle="dropdown" href="./myKeyword.do" role="button" aria-expanded="true">
    키워드 : ${fn:length(keyword)}개</a>
  </li>
  <li>
    <a class="dropdown-toggle" data-toggle="dropdown" href="./myFollow.do" role="button" aria-expanded="true">
    팔로잉 : ${fn:length(follow)}명
    </a>
  </li>
</ul>
</td>
</tr>
<tr>
<td bgcolor="white" width="75%">
<!-- <div style="overflow:scroll; width:100%; height:500px;"> -->

<div style="padding-left:40px;">
<form class="navbar-form navbar-left" role="search" action="./search_member.do" align="center">
        <span class="glyphicon glyphicon-plus"></span>
        <div class="form-group">
          <input type="text" class="form-control" name="searchAll" size="50" placeholder="팔로우할 카테고리를 입력하세요." required>
        </div>
        <button type="submit" class="btn btn-primary">팔로우</button>
</form>
</td>
</div>
<tr>
<td>
각 카테고리 별 추천
</td>
<td width="25%">

<table>
	<c:forEach var="key" items="${category}" varStatus="loop">
<tr>
	<td bgcolor="white">
	<form class="navbar-form navbar-left" action="./search_member.do" align="center">
        <div class="form-group">
          <center>${key.c_name}</center>
        </div>
        </td>
        <td>
        <button type="submit" class="btn btn-primary">팔로우</div></button>
	</form>
    </td>
</tr>
    </c:forEach>
</table>
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
