package org.example.leetcode.lang.oj;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/5657/G
 *
 * @author lifei
 */
public class Demo7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strings = sc.nextLine().split(" ");
            int sum = 0;
            for (String s : strings) {
                sum += Integer.parseInt(s);
            }
            System.out.println(sum);
        }
    }
}
