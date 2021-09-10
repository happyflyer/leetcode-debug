package org.example.algo.cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * https://leetcode-cn.com/problems/lfu-cache/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution460 {
    public class LFUCache {
        // KV表
        HashMap<Integer, Integer> keyToVal;
        // KF表
        HashMap<Integer, Integer> keyToFreq;
        // FK表
        HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
        // 最小的freq
        int minFreq;
        // 容量大小
        int cap;

        public LFUCache(int capacity) {
            keyToVal = new HashMap<>();
            keyToFreq = new HashMap<>();
            freqToKeys = new HashMap<>();
            this.minFreq = 0;
            this.cap = capacity;
        }

        public int get(int key) {
            if (!keyToVal.containsKey(key)) {
                return -1;
            }
            // 增加key的freq
            increaseFreq(key);
            return keyToVal.get(key);
        }

        public void put(int key, int value) {
            if (this.cap == 0) {
                return;
            }
            // 判断是否包含key，包含直接更新值，增加freq
            if (keyToVal.containsKey(key)) {
                keyToVal.put(key, value);
                // 增加key的freq
                increaseFreq(key);
                return;
            }
            // KF表不包含key，判断是否达到容量，达到容量则删除minFreq对应的key
            // 如果minFreq对应多个key，则删除最先的key
            if (keyToVal.size() >= this.cap) {
                removeMinFreqKey();
            }
            // 保存数据，设置freq
            // 更新KV表
            keyToVal.put(key, value);
            // 更新KF表
            keyToFreq.put(key, 1);
            // 更新FK表
            freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
            freqToKeys.get(1).add(key);
            // 更新minFreq
            this.minFreq = 1;
        }

        private void increaseFreq(Integer key) {
            int freq = keyToFreq.get(key);
            // 更新KF表
            keyToFreq.put(key, freq + 1);
            // 更新FK表
            freqToKeys.get(freq).remove(key);
            freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
            freqToKeys.get(freq + 1).add(key);
            // 触发FK表清理键
            if (freqToKeys.get(freq).isEmpty()) {
                freqToKeys.remove(freq);
                // 更新minFreq
                if (freq == this.minFreq) {
                    this.minFreq++;
                }
            }
        }

        private void removeMinFreqKey() {
            // 找到minFreq的key列表
            LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
            // 找到最先的key
            int oldestKey = keyList.iterator().next();
            // 更新FK表
            keyList.remove(oldestKey);
            if (keyList.isEmpty()) {
                freqToKeys.remove(this.minFreq);
                // 这里需要更新minFreq吗？（没必要，因为在put方法中一定会更新minFreq）
            }
            // 更新KV表
            keyToVal.remove(oldestKey);
            // 更新KF表
            keyToFreq.remove(oldestKey);
        }
    }

    public static void main(String[] args) {
    }
}
