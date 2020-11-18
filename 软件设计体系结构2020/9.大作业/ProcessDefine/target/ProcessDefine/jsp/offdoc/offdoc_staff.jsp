<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/16 0016
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/jsp/common/head.jsp" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>公文流转页面</span>
    </div>
<div class="container">
    <a href="${pageContext.request.contextPath }/jsp/offdoc/offdocadd.jsp">添加申请单</a>

    <table class="table table-hover table-responsive table-striped table-bordered">
        <thead>
        <tr>
            <td>编号</td>
            <td>申请时间</td>
            <td>申请人</td>
            <td>理由</td>
            <td>状态</td>
            <td>操作</td>
        </tr>
        </thead>
        <c:forEach var="form" items="${forms}">
            <tbody>
            <tr>
                <td>${form.id}</td>
                <td>${form.createTime}</td>
                <td>${form.creator}</td>
                <td>${form.reason}</td>
                <td>
                        <span>
                            <c:if test="${form.Sstate == 0}">等待审核</c:if>
					    </span>
                </td>
                <td>
                        <span><a class="deleteForm" href="javascript:;" formid=${form.id }>
                            <img src="${pageContext.request.contextPath }/images/del.png" alt="删除"
                                 title="删除"/>
                            </a>
                        </span>
                </td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
</div>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeForm">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/leaveform.js"></script>
