<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/13 0013
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login测试</title>
</head>
<body>
<form action="http://check.x.com:8080/sso/doLogin.action" method="post">
    <span>用户名：</span><input type="text" name="username">
    <span>密码：</span><input type="password" name="password">
    <input type="hidden" name="gotoUrl" value="${gotoUrl}">
    <button type="submit">提交</button>
</form>
</body>
</html>
