/**
 * User: jiangq
 * Date: 2015/2/11
 * Time: 9:45
 * Description:
 */
$(function () {
    $("#login").click(function () {
        var code = $("#code").val();
        var password = $("#password").val();
        if (code == "" || password == "") $("#message").text("请输入用户名和密码");
        else login(code, password);
    });
    function login(code, password) {
        $.ajax({
            type: "POST",
            dataType:"json",
            url: "login",
            data: {code: code, password: password},
            success: function (data) {
                if (data.state=="true") {
                    window.location.href = "index";
                }
                else {
                    $("#message").text(data.msg);
                }
            },
            error: function (err) {
                $("#message").text("服务器忙碌，请稍后再试");
            }
        })
        ;
    }
})