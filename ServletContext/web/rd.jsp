<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/13
  Time: 上午3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转发</title>
</head>
<body>
<h1>
    <%
        String name = (String) application.getAttribute("name");
        out.write(name);
    %>
</h1>
</body>
</html>
