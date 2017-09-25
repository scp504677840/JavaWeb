<%@ page import="session.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/25 0025
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/one.jsp">One</a>

<%
    //    触发ServletContext属性监听器
//    ServletContext servletContext = request.getServletContext();
//    servletContext.setAttribute("name","tom");
//    servletContext.setAttribute("name","jack");
//    servletContext.removeAttribute("name");
//    --- ContextAttr 被添加 ---name : tom
//    --- ContextAttr 被替换 ---name : tom
//    --- ContextAttr 被移除 ---name : jack
%>

<%
    //    触发session属性监听器
//    session.setAttribute("name", "tom");
//    session.setAttribute("name", "jack");
//    session.removeAttribute("name");
//    --- SessionAttr 被添加 ---name : tom
//    --- SessionAttr 被替换 ---name : tom
//    --- SessionAttr 被移除 ---name : jack
%>

<%
    //    触发request属性监听器
//    request.setAttribute("name", "tom");
//    request.setAttribute("name", "jack");
//    request.removeAttribute("name");
//    --- RequestAttr 被添加 ---name : tom
//    --- RequestAttr 被替换 ---name : tom
//    --- RequestAttr 被移除 ---name : jack
%>

<%
    //    User user = new User("zhangsan", 20);
//    session.setAttribute("user",user);
//
//    User newUser = new User("lisi", 23);
//    session.setAttribute("user",newUser);
//
//    session.removeAttribute("user");
//
//    触发实现了HttpSessionBindingListener的JavaBean里面的方法
//    --- Request 被销毁 ---org.apache.catalina.connector.RequestFacade@c5e5618
//    --- RequestAttr 被替换 ---org.apache.catalina.ASYNC_SUPPORTED : true
//    --- HttpSession 被创建 ---org.apache.catalina.session.StandardSessionFacade@404469d9
//    --- 从 Session 绑定 ---user : User{name='zhangsan', age=20}
//    --- SessionAttr 被添加 ---user : User{name='zhangsan', age=20}
//    --- 从 Session 绑定 ---user : User{name='lisi', age=23}
//    --- 从 Session 解绑 ---user : null
//    --- SessionAttr 被替换 ---user : User{name='lisi', age=23}
//    --- 从 Session 解绑 ---user : User{name='lisi', age=23}
//    --- SessionAttr 被移除 ---user : User{name='lisi', age=23}
//    --- Request 被创建 ---org.apache.catalina.connector.RequestFacade@c5e5618
%>

<%
    Object user = session.getAttribute("user");

    if (user == null) {
        System.out.println("新建user对象并放入session中");
        user = new User("zhangsan", 20);
        session.setAttribute("user", user);
    } else {
        System.out.println("从session中读取到user对象：" + user);
    }

//    User newUser = new User("lisi", 23);
//    session.setAttribute("user", newUser);
//
//    session.removeAttribute("user");
%>
</body>
</html>
