<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 流程定义系统</title>

    <script Charset="UTF-8"  src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script Charset="UTF-8"  src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />

</head>

<body class = "login_bg">
<div class="container">
    <div class="col-md-4"></div>
    <div class="col-md-4" style="background-color:#eee;;margin-top:200px;">
        <center>
            <h3>Login</h3>
        </center>
        <form action="${pageContext.request.contextPath}/login.do" method="post">
            <div class="info">${error }</div>
            <div class="form-group">
                <label for="userName">用户名:</label>
                <input type="text" class="form-control" style="color:red;" placeholder="请输入用户名" id="userName" name="userName" >
            </div>
            <div class="form-group">
                <label for="userPassword">密码</label>
                <input type="password" class="form-control" style="color:red;" placeholder="请输入密码" id="userPassword" name="userPassword">
            </div>
            <div class="form-group">
                <input type="submit" value="登录" class="btn btn-success form-control">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="重置" class="btn btn-success form-control">
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>
</body>
</html>