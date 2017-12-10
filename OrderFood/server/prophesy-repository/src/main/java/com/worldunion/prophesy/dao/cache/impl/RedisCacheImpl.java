package com.worldunion.prophesy.dao.cache.impl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.worldunion.prophesy.dao.cache.Cache;
import com.worldunion.prophesy.dao.cache.CacheType;

@Component("redisCache")
public class RedisCacheImpl implements Cache {

	@Resource(name="redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;

	/** The ReadWriteLock. */
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	private String id;
	
	public RedisCacheImpl() {
		if (id == null) {
			this.id = "cache";
		}
	}
	
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public int getSize() {
		return 1;
	}
	
	@Override
	public void putObject(String key, Object value, long timeout) {
		redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
	}
	
	@Override
	public void putObject(Object key, Object value) {
		redisTemplate.opsForValue().set((String)key, value);
	}
	
	@Override
	public Object getObject(Object key) {
		return redisTemplate.opsForValue().get(key);
	}
	@Override
	public Object removeObject(Object key) {
		redisTemplate.delete((String)key);
		return null;
	}
	
	@Override
	public void clear() {
		return;
	}
	
	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}
	
	/**
	 * 返回redis模板对象
	 * @param cacheType 读，写
	 * @return
	 */
	public RedisTemplate<String, Object> getRedisTemplate(CacheType cacheType){
		if(cacheType==CacheType.QUERY){
			return redisTemplate;
		}else{
			return redisTemplate;
		}
	}



}
