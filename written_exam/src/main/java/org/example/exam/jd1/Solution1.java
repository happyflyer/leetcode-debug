package org.example.exam.jd1;

import java.util.Scanner;

/**
 * 小明搬进了一个新的小区里，对里面的环境和住户都比较陌生，
 * 小明发现这个小区的房屋是一个网格型排列，所有房屋在一个网格状的地图上。
 * 小区一共有n户人家，我们假设每户人家的位置表示为（x，y）。
 * 小明觉得如果两家是邻居的话，他们的关系应该会更好一些。
 * 现在我们定义当两户人家处在相同的任意一个对角线上的时候，则两户人家为邻居。
 * 现在小明想要统计这样的邻居一共有多少对。
 * 输入描述：
 * 第一行1个整数n，0<n<=10^5，表示有n户人家。
 * 接下来n行，第i行包含两个整数xi，yi，0<xi，yi<=1000，
 * 表示第i户人家的位置为（xi，yi）。
 * 输出描述：
 * 一行一个整数，表示有多少对邻居。
 * <p>
 * 输入：
 * 5
 * 3 4
 * 4 5
 * 5 6
 * 4 7
 * 3 8
 * 输出：
 * 6
 * 说明：
 * 对于样例输入，以下几对人家均为邻居
 * （3，4）与（4，5）
 * （3，4）与（5，6）
 * （4，5）与（5，6）
 * （5，6）与（4，7）
 * （5，6）与（3，8）
 * （4，7）与（3，8）
 * <p>
 * AC：72%
 *
 * @author lifei
 */
public class Solution1 {
    public static void getCount(int[][] arr) {
        int n = arr.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            int xi = arr[i][0];
            int yi = arr[i][1];
            for (int j = i + 1; j < n; j++) {
                int xj = arr[j][0];
                int yj = arr[j][1];
                if (yj - yi == xj - xi || xi + yi == xj + yj) {
                    System.out.println("(" + xi + ", " + yi + ") - (" + xj + ", " + yj + ")");
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int i = 0;
        while (i < n) {
            int[] xy = new int[2];
            xy[0] = sc.nextInt();
            xy[1] = sc.nextInt();
            arr[i] = xy;
            i++;
        }
        // int[][] arr = new int[][]{
        //         {3, 4},
        //         {4, 5},
        //         {5, 6},
        //         {4, 7},
        //         {3, 8}
        // };
        getCount(arr);
    }
}
