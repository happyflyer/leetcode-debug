package org.example.leetcode.jianzhi.array;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187
 *
 * @author lifei
 */
public class Jz34 {
    /**
     * 两次遍历
     */
    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new HashMap<>(128);
        // 第一次循环做统计
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 第二次循环找结果
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 两次遍历
     */
    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(128);
        BitSet bs2 = new BitSet(128);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                bs1.set(c);
            } else if (bs1.get(c) && !bs2.get(c)) {
                bs2.set(c);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bs1.get(c) && !bs2.get(c)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz34().FirstNotRepeatingChar("google")
        );
    }
}
