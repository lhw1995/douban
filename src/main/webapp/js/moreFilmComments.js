/**
 * Created by lhw2 on 2017/5/15.
 */
$(document).ready(function () {
    //获得首页评论
    clickFirst();

});

/**
 * 获得首页评论
 * @type {any}
 */
function clickFirst() {
    //获得电影id
    var filmId = $("#more_film_id").val();
    var params = {
        "pageSize":10,
        "currPageNo":1
    };
    getPageComments(params,filmId);
}

/**
 * 获得上一页评论
 * @type {any}
 */
function clickPre() {
    //获得电影id
    var filmId = $("#more_film_id").val();
    //获得当前页面号
    var currPageNo = $("#currPageNo").val();
    if (currPageNo <= 1) {
        currPageNo = 1;
    } else {
        currPageNo -= 1;
    }
    var params = {
        "pageSize":10,
        "currPageNo":parseInt(currPageNo)
    };
    getPageComments(params,filmId);
}

/**
 * 获得下一页评论
 * @type {any}
 */
function clickNext() {
    //获得电影id
    var filmId = $("#more_film_id").val();
    //获得当前页面号
    var currPageNo = parseInt($("#currPageNo").val());
    //获得总页面数
    var pageCount = parseInt($("#pageCount").val());
    if (currPageNo != pageCount) {
        currPageNo += 1;
    }
    var params = {
        "pageSize":10,
        "currPageNo":parseInt(currPageNo)
    };
    getPageComments(params,filmId);
}

/**
 * 获得尾页评论
 * @type {any}
 */
function clickLast() {
    //获得电影id
    var filmId = $("#more_film_id").val();
    //获得当前页面号
    var currPageNo = $("#currPageNo").val();
    //获得总页面数
    var pageCount = $("#pageCount").val();

    currPageNo = pageCount;
    var params = {
        "pageSize":10,
        "currPageNo":parseInt(pageCount)
    };
    getPageComments(params,filmId);
}

/**
 * 根据参数显示页面信息
 * @param params
 */
function getPageComments(params,filmId) {
    console.log(params);
    $.ajax({
        type:"POST",
        url:"film_comments/"+filmId,
        dataType:"json",
        contentType: 'application/json',
        data:JSON.stringify(params),
        success:function (data) {
            $("#pageCount").val(data.page.totalPageCount);
            $("#currPageNo").val(data.page.currPageNo);
            $("#filmComments").empty();
            for (var i in data.filmCommentsVoList){

                var score = data.filmCommentsVoList[i].score;
                var _star = getStar(score);
                var _div = "<div class='comment-item'>"+
                    "<div class='comment'>"+
                    "<h3>"+
                    "<span class='comment-info'>"+
                    "<a href='#' class='name'>"+data.filmCommentsVoList[i].userName+"</a>"+
                    "<span>看过</span>"+
                    "<span class='comment-time' title='2017-02-19 18:24:10'>"+new Date(data.filmCommentsVoList[i].createTime).toLocaleString()+"</span>"+
                    "<span class='score1'>&nbsp;&nbsp;评分&nbsp;&nbsp;&nbsp;<i id='scores'></i>"+data.filmCommentsVoList[i].score + _star +"</span>"+
                    "</span>"+
                    "</h3>"+
                    "<p class='content1'>"+data.filmCommentsVoList[i].content+"</p>"+
                    "</div>"+
                    "</div>";
                $("#filmComments").append(_div);
                console.log(data);
                console.log(_div);
            }

        }
    })
}

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