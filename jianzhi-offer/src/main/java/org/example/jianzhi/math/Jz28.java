package org.example.jianzhi.math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181
 *
 * @author lifei
 */
public class Jz28 {
    /**
     * 哈希
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 排序
     */
    public int MoreThanHalfNum_Solution2(int[] array) {
        int n = array.length;
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        return array[n / 2];
    }

    /**
     * 候选法。
     * 如果两个数不相等，就消去这两个数，
     * 最坏情况下，每次消去一个众数和一个非众数，
     * 那么如果存在众数，最后留下的数肯定是众数。
     */
    public int MoreThanHalfNum_Solution3(int[] array) {
        int ans = -1;
        int cnt = 0;
        for (int i : array) {
            if (cnt == 0) {
                ans = i;
                cnt++;
            } else {
                if (ans == i) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
            System.out.println("ans = " + ans + ", cnt = " + cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz28().MoreThanHalfNum_Solution3(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2})
                // new Jz28().MoreThanHalfNum_Solution3(new int[]{3, 3, 3, 3, 3, 2, 2, 2, 2})
        );
    }
}
