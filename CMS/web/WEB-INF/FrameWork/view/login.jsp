<%--
  User: jiangq
  Date: 2015/1/5
  Time: 16:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <link href="../lib/bootstrap-3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    <link href="../static/styles/login.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="login">
    <div class="header">管理系统登陆</div>
    <br/>
    <br/>

    <div class="input-group">
        <span class="input-group-addon" ><span class="glyphicon glyphicon-user"></span></span>
        <input id="code" type="text" class="form-control" placeholder="用户名" aria-describedby="userName">
    </div>
    <br/>

    <div class="input-group">
        <span class="input-group-addon" ><span class="glyphicon glyphicon glyphicon-lock"></span></span>
        <input id="password" type="password" class="form-control" placeholder="密码" aria-describedby="userCode">
    </div>
    <br/><label id="message" style="color: red"></label>
    <br/>
    <button id="login" type="button" class="btn btn-primary"
            style="width: 100px;margin-left: 130px;background-color: #42B2FB">登陆
    </button>
</div>
</body>
<!--[if !IE]> -->
<script src="../lib/jquery/jquery-2.1.3.min.js"></script>
<!-- <![endif]-->
<!--[if IE]>
<script src="../lib/jquery/jquery-1.11.2.min.js"></script>
<![endif]-->
<script src="../static/js/login.js"></script>
</html>
