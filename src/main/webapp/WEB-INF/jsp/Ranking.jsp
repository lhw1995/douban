<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>豆瓣电影排行榜</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/Ranking.css" />
<script src="../../js/Ranking.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div id="content">
		<h1>豆瓣电影排行榜</h1>
		<p class="pp">--------------------------------------------------------------------------------------------------------------------------------------</p>
		<%for (int i = 0; i < 5; i++) {  %>
		<div class="indent">
			<div>
				<a class="" href="pinglun" title="逃出绝命镇"> <img
					src="../../img/imgturn/1.jpg" alt="逃出绝命镇"
					style="width:150px;height:200px;" class="" /> </a>
				<div class="description">
					<a href="pinglun" class="nbg">逃出绝命镇</a>
					<p class="pl">艾莉森·威廉姆斯 / 凯瑟琳·基纳 / 布莱德利·惠特福德 / 卡赖伯·兰德里·琼斯 /
						马库斯·亨德森 / 贝蒂·加布里埃尔 / 勒凯斯·斯坦菲尔德 / 斯蒂芬·鲁特 / 李雷尔·哈瓦瑞...</p>
					<span>评分：<mark>7.1</mark>
					</span>
				</div>
			</div>
		</div>
		<p class="pp">--------------------------------------------------------------------------------------------------------------------------------------</p>
		<%} %>

	</div>
    <div class="rights">
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
				<p class="scores">
					评分<span>7.1</span>
				</p>
			</div>
  		</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
