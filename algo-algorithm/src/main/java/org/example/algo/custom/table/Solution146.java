package org.example.algo.custom.table;

import java.util.LinkedHashMap;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution146 {
    public class LRUCache {
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        int cap;

        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            // cache中没有key，发生内存缺页
            if (!cache.containsKey(key)) {
                return -1;
            }
            int val = cache.get(key);
            // 把当前key设置到最后，代表最近访问
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
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            // 将新的key添加链表尾部
            cache.put(key, value);
        }

        private void makeRecently(int key) {
            // 删除原来的节点，再重新加入
            int val = cache.remove(key);
            cache.put(key, val);
        }
    }

    public static void main(String[] args) {
    }
}
