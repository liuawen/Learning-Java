package cn.mldn.microboot.shiro.realm.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.mldn.microboot.util.PasswordUtil;

//定义一个密码加密处理的密码匹配其
public class DefaultCredentialsMatcher extends SimpleCredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		// 在父类之中提供有toString()方法可以自动将传递的字符数组密码变为字符串的密码
		Object tokenCredentials = PasswordUtil.encoder(super.toString(token.getCredentials()));
		Object accountCredentials = super.getCredentials(info); // 获取认证处理后的密码
		return super.equals(tokenCredentials, accountCredentials);
	}
}
