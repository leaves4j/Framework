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
        $('#edit-dlg').dialog('open').dialog('setTitle', '修改');
        $('#user').form('load', row);
        id = row.id;
    }
}
//新增
function addUser() {
    fw.formPost("/user", "adduser",
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
    fw.formPost("/user/"+id, "user",
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
                fw.remove('/user/' + row.id, function (data) {
                    if (data == "ok") {
                        fw.popup("保存成功");
                    }
                }, "text")
            }
        });
    }
}
function formatDate(val, row) {
    var d = new Date(val);
    return d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate() + " " + d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();

}
function formateStatus(val, row) {
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
