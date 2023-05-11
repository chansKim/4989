<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
<head>
<style>
@import url(http://fonts.googleapis.com/earlyaccess/nanumgothic.css);
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>4989.</title>
  <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
  <link href="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet"/>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js"></script>
  
  <link href="${pageContext.request.contextPath}/css/main_style.css" rel="stylesheet"/> 
 <script src="${pageContext.request.contextPath}/js/memberAjax.js"></script>
  	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  
</head>

<body>
<div class="intro">
<a href="./home.do">home</a>
<form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
<center>

<div class="container" style="margin-top: 10%;">

		<div class="omb_login">
			<img src="${pageContext.request.contextPath}/img/logo_4989.png">
			<h3 class="omb_authTitle"><font color="white" size="60">4989. SNS</font></h3>

			<div class="row omb_row-sm-offset-3">
				<div class="col-xs-12 col-sm-6">

					<form novalidate class="omb_joinForm" action="./login.do" method="post"
						autocomplete="off">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
							<input type="email" class="form-control" name="m_mail"
								id="member_mail" placeholder="Email address" required>
						</div>
						<span class="help-block"></span>

						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock"></i></span>
							<input type="password" class="form-control" name="m_password"
								id="password" placeholder="Password" required>
						</div>
						<span class="help-block"></span>

						<!-- <div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="password" class="form-control" name="pw_confirm"
								ng-model="person.pw_confirm" placeholder="Password confirm">
							</div>
							<span class="help-block"></span> -->

						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
							<input type="text" class="form-control" name="m_name"
								id="name" placeholder="Name" required>
						</div>
						<span class="help-block"></span>

						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-user"></i></span>
							<input type="text" class="form-control" name="m_phone"
								id="phone" placeholder="Phone number(-는 빼고 적어주세요.)" required>
						</div>
						<span class="help-block"></span>

						<span class="help-block"></span>
						<button class="btn btn-lg btn-default btn-block" type="submit">가입</button>
					</form>
					<br> <br>
				</div>
			</div>

		</div>
	</div>
	
<div class="footer">
<form class="navbar-form navbar-left" action="./loginGo.do" method="POST">
        <div class="form-group">
        </div>
        <button type="submit" class="btn btn-default">로그인</button>
      </form>
<center>

<a href=''>소개 &nbsp;</a>
<a href=''>지원 &nbsp;</a>
<a href=''>블로그 &nbsp;</a>
<a href=''>개인 &nbsp;</a>
<a href=''>정보 보호 &nbsp;</a>
<a href=''>약관</a> &nbsp;&nbsp;&nbsp; &copy; 2015 4989.
</center>
	</div>
</body>
</html>