package org.example.exam.pdd2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * n条木棍组成正方形的数量
 * <p>
 * 输入：
 * 2
 * 4
 * 5
 * 输出：
 * 1
 * 1
 * <p>
 * 输入：
 * 1
 * 10
 * 输出：
 * 3
 * <p>
 * 输入：
 * 1
 * 22
 * 8
 * <p>
 * 通过：20%
 *
 * @author lifei
 */
public class Solution3 {
    public static int getAns(long n) {
        int a = 1;
        while (getValue(a) < n) {
            a++;
        }
        a--;
        int ans = 0;
        ans += (a * a);
        n -= getValue(a);
        if (n > 1) {
            n -= 1;
            if (n <= 2L * a) {
                ans += (n / 2);
                n = 0;
            } else {
                ans += a;
                n -= (2L * a);
            }
        }
        if (n > 1) {
            n -= 1;
            if (n <= 2L * (a + 1)) {
                ans += (n / 2);
            } else {
                ans += (a + 1);
            }
        }
        return ans;
    }

    static HashMap<Integer, Long> map = new HashMap<>();

    static {
        map.put(1, 4L);
    }

    private static Long getValue(int a) {
        if (map.containsKey(a)) {
            return map.get(a);
        }
        map.put(a, (long) a * (a + 1) * 2);
        return map.get(a);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println((i + 1) + " : " + getAns(i + 1));
        }
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while (i < t) {
            long n = sc.nextLong();
            System.out.println(getAns(n));
            i++;
        }
    }
}
