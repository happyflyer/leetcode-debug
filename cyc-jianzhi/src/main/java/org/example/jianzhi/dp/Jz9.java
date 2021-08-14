package org.example.jianzhi.dp;

/**
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162
 *
 * @author lifei
 */
public class Jz9 {
    /**
     * 递推
     */
    public int jumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        int[] cache = new int[target + 1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= target; i++) {
            int k = i - 1;
            while (k > 0) {
                cache[i] += cache[k];
                k--;
            }
            cache[i]++;
        }
        return cache[target];
    }

    /**
     * 通项
     */
    public int jumpFloorII2(int target) {
        int sum = 1;
        while (target-- > 1) {
            sum *= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz9().jumpFloorII(3)
        );
    }
}
