<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
    <div class="login">
        <div class="header">
            <h1>
                <a href="./login.jsp">登录</a> <a href="./regist.jsp">注册</a>
            </h1>

        </div>
        <form action="" method="post">
            <table>
                <tr>
                    <td class="td1">用户名</td>
                    <td><input type="text" class="input1" name="username"></td>
                </tr>
                <tr>
                <td class="td1">密码</td>
                <td><input type="password" class="input1" name="password"></td>
                </tr>
                <tr>
                <td class="td1" colspan="2">
                    <input type="checkbox" name="remember" value="true" checked="checked"> 记住用户名</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="btn-red">
                            <input type="submit" value="登录" id="login-btn">
                        </div>
                    </td>
                </tr>
            </table>

        </form>
    </div>
</body>
</html>