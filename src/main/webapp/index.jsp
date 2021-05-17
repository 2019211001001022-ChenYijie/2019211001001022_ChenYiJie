<%@include file="header.jsp" %>
<h2>Welcome to My Online Shop Home Page</h2><br>
<form method="get" target="_blank" action="search">
<!--<url-pattern>/search</url-pattern>-->
<input type="text" name="txt" size="30"/>
<select name="ChenYijie2019211001001022">
    <option value="baidu">Baidu</option>
    <option value="bing">Bing</option>
    <option value="google">Google</option>
</select>
<input type="submit" value="Search"/>
</form>
<html>
<body>
<%
    pageContext.setAttribute("attName","att in page");
    request.setAttribute("attName","att in request");
    session.setAttribute("attName","att in session");
    application.setAttribute("attName","att in application");
%>
<%out.println("<br/>"+pageContext.getAttribute("attName"));
    out.println("<br/>"+request.getAttribute("attName"));
    out.println("<br/>"+session.getAttribute("attName"));
    out.println("<br/>"+application.getAttribute("attName"));
    %>
<br/><hr/><h4>
    Use pageContext to get attribute from page,request,session add application
</h4>
<%out.println("<br/>"+pageContext.getAttribute("attName",PageContext.PAGE_SCOPE));
    out.println("<br/>"+pageContext.getAttribute("attName",PageContext.REQUEST_SCOPE));
    out.println("<br/>"+pageContext.getAttribute("attName",PageContext.SESSION_SCOPE));
    out.println("<br/>"+pageContext.getAttribute("attName",PageContext.APPLICATION_SCOPE));
    %>
<br/><hr/><h4>Use packContext to Find attribute from page,request,session and application</h4>
<%=pageContext.findAttribute("attName")%>
</body>
</html>
<%@include file="footer.jsp" %>