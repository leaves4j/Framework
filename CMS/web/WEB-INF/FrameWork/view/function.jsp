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
        <a onclick="add()" class="easyui-linkbutton" plain="true" iconCls="fa fa-plus">增加节点</a>
        <a onclick="addChildren()" class="easyui-linkbutton" plain="true" iconCls="fa fa-plus">增加子节点</a>
        <a onclick="edit()" class="easyui-linkbutton" plain="true" iconCls="fa fa-pencil">修改</a>
        <a onclick="destroy()" class="easyui-linkbutton" plain="true" iconCls="fa fa-trash-o">删除</a>
    </div>
</div>
<%--功能列表--%>
<div>
    <div style="padding-bottom: 5px;">功能列表</div>
    <table id="functionList" class="easyui-treegrid" style="width:100%;height:250px"
           data-options="
                rownumbers: true,
                animate: true,
                collapsible: true,
                fitColumns: true,
                idField: 'id',
                treeField: 'name',
                loader: loadData
            ">
        <thead>
        <tr>
            <th data-options="field:'name',width:50">功能名称</th>
            <th data-options="field:'code',width:50,align:'center'">功能代码</th>
            <th data-options="field:'uri',width:50">URI</th>
            <th data-options="field:'icon',width:20,align:'center',formatter:formatIcon">图标</th>
        </tr>
        </thead>
    </table>
</div>

<%--新增修改--%>
<div id="dlg" class="easyui-dialog" style="width:400px;height:400px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="fw-form-title">功能信息</div>
    <form id="function" method="post" class="fw-form" novalidate="true">
        <div>
            <label>功能序号：</label>
            <input name="number" class="easyui-numberbox" required="true" max="99999999">
        </div>
        <div>
            <label>功能编号：</label>
            <input name="code" class="easyui-textbox" required="true"  validType="length[1,30]">
        </div>
        <div>
            <label>功能名称：</label>
            <input name="name" class="easyui-textbox" required="true" validType="length[1,30]">
        </div>
        <div id="URI">
            <label>URI</label>
            <input name="uri" class="easyui-textbox"  validType="length[1,100]">
        </div>
        <div>
            <label>图标</label>
            <input name="icon" class="easyui-textbox"  validType="length[1,50]">
        </div>
        <div style="display:none">
            <input name="path">
            <input name="id">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="fa fa-check" onclick="addOrUpdateFunction()"
       style="width:90px">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="fa fa-times"
       onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
</div>
</body>

<script src="../static/js/Framework.js"></script>
<script src="../static/js/function.js"></script>
</html>
