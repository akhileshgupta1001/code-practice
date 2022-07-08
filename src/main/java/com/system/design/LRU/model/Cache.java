package com.system.design.LRU.model;

import com.system.design.LRU.constant.EvictionPolicy;

import java.util.HashMap;
import java.util.LinkedList;

public class Cache {
    private int size;
    private EvictionPolicy evictionPolicy;
    private LinkedList<Object> dataStore;
    private HashMap<Object, Object> cacheStore;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public EvictionPolicy getEvictionPolicy() {
        return evictionPolicy;
    }

    public void setEvictionPolicy(EvictionPolicy evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    public LinkedList<Object> getDataStore() {
        return dataStore;
    }

    public void setDataStore(LinkedList<Object> dataStore) {
        this.dataStore = dataStore;
    }

    public HashMap<Object, Object> getCacheStore() {
        return cacheStore;
    }

    public void setCacheStore(HashMap<Object, Object> cacheStore) {
        this.cacheStore = cacheStore;
    }

    public Cache(int size, EvictionPolicy policy) {
        this.size = size;
        this.evictionPolicy = policy;
        this.dataStore = new LinkedList<>();
        this.cacheStore = new HashMap<>();
    }

    public Boolean clear() {
        try {
            this.dataStore = new LinkedList<>();
            this.cacheStore = new HashMap<>();
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong while clearing cache");
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "size=" + size +
                ", evictionPolicy=" + evictionPolicy +
                ", dataStore=" + dataStore +
                ", cacheStore=" + cacheStore +
                '}';
    }
}
