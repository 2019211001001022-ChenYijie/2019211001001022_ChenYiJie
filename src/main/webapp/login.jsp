<%--
  Created by IntelliJ IDEA.
  User: 86181
  Date: 2021/4/6
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
Login <br>
<form method="post" action="/login">
    <p>Username:<input type="text" name="name"/></p>

    <p>Password:<input type="password" name="password"/></p>
    <input type="submit" value="login"/>
</form>
<%@include file="footer.jsp" %>
