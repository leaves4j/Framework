<%--
  User: jiangq
  Date: 2014/8/29
  Time: 15:36
--%>
<%@ page import="com.leaves.framework.model.Function" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title></title>
    <meta name="description" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>
    <%--<link href="lib/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>--%>
    <!--[if lte IE 8]>
    <script src="lib/html5shiv.min.js"></script>
    <script src="lib/respond.min.js"></script>
    <![endif]-->
</head>
<body style="width: 100%;height: 100%;">
<div></div>
<div id="loading"
     style="position: fixed;height: 100%;width: 100%;z-index: 99999;background-color: #ffffff;text-align:center"
     align="center">
    <img style="overflow: auto;margin: auto;position: absolute;top: 0; left: 0; bottom: 0; right: 0;"
         src="static/Images/294.GIF">
</div>
<div class="easyui-layout" style="width: 100%;height: 100%;" fit="true">
    <div id="header" data-options="region:'north'">

    </div>
    <%--<div id="footer" data-options="region:'south'"></div>--%>
    <div id="function" style="width: 200px" data-options="region:'west',headerCls:'menu-header',title:'菜单'">
        <ul id="menu">
            <%
                @SuppressWarnings("unchecked")
                List<Function> functions = (List<Function>) request.getAttribute("functions");
                List<Function> pFunctions = new ArrayList<Function>();
                List<Function> cFunctions = new ArrayList<Function>();
                for (Function function : functions) {
                    if (function.getPath() == null)
                        pFunctions.add(function);
                    else
                        cFunctions.add(function);
                }
                for (Function function : pFunctions) {
                    out.write("<li>");
                    out.write("<div class=\"title\"><i class=\"" + function.getIcon() + "\"></i>" + function.getName() + "<i class=\"fa fa-chevron-down\"></i></div>");
                    out.write("<ul class=\"item\">");
                    for (Function cFunction : cFunctions) {
                        if (cFunction.getPath().equals(function.getId()))
                            out.write("<li><a data-value=\"" + cFunction.getId() + "\" data-uri=\"" + cFunction.getUri() + "\">" + cFunction.getName() + "</a></li>");
                    }
                    out.write("</ul>");
                    out.write("</li>");
                }
            %>
        </ul>
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
        </div>
    </div>
</div>
<link href="lib/font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="lib/jquery-easyui-1.4.1/themes/own/easyui.css" rel="stylesheet" type="text/css">

<link href="lib/jquery-easyui-1.4.1/themes/icon.css" rel="stylesheet" type="text/css">
<!--[if !IE]> -->
<script src="lib/jquery/jquery-2.1.3.min.js"></script>
<!-- <![endif]-->
<!--[if IE]>
<script src="lib/jquery/jquery-1.11.2.min.js"></script>
<![endif]-->
<script src="lib/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<link href="static/styles/index.css" rel="stylesheet" type="text/css">
<script src="static/js/index.js"></script>
</body>

</html>