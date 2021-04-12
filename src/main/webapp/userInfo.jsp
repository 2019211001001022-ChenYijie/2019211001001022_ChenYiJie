<%--
  Created by IntelliJ IDEA.
  User: 86181
  Date: 2021/4/12
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<h1>UserInfo</h1>
<table>
    <tr><td>Username:</td><td><%=request.getAttribute("username")%></td></tr>
    <tr><td>Password:</td><td><%=request.getAttribute("password")%></td></tr>
    <tr><td>Email:</td><td><%=request.getAttribute("email")%></td></tr>
    <tr><td>Gender:</td><td><%=request.getAttribute("gender")%></td></tr>
    <tr><td>Birthdate:</td><td><%=request.getAttribute("birthdate")%></td></tr>
</table>
<%@include file="footer.jsp"%>