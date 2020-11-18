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

    <div class="add">
        <form id="reimForm" name="reimForm" method="post" action="${pageContext.request.contextPath }/jsp/reimbursement/reimform.do">
            <input type="hidden" name="method" value="add">
            <div class="">
                <label for="id">申请单编号：</label>
                <input type="text" name="id" class="text" id="id" value="">
                <font color="red"></font>
            </div>
            <div>
                <label for="reason">理由：</label>
                <input type="text" name="reason" id="reason" value="">
                <font color="red"></font>
            </div>

            <div>
                <label for="money">金额：</label>
                <input type="text" name="money" id="money" value="">
                <font color="red"></font>
            </div>
            <div class="addBtn">
                <input type="button" name="add" id="add" value="保存">
                <input type="button" id="back" name="back" value="返回">
            </div>
        </form>
    </div>
</div>

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/reimadd.js"></script>
