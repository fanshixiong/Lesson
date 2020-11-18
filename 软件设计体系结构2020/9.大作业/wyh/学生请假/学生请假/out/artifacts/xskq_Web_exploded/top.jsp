<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="<%=path %>/ncss/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=path %>/ncss/js/jquery.js"></script>
<title>进入系统</title>
<script language=JavaScript>
function logout(){
	if (confirm("您确定要退出系统吗？"))
	top.location = "loginout.jsp";
	return false;
}
</script>

</head> 
<body style="background:url(<%=path %>/ncss/images/topbg.gif) repeat-x;">

    <div class="topleft">
        <li><a href="<%=path %>/index.jsp" target="_parent">系统首页</a></li>
    </div>

    <div class="topright">
        <li><a href="#" target="_self" onClick="logout();">退出</a></li>

    <div class="user">
        <span>${user}(${type})</span>
    </div>

    </div>
</body>
</html>

