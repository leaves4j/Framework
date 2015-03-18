/**
 * User: jiangq
 * Date: 2015/3/13
 * Time: 15:08
 * Description:
 */
$(function () {
    $("#functionList").autoHeight(80);
});
//加载数据
function loadData(param, success, error) {
    $.get("/framework/function", function (data) {
        success(fw.toEasyTreeJson(data, "id", "path"));
    }, "json")

}
//增加节点按钮
function add() {
    $('#dlg').dialog('open').dialog('setTitle', '新增节点');
    $('#function').form('clear');
    $('#URI').hide();
}
//增加子节点按钮
function addChildren() {
    $('#URI').show();
    var row = $('#functionList').treegrid('getSelected');
    if (row && !row.path) {
        $('#dlg').dialog('open').dialog('setTitle', '新增子节点');
        $('#function').form('clear');
        $("input[name='path']").val(row.id);
    }
    else {
        fw.popup("请选中需要增加子节点的根节点");
    }
}
//修改按钮
function edit() {
    var row = $('#functionList').treegrid('getSelected');
    if (row) {
        if (!row.path)
            $('#URI').hide();
        $('#dlg').dialog('open').dialog('setTitle', '修改');
        $('#function').form('load', row);
    }
    else {
        fw.popup("请选中需要修改的行");
    }
}
//删除按钮
function destroy() {
    var row = $('#functionList').treegrid('getSelected');

    if (row) {
        var message = row.path == "" ? "您选定的功能节点包含子节点，确定删除该节点及其子节点吗？" : "确定要删除该节点吗？";
        $.messager.confirm('确定', message, function (r) {
            if (r) {
                fw.remove('/framework/function/' + row.id, function (data) {
                    if (data == "ok") {
                        $('#functionList').treegrid('reload');
                        fw.popup("删除成功");
                    }
                }, "text");
            }
        });
    }
    else {
        fw.popup("请选中需要删除的行");
    }
}
//保存
function addOrUpdateFunction() {
    var frmFunction = $("#function");
    var data = frmFunction.serializeObject();
    if (data.id == "") delete data.id;
    if (data.path == "") delete data.path;
    if (frmFunction.form('validate'))
        fw.formPost("/framework/function", data,
            function (data) {
                if (data == "ok") {
                    $('#functionList').treegrid('reload');
                    fw.popup("保存成功");
                    $('#dlg').dialog('close');
                }
                else if (data == "existed") {
                    fw.popup("用户编号已经再存")
                }
            }
        );
}
function formatIcon(val, row) {
    return "<i class='"+val+"'>";
}