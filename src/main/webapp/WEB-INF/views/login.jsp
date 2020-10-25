<%--
  Created by IntelliJ IDEA.
  User: naimi
  Date: 02.10.2020
  Time: 01:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>SignUp or SignIn</title>
</head>
<body>

<hr/>

<h3>Login Form</h3>
<%
    String profile_msg=(String)request.getAttribute("profile_msg");
    if(profile_msg!=null){
        out.print(profile_msg);
    }
    String login_msg=(String)request.getAttribute("login_msg");
    if(login_msg!=null){
        out.print(login_msg);
    }
%>
<br/>
<form action="${pageContext.request.contextPath}/login.do" method="post">
    Username:<input type="text" name="usaername"/><br/><br/>
    Password:<input type="password" name="password"/><br/><br/>
    <input type="submit" value="login"/>"
</form>
</body>
</html>
