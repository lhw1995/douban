/**
 * Created by lhw2 on 2017/5/9.
 */
$(document).ready(function () {
    /**
     * 页面加载好后加载长影评
     */
    var filmId = $("input[name='filmId']").val();

    var params = {
        "pageSize":3,
        "currPageNo":1
    };
    $.ajax({
        type:"post",
        url:"film_critics/"+filmId,
        dataType:"json",
        contentType: 'application/json',
        data:JSON.stringify(params),
        success:function (data) {
            for (var i in data.filmCriticsVoList){
                /**
                 * 评分后加上星星
                 * @type {boolean}
                 */
                var _star = getStar(data.filmCriticsVoList[i].score);
                var _div = "<div class='comment-item'>"+
                    "<div class='comment'>"+
                    "<h2 class='viewTitle'>"+
                    "<a class='look' href='#'>"+data.filmCriticsVoList[i].title+"</a>"+
                "</h2>"+
                "<a class='right1' href='javascript:;' title='展开全文' onclick='showContent()'></a>"+
                    "<h3>"+
                    "<span class='comment-info'> " +
                    "<a href='#' class='name'>"+data.filmCriticsVoList[i].userName+"</a>"+
                    "<span>看过</span>" +
                    " <span class='comment-time' title='2017-02-19 18:24:10'>"+new Date(data.filmCriticsVoList[i].createTime).toLocaleString()+"</span>" +
                    "<span class='score1'>&nbsp;&nbsp;评分&nbsp;&nbsp;&nbsp;<i id='I1'></i>"+ data.filmCriticsVoList[i].score + _star +"</span>"+
					"</span>"+
				"</h3>"+
				"<div class='content'>"+data.filmCriticsVoList[i].content+"</div>"+
			    "</div>"+
		        "</div>";
                $("#filmCritics").append(_div);



            }

        }
    })
})

function getStar(score) {
    var star2Flag = false;
    if (score%2 != 0){
        star2Flag = true;
    }
    var _star = "";
    for (var k = 0; k < parseInt(score/2);k ++) {
        _star = _star+"<img src='../img/star.png' width='15' height='15'/>";
    }
    if (star2Flag) {
        _star = _star+"<img src='../img/star2.png' width='15' height='15'/>";
    }
    return _star;
}