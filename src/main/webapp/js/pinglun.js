function showContent() {
    var name = document.getElementsByClassName("right1");
    var content1 = document.getElementsByClassName("content2");
    var content = document.getElementsByClassName("content");
    for (var i = 0; i < name.length; i++) {
        name[i].onclick = function () {
            if (this.className == "right1") {
                this.className = "right";
                this.title = "收起全文";
                alert(content[i].length);
                content1[i].style.display = "block";
                content[i].style.display = "none";
            } else {
                this.className = "right1";
                this.title = "展开全文";
                alert(content1[i].style.display);
                content1[i].style.display = "none";
                content[i].style.display = "block";
            }
        }
    }
    
}

function showWriteShort(id) {
    var movie_score = document.getElementById("movie_score");
    movie_score.style.display = "block";
    count();
    //if (id == "write") {
        //longView.style.marginTop = "-20px";
   // } else {
       // longView.style.marginTop = "600px";
    // }
}


function getLength(str) {
    return str.replace(/[^\x00-xff]/g, "xx").length;
}

function cancel() {
    var movie_score = document.getElementById('movie_score');
    movie_score.style.display = "none";
	//window.location.href="pinglun.jsp";
}
/**
 * 添加短评
 */
function save() {
    var tip = "";
    var score = document.getElementById('score2').value;
    var regu = /^([1-9]|10)$/;
    var re = new RegExp(regu);
    if (!re.test(score)) {
        tip = "评分只能输入1~10";
        alert(tip);
    }
    //添加短评
    var filmId = $("input[name='filmId']").val();
    var content = $("textarea[name='content']").val();

    var params = {
        "filmId":filmId,
        "score":score,
        "content":content
    };
    console.log(params);

    $.ajax({
        type:"post",
        url:"/film_comments",
        dataType:"json",
        contentType: 'application/json',
        data:JSON.stringify(params),
        success:function (data) {
            location.reload();
        }
    })

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
            textarea.innerText = this.value.substring(0, 140);
        }
    }
}
window.onload = function () {
    count();
};