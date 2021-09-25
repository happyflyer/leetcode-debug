package org.example.algo.custom.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * https://leetcode-cn.com/problems/random-pick-with-blacklist/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution710 {
    class Solution {
        int size;
        Map<Integer, Integer> map;

        public Solution(int n, int[] blacklist) {
            size = n - blacklist.length;
            map = new HashMap<>();
            for (int b : blacklist) {
                // 用于避免碰撞
                map.put(b, -1);
            }
            int last = n - 1;
            for (int b : blacklist) {
                // 黑名单的数字本来就位于[size,n)
                if (b >= size) {
                    continue;
                }
                // 避免碰撞
                while (map.containsKey(last)) {
                    last--;
                }
                map.put(b, last);
                last--;
            }
        }

        public int pick() {
            int index = new Random().nextInt(size);
            if (map.containsKey(index)) {
                return map.get(index);
            }
            return index;
        }
    }

    public static void main(String[] args) {
    }
}
