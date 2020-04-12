<%--
  Created by IntelliJ IDEA.
  User: coypan
  Date: 2020-04-10
  Time: 01:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   Hello world
   <br/>
   欢迎您，
   <shiro:authenticated>
       <shiro:principal></shiro:principal>
       <div>
         <a href="${pageContext.request.contextPath}/user/logout">logout</a>
       </div>
   </shiro:authenticated>
   <shiro:notAuthenticated>
       <a href="${pageContext.request.contextPath}/user/login">login</a>
   </shiro:notAuthenticated>
   <shiro:guest>
       游客
   </shiro:guest>
   <br/>
   <shiro:authenticated>
       角色标签
   </shiro:authenticated>
   <shiro:hasRole name="admin">
       <a href="#">角色：管理员</a>
   </shiro:hasRole>
   <shiro:hasRole name="seller">
       <a href="#">角色：销售员</a>
   </shiro:hasRole>
   <shiro:authenticated>
       <br/>
       权限标签
   </shiro:authenticated>
   <shiro:hasPermission name="user:query">
       <a href="#">权限 ：用户查询权限</a>
   </shiro:hasPermission>
   <shiro:hasPermission name="user:delete">
       <a href="#">权限 ：用户删除权限</a>
   </shiro:hasPermission>
</body>
</html>
