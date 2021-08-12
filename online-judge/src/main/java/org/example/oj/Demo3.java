package org.example.oj;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/5657/C
 *
 * @author lifei
 */
public class Demo3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) {
                break;
            }
            System.out.println(a + b);
        }
    }
}
