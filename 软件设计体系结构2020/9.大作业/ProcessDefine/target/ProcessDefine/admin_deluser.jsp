<%@ page import="com.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/6 0006
  Time: 10:52
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
        <%  User user = (User)request.getAttribute("userMsg");  %>
        <span>Welcome to login in!</span><br>
        <span>User ID: <%=user.getId()%></span><br>
        <span>User Name: <%=user.getUserName()%></span><br>
        <span>User identity: <%=user.getIdentity()%></span>

        <form action="/Admindelusers" method="post">
                <input  name="userid" value="<%=user.getId()%>"><br>
                <span>id:</span><input name="id"><br>
                <span>username:</span><input name="username"><br>
                <span>password:</span><input name="password"><br>
                <span>identity:</span><input name="identity"><br>
                <button type="submit">del user</button>
        </form>

</body>
</html>
