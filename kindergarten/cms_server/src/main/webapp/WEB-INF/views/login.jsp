<%--
  Description:
  User: KangWei
  Date: 13-8-26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>login</title></head>
<body>
    <div style="color: red;">${msg}</div>
    <form action="${pageContext.request.contextPath}/doLogin" method="post">
        用户名：<input type="text" name="userAccount"/><br/>
        密码：<input type="password" name="userPassword"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>