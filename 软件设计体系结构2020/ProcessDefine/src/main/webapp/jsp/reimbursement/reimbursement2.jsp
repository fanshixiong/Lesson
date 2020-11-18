<%--
  Created by IntelliJ IDEA.
  User: 樊世雄
  Date: 2020/11/9
  Time: 18:47
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
    <div class="container">
        <table class="table table-hover table-responsive table-striped table-bordered">
            <thead>
            <tr>
                <td>编号</td>
                <td>申请时间</td>
                <td>金额</td>
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
                    <td>${form.money}</td>
                    <td>${form.reason}</td>
                    <td>${form.state}</td>
                    <td>
                        <c:if test="${form.state == 0}">
                        <span><a class="modifyForm" href="javascript:;" formid=${form.id } formstate=${1}>
                            <img src="${pageContext.request.contextPath }/images/upd.png" alt="同意"
                                 title="同意"/>
                            </a>
                        </span>
                            <span><a class="modifyForm" href="javascript:;" formid=${form.id } formstate=${-1}>
                            <img src="${pageContext.request.contextPath }/images/del.png" alt="不同意"
                                 title="不同意"/>
                            </a>
                        </span>
                        </c:if>
                    </td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
</div>

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
<script type="text/javascript" src="${pageContext.request.contextPath }/js/reimform2.js"></script>