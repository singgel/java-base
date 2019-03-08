/*
 * 文件名：LRULinkedMap.java
 * 版权：Copyright by www.yiche.com
 * 描述：
 * 修改人：hekuangsheng
 * 修改时间：2019/3/7
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */
package com.hks.eightsortingalgorithms.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedMap<K,V> {
    /**
     * 最大缓存大小
     */
    private int cacheSize;
    private LinkedHashMap<K,V> cacheMap ;
    public LRULinkedMap(int cacheSize) {
        this.cacheSize = cacheSize;
        cacheMap = new LinkedHashMap(16,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if (cacheSize + 1 == cacheMap.size()){
                    return true ;
                }else {
                    return false ;
                }
            }
        };
    }
    public void put(K key,V value){
        cacheMap.put(key,value) ;
    }
    public V get(K key){
        return cacheMap.get(key) ;
    }
    public Collection<Map.Entry<K, V>> getAll() {
        return new ArrayList<Map.Entry<K, V>>(cacheMap.entrySet());
    }
}