package org.example.exam.wangyi;

import java.util.Scanner;

/**
 * 动态规划。
 *
 * 输入：3 1
 * 输出：a
 *
 * 输入：4 11
 * 输出：z
 *
 * @author lifei
 */
public class Solution2 {
    private static final char[] letters = new char[]{
            'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y',
            'z'
    };

    public static char findKthBit(int n, int k) {
        if (n == 1) {
            return 'a';
        }
        String[] cache = new String[n + 1];
        cache[1] = "a";
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + letters[i - 1] + reverseInvert(cache[i - 1]);
            System.out.println(i);
            System.out.println(cache[i]);
        }
        return cache[n].charAt(k - 1);
    }

    private static String reverseInvert(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(letters[25 - (c - 'a')]);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(findKthBit(n, k));
    }
}
