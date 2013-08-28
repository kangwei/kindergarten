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
    <form action="${pageContext.request.contextPath}/function/create" method="post">
        功能名称：<input type="text" name="functionName"/><br/>
        链接地址：<input type="text" name="url"/><br/>
        父功能：<input type="text" name="parentId"/><br/>
        是否菜单：<select name="isMenu"><br/>
            <option value="0">否</option>
            <option value="1">是</option>
        </select>
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>