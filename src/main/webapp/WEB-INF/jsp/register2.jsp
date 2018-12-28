<%--
  Created by IntelliJ IDEA.
  User: lulu
  Date: 2018-12-25
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/register2.do" method="post">
        邮箱：<input type="text" name="email" value="${param.email}"/><br/><br/>
        密码：<input type="password" name="password" value="${param.password}"/><br/><br/>
        <c:if test="${not empty message}">
            <span style="color: red;">${message}</span><br/><br/>
        </c:if>
        <input type="submit" value="regist"/>
    </form>
</body>
</html>
