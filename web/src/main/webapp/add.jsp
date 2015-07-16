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
</head>
<body>
<form method="POST" action="/add" name="addPerson">

  <%--编号 : <input type="hidden" name="id" value="<c:out value="${person.id}" />"/> <br/>--%>
  姓名 : <input type="text" name="name" value="<c:out value="${person.name}" />"/> <br/>
  性别 : <input type="text" name="sex" value="<c:out value="${person.sex}" />"/> <br/>
  邮箱 : <input type="text" name="email" value="<c:out value="${user.email}" />"/> <br/>
  年龄 : <input type="text" name="age" value="<c:out value="${perosn.age}" />"/> <br/>
  <input type="submit" value="提交"/>
</form>
</body>
</html>