<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>流程定义系统</title>

    <script Charset="UTF-8" src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script Charset="UTF-8" src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" charset=”utf-8″ href="${pageContext.request.contextPath }/css/style.css"/>
    <link type="text/css" rel="stylesheet" charset=”utf-8″ href="${pageContext.request.contextPath }/css/public.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>流程定义系统</h1>
    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${userSession.userName }</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath }/jsp/logout.do">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2020年11月11日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath }/jsp/leave/leaveform.do?method=query">请假系统</a></li>
                <li><a href="${pageContext.request.contextPath }/jsp/reimbursement/reimform.do?method=query">报销</a></li>
                <li><a href="${pageContext.request.contextPath }/jsp/offdoc/offdocform.do?method=query">公文批转</a></li>
                <li><a href="${pageContext.request.contextPath }/jsp/pwdmodify.jsp">密码修改</a></li>
                <li><a href="${pageContext.request.contextPath }/jsp/logout.do">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
    <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>