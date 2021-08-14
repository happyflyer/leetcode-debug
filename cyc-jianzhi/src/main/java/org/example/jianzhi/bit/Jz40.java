package org.example.jianzhi.bit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/389fc1c3d3be4479a154f63f495abff8?tpId=13&tqId=11193
 *
 * @author lifei
 */
public class Jz40 {
    /**
     * 哈希
     */
    public int[] FindNumsAppearOnce(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans[i++] = entry.getKey();
            }
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Jz40().FindNumsAppearOnce(new int[]{1, 4, 1, 6})
                )
        );
    }
}
