<%@include file="/common/sub_header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,com.www.db.*" pageEncoding="UTF-8"%>
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
						老师信息修改
					</th>
					<%
						DBManager dbm = new DBManager();
						Connection conn = dbm.getConnection();
						String id = request.getParameter("id");
						String sql = "select * from tea where id='" + id + "'";
						PreparedStatement stat = conn.prepareStatement(sql);
						ResultSet rs = stat.executeQuery();
						rs.next();
					%>
					<input name="id" type="hidden" id="name" value='<%=id%>'>
						<tr>
							<td class='forumRowHighLight' height=23>
								工号
							</td>
							<td class='forumRowHighLight'>
								<input id="hao" name="hao" type='text'
									value='<%=rs.getString("hao")%>' size='70'>
									&nbsp; 
							</td>
						</tr>

						<tr>
							<td class='forumRowHighLight' height=23>
								密码
							</td>
							<td class='forumRowHighLight'>
								<input id="pwd" name="pwd" type='text'
									value='<%=rs.getString("pwd")%>' size='70'>
									&nbsp; 
							</td>
						</tr>

						<tr>
							<td class='forumRowHighLight' height=23>
								姓名
							</td>
							<td class='forumRowHighLight'>
								<input id="name" name="name" type='text'
									value='<%=rs.getString("name")%>' size='70'>
									&nbsp; 
							</td>
						</tr>

						<tr>
							<td class='forumRowHighLight' height=23>
								性别
							</td>
							<td class='forumRowHighLight'>
								<input id="sex" name="sex" type='text'
									value='<%=rs.getString("sex")%>' size='70'>
									&nbsp; 
							</td>
						</tr>

						<tr>
							<td class='forumRowHighLight' height=23>
								年龄
							</td>
							<td class='forumRowHighLight'>
								<input id="age" name="age" type='text'
									value='<%=rs.getString("age")%>' size='70'>
									&nbsp; 
							</td>
						</tr>

						<tr>
							<td class='forumRowHighLight' height=23>
								负责班级
							</td>
							<td class='forumRowHighLight'>
								<input id="banji" name="banji" type='text'
									value='<%=rs.getString("banji")%>' size='70'>
									&nbsp; 
							</td>
						</tr>

						<tr>
							<td class='forumRowHighLight' height=23>
								入职日期
							</td>
							<td class='forumRowHighLight'>
								<input id="rdate" name="rdate" type='text'
									value='<%=rs.getString("rdate")%>' onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})" size='70'>
									&nbsp; 
							</td>
						</tr>
					<%
						if (rs != null)
							rs.close();
						if (stat != null)
							stat.close();
						if (conn != null)
							conn.close();
					%>


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
	document.forms[0].action = "<%=path%>/ModTeaAction";
	document.forms[0].submit();

}
</script>
