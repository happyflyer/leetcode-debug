package org.example.oj;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/5657/E
 *
 * @author lifei
 */
public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int sum = 0;
            while (n-- > 0) {
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }
}
