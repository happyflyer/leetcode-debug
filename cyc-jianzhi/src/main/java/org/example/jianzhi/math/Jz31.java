package org.example.jianzhi.math;

/**
 * https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184
 *
 * @author lifei
 */
public class Jz31 {
    /**
     * 暴力法
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += count1(i);
        }
        return ans;
    }

    private int count1(int i) {
        int ans = 0;
        while (i > 0) {
            if (i % 10 == 1) {
                ans++;
            }
            i /= 10;
        }
        return ans;
    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m;
            int b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz31().NumberOf1Between1AndN_Solution2(123)
        );
    }
}
