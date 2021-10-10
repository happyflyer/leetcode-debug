package org.example.exam.jd2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 输出：
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution1 {
    public static int getAns(int n, int k, int d, int[] a, int[] b, int[] c) {
        List<Node> tt = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tt.add(new Node(a[i], b[i], c[i]));
        }
        tt.sort((x, y) -> x.a - y.a);
        int ans = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (tt.get(i).b > k) {
                continue;
            }
            double cost = 1.0 * d / n * (i + 1);
            if (tt.get(i).c > cost + 1e-6) {
                continue;
            }
            ans = tt.get(i).a;
            break;
        }
        return ans;
    }

    static class Node {
        int a;
        int b;
        int c;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();
        // int d = sc.nextInt();
        // int[] a = new int[n];
        // int[] b = new int[n];
        // int[] c = new int[n];
        // for (int i = 0; i < n; i++) {
        //     a[i] = sc.nextInt();
        // }
        // for (int i = 0; i < n; i++) {
        //     b[i] = sc.nextInt();
        // }
        // for (int i = 0; i < n; i++) {
        //     c[i] = sc.nextInt();
        // }
        int n = 5;
        int k = 100;
        int d = 100;
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{30, 60, 90, 120, 150};
        int[] c = new int[]{11, 22, 44, 88, 176};
        System.out.println(getAns(n, k, d, a, b, c));
    }
}
