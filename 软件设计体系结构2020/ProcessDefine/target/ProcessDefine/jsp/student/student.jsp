<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/9 0009
  Time: 9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>请假页面</span>
    </div>
    <span>Welcome to login in!</span><br>
    <span>User ID:${userSession.id}</span><br>
    <span>User Name: ${userSession.userName}</span><br>
    <span>User identity: ${userSession.identity}</span>
</div>
<%@include file="/jsp/common/foot.jsp" %>
