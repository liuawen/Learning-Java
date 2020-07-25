<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
    <link rel="stylesheet" href="/style.css"></link>
  </head>
	<body onload='document.f.username.focus();'>
		<div id="loginForm">
			<h3>Login With Username and Password</h3>
			
			<form name='f' action="/login" method='POST'>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<table>
					<tr>
						<td>User:</td>
						<td><input type='text' name='username' value='' /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type='password' name='password' /></td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="submit"
							value="Login" /></td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>