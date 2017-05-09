<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../../css/Review.css"/>
    <script src="../../js/Review.js"></script>
    <script src="../../js/pinglun.js"></script>
</head>
<body>
    <div id="content">
        <h1>豆瓣最受欢迎的影评</h1>
        <div>
            <ul>
                <li>最受欢迎的/</li>
                <li class="active">新片评论</li>
            </ul>
        </div>
        <%--短评--%>

        <div class="intent">
            <a  href="pinglun">        
                <img alt="最好的我们" title="最好的我们" src="../../img/imgturn/1.jpg" style="width:100px;height:140px;"/>
            </a>
            <header class="main-hd">
                <div class="title">
                     <a href="javascript:;" class="title-link">你曾是少年 你永远是少年</a>
                     <div class="toggle_review">       
                           <a class="right1" href="javascript:;" title="展开全文" onclick="showContent()"></a>
                     </div>
                </div>
                <div class="header-more">
                     <a href="javascript:;" class="author"><span >一个屠夫</span> </a>    
                     <span>评论 </span>    
                     <a class="subject-title" href="pinglun">最好的我们</a>
                     <span >2017-05-04 10:11:52</span>
                </div>
            </header>
            <div class="short-content">
                  “当时的他是最好的他 而很多年后的我才是最好的我 最好的他和最好的我之间 
                    隔了一整个青春” 我喜欢自信阳光一笑起来会有虎牙的余淮 也爱被现实打磨在逆
                    境中翻滚的余淮 我想念年少的他会在阳光明媚的午后给喜欢的女孩子讲题 偶尔耍
                    耍恶作剧 也理解十年后的他拼命想要得到却我喜欢自信阳光一笑起来会有虎牙的余淮 也爱被现实打磨在逆
                    境中翻滚的余淮 我想念年少的他会在阳光明媚的午仍...

                  <a class="pl" href="javascript:;">(7回应)</a>
                  <div class="more-info">
                    <span class="left">29有用 / 1没用</span>
                  </div>
            </div>
        </div>
    	</c:forEach>
    </div>
</body>
</html>
