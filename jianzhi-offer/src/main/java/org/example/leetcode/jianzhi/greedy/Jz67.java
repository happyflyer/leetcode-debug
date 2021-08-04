package org.example.leetcode.jianzhi.greedy;

/**
 * https://www.nowcoder.com/practice/57d85990ba5b440ab888fc72b0751bf8?tpId=13&tqId=33257
 *
 * @author lifei
 */
public class Jz67 {
    /**
     * 错误解答
     */
    public int cutRope(int target) {
        double root = Math.round(Math.sqrt(target));
        System.out.println("root=" + root);
        double unit = Math.round(((double) target) / root);
        System.out.println("unit=" + unit);
        return (int) (Math.pow(unit, (root - 1)) * (target - unit * (root - 1)));
    }

    /**
     * 递归。
     * 2    1,1     1
     * 3    1,2     2
     * 4    2,2     4
     * 5    2,3     6
     * 6    3,3     9
     * 7    2,2,3   12
     * 8    3,3,2   18
     * 9    3,3,3   27
     * 10   3,3,4   36
     */
    private int backTrack(int n) {
        // 如果小于4就不用分段了，分段出来的结果还没自己大
        if (n <= 4) {
            return n;
        }
        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, i * backTrack(n - i));
        }
        return ret;
    }

    /**
     * 方法一。
     * 2 和 3 特殊处理。
     */
    public int cutRope2(int target) {
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }
        return backTrack(target);
    }

    private int backTrack2(int n, int[] cache) {
        if (n <= 4) {
            return n;
        }
        // 加速递归
        if (cache[n] > 0) {
            return cache[n];
        }
        int ret = 0;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, i * backTrack(n - i));
        }
        // 缓存结果
        cache[n] = ret;
        return ret;
    }

    public int cutRope3(int target) {
        if (target == 2) {
            return 1;
        } else if (target == 3) {
            return 2;
        }
        // 缓存数组，加速递归
        int[] cache = new int[target + 1];
        return backTrack2(target, cache);
    }

    /**
     * 动态规划。
     * f(n) = max[1*f(n-1), 2*f(n-2), 3*f(n-3), ..., (n-1)*f(1)]
     */
    public int cutRope4(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int[] f = new int[target + 1];
        for (int i = 1; i <= 4; i++) {
            f[i] = i;
        }
        for (int i = 5; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                f[i] = Math.max(f[i], j * f[i - j]);
            }
        }
        return f[target];
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz67().cutRope4(15)
        );
    }
}
