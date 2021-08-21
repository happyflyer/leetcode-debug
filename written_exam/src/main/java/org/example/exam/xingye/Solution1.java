package org.example.exam.xingye;

import java.util.Scanner;

/**
 * 输入：45
 * 输出：45=3*3*5
 *
 * @author lifei
 */
public class Solution1 {
    public String getFactors(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.append("=");
        int cnt = 1;
        int i = 2;
        while (n > 1) {
            if (n % i == 0) {
                if (cnt > 1) {
                    sb.append("*");
                }
                sb.append(i);
                n /= i;
                cnt++;
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(new Solution1().getFactors(n));
    }
}
