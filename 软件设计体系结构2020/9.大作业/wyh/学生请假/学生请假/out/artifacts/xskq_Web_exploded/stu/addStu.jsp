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
						学生信息添加
					</th>
					<tr>
						<td class='forumRowHighLight' height=23>
							学号
						</td>
						<td class='forumRowHighLight'>
							<input id="hao" name="hao" type='text' size='70'>
								&nbsp; 
						</td>
					</tr>
					
					<tr>
						<td class='forumRowHighLight' height=23>
							密码
						</td>
						<td class='forumRowHighLight'>
							<input id="pwd" name="pwd" type='text' size='70'>
								&nbsp; 
						</td>
					</tr>

					<tr>
						<td class='forumRowHighLight' height=23>
							姓名
						</td>
						<td class='forumRowHighLight'>
							<input id="name" name="name" type='text' size='70'>
								&nbsp; 
						</td>
					</tr>

					<tr>
						<td class='forumRowHighLight' height=23>
							性别
						</td>
						<td class='forumRowHighLight'>
							<input id="sex" name="sex" type='text' size='70'>
								&nbsp; 
						</td>
					</tr>

					<tr>
						<td class='forumRowHighLight' height=23>
							年龄
						</td>
						<td class='forumRowHighLight'>
							<input id="age" name="age" type='text' size='70'>
								&nbsp; 
						</td>
					</tr>
					
					

					<tr>
						<td class='forumRowHighLight' height=23>
							班级
						</td>
						<td class='forumRowHighLight'>
							<input id="banji" name="banji" type='text' size='70'>
								&nbsp; 
						</td>
					</tr>

					<tr>
						<td class='forumRowHighLight' height=23>
							入学日期
						</td>
						<td class='forumRowHighLight'>
							<input id="rdate" name="rdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" type='text' size='70'>
								&nbsp; 
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
	document.forms[0].action = "<%=path%>/AddStuAction";
	document.forms[0].submit();

}
</script>
