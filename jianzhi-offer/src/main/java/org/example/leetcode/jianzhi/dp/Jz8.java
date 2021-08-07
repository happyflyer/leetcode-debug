package org.example.leetcode.jianzhi.dp;

/**
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161
 *
 * @author lifei
 */
public class Jz8 {
    /**
     * 递推
     */
    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        int[] cache = new int[target + 1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= target; i++) {
            cache[i] = cache[i - 2] + cache[i - 1];
        }
        return cache[target];
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz8().jumpFloor(7)
        );
    }
}
