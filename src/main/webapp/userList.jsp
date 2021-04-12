<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userList</title>
</head>
<body>
<table border="1">
    <tr>
        <td>username</td>
        <td>email</td>
        <td>gender</td>
        <td>birthdate</td>
    </tr>
    <%
        ResultSet rs = (ResultSet) request.getAttribute("rsname");
        int i = 0;
        while(rs.next()){

    %>
    <tr>
        <td><%=rs.getString(1)%>
        </td>
        <td><%=rs.getString(3)%>
        </td>
        <td><%=rs.getString(4)%>
        </td>
        <td><%=rs.getString(5)%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>