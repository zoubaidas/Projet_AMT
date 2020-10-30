<%--
  Created by IntelliJ IDEA.
  User: naimi
  Date: 02.10.2020
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="questions" scope="request"
             type="java.util.ArrayList<io.zoubaidas.overflowstack.application.question.QuestionDTO>"/>
<%@ include file="fragments/header.jsp" %>

<h1>Ask new question</h1>
<form action="/question.do" method="post">
    Title:<input type="text" name="title"/><br/><br/>
    Body:<input type="text" name="body"/><br/><br/>
    <input type="submit" value="Submit"/>"
</form>

<h1>List of questions</h1>
    <c:forEach var="question" items="${questions}">
        ${question.title} by ${question.authorId} on ${question.authorId} <br/>
    </c:forEach>




