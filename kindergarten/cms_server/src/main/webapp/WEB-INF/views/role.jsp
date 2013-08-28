<%--
  Description:
  User: KangWei
  Date: 13-8-26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Simple jsp page</title></head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/role/create" method="post">
        <input type="text" name="roleName"/>
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>