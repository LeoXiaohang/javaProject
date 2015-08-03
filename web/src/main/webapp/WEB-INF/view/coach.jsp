<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiaohang
  Date: 7/19/15
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="../../lib/css/subject.css" />
<html>
<head>
    <title>教练信息</title>
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
        <table align="center" border="1">
            <%--<th width="50px" align="center">教练</th>--%>
            <th width="200px" align="center">编号</th>
            <th width="200px" align="center">姓名</th>
            <th width="200px" align="center">职位</th>

            <c:forEach items="${coachs}" var="coach">
                <tr>
                    <input type="text" name="customerId" hidden="hidden" readonly="readonly" value="<c:out value="${customerId}" />"/>
                    <td width="200px" align="center"><c:out value="${coach.id}"/></td>
                    <td width="200px" align="center"><c:out value="${coach.name}"/></td>
                    <td width="200px" align="center"><c:out value="${coach.department}"/></td>
                    <td><a href="/web/selectCoach?id=${coach.id}&customerId=${customerId}">选择教练</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="footer">Copyright www.localhost:8080/web/hello</div>
</div>
</body>
</html>
