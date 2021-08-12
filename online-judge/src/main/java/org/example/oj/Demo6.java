package org.example.oj;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/5657/F
 *
 * @author lifei
 */
public class Demo6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int sum = 0;
            while (x-- != 0) {
                int a = sc.nextInt();
                sum += a;
            }
            System.out.println(sum);
        }
    }
}
