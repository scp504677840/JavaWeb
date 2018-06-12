<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/13
  Time: 上午7:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功，跳转首页</title>
</head>
<body>
<%
    String message = (String) application.getAttribute("message");
    out.write(message);
%>
</body>
</html>
