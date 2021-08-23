package org.example.exam.tencent;

import java.util.Scanner;

/**
 * 输入：
 * 4 2
 * ebfc
 * 输出：
 * fc
 * <p>
 * 输入：
 * 10 7
 * yicfihpfbz
 * 输出：
 * yiipfbz
 *
 * @author lifei
 */
public class Solution4 {
    public static String getSequence(int n, int k, String s) {
        return null;
    }

    public static int compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int n = Math.min(len1, len2);
        if (n == 0) {
            if (len1 == 0 && len2 == 0) {
                return 0;
            }
            if (len1 != 1) {
                return 1;
            } else {
                return -1;
            }
        }
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2) {
                continue;
            }
            if (c1 > c2) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        System.out.println(getSequence(n, k, s));
    }
}
