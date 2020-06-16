package cn.mldn.microboot.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class DefaultFormAuthenticationFilter extends FormAuthenticationFilter {
	private String randname = "rand" ; // 验证码生成的session属性名称
	private String randparam = "code" ; // 用户表单输入的名称
	@Override
	protected boolean onAccessDenied(ServletRequest request, 
			ServletResponse response) throws Exception {	// 访问拒绝处理
		// 1、验证码是session的概念，所以应该首先获取HttpSession对象
		HttpSession session = ((HttpServletRequest) request).getSession() ;
		// 2、通过session获取生成的验证码数据
		String rand = (String) session.getAttribute(this.randname) ;
		if (rand == null || "".equals(rand)) {
			return super.onAccessDenied(request, response) ;
		}
		// 3、获取用户输入的验证码数据
		String code = request.getParameter(this.randparam) ; 
		if (code == null || "".equals(code)) {
			request.setAttribute("error", "验证码不允许为空！");
			return true ;	// 返回true表示拒绝
		} else {
			if (!rand.equalsIgnoreCase(code)) {	// 输入的验证码不同
				request.setAttribute("error", "验证码输入错误！");
				return true ;
			}
		}
		return super.onAccessDenied(request, response);	// 交给后续处理 
	}
	public void setRandname(String randname) {
		this.randname = randname;
	}
	public void setRandparam(String randparam) {
		this.randparam = randparam;
	}
}