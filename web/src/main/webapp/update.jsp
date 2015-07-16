<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%--
  Created by IntelliJ IDEA.
  entity: xiaohang
  Date: 7/10/15
  Time: 7:40 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
  <title>修改用户</title>
</head>
<body>
<form method="POST" action="/web/update" name="updatePerson">

  <%--<input type="hidden" name="id" value="<c:out value="${person.id}" />"/> <br/>--%>
    <%--<c:out value="${person.id}"/>--%>
    <%--<intput type="text" name="id" value="<c:out value="${person.id}" />"/><br/>--%>
    <input type="text"  name="id" hidden="hidden" readonly="readonly" value="<c:out value="${person.id}" />"/>
  姓名 : <input type="text" name="name" value="<c:out value="${person.name}" />"/> <br/>
  性别 : <input type="text" name="sex" value="<c:out value="${person.sex}" />"/> <br/>
  邮箱 : <input type="text" name="email" value="<c:out value="${person.email}" />"/> <br/>
  年龄 : <input type="text" name="age" value="<c:out value="${perosn.age}" />"/> <br/>
  <input type="submit" value="提交"/>
</form>
</body>
</html>