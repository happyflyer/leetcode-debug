package org.example.leetcode.lang.oj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/5657/H
 *
 * @author lifei
 */
public class Demo8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().trim().split(" ");
        Arrays.sort(s);
        for (int i1 = 0; i1 < s.length; i1++) {
            if (i1 != 0) {
                System.out.print(" ");
            }
            System.out.print(s[i1]);
        }
    }
}
