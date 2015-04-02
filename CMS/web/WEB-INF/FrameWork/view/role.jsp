<%--
  User: jiangq
  Date: 2015/3/13
  Time: 10:30
  Description:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title></title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <link href="../lib/font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../lib/jquery-easyui-1.4.1/themes/own/easyui.css" rel="stylesheet" type="text/css">
    <link href="../lib/jquery-easyui-1.4.1/themes/icon.css" rel="stylesheet" type="text/css">
    <link href="../static/styles/Framework.css" rel="stylesheet" type="text/css">
    <!--[if !IE]> -->
    <script src="../lib/jquery/jquery-2.1.3.min.js"></script>
    <!-- <![endif]-->
    <!--[if IE]>
    <script src="../lib/jquery/jquery-1.11.2.min.js"></script><![endif]-->
    <script src="../lib/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script src="../lib/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <!--[if lte IE 8]>
    <script src="../lib/html5shiv.min.js"></script>
    <script src="../lib/respond.min.js"></script><![endif]-->
</head>
<body>

<div class="fw-toolbar">
    <div class="easyui-panel" style="padding:4px;" fit="true">
        <a onclick="addRole()" class="easyui-linkbutton" plain="true" iconCls="fa fa-plus">新增</a>
        <a onclick="editRole()" class="easyui-linkbutton" plain="true" iconCls="fa fa-pencil">修改</a>
        <a onclick="deleteRole()" class="easyui-linkbutton" plain="true" iconCls="fa fa-trash-o">删除</a>
    </div>
</div>
<%--用户列表--%>
<div>
    <div style="padding-bottom: 5px;">角色列表</div>
    <table id="roleList" class="easyui-datagrid" style="width:100%;"
           url="role" method="GET" nowrap="false"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="code" width="30" align="center">角色编号</th>
            <th field="name" width="30" align="center">角色名称</th>
            <th field="temp" width="60" formatter="formatFunction" align="center">功能</th>
            <th field="description" width="40" align="center">备注</th>

        </tr>
        </thead>
    </table>
</div>
<%--详情页面--%>
<div id="dlg" class="easyui-dialog" style="width:400px;height:400px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="fw-form-title">角色信息</div>
    <form id="role" method="post" novalidate="true" class="fw-form">
        <div>
            <label>角色编号：</label>
            <input name="code" class="easyui-textbox" required="true" validType="length[1,30]">
        </div>
        <div>
            <label>角色名称：</label>
            <input name="name" class="easyui-textbox" required="true" validType="length[1,30]">
        </div>
        <div>
            <label>备注：</label>
            <input name="description" class="easyui-textbox" validType="length[0,500]">
        </div>
        <div>
            <label>功能：</label>
            <select id="function" class="easyui-combotree" data-options="loader:loadData" multiple style="width:175px;"></select>
        </div>
        <div style="display: none">
            <input name="id">
        </div>
    </form>

</div>
<div id="dlg-buttons">
    <a class="easyui-linkbutton " iconCls="fa fa-check" onclick="saveRole()"
       style="width:90px">保存</a>
    <a class="easyui-linkbutton" iconCls="fa fa-times"
       onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
</div>

</body>

<script src="../static/js/Framework.js"></script>
<script src="../static/js/role.js"></script>
</html>
