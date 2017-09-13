<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/13 0013
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>One测试</title>
</head>
<body>
<h1>One测试</h1>
<%-- 这个页面一运行下面的程序就好执行，里面的URL都会被执行。 --%>
<c:forEach var="url" items="${hiddenUrl}">
    <iframe src="${url}" width="0px" height="0px" style="display: none"></iframe>
</c:forEach>
</body>
</html>