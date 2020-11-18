<%@ page import="com.pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/5 0005
  Time: 15:23
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
    <form action="/AdminServlet" method="post">
        <input  name="userid" value="<%=user.getId()%>">
    <button >add user</button>
    </form>
    <form action="/AdminServlete" method="post">
        <input  name="userid1" value="<%=user.getId()%>"><br>
        <button type="submit">del user</button>
    </form>
    <br>

    <div class="container">

        <c:set var="totalUsers" value="${requestScope.totalUsers}"/>
        <c:set var="page" value="${requestScope.page}"/>
        <%
            List<User> users = (List<User>) request.getAttribute("users");
        %>
        <p>用户总数:${totalUsers}</p>

        <table class="table table-hover table-responsive table-striped table-bordered">
            <thead>
            <tr>
                <td>用户编号</td>
                <td>姓名</td>
                <td>密码</td>
                <td>用户身份</td>
            </tr>
            </thead>
            <tbody>
            <% for(int i=0;i<users.size();i++){%>
                <tr>
                    <td><%=users.get(i).getId()%></td>
                    <td><%=users.get(i).getUserName()%></td>
                    <td><%=users.get(i).getUserPassword()%></td>
                    <td><%=users.get(i).getIdentity()%></td>
                </tr>
            <%}%>
            </tbody>
        </table>
    </div>

</body>
</html>
