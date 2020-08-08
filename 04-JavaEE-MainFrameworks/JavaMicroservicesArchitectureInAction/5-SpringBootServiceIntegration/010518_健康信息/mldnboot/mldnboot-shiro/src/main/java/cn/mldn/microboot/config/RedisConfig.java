package cn.mldn.microboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig { // 表示定义一个配置类

	@Bean("redisConnectionFactory") // 如果要与SpringBoot整合一定要提供一个指定名字的RedisConnectionFactory
	public RedisConnectionFactory getRedisConnectionFactoryAuthentication(
			@Value("${myredis.redis-authentication.host}") String hostName,
			@Value("${myredis.redis-authentication.password}") String password, 
			@Value("${myredis.redis-authentication.port}") int port,
			@Value("${myredis.redis-authentication.database}") int database,
			@Value("${myredis.redis-authentication.pool.max-active}") int maxActive,
			@Value("${myredis.redis-authentication.pool.max-idle}") int maxIdle,
			@Value("${myredis.redis-authentication.pool.min-idle}") int minIdle,
			@Value("${myredis.redis-authentication.pool.max-wait}") long maxWait) { // 负责建立Factory的连接工厂类
		JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
		jedisFactory.setHostName(hostName);
		jedisFactory.setPort(port);
		jedisFactory.setPassword(password);
		jedisFactory.setDatabase(database);
		JedisPoolConfig poolConfig = new JedisPoolConfig(); // 进行连接池配置
		poolConfig.setMaxTotal(maxActive);
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMinIdle(minIdle);
		poolConfig.setMaxWaitMillis(maxWait);
		jedisFactory.setPoolConfig(poolConfig);
		jedisFactory.afterPropertiesSet(); // 初始化连接池配置
		return jedisFactory;
	}
	
	@Bean("redisConnectionFactoryAuthorization")
	public RedisConnectionFactory getRedisConnectionFactoryAuthorization(
			@Value("${myredis.redis-authorization.host}") String hostName,
			@Value("${myredis.redis-authorization.password}") String password, 
			@Value("${myredis.redis-authorization.port}") int port,
			@Value("${myredis.redis-authorization.database}") int database,
			@Value("${myredis.redis-authorization.pool.max-active}") int maxActive,
			@Value("${myredis.redis-authorization.pool.max-idle}") int maxIdle,
			@Value("${myredis.redis-authorization.pool.min-idle}") int minIdle,
			@Value("${myredis.redis-authorization.pool.max-wait}") long maxWait) { // 负责建立Factory的连接工厂类
		JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
		jedisFactory.setHostName(hostName);
		jedisFactory.setPort(port);
		jedisFactory.setPassword(password);
		jedisFactory.setDatabase(database);
		JedisPoolConfig poolConfig = new JedisPoolConfig(); // 进行连接池配置
		poolConfig.setMaxTotal(maxActive);
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMinIdle(minIdle);
		poolConfig.setMaxWaitMillis(maxWait);
		jedisFactory.setPoolConfig(poolConfig);
		jedisFactory.afterPropertiesSet(); // 初始化连接池配置
		return jedisFactory;
	}
	@Bean("redisConnectionFactoryActiveSessionCache")
	public RedisConnectionFactory getRedisConnectionFactoryActiveSessionCache(
			@Value("${myredis.redis-activeSessionCache.host}") String hostName,
			@Value("${myredis.redis-activeSessionCache.password}") String password, 
			@Value("${myredis.redis-activeSessionCache.port}") int port,
			@Value("${myredis.redis-activeSessionCache.database}") int database,
			@Value("${myredis.redis-activeSessionCache.pool.max-active}") int maxActive,
			@Value("${myredis.redis-activeSessionCache.pool.max-idle}") int maxIdle,
			@Value("${myredis.redis-activeSessionCache.pool.min-idle}") int minIdle,
			@Value("${myredis.redis-activeSessionCache.pool.max-wait}") long maxWait) { // 负责建立Factory的连接工厂类
		JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
		jedisFactory.setHostName(hostName);
		jedisFactory.setPort(port);
		jedisFactory.setPassword(password);
		jedisFactory.setDatabase(database);
		JedisPoolConfig poolConfig = new JedisPoolConfig(); // 进行连接池配置
		poolConfig.setMaxTotal(maxActive);
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMinIdle(minIdle);
		poolConfig.setMaxWaitMillis(maxWait);
		jedisFactory.setPoolConfig(poolConfig);
		jedisFactory.afterPropertiesSet(); // 初始化连接池配置
		return jedisFactory;
	}

}
