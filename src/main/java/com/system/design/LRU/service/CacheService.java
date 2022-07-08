package com.system.design.LRU.service;

import com.system.design.LRU.constant.EvictionPolicy;
import com.system.design.LRU.dao.CacheDao;
import com.system.design.LRU.model.Cache;

public class CacheService {
    private Cache cache;
    private static CacheService cacheService;
    private CacheDao cacheDao = CacheDao.getInstance();

    private CacheService() {
    }

    public static CacheService getInstance() {
        if (cacheService == null)
            return new CacheService();
        return cacheService;
    }

    public Cache init(int size, EvictionPolicy evictionPolicy) {
        return cacheDao.createCache(size, evictionPolicy);
    }

    public Object get(Object object) {
        return cacheDao.get(object);
    }

    public Boolean put(Object key, Object value) {
        return cacheDao.put(key, value);
    }

    public Boolean delete(Object key) {
        return cacheDao.delete(key);
    }

    public Boolean clear() {
        return cacheDao.clear();
    }
}
