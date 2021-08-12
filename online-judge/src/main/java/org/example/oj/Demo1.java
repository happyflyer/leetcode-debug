package org.example.oj;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/5657/A
 *
 * @author lifei
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a + b);
        }
    }
}
