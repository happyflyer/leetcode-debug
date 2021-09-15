package org.example.exam.huawei1;

import java.util.Scanner;

/**
 * 输入：
 * 输出：
 *
 * @author lifei
 */
public class Solution1 {
    public static int getAns(int k, int[] forward, int[] cache, int a) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] forward = new int[k];
        int[] cache = new int[k];
        int i = 0;
        while (i < k) {
            String s = sc.next();
            String[] split = s.split(",");
            forward[i] = Integer.parseInt(split[0]);
            cache[i] = Integer.parseInt(split[1]);
            i++;
        }
        int a = sc.nextInt();
        System.out.println(getAns(k, forward, cache, a));
    }
}
