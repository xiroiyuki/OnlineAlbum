<%--
  Created by IntelliJ IDEA.
  User: holdo
  Date: 2018/3/29
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>$Title$</title>
</head>
<body>

<form action="login.do" method="post">
    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password">
    <button type="submit">提交</button>
</form>

</body>
</html>
