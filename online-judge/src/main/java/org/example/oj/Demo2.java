package org.example.oj;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/5657/B
 *
 * @author lifei
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
            t--;
        }
    }
}
