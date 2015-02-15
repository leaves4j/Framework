<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  User: jiangq
  Date: 2015/2/12
  Time: 15:45
  Description:
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title></title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <link href="static/styles/Framework.css" rel="stylesheet" type="text/css">
    <!--[if lte IE 8]>
    <script src="lib/html5shiv.min.js"></script>
    <script src="lib/respond.min.js"></script><![endif]-->
    <script type="text/javascript">
        var userList = ${userList};
    </script>
</head>
<body>
<%--<div class="fw-toolbar">--%>
    <%--<div class="easyui-panel" style="padding:5px;">--%>
    <%--<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'">Cancel</a>--%>
    <%--<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-reload'">Refresh</a>--%>
    <%--<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'">Search</a>--%>
    <%--<a href="#" class="easyui-linkbutton" data-options="plain:true">Text Button</a>--%>
    <%--<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-print'">Print</a>--%>
    <%--<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-help'"> </a>--%>
    <%--<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save'"></a>--%>
    <%--<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-back'"></a>--%>
    <%--</div>--%>
<%--</div>--%>
<toolbar>
    <button ><i class=""/>新增</button>
    <button ></button>
</toolbar>
<link href="lib/font-awesome-4.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="lib/jquery-easyui-1.4.1/themes/own/easyui.css" rel="stylesheet" type="text/css">
<link href="lib/jquery-easyui-1.4.1/themes/icon.css" rel="stylesheet" type="text/css">
<!--[if !IE]> -->
<script src="lib/jquery/jquery-2.1.3.min.js"></script>
<!-- <![endif]-->
<!--[if IE]>
<script src="lib/jquery/jquery-1.11.2.min.js"></script><![endif]-->
<script src="lib/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
</body>

</html>
