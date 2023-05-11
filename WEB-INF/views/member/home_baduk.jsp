<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
</style>
<html>
<head>
<title>4989.</title>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/main_style.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/myJS.js" /></script>
<script src="${pageContext.request.contextPath}/js/upload.js" /></script>
<link href="${pageContext.request.contextPath}/css/uploadType.css" rel="stylesheet"/> 
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dropdown.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.dropdown.css" />

</head>
<body>
	<%@include file="loginSession.jsp"%>
	<%@include file="../menu.jsp"%>
<div class="CEN">

	<%@include file="../dashboard_baduk.jsp"%>

</div>
</body>
</html>