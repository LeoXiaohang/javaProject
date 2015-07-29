<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiaohang
  Date: 7/19/15
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
  <th width="50px" align="center">编号</th>
  <th width="50px" align="center">姓名</th>
  <th width="50px" align="center">职位</th>
  <%--<th width="90px" align="center">性别</th>--%>
  <%--<th width="50px" align="center">邮箱</th>--%>
  <%--<th width="50px" align="center">年龄</th>--%>

  <c:forEach items="${coachs}" var="coach">
    <tr>
      <td width="50px" align="center"><c:out value="${coach.id}"/></td>
      <td width="50px" align="center"><c:out value="${coach.name}"/></td>
      <td width="50px" align="center"><c:out value="${coach.department}"/></td>
      <td><a href="/web/selectCoach?id=${coach.id}">添加私教</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
