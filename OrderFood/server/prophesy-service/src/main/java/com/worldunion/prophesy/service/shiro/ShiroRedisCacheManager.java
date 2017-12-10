package com.worldunion.prophesy.service.shiro;

import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import com.worldunion.prophesy.dao.cache.ICached;
import com.worldunion.prophesy.service.shiro.cache.ShiroRedisCache;

/**
 * Created by starhousexq on 2015/11/18.
 */
public class ShiroRedisCacheManager extends AbstractCacheManager {
    private ICached cached;
    @Override
    protected Cache createCache(String cacheName) throws CacheException {
        return new ShiroRedisCache<String, Object>(cacheName,cached);
    }
    public ICached getCached() {
        return cached;
    }
    public void setCached(ICached cached) {
        this.cached = cached;
    }

}