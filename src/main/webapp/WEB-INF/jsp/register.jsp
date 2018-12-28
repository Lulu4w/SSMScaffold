<%--
  Created by IntelliJ IDEA.
  User: lulu
  Date: 2018-12-25
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>register</title>
</head>
<body>
    <form:form modelAttribute="user" action="${pageContext.request.contextPath}/user/register.do" method="post">
        邮箱：<form:input path="email"/> <form:errors path="email"></form:errors> <br/><br/>
        密码：<form:password path="password"/> <form:errors path="password"></form:errors> <br/><br/>
        <input type="submit" value="regist"/>
    </form:form>
</body>
</html>
