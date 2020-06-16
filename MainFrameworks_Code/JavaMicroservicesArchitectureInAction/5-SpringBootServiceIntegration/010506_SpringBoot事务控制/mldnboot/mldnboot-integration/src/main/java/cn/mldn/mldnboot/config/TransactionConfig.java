package cn.mldn.mldnboot.config;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration						// 定义配置Bean
@Aspect								// 采用AOP切面处理
public class TransactionConfig {
	private static final int TRANSACTION_METHOD_TIMEOUT = 5 ;	// 事务超时时间为5秒
	private static final String AOP_POINTCUT_EXPRESSION = "execution (* cn.mldn..service.*.*(..))";	// 定义切面表达式
	@Autowired
	private PlatformTransactionManager transactionManager;		// 注入事务管理对象
	@Bean("txAdvice")											// Bean名称必须为txAdvice
	public TransactionInterceptor transactionConfig() {			// 定义事务控制切面
		// 定义只读事务控制，该事务不需要启动事务支持
		RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
		readOnly.setReadOnly(true);
		readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
		// 定义更新事务，同时设置事务操作的超时时间
		RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
		required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		required.setTimeout(TRANSACTION_METHOD_TIMEOUT);
		Map<String, TransactionAttribute> transactionMap = new HashMap<>();			// 定义业务切面
		transactionMap.put("add*", required);
		transactionMap.put("edit*", required);
		transactionMap.put("delete*", required);
		transactionMap.put("get*", readOnly);
		transactionMap.put("list*", readOnly);
		NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
		source.setNameMap(transactionMap);
		TransactionInterceptor transactionInterceptor = new TransactionInterceptor(transactionManager, source);
		return transactionInterceptor ;
	}
	@Bean
	public Advisor transactionAdviceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression(AOP_POINTCUT_EXPRESSION);									// 定义切面
		return new DefaultPointcutAdvisor(pointcut, transactionConfig());
	}
}
