<%@ page import="com.lab1.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lab1.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 9:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assignemnt1</title>
</head>
<body>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<h1> c:forEach loog to print 1 to 10</h1>

    <ul>
        <c:forEach var="i" begin="1" end="10">
        <li>$${i}</li>
        </c:forEach>
    </ul>
    <%-- todo 1 : run assignement1.jsp  --%>
<h1> c:forEach to print list 1,3,5,7,9</h1>
<%-- todo 2 : use c:forEach to print list 1,3,5,7,9   --%>
<ul>
    <c:forEach var="i" begin="1" end="9" step="2">
        <li>$${i}</li>
    </c:forEach>
</ul>
<h1> c:forEach to print list 1,3,5,7,9</h1>
   <%-- todo 3 : use c:forEach to print 2,4,6,8,10   --%>
<ul>
    <c:forEach var="i" begin="2" end="10" step="2">
        <li>$${i}</li>
    </c:forEach>
</ul>

<% String[] words ={"one","two","three","four","five","six","seven","eight","nine","ten"};
   pageContext.setAttribute("words", words);
%>
<h1> c:forEach to print all elements of array </h1>
<%-- todo 4 : use c:forEach to print all elements of array --%>
<ul>
    <c:forEach var="w" items="${pageScope.words}">
        <li>$${w}</li>
    </c:forEach>
</ul>

<% String[] words2 ={"one","three","five","seven","nine"};
    pageContext.setAttribute("words", words);
%>
<h1> c:forEach to print all elements of array </h1>
<%-- todo 5 : use c:forEach to print "one","three","five","seven","nine"  of array --%>
<ul>
    <c:forEach var="w" items="${pageScope.words}">
        <li>$${w}</li>
    </c:forEach>
</ul>

<%
List<Person> personList=new ArrayList<Person>();
personList.add(new Person("Tom",new Dog("Tommy")));
personList.add(new Person("Sam",new Dog("Sammy")));
personList.add(new Person("jack",new Dog("jacks")));
// todo 6 : add a new person into PersonList - person name and dog name
request.setAttribute("AllPerson",personList);
%>
<h1> c:forEach to print person name :   and persons' dog name :  </h1>
<%--//todo 7: use c:forEach to print person name :   and persons' dog name : --%>
<ul>
    <c:forEach var="w" items="${pageScope.words}">
        <li>$${w}</li>
    </c:forEach>
</ul>

<%
    String str="one:two:three-four-five";
%>
<h1> c:forToken to print all words </h1>
<%--todo 8 : use c:forToken to print all words --%>
<ul>
    <c:forEach var="w" items="${pageScope.words}">
        <li>$${w}</li>
    </c:forEach>
</ul>
</body>
</html>
