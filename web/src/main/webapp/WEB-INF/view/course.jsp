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
    <link rel="stylesheet" type="text/css" href="../../lib/css/subject.css"/>
</head>
<div>


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
            <header>该教练已有课程</header>
            <table align="center" border="1">
                <th width="50px" align="center">编号</th>
                <th width="50px" align="center">课程</th>
                <th width="50px" align="center">时间</th>
                <th width="50px" align="center">教练</th>

                <c:forEach items="${courses}" var="course">
                    <tr>
                        <td width="200px" align="center"><c:out value="${course.id}"/></td>
                        <td width="200px" align="center"><c:out value="${course.course}"/></td>
                        <td width="200px" align="center"><c:out value="${course.time}"/></td>
                        <td width="200px" align="center"><c:out value="${course.coach.name}"/></td>
                    </tr>
                </c:forEach>
            </table>
            <header>添加私教</header>
            <form method="POST" action="/web/selectCoach" name="addCourse">

                <input type="text" name="id" hidden="hidden" readonly="readonly" value="<c:out value="${id}" />"/>
                <p>课程 :<select name="course">
                    <option value="健美操">健美操</option>
                    <option value="形体芭蕾">形体芭蕾</option>
                    <option value="羽毛球">羽毛球</option>
                    <option value="私教课">私教课</option>
                </select></p>
                <p>时间 : <input name="time" type="date" value="2015-07-24" min="2015-07-24"/></p>

                <input type="submit" value="提交"/>
            </form>
        </div>
        <div id="footer">Copyright www.localhost:8080/web/hello</div>
    </div>

</div>

</body>
</html>
