<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/13
  Time: 上午5:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%-- 运行结果：不行 --%>
<img src="http://localhost:8080/hi" onclick="this.src=this.src">

<%-- 运行结果：可以 --%>
<img src="http://localhost:8080/hi" onclick="this.src=this.src + '?' + Math.random()">

<%-- 运行结果：可以【推荐】 --%>
<img src="http://localhost:8080/hi" onclick="this.src=this.src + '?' + Date.now()">

<%-- 运行结果：可以 --%>
<img src="http://localhost:8080/hi" onclick="function getVerify(p) {
      p.src ='http://localhost:8080/hi?'+Math.random();
}
getVerify(this)">
</body>
</html>
