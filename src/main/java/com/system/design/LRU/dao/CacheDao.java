package com.system.design.LRU.dao;

import com.system.design.LRU.constant.EvictionPolicy;
import com.system.design.LRU.model.Cache;

public class CacheDao {

    private Cache cache;
    private static CacheDao cacheDao;

    private CacheDao() {
    }

    public static CacheDao getInstance() {
        if (cacheDao == null)
            return new CacheDao();
        return cacheDao;
    }

    public Cache createCache(int size, EvictionPolicy policy) {
        return cache = new Cache(size, policy);
    }

    public Object get(Object obj) {
        Object result = cache.getCacheStore().get(obj);
        if (result == null) return null;
        cache.getDataStore().remove(obj);
        cache.getDataStore().addFirst(obj);
        return result;
    }

    public Boolean put(Object key, Object value) {
        try {
            if (cache.getSize() == cache.getDataStore().size()) {
                Object last = cache.getDataStore().removeLast();
                cache.getCacheStore().remove(last);
            }
            cache.getDataStore().remove(key);
            cache.getDataStore().addFirst(key);
            cache.getCacheStore().put(key, value);
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong while adding element in cache");
        }
        return false;
    }

    public Boolean delete(Object object) {
        if (cache.getDataStore().size() == 0) return true;
        try {
            cache.getDataStore().remove(object);
            cache.getCacheStore().remove(object);
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong while removing element");
        }
        return false;
    }

    public Boolean clear() {
        return cache.clear();
    }
}
