package cn.mldn.mldnboot.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import cn.mldn.mldnboot.util.redis.RedisObjectSerializer;
import redis.clients.jedis.JedisPoolConfig;
@Configuration
public class RedisConfig {	// 表示定义一个配置类
	@Resource(name="redisConnectionFactory") 
	private RedisConnectionFactory redisConnectionFactoryOne ;
	@Resource(name="redisConnectionFactoryTwo") 
	private RedisConnectionFactory redisConnectionFactoryTwo ;
	@Bean("redisConnectionFactoryTwo")
	public RedisConnectionFactory getRedisConnectionFactoryTwo(
			@Value("${myredis.redis-two.host}") String hostName,
			@Value("${myredis.redis-two.password}") String password,
			@Value("${myredis.redis-two.port}") int port,
			@Value("${myredis.redis-two.database}") int database,
			@Value("${myredis.redis-two.pool.max-active}") int maxActive,
			@Value("${myredis.redis-two.pool.max-idle}") int maxIdle,
			@Value("${myredis.redis-two.pool.min-idle}") int minIdle,
			@Value("${myredis.redis-two.pool.max-wait}") long maxWait) { // 负责建立Factory的连接工厂类
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
	@Bean("redisConnectionFactory")	// 如果要与SpringBoot整合一定要提供一个指定名字的RedisConnectionFactory
	public RedisConnectionFactory getRedisConnectionFactoryOne(
			@Value("${myredis.redis-one.host}") String hostName,
			@Value("${myredis.redis-one.password}") String password,
			@Value("${myredis.redis-one.port}") int port,
			@Value("${myredis.redis-one.database}") int database,
			@Value("${myredis.redis-one.pool.max-active}") int maxActive,
			@Value("${myredis.redis-one.pool.max-idle}") int maxIdle,
			@Value("${myredis.redis-one.pool.min-idle}") int minIdle,
			@Value("${myredis.redis-one.pool.max-wait}") long maxWait) { // 建立Factory的连接工厂类
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
		jedisFactory.afterPropertiesSet(); 								// 初始化连接池配置
		return jedisFactory;
	}
	@Bean("redisOne")
	public RedisTemplate<String, String> getRedisTemplateOne() { 
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setKeySerializer(new StringRedisSerializer()); 	// key的序列化类型
		redisTemplate.setValueSerializer(new RedisObjectSerializer()); 	// value的序列化类型
		redisTemplate.setConnectionFactory(this.redisConnectionFactoryOne);
		return redisTemplate; 
	}
	@Bean("redisTwo")
	public RedisTemplate<String, String> getRedisTemplateTwo() { 
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
		redisTemplate.setKeySerializer(new StringRedisSerializer()); 	// key的序列化类型
		redisTemplate.setValueSerializer(new RedisObjectSerializer()); 	// value的序列化类型
		redisTemplate.setConnectionFactory(this.redisConnectionFactoryTwo);
		return redisTemplate; 
	}
}
