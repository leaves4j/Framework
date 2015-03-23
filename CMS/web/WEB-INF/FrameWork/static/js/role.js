/**
 * User: jiangq
 * Date: 2015/3/18
 * Time: 10:43
 * Description:
 */
$(function () {
    $("#roleList").autoHeight(80);
})
//加载功能树数据
function loadData(param, success, error) {
    $.get("function", function (data) {
        success(fw.LTreeToOTree(data, "id", "path", "name"));
    }, "json")

}
//新增
function addRole() {
    $('#dlg').dialog('open').dialog('setTitle', '新增角色');
    $('#role').form('clear');
    $('#function').combotree('setValue', '');
    //$('#URI').hide();
}
//修改
function editRole() {

    var row = $('#roleList').datagrid('getSelected');
    if (row) {
        $('#dlg').dialog('open').dialog('setTitle', '修改角色');
        $('#role').form('load', row);
        var checked = [];
        for (var i in row.functions) {
            if (row.functions[i].path != null)
                checked.push(row.functions[i].id);
        }
        $('#function').combotree('setValues', checked);
    }
    else {
        fw.popup("请选中需要修改的行");
    }
}
//删除
function deleteRole() {
    var row = $('#roleList').datagrid('getSelected');
    if (row) {
        $.messager.confirm('确定', '确定要删除当前角色吗?', function (r) {
            if (r) {
                fw.remove('role/' + row.id, function (data) {
                    if (data == "ok") {
                        $('#roleList').datagrid('reload');
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
//保存
function saveRole() {
    var frmRole = $("#role");
    var data = frmRole.serializeObject();
    data.functions = getTreeChecked();
    if (data.id == "") delete data.id;
    if (frmRole.form('validate'))
        fw.formPost("role", data,
            function (data) {
                if (data == "ok") {
                    $('#roleList').datagrid('reload');
                    fw.popup("保存成功");
                    $('#dlg').dialog('close');
                }
                else if (data == "existed") {
                    fw.popup("用户编号或邮箱已经再存")
                }
            }
        );

}
//获取功能树选中数据
function getTreeChecked() {
    var data = [];
    var functionTree = $('#function').combotree('tree');
    var checked = functionTree.tree('getChecked', ['checked', 'indeterminate']);
    for (var i in checked) {
        data.push(checked[i].attributes);
    }
    return data;
}

function formatFunction(val, row) {
    var data = "";
    for (var i in row.functions) {
        if (row.functions[i].path != null) {
            data += row.functions[i].name;
            data += ","
        }
    }
    data = data.substring(0, data.length - 1)
    return "<span title='" + data + "' class='easyui-tooltip'>" + data + "</span>";
}