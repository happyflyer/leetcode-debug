package org.example.exam.pdd2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串排序
 * <p>
 * 输入：
 * 2
 * dcba
 * abcd
 * 输出：
 * dcba
 * abcd
 * <p>
 * 输入：
 * 2
 * abcde
 * abcdeaf
 * 输出：
 * abcdeaf
 * abcde
 * <p>
 * 通过：72.5%
 *
 * @author lifei
 */
public class Solution2 {
    public static String[] getAns(int n, String[] s) {
        Arrays.sort(s, Solution2::compare);
        return s;
    }

    public static int compare(String a, String b) {
        int min = Math.min(a.length(), b.length());
        a = getMin(a);
        b = getMin(b).substring(0, min);
        if (a.substring(0, min).compareTo(b.substring(0, min)) > 0) {
            return 1;
        } else if (b.substring(0, min).compareTo(a.substring(0, min)) > 0) {
            return -1;
        } else {
            return a.length() - b.length();
        }
    }

    private static String getMin(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder(str);
        int low = 0;
        int high = n - 1;
        while (low < high) {
            if (sb.charAt(low) > sb.charAt(high)) {
                char c1 = sb.charAt(low);
                char c2 = sb.charAt(high);
                sb.setCharAt(low, c2);
                sb.setCharAt(high, c1);
            }
            low++;
            high--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        int i = 0;
        while (i < n) {
            s[i] = sc.next();
            i++;
        }
        for (String s1 : getAns(n, s)) {
            System.out.println(s1);
        }
    }
}
