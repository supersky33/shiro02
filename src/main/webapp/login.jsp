<%--
  Created by IntelliJ IDEA.
  User: coypan
  Date: 2020-04-09
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/login" method="post">
        username: <input type="text" name="username"> <br>
        password: <input type="text" name="password"> <br>
        <input type="submit" value="login">
    </form>
</body>
</html>
