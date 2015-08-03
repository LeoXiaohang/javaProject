<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiaohang
  Date: 7/20/15
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部顾客</title>
    <link rel="stylesheet" type="text/css" href="../../lib/css/subject.css"/>
</head>
<body>


<div id="container">
    <div id="header">
        <h1>健身房管理系统</h1>
    </div>
    <div id="menu" align="center">
        <a href="/web/hello">首页</a><br><br>
        <a href="/web/add">添加用户</a><br><br>
        <a href="/web/subject">显示全部课表</a><br><br>
        <a href="/web/printAllCustomer">显示全部顾客</a><br><br>
        <a href="/web/logout">退出登录</a><br><br>
    </div>
    <div id="content">
        <table class="hovertable" align="center" border="1">
            <th width="50px" align="center">编号</th>
            <th width="50px" align="center">用户名</th>

            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td width="200px" align="center"><c:out value="${customer.id}"/></td>
                    <td width="200px" align="center"><c:out value="${customer.name}"/></td>
                    <td><a href="/web/deleteCustomer?id=${customer.id}">删除</a></td>
                    <c:if test="${customer.coach.id == null}">
                        <td><a href="/web/coach?id=${customer.id}">添加私教</a></td>
                    </c:if>
                    <c:if test="${customer.coach.id != null}">
                        <td><a href="/web/getCourse?id=${customer.id}">添加私教</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <header>添加顾客</header>
        <form method="POST" action="/web/addCustomer" name="addCustomer">

            姓名 : <input type="text" name="name" value="<c:out value="${name}" />"/> <br/>
            <input type="submit" value="提交"/>
        </form>
    </div>
    <div id="footer">Copyright www.localhost:8080/web/hello</div>
</div>

</div>

</body>
</html>
