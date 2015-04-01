/**
 * User: jiangq
 * Date: 2015/2/26
 * Time: 9:45
 * Description:
 */
$(function () {
    $("#userlist").autoHeight(80);
    //$('#roles').combobox({
    //    icons: [{iconCls: 'fa fa-spinner fa-pulse'}]
    //});
})
var id;
//新增
function newUser() {
    $('#dlg').dialog('open').dialog('setTitle', '新增');
    $('#user').form('clear');
    $("[mame='code']").removeAttr("readonly");
    $("[hide-flag]").hide();
    $('#role').combotree('setValue', '');

}
//修改
function editUser() {
    var row = $('#userlist').datagrid('getSelected');
    if (row) {
        row.createTime = formatDate(row.createTime);
        row.password = "******";
        $('#dlg').dialog('open').dialog('setTitle', '修改');
        $('#user').form('load', row);
        $("[mame='code']").attr("readonly", "readonly");
        $.get("user/" + row.id, function (data) {
            var checked = [];
            for (var i in data.roles) {
                checked.push(data.roles[i].id);
            }
            $('#roles').combobox('setValues', checked);
        }, "json");
        id = row.id;
    }
    else {
        fw.popup("请选中需要修改的行");
    }
}
//保存
function saveUser() {
    var data = $("#user").serializeObject();

    delete data.createTime;
    if (data.id == "") delete data.id;
    if (data.state == "") data.state = 0;
    if (data.password == "******") delete data.password;
    else data.password = RSAEncrypt(data.password);
    var selected = $('#roles').combobox("getValues");
    data.roles = [];
    for (var i in selected) {
        data.roles.push({id: selected[i]});
    }

    if ($("#user").form('validate'))
        fw.formPost("user", data,
            function (data) {
                if (data == "ok") {
                    $('#userlist').datagrid('reload')
                    fw.popup("保存成功");
                    $('#dlg').dialog('close');
                }
                else if (data == "existed") {
                    fw.popup("用户编号或邮箱已经再存")
                }
            }
        );
}
//删除
function destroyUser() {
    var row = $('#userlist').datagrid('getSelected');
    if (row) {
        $.messager.confirm('确定', '确定要删除当前用户吗?', function (r) {
            if (r) {
                fw.remove('user/' + row.id, function (data) {
                    if (data == "ok") {
                        $('#userlist').datagrid('reload')
                        fw.popup("删除成功");
                    }
                }, "text")
            }
        });
    }
    else {
        fw.popup("请选中需要删除的行");
    }
}
function formatDate(val, row) {
    var d = new Date(val);
    return d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();

}
function formatState(val, row) {
    switch (val) {
        case "0":
            return "正常";
            break;
        case "1":
            return "停用";
            break;
        default :
            return "";
            break;
    }

}
