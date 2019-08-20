<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <title>修改个人信息</title>
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../../css/add.css">
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        慕课网留言板个人信息
                    </a>
                </div>
            </div>
        </nav>
        <div class="container">
            <div class="jumbotron">
                <h1>Hello, ${user.name}!</h1>
                <p>请斟酌后修改 ^_^</p>
            </div>
            <div class="page-header">
                <h3><small>个人信息</small></h3>
            </div>
            <form class="form-horizontal" action="/editUser.do" method="post">
                <input id="id" name="id" type="hidden" value="${user.id}">
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">用户 ：</label>
                    <div class="col-sm-6">
                        <input name="name" class="form-control" id="name" value="${user.name}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码 ：</label>
                    <div class="col-sm-6">
                        <input name="password" class="form-control" id="password" value="${user.password}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="realName" class="col-sm-2 control-label">姓名 ：</label>
                    <div class="col-sm-8">
                        <input name="realName" class="form-control" id="realName" value="${user.realName}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthday" class="col-sm-2 control-label">生日 ：</label>
                    <div class="col-sm-8">
                        <input name="birthday" class="form-control" id="birthday" value="${user.birthday}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">电话 ：</label>
                    <div class="col-sm-8">
                        <input name="phone"  class="form-control" id="phone" value="${user.phone}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="address" class="col-sm-2 control-label">地址 ：</label>
                    <div class="col-sm-8">
                        <input name="address"  class="form-control" id="address" value="${user.address}">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
                    </div>
                </div>
            </form>
        </div>
        <footer class="text-center" >
            copy@imooc
        </footer>
    </body>
</html>
