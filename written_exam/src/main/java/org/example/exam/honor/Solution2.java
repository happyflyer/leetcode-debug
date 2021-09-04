package org.example.exam.honor;

import java.util.Scanner;

/**
 * @author lifei
 */
public class Solution2 {
    private static int getAns(int n) {
        int k = 0;
        int x = 1;
        while (x <= n) {
            x *= 2;
            k++;
        }
        return k - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getAns(n));
    }
}
