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
</head>
<body>
<form name="loginForm" method="post" action="/web/login">
    <table>
        <tr>
            <td>
                <%--用户名:<input type="text" name="userName" id="userName"></td>--%>
                <label for="userName">用户名:</label><input type="text" name="userName" id="userName"/>
        </tr>
        <tr>
            <td>
                <%--密码:<input type="password" name="password" id="password"></td>--%>
                <label for="password">密码:&nbsp</label><input type="password" name="password" id="password"/>
        </tr>
        <tr>
            <td>
                <input type="submit" value="登录" style="background-color:pink" />
                <%--<input type="button" value="登陆" onclick="addCookie('userName', document.forms[loginForm].elements[userName].value, 1)" />--%>
                <input type="submit" value="重置" style="background-color:red"></td>
        </tr>
    </table>

</form>
</body>
</html>
