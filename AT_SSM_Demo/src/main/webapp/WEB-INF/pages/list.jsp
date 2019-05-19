<%--
  Created by IntelliJ IDEA.
  User: AT
  Date: 2019/5/10
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${accountList}" var="account">
    ${account.toString()}
</c:forEach>
</body>
</html>
