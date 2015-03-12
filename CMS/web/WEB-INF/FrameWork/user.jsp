<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  User: jiangq
  Date: 2015/2/12
  Time: 15:45
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

    <!--[if lte IE 8]>
    <script src="lib/html5shiv.min.js"></script>
    <script src="lib/respond.min.js"></script><![endif]-->
</head>
<body>
<div class="fw-toolbar">
    <div class="easyui-panel" style="padding:4px;" fit="true">
        <a onclick="newUser()" class="easyui-linkbutton" plain="true" iconCls="fa fa-plus">新增</a>
        <a onclick="editUser()" class="easyui-linkbutton" plain="true" iconCls="fa fa-pencil">修改</a>
        <a onclick="destroyUser()" class="easyui-linkbutton" plain="true" iconCls="fa fa-trash-o">删除</a>
    </div>
</div>
<%--用户列表--%>
<div>
    <div style="padding-bottom: 5px;">用户列表</div>
    <table id="userlist" class="easyui-datagrid" style="width:100%;"
           url="/user" method="GET"
           pagination="true"
           rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="code" width="50" align="center">用户编号</th>
            <th field="name" width="50" align="center">用户名称</th>
            <th field="email" width="50" align="center">用户邮箱</th>
            <th field="createTime" width="50" formatter="formatDate" align="center">创建时间</th>
            <th field="state" width="50" formatter="formateStatus" align="center">用户状态</th>
        </tr>
        </thead>
    </table>
</div>
<%--新增页面--%>
<div id="add-dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#add-buttons">
    <div class="fw-form-title">User Information</div>
    <form id="adduser" method="post" novalidate="true" class="fw-form">
        <div>
            <label>用户编号：</label>
            <input name="code" class="easyui-textbox" required="true">
        </div>
        <div>
            <label>用户名：</label>
            <input name="name" class="easyui-textbox" required="true">
        </div>
        <div>
            <label>密码：</label>
            <input name="password" class="easyui-textbox">
        </div>
        <div>
            <label>邮箱：</label>
            <input name="email" class="easyui-textbox" validType="email">
        </div>
    </form>
</div>
<div id="add-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton " iconCls="fa fa-check" onclick="addUser()"
       style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-times"
       onclick="javascript:$('#add-dlg').dialog('close')" style="width:90px">取消</a>
</div>
<%--修改--%>
<div id="edit-dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#edit-buttons">
    <div class="fw-form-title">User Information</div>
    <form id="user" method="post" class="fw-form" novalidate="true">
        <div>
            <label>用户编号：</label>
            <input name="code" class="easyui-textbox" required="true" readonly="true">
        </div>
        <div>
            <label>用户名：</label>
            <input name="name" class="easyui-textbox" required="true">
        </div>
        <div>
            <label>邮箱:</label>
            <input name="email" class="easyui-textbox" validType="email">
        </div>
        <div>
            <label>创建时间</label>
            <input name="createTime" class="easyui-textbox" readonly="true">
        </div>
        <div>
            <label>状态</label>
            <input name="state" class="easyui-textbox" readonly="true">
        </div>
    </form>
</div>
<div id="edit-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="fa fa-check" onclick="updateUser()"
       style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-times"
       onclick="javascript:$('#edit-dlg').dialog('close')" style="width:90px">取消</a>
</div>
</body>
<link href="lib/font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="lib/jquery-easyui-1.4.1/themes/own/easyui.css" rel="stylesheet" type="text/css">
<link href="lib/jquery-easyui-1.4.1/themes/icon.css" rel="stylesheet" type="text/css">
<link href="static/styles/Framework.css" rel="stylesheet" type="text/css">
<!--[if !IE]> -->
<script src="lib/jquery/jquery-2.1.3.min.js"></script>
<!-- <![endif]-->
<!--[if IE]>
<script src="lib/jquery/jquery-1.11.2.min.js"></script><![endif]-->
<script src="lib/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script src="lib/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script src="static/js/Framework.js"></script>
<script src="static/js/user.js"></script>
</html>
