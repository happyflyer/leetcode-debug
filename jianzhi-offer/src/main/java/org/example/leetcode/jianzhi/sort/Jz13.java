package org.example.leetcode.jianzhi.sort;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/ef1f53ef31ca408cada5093c8780f44b?tpId=13&tqId=11166
 *
 * @author lifei
 */
public class Jz13 {
    /**
     * 遍历两次 + 空数组
     */
    public int[] reOrderArray(int[] array) {
        int n = array.length;
        int[] ans = new int[n];
        int cur = 0;
        for (int i : array) {
            if (i % 2 == 1) {
                ans[cur++] = i;
            }
        }
        for (int i : array) {
            if (i % 2 == 0) {
                ans[cur++] = i;
            }
        }
        return ans;
    }

    /**
     * 冒泡
     */
    public int[] reOrderArray2(int[] array) {
        int n = array.length;
        int cur = 0;
        int nextOdd = 0;
        while (cur < n && nextOdd < n) {
            if (array[cur] % 2 == 0) {
                nextOdd = cur + 1;
                while (nextOdd < n && array[nextOdd] % 2 == 0) {
                    nextOdd++;
                }
                if (nextOdd == n) {
                    break;
                }
                int temp = array[nextOdd];
                int i = nextOdd;
                while (i > cur) {
                    array[i] = array[i - 1];
                    i--;
                }
                array[cur] = temp;
                nextOdd++;
            }
            cur++;
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Jz13().reOrderArray(new int[]{1, 2, 3, 4})
                )
        );
    }
}
