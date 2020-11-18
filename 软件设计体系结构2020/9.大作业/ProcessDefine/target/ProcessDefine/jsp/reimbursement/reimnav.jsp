<%--
  Created by IntelliJ IDEA.
  User: 樊世雄
  Date: 2020/11/10
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>


<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>报销页面</span>
    </div>
    <nav class="navbar navbar-expand-sm   navbar-light bg-light">
        <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath }/jsp/reimbursement/reimbursement.jsp">申请
                        <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"
                       href="${pageContext.request.contextPath }/jsp/reimbursement/reimstaff.jsp">我的 </a>
                </li>
            </ul>
        </div>
    </nav>
</div>

<%@include file="/jsp/common/foot.jsp" %>
