package org.example.algo.cache;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/maximum-frequency-stack/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution895 {
    class FreqStack {
        // VF表
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        // FV表
        HashMap<Integer, Stack<Integer>> freqToVals = new HashMap<>();
        // 最大的freq
        int maxFreq = 0;

        public FreqStack() {
        }

        public void push(int val) {
            int freq = valToFreq.getOrDefault(val, 0) + 1;
            // 更新VF表
            valToFreq.put(val, freq);
            // 更新FV表
            freqToVals.putIfAbsent(freq, new Stack<>());
            freqToVals.get(freq).push(val);
            // 更新maxFreq
            maxFreq = Math.max(maxFreq, freq);
        }

        public int pop() {
            Stack<Integer> vals = freqToVals.get(maxFreq);
            int v = vals.pop();
            // 更新VF表
            int freq = valToFreq.get(v) - 1;
            valToFreq.put(v, freq);
            // 更新maxFreq
            if (vals.isEmpty()) {
                this.maxFreq--;
            }
            return v;
        }
    }

    public static void main(String[] args) {
    }
}
