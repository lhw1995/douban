<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>写下你的长评</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
      <script src="../../js/jquery-2.0.3.min.js"></script>
      <script src="../../js/pinglun.js"></script>
      <script src="../../js/AddFilmCritics.js"></script>
      <link rel="stylesheet" type="text/css" href="../../css/longView.css" />
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<h1>
		<span>独自在夜晚的海边 밤의 해변에서 혼자</span> <span class="year">(2017)</span>
	</h1>
    <div id="longView">
    	
      <div class="movie_score" id="movie_score">
       <div class="score_head">

           <span>添加收藏：写长评</span>
           <a href="pinglun.jsp">返回</a>
       </div>
        <div class="score_mid">
            <span class="s0">给个题目吧</span>
            <input id="title" class="title" type="text" />
            <span class="s1">给个评分吧</span>
            <input id="score2" class="score"type="text" />
            <input type="button" value="上传图片" class="upload"/>
            <span class="s2">说说的你的看法</span>
            <textarea id="textarea" class=""></textarea>
        </div>
        <div class="score_fool"><input id="save"type="button" value="保存" onclick="save();"/></div>
    </div>
   </div>
   <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
