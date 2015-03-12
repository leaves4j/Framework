/**
 * User: jiangq
 * Date: 2015/2/26
 * Time: 9:37
 * Description:
 */
$.fn.extend({

    autoHeight: function (heightMargin) {
        var height = $("html").height() - heightMargin;

        $(this).datagrid('resize', {
            height: height
        });
        var _this = this;
        $(window).resize(function () {
            var height = $("html").height() - heightMargin;
            $(_this).datagrid('resize', {
                height: height
            });
        });
    },
    serializeObject: function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    }
})
var fw = {
    post: function (url, data, success, type) {
        $.ajax({
            type: "POST",
            dataType: type == undefined || type == '' ? 'text' : type,
            url: url,
            processData: false,
            contentType: "application/json;charset=utf-8",
            data: data,
            success: success
        })
    },
    formPost: function (url,formId,success,type) {
        $.ajax({
            type: "POST",
            dataType: type == undefined || type == '' ? 'text' : type,
            url: url,
            processData: false,
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify($('#' + formId).serializeObject()),
            success: success
        })
    },
    get: $.get,
    remove: function (url, success, type) {
        $.ajax({
            type: "DELETE",
            dataType: type == undefined || type == '' ? 'json' : type,
            url: url,
            processData: false,
            contentType: "text/plain;charset=utf-8",
            success: success
        })
    },
    popup: function (msg) {
        $.messager.show({
            title: '提示',
            msg: msg,
            timeout: 5000,
            showType: 'slide'
        })
    }
}