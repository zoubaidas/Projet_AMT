<%@ page import="io.zoubaidas.overflowstack.application.user.UserDTO" %><%--
  Created by IntelliJ IDEA.
  User: naimi
  Date: 25.10.2020
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${pageTitle} - Overflowstack</title>
</head>
<body>
Username: <%= ((UserDTO) request.getSession().getAttribute("currentUser")).getUsername()%>

</body>