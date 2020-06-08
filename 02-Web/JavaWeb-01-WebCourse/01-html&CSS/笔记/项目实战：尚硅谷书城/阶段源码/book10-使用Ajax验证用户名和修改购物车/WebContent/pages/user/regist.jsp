<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>

<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 --> 
<%@ include file="/pages/common/header.jsp" %>

<script type="text/javascript">

	// 页面加载完成之后
	$(function(){
		
		//用户名是否存在验证
		$("#username").blur(function(){
			// 获取用户名
			var usernameValue = this.value;
			//判断用户名不能为空
			if (usernameValue == "") {
				$("#errorSpan").html("用户名不能为空！");
				return;
			}
			
			// 发送ajax请求验证
			$.getJSON("userServlet?action=existsUsername&username="+usernameValue,function(data){
				// result 等于0，说明用户名不存在
				if (data.result == 0) {
					$("#errorSpan").html("");
				} 
				// result 等于1，说明用户名存在
				else if (data.result == 1) {
					$("#errorSpan").html("用户名已存在");
				}
			});
			
		});
		
		
		
		// 给注册按钮添加事件
		$("#sub_btn").click(function(){
			
			// 获取用户名
			var usernameValue = $("#username").val();
			// 验证用户名是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为6到15位。
			var usernameReg = /^\w{5,15}$/;
			// 验证用户信息
			if (!usernameReg.test(usernameValue)) {
				// 提示用户
				alert("用户名不合法！");
				return false;
			}
			
			// 获取密码
			var passwordValue = $("#password").val();
			// 验证密码是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为6到15位。
			var passwordReg = /^\w{5,15}$/;
			// 验证用户信息
			if (!passwordReg.test(passwordValue)) {
				// 提示用户
				alert("密码不合法！");
				return false;
			}
			
			// 获取确认密码
			var repwdValue = $("#repwd").val();
			// 验证确认密码和密码一致
			if (passwordValue != repwdValue) {
				// 提示用户
				alert("确认密码和密码不一致！");
				return false;
			}
			
			// 获取用户名
			var emailValue = $("#email").val();
			// 验证邮件输入是否合法。
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			
			if (!emailReg.test(emailValue)) {
				// 提示用户
				alert("邮件输入不合法！");
				return false;
			}
			
			
			// 获取验证码信息
			var codeValue = $("#code").val();
			// 验证验证码不为空！
			if (codeValue == "") {
				alert("验证码不能为空！");
			}
	
			return true;
		});
		
	});

</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span id="errorSpan" class="errorMsg">${ msg }</span>
							</div>
							<div class="form">
								<form action="userServlet?action=regist" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" 
										tabindex="1" name="username" id="username" 
										value="${ param.username }"
										/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" 
										tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" 
										tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" 
										tabindex="1" name="email" id="email" 
										value="${param.email }"
										/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 130px;" id="code" name="code"/>
									<img alt="" src="kaptcha.jpg" style="float: right;  width: 100px; height:35px; margin-right: 50px;">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>

	
	<!-- 这是页脚的引入 -->
	<%@ include file="/pages/common/footer.jsp" %>


</body>
</html>