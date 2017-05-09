/**
 * Created by lhw2 on 2017/5/9.
 */
/**
 * 添加长影评
 */
function addFilmCritics() {
    var filmId = $("input[name='filmId']").val();
    var title = $("#title").val();
    var score = $("#score2").val();
    var content = $("#textarea").val()

    var reg = /^[0-9]{1,2}$/g;
    if (!reg.test(score)){
        alert("只能输入数字");
        return;
    }

    var params = {
        "filmId":filmId,
        "title":title,
        "score":score,
        "content":content
    };

    $.ajax({
        type:"post",
        url:"film_critics",
        dataType:"json",
        contentType: 'application/json',
        data:JSON.stringify(params),
        success:function (data) {
            window.location = "/pinglun";
        }
    })

}