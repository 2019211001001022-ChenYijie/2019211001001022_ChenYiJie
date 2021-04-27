<%@include file="header.jsp" %>
Login <br>
<%
    if(request.getAttribute("msg") != null)
    {
        out.println("<h3 style = 'color:red'>"+request.getAttribute("msg")+"</h3>");

    }

%>
<%
    Cookie[]allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if (allCookies!=null){
        for (Cookie c:allCookies){
            if (c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password =c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post" action="${pageContext.request.contextPath}/login">
    <p>Username:<input type="text" name="name" value="<%=username%>"/></p>

    <p>Password:<input type="password" name="password"  value="<%=password%>"/></p>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1")?"checked":""%>/> Remember Me
    </br>
    <input type="submit" value="Login"/>
</form>
<%@include file="footer.jsp" %>
