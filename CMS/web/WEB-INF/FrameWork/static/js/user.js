/**
 * User: jiangq
 * Date: 2015/2/26
 * Time: 9:45
 * Description:
 */
$(function () {
    $("#userlist").autoHeight(80);
})
var id;
//
function newUser() {
    $('#add-dlg').dialog('open').dialog('setTitle', '新增');
    $('#adduser').form('clear');

}
//
function editUser() {
    var row = $('#userlist').datagrid('getSelected');
    if (row) {
        row.state=formatState(row.state);
        row.createTime=formatDate(row.createTime);
        $('#edit-dlg').dialog('open').dialog('setTitle', '修改');
        $('#user').form('load', row);
        id = row.id;
    }
    else {
        fw.popup("请选中需要修改的行");
    }
}
//新增
function addUser() {
    var data=$("#adduser").serializeObject();
    if ($("#adduser").form('validate'))
        fw.formPost("framework/user", data,
            function (data) {
                if (data == "ok") {
                    $('#userlist').datagrid('reload')
                    fw.popup("保存成功");
                    $('#add-dlg').dialog('close');
                    $('#edit-dlg').dialog('close');
                }
                else if (data == "existed") {
                    fw.popup("用户编号或邮箱已经再存")
                }
            }
        );
}
//更新
function updateUser() {
    var data=$("#user").serializeObject();
    delete data.state;
    delete data.createTime;
    if ($("#user").form('validate'))
        fw.formPost("framework/user" + id, data,
            function (data) {
                if (data == "ok") {
                    $('#userlist').datagrid('reload')
                    fw.popup("保存成功");
                    $('#add-dlg').dialog('close');
                    $('#edit-dlg').dialog('close');
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
                fw.remove('framework/user' + row.id, function (data) {
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
