<%--
  Created by IntelliJ IDEA.
  User: xiaohang
  Date: 7/8/15
  Time: 12:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<head>
    <title>个人信息</title>
</head>
<body>
<table>
    <th width="50px" align="center">编号</th>
    <th width="50px" align="center">姓名</th>
    <th width="90px" align="center">性别</th>
    <th width="50px" align="center">邮箱</th>
    <th width="50px" align="center">年龄</th>

    <c:forEach items="${persons}" var="person">
        <tr>
            <td width="50px" align="center"><c:out value="${person.id}"/></td>
            <td width="50px" align="center"><c:out value="${person.name}"/></td>
            <td width="90px" align="center"><c:out value="${person.sex}"/></td>
            <td width="50px" align="center"><c:out value="${person.email}"/></td>
            <td width="50px" align="center"><c:out value="${person.age}"/></td>
            <td><a href="/web/delete?id=${person.id}">删除</a></td>
            <td><a href = "/web/update?id=${person.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
    <div><a href ="./add.jsp">添加</a></div>
</body>
</html>
