package org.example.exam.baidu2;

import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 4
 * 213
 * 3244
 * 22
 * 100
 * 输出：
 * 213
 * 3233
 * 22
 * 33
 * 说明：
 *
 * @author lifei
 */
public class Solution2 {
    public static long getAns(String str) {
        char[] s = str.toCharArray();
        int l = s.length;
        for (int i = l - 1; i >= 0; i--) {
            if (s[0] == '0') {
                break;
            }
            if (s[i] <= '3' && s[i] > '0') {
                continue;
            } else if (s[i] > '3') {
                s[i] = '3';
            } else if (s[i] == '0') {
                s[i] = '3';
                if (i - 1 >= 0 && s[i - 1] > '0') {
                    s[i - 1]--;
                }
            }
        }
        long res = 0;
        long base = 1;
        for (int i = l - 1; i >= 0; i--) {
            res += ((s[i] - '0') * base);
            base *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        while (i < t) {
            String str = sc.next();
            System.out.println(getAns(str));
            i++;
        }
    }
}
