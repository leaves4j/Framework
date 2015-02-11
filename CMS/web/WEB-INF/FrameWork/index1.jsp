<%--
  User: jiangq
  Date: 2014/8/29
  Time: 15:36
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
    <link href="lib/font-awesome-4.2.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="lib/jquery-easyui-1.4.1/themes/default/easyui.css" rel="stylesheet" type="text/css">
    <link href="lib/jquery-easyui-1.4.1/themes/icon.css" rel="stylesheet" type="text/css">


    <!--[if !IE]> -->
    <script src="lib/jquery/jquery-2.1.3.min.js"></script>
    <!-- <![endif]-->
    <!--[if IE]>
    <script src="lib/jquery/jquery-1.11.2.min.js"></script>
    <![endif]-->
    <script src="lib/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <%--<script src="lib/jquery-easyui-1.4.1/easyloader.js"></script>--%>
    <link href="static/styles/framework.css" rel="stylesheet" type="text/css">
    <script src="static/js/framework.js"></script>
    <!--[if lte IE 8]>
    <script src="lib/html5shiv.min.js"></script>
    <script src="lib/respond.min.js"></script>
    <![endif]-->
</head>
<body style="padding: 1px">
<div id="loading" class="loading">

    <div class="sk-spinner sk-spinner-circle">
        <div class="sk-circle1 sk-circle"></div>
        <div class="sk-circle2 sk-circle"></div>
        <div class="sk-circle3 sk-circle"></div>
        <div class="sk-circle4 sk-circle"></div>
        <div class="sk-circle5 sk-circle"></div>
        <div class="sk-circle6 sk-circle"></div>
        <div class="sk-circle7 sk-circle"></div>
        <div class="sk-circle8 sk-circle"></div>
        <div class="sk-circle9 sk-circle"></div>
        <div class="sk-circle10 sk-circle"></div>
        <div class="sk-circle11 sk-circle"></div>
        <div class="sk-circle12 sk-circle"></div>

    </div>
</div>
<div id="layout" style="display: none;width: 100%;height: 100%;">
    <div class="easyui-layout" style="width: 100%;height: 100%;" fit="true">
        <div id="header" data-options="region:'north'"></div>
        <div id="footer" data-options="region:'south'"></div>
        <div id="menu" data-options="region:'west',headerCls:'menu-header',title:'菜单'">
            <jsp:include page="/menu"></jsp:include>
        </div>
        <div id="main" data-options="region:'center'">
            <div id="main-tabs" class="easyui-tabs" style="width:100%;height:100%" data-options="fit:true,border:false">
                <div title="主页" style="padding:10px;width:100%;height:100%">
                    <p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
                    <ul>
                        <li>easyui is a collection of user-interface plugin based on jQuery.</li>
                        <li>easyui provides essential functionality for building modem, interactive, javascript
                            applications.
                        </li>
                        <li>using easyui you don't need to write many javascript code, you usually defines
                            user-interface by
                            writing some HTML markup.
                        </li>
                        <li>complete framework for HTML5 web page.</li>
                        <li>easyui save your time and scales while developing your products.</li>
                        <li>easyui is very easy but powerful.</li>
                    </ul>
                </div>
                <div title="人员管理" data-options="closable:true" style="padding:10px">

                </div>
                <div title="Help" data-options="closable:true">
                    <iframe src="" style="background-color: #F9F9F9"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>