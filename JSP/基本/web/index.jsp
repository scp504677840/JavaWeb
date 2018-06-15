<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/15
  Time: 下午9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%-- 1.JSP 脚本代码 --%>
<%
    String name = "tom123";
%>
<%=name%>

<%-- 2.JSP 脚本代码 --%>
<%
    for (int i = 0; i < 10; i++) {
%>
<h3>Hi,Jsp</h3><br>
<%
    }
%>

<%-- 3.JSP声明 --%>
<%!
    private void pl() {

    }
%>
</body>
</html>
