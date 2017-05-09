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
	<link rel="stylesheet" type="text/css" href="../../css/index.css"/>
	<link rel="stylesheet" type="text/css" href="../../css/normalize.css" />
	<link rel="stylesheet" href="../../css/font-awesome.min.css"/>
	  <script type="text/javascript" src="../../js/jquery-2.0.3.min.js"></script>
	  <script type="text/javascript" src="../../js/index.js"></script>
</head>
<body>
	<div class="search d7">
	<form>
	  <input type="text" placeholder="搜索从这里开始..."/>
	  <button type="submit"></button>
	</form>
	</div>
	<div id="wrapper"><!-- 最外层部分 -->
    <div id="banner" class="ul1"><!-- 轮播部分 -->
        <ul class="imgList"><!-- 图片部分 -->
            <li><a href="pinglun"><img class="img" src="../../img/imgturn/1.jpg" width="1000px" height="350px" alt="Trave"/></a></li>
            <li><a href="pinglun"><img class="img" src="../../img/imgturn/2.jpg" width="1000px" height="350px" alt="Trave"/></a></li>
            <li><a href="pinglun"><img class="img" src="../../img/imgturn/3.jpg" width="1000px" height="350px" alt="Trave"/></a></li>
            <li><a href="pinglun"><img class="img" src="../../img/imgturn/4.jpg" width="1000px" height="350px" alt="Trave"/></a></li>
            <li><a href="pinglun"><img class="img" src="../../img/imgturn/5.jpg" width="1000px" height="350px" alt="Trave"/></a></li>
        </ul>
        <img src="../../img/imgturn/left.jpg" width="20px" height="40px" id="prev"/>
        <img src="../../img/imgturn/right.jpg" width="20px" height="40px" id="next"/>
        <div class="bg"></div> <!-- 图片底部背景层部分-->
        <ul class="infoList"><!-- 图片左下角文字信息部分 -->
            <li class="infoOn"> </li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
        <ul class="indexList"><!-- 图片右下角序号部分 -->
            <li class="indexOn"></li>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>
    </div>
	<div class="Onshow">
		<nav id="onshow-li"class="onshow-li">
			<ul>
				<li id="li1"class="active" >正在热映</li>
				<li id="li2" >即将上映</li>
			</ul>
		</nav> 
		
		<p class="pp">________________________________________________________________________</p>
		
		<div id="movie-onshow" class="div2" >
            <% for (int i = 0; i < 6; i++) {  %>
				<div class="information">
					<div class="movie" >
						<a href="pinglun"><img src="../../img/imgturn/1.jpg" style="width:170px;height:250px;"/></a>
					</div>
					<div class="description" id="description">
						<p>电影名称<mark>上映时间</mark></p>
						<span>电影描述信息-承诺的及时发货费不是变成可
                            	电影描述信息-承诺的及时发货费不是变成可
                           	 电影描述信息-承诺的及时发货费不是变成可
						</span>
						<div class="score">
							<input type="text" value="分数"/>
						</div>
				   </div>
				</div>
            <%} %>
			
		</div>

		<div id="movie-next" class="div2" >
            <%for (int i = 0; i < 6; i++) {  %>
			<div class="information">
				<div class="movie" >
					<a href="javascript:;"><img src="../../img/imgturn/2.jpg" style="width:170px;height:250px;"/></a>
				</div>
				<div class="description">
					<p>电影名称<mark>上映时间</mark></p>
					<span>电影描述信息-承诺的及时发货费不是变成可</span>
					<div class="score">
						<input type="text" value="分数"/>
					</div>
			   </div>
			</div>
            <%} %>
			
		</div>

		<div>
			<input type="button" value="←" />
			<input type="button" value="→" />
			<span class="prev-btn"><a class="btn-prev" href="javascript:void(0)"></a></span>
			<span class="next-btn"><a class="btn-next" href="javascript:void(0)"></a></span>
		</div>
	</div>

	
	<div class="special">
		<div><h1>特色榜单</h1></div>
		<div class="special-movie">
			<div class="reconmend">
				<img src="../../img/reconmend/1.jpg" style="width:300px;height:220px;float:left;"/>
				<div class="reconmend-pic">
					<img src="../../img/reconmend/2.jpg" style="width:130px;height:108px;"/>
					<img src="../../img/reconmend/3.jpg" style="width:130px;height:108px;"/>
				</div>
				<div>
					<span>热门新片推荐</span>
				</div>
			</div>

		</div>

		<div class="special-movie">
			<div class="reconmend">
				<img src="../../img/reconmend/5.jpg" style="width:300px;height:220px;float:left;"/>
				<div class="reconmend-pic">
					<img src="../../img/reconmend/4.jpg" style="width:130px;height:108px;"/>
					<img src="../../img/reconmend/6.jpg" style="width:130px;height:108px;"/>
				</div>
				<div>
					<span>内地影视票房TOP(10)</span>
				</div>
			</div>
		</div>
		
		<div class="special-movie">
			<div class="reconmend">
				<img src="../../img/reconmend/7.jpg" style="width:300px;height:220px;float:left;"/>
				<div class="reconmend-pic">
					<img src="../../img/reconmend/8.jpg" style="width:130px;height:108px;"/>
					<img src="../../img/reconmend/9.jpg" style="width:130px;height:108px;"/>
				</div>
				<div>
					<span>全球影视票房TOP(10)</span>
				</div>
			</div>
		</div>

		<div class="special-movie">
			<div class="reconmend">
				<img src="../../img/reconmend/10.jpg" style="width:300px;height:220px;float:left;"/>
				<div class="reconmend-pic">
					<img src="../../img/reconmend/12.jpg" style="width:130px;height:108px;"/>
					<img src="../../img/reconmend/11.jpg" style="width:130px;height:108px;"/>
				</div>
				<div>
					<span>穿越回过去与熟人相遇10部金典</span>
				</div>
			</div>
		</div>

	</div>
	
    <div class="movie_score" id="movie_score">
       <div class="score_head">
           <span>添加收藏：写短评</span>
           <input type="button" value="关闭"onclick="cancel();"/>
       </div>
        <div class="score_mid">
            <span class="s1">给个评分吧1~10噢</span>
            <input id="score2" class="score"type="text" />
            <span class="s2">简短评论</span>
            <span id="num" class="num">140</span>
            <textarea id="textarea" maxlength="140"></textarea>
        </div>
        
        <div class="score_fool"><input id="save"type="button" value="保存" onclick="save();"/></div>
    </div>

</body>
</html>
