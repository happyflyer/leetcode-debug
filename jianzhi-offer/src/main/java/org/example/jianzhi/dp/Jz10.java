package org.example.jianzhi.dp;

/**
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163
 *
 * @author lifei
 */
public class Jz10 {
    /**
     * 递推
     */
    public int rectCover(int target) {
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
                new Jz10().rectCover(4)
        );
    }
}
