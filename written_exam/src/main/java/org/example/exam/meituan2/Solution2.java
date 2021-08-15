package org.example.exam.meituan2;

import java.util.Scanner;

/**
 * 小美现在有一个字符串，
 * 小美现在想知道能不能通过在字符串的尾端增加若干字符使得整个字符串变成一个回文串。
 * 回文串的定义：
 * 若一个字符串，对他正序遍历和倒序遍历得到的结果是完全一致的，就称它是一个回文串。
 * 例如 abcba 就是一个回文串，因为无论正序还是倒序都是一样的。
 * 对于字符串 abaaca，显然在该字符串末尾继续补上三个字符 aba 就可以构成 abaacaaba，
 * 就可以把原字符串变成回文串。换句话说，最少补上三个字符。
 * 你的任务就是找到使得原来的字符串变成回文串所需要的最少字符数量。
 * 本题数据保证没有空串，因此不考虑空串是否为回文串。
 * 保证输入的字符串仅包含小写字母。
 * <p>
 * 输入：abaaca
 * 输出：3
 * <p>
 * 输入：aba
 * 输出：0
 * <p>
 * 部分通过。
 *
 * @author lifei
 */
public class Solution2 {
    private static int getMinLength(String s) {
        int n = s.length();
        if (n % 2 == 0) {
            return getMinLength(s, n / 2 - 1, n / 2);
        } else {
            return getMinLength(s, n / 2);
        }
    }

    private static int getMinLength(String s, int mid) {
        int n = s.length();
        int i = 0;
        while (mid - i >= 0 && mid + i < n) {
            int left = mid - i;
            int right = mid + i;
            if (s.charAt(left) != s.charAt(right)) {
                return Math.max(
                        getMinLength(s, mid, mid + 1),
                        getMinLength(s, right)
                );
            }
            i++;
        }
        return mid - i + 1;
    }

    private static int getMinLength(String s, int left, int right) {
        int n = s.length();
        while (left >= 0 && right < n) {
            if (s.charAt(left) != s.charAt(right)) {
                return getMinLength(s, right);
            }
            left--;
            right++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getMinLength(s));
    }
}
