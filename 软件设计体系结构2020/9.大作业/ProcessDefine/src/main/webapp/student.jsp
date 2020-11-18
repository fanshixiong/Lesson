<%@ page import="com.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/9 0009
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Process Defination</title>
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <jsp:include page="Header.jsp" />
    <%  User user = (User)request.getAttribute("userMsg");
    %>
    <span >Welcome to login in!</span><br>
    <span>User ID:<%=user.getId()%></span><br>
    <span>User Name: <%=user.getUserName()%></span><br>
    <span>User identity: <%=user.getIdentity()%></span>
</body>
</html>
