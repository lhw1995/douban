$(document).ready(function () {
    /**
     * 页面加载好后加载短评
     */
    var filmId = $("input[name='filmId']").val();

    var params = {
        "pageSize":5,
        "currPageNo":1
    };
    $.ajax({
        type:"POST",
        url:"film_comments/"+filmId,
        dataType:"json",
        contentType: 'application/json',
        data:JSON.stringify(params),
        success:function (data) {
            for (var i in data.filmCommentsList){

                var score = data.filmCommentsList[i].score;
                var _star = getStar(score);
                var _div = "<div class='comment-item'>"+
                    "<div class='comment'>"+
                    "<h3>"+
                    "<span class='comment-info'>"+
                    "<a href='#' class='name'>"+data.filmCommentsList[i].userId+"</a>"+
                    "<span>看过</span>"+
                    "<span class='comment-time' title='2017-02-19 18:24:10'>"+new Date(data.filmCommentsList[i].createTime).toLocaleString()+"</span>"+
                    "<span class='score1'>&nbsp;&nbsp;评分&nbsp;&nbsp;&nbsp;<i id='scores'></i>"+data.filmCommentsList[i].score + _star +"</span>"+
                    "</span>"+
                    "</h3>"+
                    "<p class='content1'>"+data.filmCommentsList[i].content+"</p>"+
                    "</div>"+
                    "</div>";
                $("#filmComments").append(_div);
            }

        }
    })
});

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