package cn.mldn.microboot.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.Filter;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import cn.mldn.microboot.shiro.job.DefaultQuartzSessionValidationScheduler;
import cn.mldn.microboot.shiro.realm.MemberRealm;
import cn.mldn.microboot.shiro.realm.matcher.DefaultCredentialsMatcher;
import cn.mldn.microboot.shiro.util.cache.manager.RedisCacheManager;

@Configuration
public class ShiroConfig {
	public static final String LOGOUT_URL = "/logout.action" ;			// 退出路径
	public static final String LOGIN_URL = "/loginPage" ;				// 登录路径
	public static final String UNAUTHORIZED_URL = "/unauth" ;			// 未授权错误页
	public static final String SUCCESS_URL = "/pages/back/welcome" ;	// 登录成功页
	
	@Resource(name = "redisConnectionFactory")
	private RedisConnectionFactory redisConnectionFactoryAuthentication;
	@Resource(name = "redisConnectionFactoryAuthorization")
	private RedisConnectionFactory redisConnectionFactoryAuthorization;
	@Resource(name = "redisConnectionFactoryActiveSessionCache")
	private RedisConnectionFactory redisConnectionFactoryActiveSessionCache; 
	
	
	@Bean
	public MemberRealm getRealm() {										// 定义Realm
		MemberRealm realm = new MemberRealm();
		realm.setCredentialsMatcher(new DefaultCredentialsMatcher());	// 配置缓存
		realm.setAuthenticationCachingEnabled(true);
		realm.setAuthenticationCacheName("authenticationCache");
		realm.setAuthorizationCachingEnabled(true);
		realm.setAuthorizationCacheName("authorizationCache");
		return realm;
	}
	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {	// Shiro实现控制器处理
		return new LifecycleBeanPostProcessor();
	}
	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}
	@Bean
	public CacheManager getCacheManager(
			@Qualifier("redisConnectionFactory")
			RedisConnectionFactory redisConnectionFactoryAuthentication ,
			@Qualifier("redisConnectionFactoryAuthorization")
			RedisConnectionFactory redisConnectionFactoryAuthorization ,
			@Qualifier("redisConnectionFactoryActiveSessionCache")
			RedisConnectionFactory redisConnectionFactoryActiveSessionCache
			) {															// 缓存配置
		RedisCacheManager cacheManager = new RedisCacheManager();		// 缓存集合
		Map<String,RedisConnectionFactory> map = new HashMap<>() ;
		map.put("authenticationCache", redisConnectionFactoryAuthentication) ;
		map.put("authorizationCache", redisConnectionFactoryAuthorization) ;
		map.put("activeSessionCache", redisConnectionFactoryActiveSessionCache) ;
		cacheManager.setConnectionFactoryMap(map);
		return cacheManager;
	}
	@Bean
	public SessionIdGenerator getSessionIdGenerator() { 				// SessionID生成
		return new JavaUuidSessionIdGenerator();
	}
	@Bean
	public SessionDAO getSessionDAO(SessionIdGenerator sessionIdGenerator) {
		EnterpriseCacheSessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
		sessionDAO.setActiveSessionsCacheName("activeSessionCache");
		sessionDAO.setSessionIdGenerator(sessionIdGenerator);
		return sessionDAO;
	}
	@Bean
	public RememberMeManager getRememberManager() {						// 记住我
		CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
		SimpleCookie cookie = new SimpleCookie("MLDNJAVA-RememberMe");
		cookie.setHttpOnly(true); 
		cookie.setMaxAge(3600);
		rememberMeManager.setCookie(cookie);
		return rememberMeManager;
	}
	@Bean
	public DefaultQuartzSessionValidationScheduler getQuartzSessionValidationScheduler(
			DefaultWebSessionManager sessionManager) {
		DefaultQuartzSessionValidationScheduler sessionValidationScheduler = new DefaultQuartzSessionValidationScheduler();
		sessionValidationScheduler.setSessionValidationInterval(100000);
		sessionValidationScheduler.setSessionManager(sessionManager);
		return sessionValidationScheduler;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(
			DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(securityManager);
		return aasa; 
	}

	@Bean
	public ShiroDialect shiroDialect() { 							// 追加配置，启动Thymeleaf模版支持
		return new ShiroDialect();
	}
	@Bean
	public DefaultWebSessionManager getSessionManager(SessionDAO sessionDAO) { // Session管理
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setDeleteInvalidSessions(true);
		sessionManager.setSessionValidationSchedulerEnabled(true);
		sessionManager.setSessionDAO(sessionDAO);
		SimpleCookie sessionIdCookie = new SimpleCookie("mldn-session-id");
		sessionIdCookie.setHttpOnly(true);
		sessionIdCookie.setMaxAge(-1);
		sessionManager.setSessionIdCookie(sessionIdCookie);
		sessionManager.setSessionIdCookieEnabled(true);
		return sessionManager;
	}
	@Bean
	public DefaultWebSecurityManager getSecurityManager(Realm memberRealm, CacheManager cacheManager,
			SessionManager sessionManager, RememberMeManager rememberMeManager) {// 缓存管理
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(memberRealm);
		securityManager.setCacheManager(cacheManager);
		securityManager.setSessionManager(sessionManager);
		securityManager.setRememberMeManager(rememberMeManager);
		return securityManager;
	}
	public FormAuthenticationFilter getLoginFilter() { 		// 在ShiroFilterFactoryBean中使用
		FormAuthenticationFilter filter = new FormAuthenticationFilter();
		filter.setUsernameParam("mid");
		filter.setPasswordParam("password");
		filter.setRememberMeParam("rememberMe");
		filter.setLoginUrl(LOGIN_URL);						// 登录提交页面
		filter.setFailureKeyAttribute("error");
		return filter;
	}
	public LogoutFilter getLogoutFilter() { 				// 在ShiroFilterFactoryBean中使用
		LogoutFilter logoutFilter = new LogoutFilter();
		logoutFilter.setRedirectUrl("/");					// 首页路径，登录注销后回到的页面
		return logoutFilter;
	}
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);	// 设置 SecurityManager
		shiroFilterFactoryBean.setLoginUrl(LOGIN_URL);		// 设置登录页路径
		shiroFilterFactoryBean.setSuccessUrl(SUCCESS_URL);	// 设置跳转成功页
		shiroFilterFactoryBean.setUnauthorizedUrl(UNAUTHORIZED_URL);	// 授权错误页
		Map<String, Filter> filters = new HashMap<String, Filter>();
		filters.put("authc", this.getLoginFilter());
		filters.put("logout", this.getLogoutFilter());
		shiroFilterFactoryBean.setFilters(filters);
		Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
		filterChainDefinitionMap.put("/logout.page", "logout");
		filterChainDefinitionMap.put("/loginPage", "authc");	// 定义内置登录处理
		filterChainDefinitionMap.put("/pages/**", "authc");
		filterChainDefinitionMap.put("/*", "anon");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
}
