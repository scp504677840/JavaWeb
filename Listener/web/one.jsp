<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/25 0025
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>One</title>
</head>
<body>
<%session.invalidate();%>
<a href="<%=request.getContextPath()%>/index.jsp">Index</a>
</body>
</html>
