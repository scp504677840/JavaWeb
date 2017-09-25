<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/25 0025
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Content</title>
</head>
<body>
<p>
    <a href="<%=request.getContextPath()%>/index.jsp">首页</a>
</p>
<p>
    <span>内容：</span>
    <%=session.getAttribute("content")%>
</p>
</body>
</html>
