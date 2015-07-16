<%--import java.lang.string;--%>
<%--
  Created by IntelliJ IDEA.
  User: xiaohang
  Date: 7/14/15
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录成功</title>
</head>
<body>

<%
  request.setCharacterEncoding("GB18030");
  String name = request.getParameter("userName");
  out.println("欢迎你:" + name);
//  System.out.println("欢迎你:" + name);
%>
</body>
</html>
