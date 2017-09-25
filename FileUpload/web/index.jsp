<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2017/9/25
  Time: 下午9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="fileUploadServlet" method="post" enctype="multipart/form-data">
    <p>
        File:<input type="file" name="file">
    </p>
    <p>
        Desc:<input type="text" name="desc">
    </p>

    <p>
        File:<input type="file" name="secondFile">
    </p>
    <p>
        Desc:<input type="text" name="secondDesc">
    </p>

    <button type="submit">上传</button>
</form>
</body>
</html>
