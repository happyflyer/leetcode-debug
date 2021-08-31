package org.example.memory;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * https://leetcode-cn.com/problems/lfu-cache/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class LfuCache {
    // 容量大小
    int cap;
    // 最小的频次
    int minFreq;
    // key到val的映射
    HashMap<Integer, Integer> key2Val;
    // key到freq的映射
    HashMap<Integer, Integer> key2Freq;
    // freq到key列表的映射
    HashMap<Integer, LinkedHashSet<Integer>> freq2Keys;

    public LfuCache(int capacity) {
        this.cap = capacity;
        this.minFreq = 0;
        key2Val = new HashMap<>();
        key2Freq = new HashMap<>();
        freq2Keys = new HashMap<>();
    }

    public int get(int key) {
        if (!key2Val.containsKey(key)) {
            return -1;
        }
        // 增加访问频次
        increaseFreq(key);
        return key2Val.get(key);
    }

    public void put(int key, int value) {
        if (this.cap == 0) {
            return;
        }
        // 判断是否包含key，包含直接增加访问频次，更新值
        if (key2Val.containsKey(key)) {
            // 增加访问频次
            increaseFreq(key);
            key2Val.put(key, value);
            return;
        }
        // 不包含，判断是否达到容量，达到容量删除最少频次，最先访问的元素
        if (key2Val.size() >= this.cap) {
            removeMinFreqKey();
        }
        // 保存数据，更新频次
        key2Val.put(key, value);
        // 设置key热度
        key2Freq.put(key, 1);
        freq2Keys.putIfAbsent(1, new LinkedHashSet<>());
        // 热度与key关联
        freq2Keys.get(1).add(key);
        this.minFreq = 1;
    }

    private void increaseFreq(Integer key) {
        int freq = key2Freq.get(key);
        // 增加热度
        key2Freq.put(key, freq + 1);
        freq2Keys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freq2Keys.get(freq + 1).add(key);
        // 调整热度与key关系的数据
        freq2Keys.get(freq).remove(key);
        if (freq2Keys.get(freq).size() == 0) {
            freq2Keys.remove(freq);
            if (freq == this.minFreq) {
                this.minFreq++;
            }
        }
    }

    private void removeMinFreqKey() {
        // 查看最小的热度
        // 找到最先访问的key
        int oldKey = freq2Keys.get(this.minFreq).iterator().next();
        // 删除key及val
        key2Val.remove(oldKey);
        key2Freq.remove(oldKey);
        // 删除热度与key的关系
        freq2Keys.get(this.minFreq).remove(oldKey);
        if (freq2Keys.get(this.minFreq).size() == 0) {
            freq2Keys.remove(this.minFreq);
        }
    }
}
