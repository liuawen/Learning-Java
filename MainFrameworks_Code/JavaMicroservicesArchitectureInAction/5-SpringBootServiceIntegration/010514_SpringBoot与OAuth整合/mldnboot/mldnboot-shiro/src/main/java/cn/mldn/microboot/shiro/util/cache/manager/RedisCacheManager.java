package cn.mldn.microboot.shiro.util.cache.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import cn.mldn.microboot.shiro.util.cache.RedisCache;
import cn.mldn.microboot.shiro.util.cache.abs.AbstractRedisCache;

public class RedisCacheManager implements CacheManager {
	// 建立一个负责管理所有缓存处理类的集合操作，要求保证线程安全
	private final ConcurrentMap<String, Cache<Object, Object>> CACHES = new ConcurrentHashMap<>();
	private Map<String, RedisConnectionFactory> connectionFactoryMap;

	@Override
	public Cache<Object, Object> getCache(String name) throws CacheException {
		Cache<Object, Object> cache = CACHES.get(name);
		if (cache == null) { // 还没有创建该缓存管理的对象就需要进行对象的创建处理
			AbstractRedisCache<Object, Object> abstractCache = null;
			if ("authenticationCache".equals(name)) { // 要获取的是认证缓存
				abstractCache = new RedisCache<Object, Object>();
				abstractCache.setConnectionFactory(this.connectionFactoryMap.get("authenticationCache"));
			} else if ("authorizationCache".equals(name)) { // 获得授权缓存
				abstractCache = new RedisCache<Object, Object>();
				abstractCache.setConnectionFactory(this.connectionFactoryMap.get("authorizationCache"));
			} else if ("activeSessionCache".equals(name)) { // 获得session缓存activeSessionCache
				abstractCache = new RedisCache<Object, Object>();
				abstractCache.setConnectionFactory(this.connectionFactoryMap.get("activeSessionCache"));
			}
			cache = abstractCache;
			CACHES.put(name, cache); // 防止随后重复取出
		}
		return cache;
	}

	public void setConnectionFactoryMap(Map<String, RedisConnectionFactory> connectionFactoryMap) {
		this.connectionFactoryMap = connectionFactoryMap;
	}
}
