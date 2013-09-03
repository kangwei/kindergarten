<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Description:
  User: KangWei
  Date: 13-8-26
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head></head>
<body>
<c:if test="${sessionScope[\"SPRING_SECURITY_LAST_EXCEPTION\"].message eq 'Bad credentials'}">
    用户名或者密码错误
</c:if>
<c:if test="${sessionScope[\"SPRING_SECURITY_LAST_EXCEPTION\"].message eq 'User is disabled'}">
    账号不可用，请联系管理员
</c:if>
<c:if test="${fn:containsIgnoreCase(sessionScope[\"SPRING_SECURITY_LAST_EXCEPTION\"].message,'A communications error has been detected')}">
    数据库异常，请稍后再试
</c:if>
<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
    用户名：<input type="text" name="j_username" value="${sessionScope["SPRING_SECURITY_LAST_USERNAME"]}"/><br/>
    密&nbsp;&nbsp;码：<input type="password" name="j_password"/><br/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>