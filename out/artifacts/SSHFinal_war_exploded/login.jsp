<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
<div class="container" style="width: 400px;margin: 0 auto">
    <h4 style="color: red">${tips}</h4>
    <form action="login.php" method="post">
        <div class="form-group">
            <label>账户名:</label>
            <input type="text" class="form-control" value="ronaldo" name="userName" placeholder="请输入用户名" autocomplete="off">
        </div>
        <div class="form-group">
            <label>密码:</label>
            <input type="password" class="form-control" name="passWord" placeholder="请输入密码" autocomplete="off">
        </div>
        <button type="submit" class="btn btn-primary btn-sm">登陆</button>
    </form>
</div>

</body>
</html>
