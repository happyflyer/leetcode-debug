package org.example.exam.xiaohongshu;

import java.util.Scanner;

/**
 * 薯队长看到了一颗神奇的树，树上有在每个结点上都住的一只蜗牛，树的结点数是N(N<=10000)。
 * 假设每只蜗牛的爬行速度都是一样的，树的每条边代表着蜗牛通过需要的时间（不超过1000）。
 * 如果在两个结点上的蜗牛到达对方的时间不超过K（K <= 10^9)，我们认为这两个蜗牛是好朋友。
 * 现在给定蜗牛们居住的树，薯队长想知道蜗牛们有多少对好朋友。
 * 对于30%的数据，N<=20
 * 对于50%的数据，N<=2000
 * 对于100%的数据，N<=10000
 * <p>
 * 输入：
 * 5 4
 * 1 2 3 1 3 1 1 4 2 3 5 1
 * 输出：
 * 8
 * <p>
 * POJ 1741 有点难
 *
 * @author lifei
 */
public class Solution3 {
    public static int getAns(int n, int k, int[] a, int[] b, int[] c) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n - 1];
        int[] b = new int[n - 1];
        int[] c = new int[n - 1];
        int i = 0;
        while (i < 3 * (n - 1)) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
            c[i] = sc.nextInt();
            i++;
        }
        System.out.println(getAns(n, k, a, b, c));
    }
}
