<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../../lib/css/subject.css"/>
    <title>个人信息</title>
    <spring:url value="./lib/js/jquery-1.11.1.min.js" var="jquery"/>
    <script src="${jquery}"></script>
    <spring:url value="./lib/js/bootstrap.min.js" var="boot"/>
    <script src="${boot}"></script>
    <spring:url value="./js/update.js" var="updateJs"/>
    <script src="${updateJs}"></script>

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
        <table id="table" align="center" border="1">
            <th width="200px" align="center">编号</th>
            <th width="200px" align="center">用户名</th>
            <c:forEach items="${persons}" var="person">
                <tr id = "${person.id}">
                    <td class="person-id" width="200px" align="center"><c:out value="${person.id}"/></td>
                    <td class="person-name" width="200px" align="center"><c:out value="${person.userName}"/></td>
                    <td><a href="/web/delete?id=${person.id}">删除</a></td>
                    <td>
                        <button class="updateButton">修改</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form id="updateForm" hidden="hidden">
            <input type="text" class="update-id" name="id" hidden="hidden" value=""/>
            用户名 : <input type="text" class="update-name" name="userName" value=""/> <br/>
            密码 : <input type="password" class="update-password" name="password" value=""/> <br/>
            <button id="submit_button" type="submit" value="提交">提交</button>
        </form>
    </div>

    <div id="footer">Copyright www.localhost:8080/web/hello</div>
</div>


</body>
</html>