package org.example.memory;

import java.util.LinkedHashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class LruCache {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LruCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        // 如果找不到就返回-1
        if (!cache.containsKey(key)) {
            return -1;
        }
        int val = cache.get(key);
        // 把当前key设置到最后（代表最近访问）
        makeRecently(key);
        return val;
    }

    public void put(int key, int value) {
        // 如果原来有，修改数据，并放到最后，代表最近访问
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        // 如果缓存存满了，删除头部元素（最长时间没访问的）
        if (cache.size() >= this.cap) {
            int oldKey = cache.keySet().iterator().next();
            cache.remove(oldKey);
        }
        // 保存数据
        cache.put(key, value);
    }

    private void makeRecently(int key) {
        // 删除原来的节点，再重新加入
        int val = cache.remove(key);
        cache.put(key, val);
    }
}
