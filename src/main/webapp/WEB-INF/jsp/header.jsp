<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>豆瓣影评</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="../../css/header.css">

<script src="../../js/Header.js"></script>
</head>
<body class="tm-gray-bg">
	<div class="tm-header">
		<div class="container">
			<div>
				<div class="tm-site-name-container">
					<a href="#" class="tm-site-name" style="text-decoration:none">豆瓣网</a>
				</div>
				<div>
					<nav class="tm-nav">
						<ul>
							<li><a href="index" style="text-decoration:none"
                                   target="ad">首页</a>
							</li>
							<li><a href="Review" style="text-decoration:none"
                                   target="ad">评论</a>
							</li>
							<li><a href="Ranking" style="text-decoration:none"
                                   target="ad">排行榜</a>
							</li>
							<li><a href="Classify" style="text-decoration: none"
								target="ad">分类</a>
							</li>
						</ul>
					</nav>
				</div>
				<div>
					<nav class="tm-nav1">
						<ul>
							<li><a href="login" style="text-decoration:none" target="ad">登录</a>
							</li>
							<li><a href="login" style="text-decoration:none" target="ad">注册</a>
							</li>

						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<iframe name="ad" id="mainFrame" src="index" width="1345"
            scrolling="no" frameborder="0"></iframe>
	<iframe name="ad" id="Iframe1" src="footer" height="130"
            width="1345" scrolling="no" frameborder="0"></iframe>
</body>
<script type="text/javascript">
        startInit('mainFrame', 560);
</script>
</html>
