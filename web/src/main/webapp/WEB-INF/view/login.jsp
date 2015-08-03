<%--
  Created by IntelliJ IDEA.
  User: xiaohang
  Date: 7/14/15
  Time: 8:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="./lib/css/subject.css"/>
</head>
<body>


<div id="container">
    <div id="header">
        <h1>健身房管理系统</h1>
    </div>
    <div id="menu" align="center">
        <a href="/web/hello" >首页</a><br><br>
        <a href="/web/add" >添加用户</a><br><br>
        <a href="/web/subject">显示全部课表</a><br><br>
        <a href="/web/printAllCustomer">显示全部顾客</a><br><br>
        <a href="/web/logout">退出登录</a><br><br>

    </div>
    <div id="content">
        <form name="loginForm" method="post" action="/web/login">
            <br/><br/><br/><br/>
            <p>用户名:<input type="text" name="userName" id="userName"/></p>
            <p>密码:&nbsp&nbsp&nbsp&nbsp<input type="password" name="password" id="password"/></p>
            <input type="submit" value="登录" style="background-color:pink"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <input type="submit" value="重置" style="background-color:red">

        </form>
    </div>
    <div id="footer">Copyright www.localhost:8080/web/hello</div>
</div>

</div>
</body>
</html>
