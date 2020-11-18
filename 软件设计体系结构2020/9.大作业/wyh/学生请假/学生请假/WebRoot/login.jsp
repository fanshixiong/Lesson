<%@include file="/common/sub_header.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>请假管理系统</title>

		<script src="<%=path %>/ncss/js/cloud.js" type="text/javascript">
</script><link href="<%=path %>/ncss/css/style.css" rel="stylesheet" type="text/css" />

		<script language="javascript">
$(function() {
	$('.loginbox').css( {
		'position' : 'absolute',
		'left' : ($(window).width() - 500) / 2,
		'top' : ($(window).height() - 500) / 2
	});
	$(window).resize(function() {
		$('.loginbox').css( {
			'position' : 'absolute',
			'left' : ($(window).width() - 500) / 2,
			'top' : ($(window).height() - 500) / 2
		});
	})
});
</script>


	</head>
	<body
		style="background-color: #aca584; background-image: url(ncss/images/light1.png); background-repeat: repeat; background-position: center top; overflow: hidden;">

		<div id="mainBody">
			<div id="cloud1" class="cloud"></div>
			<div id="cloud2" class="cloud"></div>
		</div>


		<div class="logintop">
			<span>欢迎登录请假管理系统</span>
		
		</div>

		<div class="loginbody">

			<span class="systemlogo"></span>

			<div class="loginbox">
			<form name="form1" action="LoginAction" method="post">
						<input type="hidden" id="messageInfo"
							value="${requestScope.messageInfo}" />
			

				<ul>
					<li>
						<input name="username" id="username" type="text" class="loginuser"  
							onclick="JavaScript:this.value=''"  />
					</li>
					<li>
						<input name="userpwd"  id="userpwd" type="password" class="loginpwd"  
							onclick="JavaScript:this.value=''" />
					</li>
					<li>
						<select  name="type"  id="type"  >
						   <option value="管理员">管理员</option>
						   <option value="老师">老师</option>
						   <option value="学生">学生</option>
						</select>	
					</li>
					<li>
						<input name="" type="button" class="loginbtn" value="登录"
							onclick="login();"/>
						 
					</li>
				</ul>

</form>
			</div>

		</div>
	</body>
</html>
<script>

function login() {

	if ($("#username").val() == "") {
		$.messager.alert('警告', '请输入用户名！', 'warning');
		return;
	}
	if ($("#userpwd").val() == "") {
		$.messager.alert('警告', '请输入密码！', 'warning');
		return;
	}
	document.forms[0].action = "<%=path%>/LoginAction";
	document.forms[0].submit();

}
</script>