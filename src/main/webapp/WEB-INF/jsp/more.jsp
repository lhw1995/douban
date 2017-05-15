<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>">
    <title>更多评论</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript" src="../../js/jquery-2.0.3.min.js"></script>
    <!-- 本地加载mock.js文件 -->
    <script src="../../js/mock.js"></script>
    <script src="../../js/pinglun.js"></script>
    <script src="../../js/moreFilmComments.js"></script>
    <link rel="stylesheet" type="text/css" href="../../bootstrap3/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/more.css"/>
</head>
<body id="body">
<jsp:include page="header.jsp"></jsp:include>
<div class="ctn">

    <%--电影信息--%>
    <div id="films">
        <input type="hidden" id="more_film_id" value="001"/>
        <h1>
            <span>独自在夜晚的海边 밤의 해변에서 혼자</span> <span class="year">(2017)</span>
        </h1>
        <img src="../../img/1.jpg" width="100" height="150"/>
        <p class="inf">
            导演: 洪尚秀<br/> 编剧: 洪尚秀<br/> 主演: 金敏喜 / 徐永嬅 / 郑在咏 / <br/> 文成根 / 权海骁
            / 更多...<br/> 类型: 剧情<br/> 制片国家/地区: 韩国<br/> 语言: 韩语<br/> 上映日期:
            2017-02-16(柏林电影节) / <br/> 2017-03-23(韩国)<br/> 片长: 101分钟<br/>
            又名: 等一个人的心湾(港) /<br/> On the Beach at Night Alone
        </p>
        <p class="score">
            评分<span>7.1</span>
        </p>
    </div>
    <div class="line"></div>
    <div class="gtleft">
        <ul class="myul">
            <li><img src="../../img/short.bmp"/>&nbsp; <a class="write"
                                                    id="writeShort" href="javascript:;" rel="nofollow"
                                                    onclick="showWriteShort(this.id)">写短评</a></li>
            <li><img src="../../img/add_f.bmp"/>&nbsp; <a class="write"
                                                    id="write" href="longView" rel="nofollow">写影评</a></li>
        </ul>
    </div>
    <div class="jianjie">
        <p class="title">
            <i class="">独自在夜晚的海边的剧情简介</i>· · · · · ·
        </p>
        <div class="indent" id="link-report">
			<span class="sp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;某外国城市，来自韩国的女演员英熙，正因为和国内一
				个已婚男子的恋情而备受压力，她放弃了一切，甘受千夫 所指以此表明心迹。他说会去找他，但她并不相信。在熟识
				的朋友家吃过饭，她去了海边。她认为朋友不会理解这段感情， 但还是问道：“他会像我思念他一样思念我吗” <br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;韩国江陵。几个老朋友的聚会。起初气氛有点尴尬，喝了些酒之后，
				英熙想吓吓他们。她表现得冷漠又不近人情，但他们反而喜欢这样。 酒终人散，英熙独自去了海滩，发泄重重心事似雾般消散。她想知道，
				爱在生命中到底有多重要？ </span>
        </div>
    </div>

    <div class="short">
        <p class="title">
            <i class="">独自在夜晚的海边的短评</i>· · · · · ·
        </p>
        <a class="writeshort" id="writeshort" href="javascript:;"
           onclick="showWriteShort(this.id)">我要写短评</a>
        <div id="filmComments">
            <%--短评区--%>
        </div>
        <%--<%for (int i = 0; i < 12; i++) { %>
        <div class="comment-item">
            <div class="comment">
                <h3>
					<span class="comment-info"> <a href="#" class="name">一叶知秋</a>
						<span>看过</span>
                        <span class="comment-time " title="2017-02-19 18:24:10">2017-02-19</span> 
                        <span class="score1">&nbsp;&nbsp;评分&nbsp;&nbsp;&nbsp;<i id="scores"></i>7</span> </span>
                </h3>
                <p class="content1">他说会去找他，但她并不相信。在熟识的朋友家吃过饭，她去了海边。她认为朋友不会理解这段感情， 但还是问道：</p>

            </div>
        </div>
        <%} %>--%>
    </div>
    <div class="pages">
        <%--当前页面号--%>
        <input type="hidden" id="currPageNo" value="1"/>
        <input type="hidden" id="pageCount" value="1"/>
        <button id="firstBtn" onclick="clickFirst()" class="btn btn-primary">首页</button>
        <button id="preBtn" onclick="clickPre()" class="btn btn-primary">上一页</button>
        <button id="nextBtn" onclick="clickNext()" class="btn btn-primary">下一页</button>
        <button id="lastBtn" onclick="clickLast()" class="btn btn-primary">最后一页</button>
    </div>
    <div class="movie_score" id="movie_score">
        <div class="score_head">
            <span>添加收藏：写短评</span> <input type="button" value="关闭"
                                         onclick="cancel();"/>
        </div>
        <div class="score_mid">
            <span class="s1">给个评分吧1~10噢</span> 
            <input id="score2" class="score" type="text"/> 
            <span class="s2">简短评论</span> 
            <span id="num" class="num">140</span>
            <textarea id="textarea" maxlength="140"></textarea>
        </div>

        <div class="score_fool">
            <input id="save" type="button" value="保存" onclick="save();"/>
        </div>
    </div>
</div>
<div class="footer">
    <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
<script>
    Mock.mock('http://test.com', {
        'name|1': ['一叶知秋'],
        'score|0-10': 1,
        'content|1': ['被某些又当又立的女主粉恶心到，让你们求仁得仁：）']
    });
    $.ajax({
        type: "GET",
        url: 'http://test.com',
        dataType: "json",
        data: {},
        success: function (data) {
            var _html = '';
            $.each(data, function (index, content) {
                //$(".name").append(data);
                //$("#scores").innerText(data[1]);
                //$(".content1").innerText(data[2]);
                _html += '<a href=\'#\' class=\'name\'>' + content + '</a>';
                //$.each(content, function (key, value) {
                // _html += '<li>' + key + " : " + value + '</li>';
                // });


            });
            //$("#resText").append(_html);
        }
    });
</script>
</html>
