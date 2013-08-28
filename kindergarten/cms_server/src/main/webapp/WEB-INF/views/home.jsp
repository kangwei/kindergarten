<%--
  Description:
  User: KangWei
  Date: 13-8-26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>home</title></head>
<body>
    欢迎使用本系统--${sessionScope.sessionUser.userNick}
    <p><a href="${pageContext.request.contextPath}/user">用户管理</a></p>
    <p><a href="${pageContext.request.contextPath}/role">角色管理</a></p>
    <p><a href="${pageContext.request.contextPath}/function">功能管理</a></p>
    <p><a href="${pageContext.request.contextPath}/right">权限分配</a></p>
    <p><a href="">栏目管理</a></p>
</body>
</html>