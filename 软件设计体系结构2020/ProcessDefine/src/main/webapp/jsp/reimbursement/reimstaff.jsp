<%--
  Created by IntelliJ IDEA.
  User: 樊世雄
  Date: 2020/11/10
  Time: 10:33
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
            <tr>
                <td>${userSession.staName}</td>
                <td>${userSession.staAge}</td>
                <td>${userSession.staGender}</td>
                <td>${userSession.post}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<%@include file="/jsp/common/foot.jsp" %>