package cn.mldn.microboot.shiro.util.cache.abs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.util.SerializationUtils;

public abstract class AbstractRedisCache<K, V> implements Cache<K, V> {
	private RedisConnectionFactory connectionFactory ; // 定义一个Jedis连接工厂
	/**
	 * 由于RedisConnection的所有操作都是以字节数组的形式出现的，所以建议直接设置一个工具方法转换
	 * @param obj 要转换的任意对象
	 * @return 对象的字节数组
	 */
	protected byte [] objectToArray(Object obj) {
		return SerializationUtils.serialize(obj) ;
	}

	/**
	 * 将字节数组重新变为Object对象
	 * @param data 要转变的字节数组
	 * @return 目标处理对象
	 */
	protected Object byteArrayToObject(byte data[]) {
		return SerializationUtils.deserialize(data) ;
	}
	
	@Override
	public V get(K key) throws CacheException {
		V obj = null ;
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			obj = (V) this.byteArrayToObject(connection.get(this.objectToArray(key))) ;
		} catch (Exception e) {}
		connection.close(); 	// 将连接交回到连接池之中
		return obj;
	}

	@Override
	public V put(K key, V value) throws CacheException {
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			connection.set(this.objectToArray(key), this.objectToArray(value)) ;
		} catch (Exception e) {}
		connection.close(); 	// 将连接交回到连接池之中
		return value;
	}
	/**
	 * 设置一个Redis的数据操作，其本身需要一个失效时间
	 * @param key 要设置的key
	 * @param value 要设置的value
	 * @param expire 失效时间
	 * @return 返回Value
	 * @throws CacheException 缓存异常
	 */
	public V putEx(K key, V value,Long expire) throws CacheException {
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			connection.setEx(this.objectToArray(key), expire, this.objectToArray(value)) ;
		} catch (Exception e) {}
		connection.close(); 	// 将连接交回到连接池之中
		return value;
	}
	/**
	 * 设置一个Redis的数据操作，其本身需要一个失效时间
	 * @param key 要设置的key
	 * @param value 要设置的value
	 * @param expire 失效时间
	 * @return 返回Value
	 * @throws CacheException 缓存异常
	 */
	public V putEx(K key, V value,String expire) throws CacheException {
		return this.putEx(key, value, Long.parseLong(expire)) ;
	}

	@Override
	public V remove(K key) throws CacheException {
		V obj = null ;
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			obj = (V) this.byteArrayToObject(connection.get(this.objectToArray(key))) ;
			connection.del(this.objectToArray(key)) ;
		} catch (Exception e) {}
		connection.close(); 	// 将连接交回到连接池之中
		return obj;
	}

	@Override
	public void clear() throws CacheException {
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			connection.flushDb();	// 删除当前数据库之中的全部数据
		} catch (Exception e) {}
		connection.close(); 	// 将连接交回到连接池之中
	}

	@Override
	public int size() {
		int size = 0 ;
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			Set<byte[]> keys = connection.keys(this.objectToArray("*")) ;
			size = keys.size() ;
		} catch (Exception e) {}
		connection.close(); 	// 将连接交回到连接池之中
		return size ;
	}

	@Override
	public Set<K> keys() {
		Set<K> allKeys = new HashSet<K>() ; // 返回全部的Key信息
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			Set<byte[]> keys = connection.keys(this.objectToArray("*")) ;
			for (byte[] key : keys) {
				allKeys.add((K) this.byteArrayToObject(key));
			}
		} catch (Exception e) {}
		connection.close(); 	// 将连接交回到连接池之中
		return allKeys;
	}

	@Override
	public Collection<V> values() {
		Set<V> allValues = new HashSet<V>() ; // 返回全部的Key信息
		RedisConnection connection = this.connectionFactory.getConnection() ;
		try {
			Set<byte[]> keys = connection.keys(this.objectToArray("*")) ;
			for (byte[] key : keys) {
				allValues.add((V) this.byteArrayToObject(connection.get(key)));
			}
		} catch (Exception e) {}
		connection.close(); 	// 将连接交回到连接池之中
		return allValues;
	}
	public void setConnectionFactory(RedisConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}
}
