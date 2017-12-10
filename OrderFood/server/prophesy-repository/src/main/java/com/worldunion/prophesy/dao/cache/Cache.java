package com.worldunion.prophesy.dao.cache;

import java.util.concurrent.locks.ReadWriteLock;

import org.springframework.data.redis.core.RedisTemplate;
public interface Cache {
	/**
	 * 获取缓存对象的唯一标识
	 * @return
	 */
	String getId();

	/**
	 * 保存key/value到缓存对象中,timeout为超时时间
	 * @param key 
	 * @param value
	 * @param timeout
	 */
	void putObject(String key, Object value, long timeout);
	
	/**
	 * 保存key/value到缓存对象中
	 * key可以是任何对象，但一般是CacheKey对象
	 * value是查询结果，为List类型
	 * @param key
	 * @param value
	 */
	void putObject(Object key, Object value);

	/**
	 * 从缓存对象中获取key对应的value
	 * @param key
	 * @return
	 */
	Object getObject(Object key);

	/**
	 * 可选的方法，没有被核心框架调用，移除key对应的value
	 * @param key
	 * @return
	 */
	Object removeObject(Object key);

	/**
	 * 清空缓存
	 */
	void clear();

	/**
	 * 获取缓存对象中存储的键/值对的数量
	 * 可选的方法，没有被框架核心调用
	 */
	int getSize();

	/**
	 * 获取读写锁
	 * 可选的方法，从3.2.6起这个方法不再被框架核心调用
	 * 任何需要的锁，都必须由缓存供应商提供
	 * 
	 * @return A ReadWriteLock
	 */
	ReadWriteLock getReadWriteLock();
	/**
	 * 返回redis模板对象
	 * @return
	 */
	public RedisTemplate<String, Object> getRedisTemplate(CacheType cacheType);
}