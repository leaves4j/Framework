/**
 * Created by jiangq on 2014/12/25.
 */
$(function () {
    function addTabs(title, url, id) {
        $('#main-tabs').tabs('add', {
            title: title,
            content: '<iframe id="' + id + '" src="' + url + '" frameborder=no border=0></iframe>',
            closable: true
        });
    }

    // addTabs('欢迎', '/welcome',"welcome_i");


    $(document).ajaxError(ajaxRedirectListener);
    function ajaxRedirectListener(e, jqXHR, ajaxOptions, err) {
        if (jqXHR.status == 401)
            $.message.alert("提示", "您的登陆信息已经过期，请重新登陆", "info", function () {
                window.location.href = '/login'
            })
    }

    $("#menu .title").click(function () {
        $(this).next().slideToggle("normal");
        if ($(this).hasClass("open")) {
            $(this).removeClass("open")
        }
        else {
            $(this).addClass("open")
        }
    });
    $("#menu .item li").click(function () {
        $("#menu .item li.selected").removeClass("selected");
        $(this).addClass("selected");
        var link = $(this).children("a");
        var id = link.attr("data-value");
        var title = link.text();
        var uri = link.attr('data-uri');
        if ($('#main-tabs').tabs("exists", title)) {
            $('#main-tabs').tabs("select", title)
        }
        else {
            addTabs(title, uri, id);
        }

    });
});
$.parser.onComplete = function () {
    $('#loading').hide();
};
