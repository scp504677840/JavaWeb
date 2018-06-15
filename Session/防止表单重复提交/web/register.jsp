<%--
  Created by IntelliJ IDEA.
  User: scp
  Date: 2018/6/15
  Time: 下午5:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>

    <script type="text/javascript">
        <%-- 客户端防止表单重复提交方式一 --%>

        var isCommitted = false;

        function doSubmit() {
            if (!isCommitted) {
                isCommitted = true;
                return true;
            }
            return false;
        }

        <%-- 客户端防止表单重复提交方式二 --%>

        /*function doSubmit() {
            let submitBtn = document.getElementById("submit");
            submitBtn.disabled = 'disabled';
            return true;
        }*/
    </script>
</head>
<body>
<form action="register" method="post" onsubmit="return doSubmit()">
    <input type="hidden" name="token" value="${token}">
    用户名：<input type="text" name="username">
    密码：<input type="password" name="password">
    <button id="submit" type="submit">注册</button>
</form>
</body>
</html>
