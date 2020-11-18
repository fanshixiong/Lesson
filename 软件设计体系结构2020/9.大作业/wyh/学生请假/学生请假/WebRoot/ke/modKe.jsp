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
						课程信息修改
					</th>
					<%
						DBManager dbm = new DBManager();
						Connection conn = dbm.getConnection();
						String id = request.getParameter("id");
						String sql = "select * from ke where id='" + id + "'";
						PreparedStatement stat = conn.prepareStatement(sql);
						ResultSet rs = stat.executeQuery();
						rs.next();
					%>
					<input name="id" type="hidden" id="name" value='<%=id%>'>
						<tr>
							<td class='forumRowHighLight' height=23>
								课程名称
							</td>
							<td class='forumRowHighLight'>
								<input id="name" name="name" type='text'
									value='<%=rs.getString("name")%>' size='70'>
									&nbsp; 
							</td>
						</tr>

						<tr>
							<td class='forumRowHighLight' height=23>
								代课老师
							</td>
							<td class='forumRowHighLight'>
								<input id="shi" name="shi" type='text'
									value='<%=rs.getString("shi")%>' size='70'>
									&nbsp; 
							</td>
						</tr>

						<tr>
							<td class='forumRowHighLight' height=23>
								教室
							</td>
							<td class='forumRowHighLight'>
								<input id="jiao" name="jiao" type='text'
									value='<%=rs.getString("jiao")%>' size='70'>
									&nbsp; 
							</td>
						</tr>

						<tr>
							<td class='forumRowHighLight' height=23>
								课程描述
							</td>
							<td class='forumRowHighLight'>
								<input id="info" name="info" type='text'
									value='<%=rs.getString("info")%>' size='70'>
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
	document.forms[0].action = "<%=path%>/ModKeAction";
	document.forms[0].submit();

}
</script>
