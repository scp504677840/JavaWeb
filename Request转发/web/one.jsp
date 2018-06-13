<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/14
  Time: 上午7:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>One</title>
</head>
<body>

${data}

<%
    String data = (String) request.getAttribute("data");
    out.write(data);
%>
</body>
</html>
