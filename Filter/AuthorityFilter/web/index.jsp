<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/25 0025
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

<%
    String username = (String) session.getAttribute("username");
    String authority = (String) session.getAttribute("authority");
    String[] authorities = authority.split(",");
%>

<p>
    用户名：<%=username%>
</p>

<%
    for (String authorityName : authorities) {
%>
<p>
    ---<%=authorityName%>
</p>
<%
    }
%>

<p><a href="<%=request.getContextPath()%>/home/one.jsp">One</a></p>
<p><a href="<%=request.getContextPath()%>/home/two.jsp">Two</a></p>
<p><a href="<%=request.getContextPath()%>/home/three.jsp">Three</a></p>
<p><a href="<%=request.getContextPath()%>/home/four.jsp">Four</a></p>

</body>
</html>
