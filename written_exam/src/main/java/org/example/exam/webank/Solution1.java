package org.example.exam.webank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述：小A的高次方程。
 * 小A在做数学作业时，看到了这样一个题目：求方程x3+y4+z5=k的一组正整数解(x,y,z)。
 * 小A实在做不来这道题，于是他找你帮忙写一个程序来解决这个问题。
 * 由于你希望小A的作业让他自己做，你只需要判断是否存在解即可。
 * 输入：
 * 3
 * 3
 * 25
 * 2
 * 输出：
 * YES
 * YES
 * NO
 * 说明：
 * 通过：72%
 *
 * @author lifei
 */
public class Solution1 {
    public static String getAns(long k) {
        Map<Long, Long> map = new HashMap<>();
        for (long i = 1; i <= 10000; i++) {
            long t = i * i * i;
            map.put(t, i);
        }
        boolean found = false;
        for (long y = 1; y <= 1000; y++) {
            for (long z = 1; z <= 1000; z++) {
                long t = y * y * y * y + z * z * z * z * z;
                if (t < k && map.containsKey(k - t)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        return found ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        while (i < n) {
            long k = sc.nextInt();
            System.out.println(getAns(k));
            i++;
        }
    }
}
