package org.example.leetcode.jianzhi.array;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=13&tqId=11203
 *
 * @author lifei
 */
public class Jz50 {
    /**
     * 哈希表
     */
    public int duplicate(int[] numbers) {
        int n = numbers.length;
        Set<Integer> set = new HashSet<>();
        for (int i : numbers) {
            if (i < 0 || i > n - 1) {
                return -1;
            }
            if (set.contains(i)) {
                return i;
            } else {
                set.add(i);
            }
        }
        return -1;
    }

    /**
     * 替换法
     * <p>
     * 因为数组里的所有数字都在 0 到 n-1 的范围内，
     * 可以将值为 i 的元素调整到第 i 个位置上进行求解。
     * 在调整过程中，如果第 i 位置上已经有一个值为 i 的元素，就可以知道 i 值重复。
     */
    public int duplicate2(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    return numbers[i];
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return -1;
    }

    public void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz50().duplicate2(
                        new int[]{2, 3, 1, 0, 2, 5, 4}
                )
        );
    }
}
