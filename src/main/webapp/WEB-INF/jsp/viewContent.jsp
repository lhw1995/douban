<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>你曾是少年，你永远是少年</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="../../css/header.css">
	<link rel="stylesheet" type="text/css" href="../../css/viewContent.css">

	<script src="../../js/Header.js"></script>
  </head>
  
  <body>
    	<jsp:include page="header.jsp"></jsp:include>
  		<div class="content">
  			<h1>
				<span class="title">你曾是少年，你永远是少年</span> 
			</h1>
			<h3>
				<span class="comment-info"> <a href="#" class="name">一叶知秋</a>
				<span>看过</span> <span class="comment-time "
				title="2017-02-19 18:24:10">2017-02-19</span> ` <span
				class="score1">&nbsp;&nbsp;评分&nbsp;&nbsp;&nbsp;<i id="I1"></i>7</span>
				</span>
			</h3>
  			<p class="view">前言：在写《我的少女时代》的影评的时候，我以
					为这会是近几年最触动我的青春电影，但却未料到 会不经意邂逅这部爱奇艺的网剧，那些耿耿于怀的
					岁月一一重现在眼前，迟迟不能忘记。回忆如潮水 般汹涌而至，原来这才是我不曾忘记的时光。 抄送 少女时代影评：
					https://movie.douban.... 版权归作者所有，任何形式转载请联系作者。 作者：山水烟花（来自豆瓣）
					来源：https://movie.douban.com/review/7967743/ 【少年少女的爱情呀，是未说出口的喜欢啊】

					暧昧的情愫，羞红的脸，偶尔碰到的手，无处不在的摸头杀，随着剧情一步步推进下去，那些恍如隔世的寻常样子仿佛一一又重现在眼前。

					他和她四目相对，带着一起温书的浅浅笑容，那不是轰轰烈烈的爱情，只是细水长流的喜欢。也许未说出口，却真实的存在于每时每刻每个细节。

					耿耿说，被爱的人是幸运而感动的，而爱人却是一次又一次猝不及防的心跳加速。她和余淮的喜欢发端于点点滴滴的学习生活，也许是哪一次他为了她向老师提问，也许是哪一次他说她是他的人，也许是哪一次他宠溺的摸摸她的头，骂她小白痴......因为喜欢所以亲昵，而亲昵但不敢越距，这是高中时候的小小心思，你和我都懂，懂就够了。

					在一起，是最自然而然的事情。

					在年少的时候，我们能为喜欢的人做很多很多未来不会去做的事情。心里眼里都是他，所以会为了他而做出最出于本心的选择，因他的喜而喜，因他的忧而忧。——耿耿是这样，贝塔是这样，简单更是这样，尽管他们的喜欢不尽相同，但少女的心思却出奇的一致。

					尤其，是在涉及到文理分科的那一晚。她们撕碎的分科志愿单，是少女时代最大的一次勇敢。但，并不是你勇敢过了，就会有一个最好的结局。

					——耿耿与余淮有多少年不曾相见； ——贝塔与张平永远止于师生之情； ——简单和韩叙终究还是一场愿赌服输的一厢情愿。

					成长就是这样，你做你想做的，但生活未必给你最想要的。 如果当我喜欢你的时候，你也喜欢我，那最好不过，如果没有，我也不曾后悔。</p>
  		</div>
  		<div class="right">
  			<div id="films">
				<h1>
					<span>最好的我们</span>
				</h1>
				<img src="../../img/最好的我们.jpg" width="100" height="150" />
				<p class="inf">
				导演: 洪尚秀<br /> 编剧: 洪尚秀<br /> 主演: 金敏喜 / 徐永嬅 / 郑在咏 / <br /> 文成根 / 权海骁
				/ 更多...<br /> 类型: 剧情<br /> 制片国家/地区: 韩国<br /> 语言: 韩语<br /> 上映日期:
				2017-02-16(柏林电影节) / <br /> 2017-03-23(韩国)<br /> 片长: 101分钟<br />
				又名: 等一个人的心湾(港) /<br /> On the Beach at Night Alone
				</p>
				<p class="score">
					评分<span>7.1</span>
				</p>
			</div>
  		</div>
  	<jsp:include page="footer.jsp"></jsp:include>
  </body>
</html>
