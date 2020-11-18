<%@include file="/common/sub_header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.util.*,java.sql.*,com.www.db.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

		<link href="<%=path%>/css/list.css" rel="stylesheet" type="text/css" />

	</head>
	<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">

		<br />


		<form id="form1" name="form1" method="post" action="">

			<table cellpadding='3' cellspacing='1' border='0' class='tableBorder'
				align=center>
				<tr>
					<th class='tableHeaderText' colspan=2 height=25>
						请假申请
					</th>
					<tr>
						<td class='forumRowHighLight' height=23>
							姓名
						</td>
						<td class='forumRowHighLight'>
							<input id="name" name="name" type='text' value="${user}" size='70'>
								&nbsp; 
						</td>
					</tr>

					<tr>
						<td class='forumRowHighLight' height=23>
							课程
						</td>
						<td class='forumRowHighLight'>
							<input id="ke" name="ke" type='text' size='70'>
								&nbsp; 
						</td>
					</tr>

					<tr>
						<td class='forumRowHighLight' height=23>
							请假时间
						</td>
						<td class='forumRowHighLight'>
							<input id="adate" name="adate" value="<%=new java.util.Date().toLocaleString() %>" type='text' size='70'>
								&nbsp; 
						</td>
					</tr>

					<tr>
						<td class='forumRowHighLight' height=23>
							请假班级
						</td>
						<td class='forumRowHighLight'>
							<input id="banji" name="banji" value="${banji}"  type='text' size='70'>
								&nbsp; 
						</td>
					</tr>

					<tr>
						<td class='forumRowHighLight' height=23>
							请假原因
						</td>
						<td class='forumRowHighLight'>
							<input id="info" name="info" type='text' size='70'>
								&nbsp; 
						</td>
					</tr>

					<tr>
						<td class='forumRowHighLight' height=23>
							病历
						</td>
						<td class='forumRowHighLight'>
							<input id="fujian" name="fujian" type='text' size='70'>
								&nbsp; 
							<input type="button" value="上传" onclick="up()" />	
							<input id="state" name="state" type='hidden' value="提交申请" size='70'>	
						</td>
					</tr>

				 


					<tr>
						<td height="50" colspan=2 class='forumRow'>
							<div align="center">
								<input type="button" name="Submit" value="保存" class="button"
									onclick="save();" />

								<input type="button" name="Submit2" value="返回" class="button"
									onclick="window.history.go(-1);" />
							</div>
						</td>
					</tr>
			</table>
		</form>
	</body>
</html>
<script>

function save() {
	if ($("#name").val() == "") {
		$.messager.alert('警告', '姓名不能为空！', 'warning');
		return;
	}
	if ($("#pwd").val() == "") {
		$.messager.alert('警告', '密码不能为空！', 'warning');
		return;
	}
	document.forms[0].action = "<%=path%>/AddQingAction";
	document.forms[0].submit();

}
</script>
