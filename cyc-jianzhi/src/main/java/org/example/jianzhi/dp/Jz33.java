package org.example.jianzhi.dp;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186
 *
 * @author lifei
 */
public class Jz33 {
    /**
     * 暴力法，超时
     */
    public int GetUglyNumber_Solution(int index) {
        int[] cache = new int[index + 1];
        cache[1] = 1;
        int i = 2;
        int pos = 2;
        while (pos <= index) {
            if (isUglyNumber(i)) {
                cache[pos++] = i;
            }
            i++;
        }
        System.out.println(Arrays.toString(cache));
        return cache[index];
    }

    private boolean isUglyNumber(int i) {
        while (i % 2 == 0) {
            i /= 2;
        }
        while (i % 3 == 0) {
            i /= 3;
        }
        while (i % 5 == 0) {
            i /= 5;
        }
        return i == 1;
    }

    /**
     * 动态规划。
     * 维护三个队列，从中选取出最小的值，作为下一个丑数。
     */
    public int GetUglyNumber_Solution2(int index) {
        if (index < 7) {
            return index;
        }
        int[] cache = new int[index];
        cache[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        for (int i = 1; i < index; i++) {
            cache[i] = Math.min(cache[t2] * 2, Math.min(cache[t3] * 3, cache[t5] * 5));
            if (cache[i] == cache[t2] * 2) {
                t2++;
            }
            if (cache[i] == cache[t3] * 3) {
                t3++;
            }
            if (cache[i] == cache[t5] * 5) {
                t5++;
            }
        }
        System.out.println(Arrays.toString(cache));
        return cache[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz33().GetUglyNumber_Solution2(100)
        );
    }
}
