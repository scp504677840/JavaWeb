<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/16
  Time: 上午11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%-- 静态包含 --%>
<%@include file="head.jsp" %>
<br>

静态包含<br>

<%@include file="foot.jsp" %>
<br>

<%-- 动态包含 --%>
<%
    request.getRequestDispatcher("/head.jsp").include(request, response);
%>

动态包含<br>

<%
    request.getRequestDispatcher("/foot.jsp").include(request, response);
%>

</body>
</html>
