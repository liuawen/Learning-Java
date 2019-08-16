<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<link rel="stylesheet" href="./css/reg.css">
</head>
<body>
    <div class="reg">
        <div class="header">
            <h1>
                <a href="./login.jsp">登录</a> <a href="./regist.jsp">注册</a>
            </h1>
        </div>
        <form action="/reg_login/RegistServlet" method="post">
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
                    <td class="td1">昵称</td>
                    <td><input type="text" class="input1" name="nickname"></td>
                </tr>
                <tr>
                    <td class="td1">性别</td>
                    <td>
                        <input type="radio" name="sex" value="male">男
                        <input type="radio" name="sex" value="female">女
                    </td>
                </tr>
                <tr>
                    <td class="td1">上传头像</td>
                    <td><input type="file" id="photo" name="upload"></td>
                </tr>
                <tr>
                    <td class="td1">兴趣爱好</td>
                    <td><label> 
                        <input type="checkbox" name="hobby" value="篮球">篮球
                        <input type="checkbox" name="hobby" value="足球">足球
                        <input type="checkbox" name="hobby" value="排球">排球 
                        <input type="checkbox" name="hobby" value="羽毛球">羽毛球
                    </label></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="btn-red">
                            <input type="submit" value="注册" id="reg-btn">
                        </div>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>