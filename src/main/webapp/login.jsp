<%--
  Created by IntelliJ IDEA.
  User: 86181
  Date: 2021/4/6
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    if(!(request.getAttribute("message") == null)){
        out.print("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>
<form method="post" action="/2019211001001022ChenYiJie_war_exploded/login">
    username:<input type = "text" name="username"><br/>
    password:<input type = "password" name="password"><br/>
    <input type="submit" name="提交">
</form>
</body>
</html>
<%@include file="footer.jsp"%>
