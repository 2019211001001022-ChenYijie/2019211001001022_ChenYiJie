<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 86181
  Date: 2021/4/12
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<h1>User List</h1>
<table border=1>
 <tr>
     <td>id</td><td>password</td><td>Email</td><td>Gander</td><td>Birthday</td>
 </tr>
    <%
        ResultSet rs=(ResultSet)  request.getAttribute("rsname");
        if (rs==null){
    %>
    <tr>
    <td>No Data!!!</td>
    </tr>
    <%}else {
       while (rs.next()) {
            //get one by one
            out.println("<tr>");
           out.println("<td>" + rs.getInt("id") + "</td>");
            out.println("<td>" + rs.getString("username") + "</td>");
            out.println("<td>" + rs.getString("password") + "</td>");
            out.println("<td>" + rs.getString("email") + "</td>");
            out.println("<td>" + rs.getString("gender") + "</td>");
            out.println("<td>" + rs.getString("birthdata") + "</td>");
            out.println("</td>");
        }
    }
    %>
</table>
<%@include file="footer.jsp" %>

