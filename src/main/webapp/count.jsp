<%--
  Created by IntelliJ IDEA.
  User: 86181
  Date: 2021/4/6
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter JSP</title>
</head>

<body>
This is Count JSP page.<br>
<%!int getCount(){
    return ++count;
}%>
<%! int count=0;%>
<!-- The page count is now : <%//out.println(++count);%><br/>-->
The page count is now(using count()):  <%//out.println(getCount());%>
</body>
</html>

