<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<h1>SingIn!</h1>
<form action="/login.do" method="post">
    Username:<input type="text" name="username"/><br/><br/>
    Password:<input type="password" name="password"/><br/><br/>
    <input type="submit" value="login"/>"
</form>
<h1>SignUp!</h1>
<form action="/register.do" method="post">
    Username:<input type="text" name="username"/><br/><br/>
    First name:<input type="text" name="firstName"/><br/><br/>
    Last name:<input type="text" name="lastName"/><br/><br/>
    Email:<input type="text" name="email"/><br/><br/>
    Password:<input type="password" name="password"/><br/><br/>
    <input type="submit" value="register"/>"
</form>
</body>
</html>
