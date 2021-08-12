package org.example.oj;

import java.util.Scanner;

/**
 * https://ac.nowcoder.com/acm/contest/5657/D
 *
 * @author lifei
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            if (x == 0) {
                break;
            }
            int ans = 0;
            while (x-- != 0) {
                int a = sc.nextInt();
                ans += a;
            }
            System.out.println(ans);
        }
    }
}
