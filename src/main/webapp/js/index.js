
function getLength(str) {
    return str.replace(/[^\x00-xff]/g, "xx").length;
}
function imgturn() {
    var curIndex = 0, //当前index
    imgLen = $(".imgList li").length; //图片总数
    // 定时器自动变换2.5秒每次
    var autoChange = setInterval(function () {
        if (curIndex < imgLen - 1) {
            curIndex++;
        } else {
            curIndex = 0;
        }
        //调用变换处理函数
        changeTo(curIndex);
    }, 10000);
    //左箭头滑入滑出事件处理
    $("#prev").hover(function () {
        //滑入清除定时器
        clearInterval(autoChange);
    }, function () {
        //滑出则重置定时器
        autoChangeAgain();
    });
    //左箭头点击处理
    $("#prev").click(function () {
        //根据curIndex进行上一个图片处理
        curIndex = (curIndex > 0) ? (--curIndex) : (imgLen - 1);
        changeTo(curIndex);
    });
    //右箭头滑入滑出事件处理
    $("#next").hover(function () {
        //滑入清除定时器
        clearInterval(autoChange);
    }, function () {
        //滑出则重置定时器
        autoChangeAgain();
    });
    //右箭头点击处理
    $("#next").click(function () {
        curIndex = (curIndex < imgLen - 1) ? (++curIndex) : 0;
        changeTo(curIndex);
    });
    //对右下角按钮index进行事件绑定处理等
    $(".indexList").find("li").each(function (item) {
        $(this).hover(function () {
            clearInterval(autoChange);
            changeTo(item);
            curIndex = item;
        }, function () {
            autoChangeAgain();
        });
    });
    //清除定时器时候的重置定时器--封装
    function autoChangeAgain() {
        autoChange = setInterval(function () {
            if (curIndex < imgLen - 1) {
                curIndex++;
            } else {
                curIndex = 0;
            }
            //调用变换处理函数
            changeTo(curIndex);
        }, 5000);
    }
    function changeTo(num) {
        var goLeft = num * 1500;
        $(".imgList").animate({ left: "-" + goLeft + "px" }, 500);
        $(".infoList").find("li").removeClass("infoOn").eq(num).addClass("infoOn");
        $(".indexList").find("li").removeClass("indexOn").eq(num).addClass("indexOn");
    }

    var onav = document.getElementById('se-nav');
    var lis = onav.getElementsByTagName('li');
    var ocontent = document.getElementById('content');
    var adiv = ocontent.getElementsByTagName('div');

    for (var i = 0; i < lis.length; i++) {
        lis[i].index = i;
        var color1 = '';
        lis[i].onmouseover = function () {
            for (var j = 0; j < lis.length; j++) {
                lis[j].className = '';
                adiv[j].style.display = 'none';
            }
            this.className = 'active';
            adiv[this.index].style.display = 'block';

        }
    }
}

function tab() {
    //选择项
    var li1 = document.getElementById('li1');
    var li2 = document.getElementById('li2');

    //需要显示的两个div
    var onshow = document.getElementById('movie-onshow');
    var nextshow = document.getElementById('movie-next');

    li1.onmouseover = function () {
        li1.className = 'active';
        onshow.style.display = 'block';
        li2.className = '';
        nextshow.style.display = 'none';
    };

    li2.onmouseover = function () {
        li2.className = 'active';
        nextshow.style.display = 'block';
        li1.className = '';
        onshow.style.display = 'none';
    };


}
function cancel() {
    var movie_score = document.getElementById('movie_score');
    movie_score.style.display = "none";
}
function save() {
    var tip = "";
    var score = document.getElementById('score2').value;
    var regu = /^([1-9]|10)$/;
    var re = new RegExp(regu);
    if (!re.test(score)) {
        tip = "评分只能输入1~10";
    }else { tip = "评论成功" }
    alert(tip);
    
}
function count() {
    var num = document.getElementById('num');
    var textarea = document.getElementById('textarea');
    textarea.onkeyup = function () {
        //this.value = this.value.substring(0, 140);
        var texarea_length = getLength(this.value);
        if (texarea_length < 141) {
            texarea_length1 = 140 - texarea_length;
            num.innerHTML = texarea_length1;
        } else if (texarea_length > 140) {
            textarea.innerText = this.value.substring(0,140);
        }
    }
}

window.onload = function () {

    count();
    tab();
    imgturn();
    
};