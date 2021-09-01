package org.example.exam.shence;

import java.util.Scanner;

/**
 * 输入：abc def efg
 * 输出：cba fed gfe
 *
 * @author lifei
 */
public class Solution1 {
    public static String getAns(String s) {
        StringBuilder res = new StringBuilder();
        int n = s.length();
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                res.append(s.charAt(start + i - 1 - p));
            }
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }
            if (i < n) {
                res.append(' ');
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getAns(s));
    }
}
