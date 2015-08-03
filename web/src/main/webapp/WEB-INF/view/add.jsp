<%--
  Created by IntelliJ IDEA.
  Person: xiaohang
  Date: 7/10/15
  Time: 7:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>添加新用户</title>
    <link rel="stylesheet" type="text/css" href="../../lib/css/subject.css"/>
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
        <form method="POST" action="/web/add" name="addPerson">
            <br/><br/><br/><br/><br/>
            <p>姓名 :<input type="text" name="name" value="<c:out value="${name}" />"/></p>
            <p>职位 :<select name="department">
                <option value="Coach">Coach</option>
                <option value="HR">HR</option>
                <option value="OPs">OPs</option>
            </select></p>
            <p>用户名 : <input type="text" name="userName" value="<c:out value="${userName}" />"/></p>
            <p>密码 : <input type="password" name="password" value="<c:out value="${password}" />"/></p>
            <input type="submit" value="提交"/>
        </form>
    </div>
    <div id="footer">Copyright www.localhost:8080/web/hello</div>
</div>

</div>
</body>
</html>