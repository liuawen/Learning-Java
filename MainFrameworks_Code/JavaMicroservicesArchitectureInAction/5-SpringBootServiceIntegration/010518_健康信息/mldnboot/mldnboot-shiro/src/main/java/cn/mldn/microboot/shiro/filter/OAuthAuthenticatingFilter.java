package cn.mldn.microboot.shiro.filter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.util.WebUtils;

import cn.mldn.microboot.shiro.token.OAuthToken;

public class OAuthAuthenticatingFilter extends AuthenticatingFilter {
	private String authcodeParam = "code" ; // 由OAuth返回的地址上提供有参数
	private String failureUrl ;  // 定义一个失败的跳转页面
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		// 随后需要在这个程序之中进行关于oauth登录处理的相关配置操作
		String error = request.getParameter("error") ; // 此处要求获得错误的提示信息
		if (!(error == null || "".equals(error))) {	// 现在出现有错误提示信息
			String errorDesc = request.getParameter("error_description") ; // 错误信息
			// 如果此时出现有错误信息，则直接跳转到错误页面
			WebUtils.issueRedirect(request, response,
					this.failureUrl + "?error=" + error + "&error_description" + errorDesc);
			return false ; // 后续的操作不再执行，直接跳转
		}
		Subject subject = super.getSubject(request, response) ; // 获得Subject
		if (!subject.isAuthenticated()) { // 用户现在未进行登录认证
			String code = request.getParameter(this.authcodeParam) ; // 需要接收返回的code数据
			if (code == null || "".equals(code)) {	// 此时一定是一个错误的处理操作
				super.saveRequestAndRedirectToLogin(request, response); // 跳转到登录页
				return false ;
			}
		}
		return super.executeLogin(request, response); // 执行登录处理逻辑
	}
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {			// 登录成功之后应该跳转到成功页面
		super.issueSuccessRedirect(request, response);				// 跳转到登录成功页面
		return false ;
	}
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {								// 登录失败
		Subject subject = super.getSubject(request, response) ; 	// 获得当前用户Subject
		if (subject.isAuthenticated() || subject.isRemembered()) {	// 认证判断
			try { 													// 已经登录成功了就返回到首页上
				super.issueSuccessRedirect(request, response);
			} catch (Exception e1) {}
		} else { 													// 如果没有成功则直接跳转到失败页面
			try {
				WebUtils.issueRedirect(request, response, this.failureUrl);
			} catch (IOException e1) {}
		}
		return false ;
	} 
	public void setAuthcodeParam(String authcodeParam) {
		this.authcodeParam = authcodeParam;
	}
	public void setFailureUrl(String failureUrl) {
		this.failureUrl = failureUrl;
	}
	@Override
	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
		OAuthToken token = new OAuthToken(request.getParameter(this.authcodeParam)) ;	// 要传入一个自定义的Token信息
		token.setRememberMe(true); 									// 设置记住我的功能
		return token ; 
	}
}