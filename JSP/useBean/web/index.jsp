<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/16
  Time: 下午12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<%-- AAA在javaBean初始化时输出 --%>
<jsp:useBean id="person" class="bean.Person" scope="page">
    AAA
</jsp:useBean>
<%=person.getName()%>
<%--<%
    String name = person.getName();
    out.write("name：" + name);
%>--%>

<%-- 基本数据类型 --%>
<%--<jsp:setProperty name="person" property="name" param="jack"/>
<%-- 引用数据类型 --%>
<%--<jsp:setProperty name="person" property="birthday" value="<%=new Date()%>"/>

<jsp:getProperty name="person" property="name"/>--%>
</body>
</html>
