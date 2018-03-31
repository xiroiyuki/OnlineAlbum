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
这是首页
<form action="user/login.do" method="post">
    <input type="text" name="username" placeholder="username" value="admin">
    <input type="password" name="password" placeholder="password" value="111111">
    <button type="submit">提交</button>
</form>

</body>
</html>
