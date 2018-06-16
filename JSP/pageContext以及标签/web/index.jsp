<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/16
  Time: 上午11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    //request:HttpServletRequest
    //response:HttpServletResponse
    //session:HttpSession
    //application:ServletContext
    //config:ServletConfig
    //page:this
    //exception:Exception
    //out:JspWriter
    //pageContext:PageContext；封装其他八大对象。用在自定义标签里面。

    out.write("out.write");//推荐以这种方式输出。
    response.getWriter().write("response.getWriter().write");

    //pageContext：page域；生命周期最短。
    //request：request域；生命周期比page域长。
    //session：session域；生命周期比request域长。
    //servletContext：servletContext域；生命周期比session域长。
    pageContext.getAttribute("name");//从pageContext域中查找数据。
    pageContext.getAttribute("name", PageContext.PAGE_SCOPE);//从pageContext域中查找数据。
    pageContext.getAttribute("name", PageContext.REQUEST_SCOPE);//从request域中查找数据。
    pageContext.getAttribute("name", PageContext.SESSION_SCOPE);//从session域中查找数据。
    pageContext.getAttribute("name", PageContext.APPLICATION_SCOPE);//从servletContext域中查找数据。

    //依次从pageContext request session servletContext四个域中查找数据。
    pageContext.findAttribute("name");

    //转发与包含
    pageContext.forward("/home");
    pageContext.include("/head.jsp");

%>

<%--<jsp:attribute name="name" trim="true">tom</jsp:attribute>--%>

<%--<jsp:body>Hi</jsp:body>--%>

<%--<jsp:element name="font">16</jsp:element>--%>

<%--<jsp:forward page="welcome.jsp">
    <jsp:param name="name" value="tom"/>
</jsp:forward>--%>

<%--<jsp:getProperty name="name" property="tom"/>--%>

<%-- 动态包含 --%>
<%--<jsp:include page="one.jsp"/>--%>

<%--<jsp:setProperty name="name" property="tom"/>--%>

<%--<jsp:plugin type="bean"></jsp:plugin>--%>

<%--<jsp:text></jsp:text>--%>

<%--<jsp:useBean id=""--%>
</body>
</html>
