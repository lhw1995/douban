<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style>
body {
	padding-top: 60px;
}
</style>

<link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />

<link href="css/login-register.css" rel="stylesheet" />
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">

<script src="jquery/jquery-1.10.2.js" type="text/javascript"></script>
<script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
<script src="js/login-register.js" type="text/javascript"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<a class="btn big-login" data-toggle="modal"
					href="javascript:void(0)" onclick="openLoginModal();">Log in</a> 
				<a class="btn big-register" data-toggle="modal"
					href="javascript:void(0)" onclick="openRegisterModal();">Register</a>
			     <a class="btn big-back"href="index">返回</a>
			</div>
			<div class="col-sm-4"></div>
		</div>


		<div class="modal fade login" id="loginModal">
			<div class="modal-dialog login animated">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Login with</h4>
					</div>
					<div class="modal-body">
						<div class="box">
							<div class="content">
								<div class="social">
									<a class="circle github" href="/auth/github"> <i
										class="fa fa-github fa-fw"></i> </a> <a id="google_login"
										class="circle google" href="/auth/google_oauth2"> <i
										class="fa fa-google-plus fa-fw"></i> </a> <a id="facebook_login"
										class="circle facebook" href="/auth/facebook"> <i
										class="fa fa-facebook fa-fw"></i> </a>
								</div>
								<div class="division">
									<div class="line l"></div>
									<span>or</span>
									<div class="line r"></div>
								</div>
								<div class="error"></div>
								<div class="form loginBox">
									<form method="post" action="/login" accept-charset="UTF-8">
										<input id="Username" class="form-control" type="text"
											placeholder="Username" name="Username"> <input
											id="password" class="form-control" type="password"
											placeholder="Password" name="password"> <input
											class="btn btn-default btn-login" type="button" value="Login"
											onclick="loginAjax()">
									</form>
								</div>
							</div>
						</div>
						<div class="box">
							<div class="content registerBox" style="display:none;">
								<div class="form">
									<form method="post" html="{:multipart=>true}"
										data-remote="true" action="/register" accept-charset="UTF-8">
										<input id="Username" class="form-control" type="text"
											placeholder="Username" name="Username"> <input
											id="password" class="form-control" type="password"
											placeholder="Password" name="password"> <input
											id="password_confirmation" class="form-control"
											type="password" placeholder="Repeat Password"
											name="password_confirmation"> <input
											class="btn btn-default btn-register" type="submit"
											value="Create account" name="commit">
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="forgot login-footer">
							<span>Looking to <a href="javascript: showRegisterForm();">create
									an account</a> ?</span>
						</div>
						<div class="forgot register-footer" style="display:none">
							<span>Already have an account?</span> <a
								href="javascript: showLoginForm();">Login</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

