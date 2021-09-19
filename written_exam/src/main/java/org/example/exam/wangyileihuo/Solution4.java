package org.example.exam.wangyileihuo;

import java.util.*;

/**
 * 题目描述：
 * 输入：
 * 3 12
 * 2 3
 * 3 2
 * 4 1
 * 输出：
 * 15
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution4 {
    public static int getAns(int M, int N, int[] costOne, int[] costTwo) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] costOne = new int[M];
        int[] costTwo = new int[M];
        int i = 0;
        while (i < M) {
            costOne[i] = sc.nextInt();
            costTwo[i] = sc.nextInt();
            i++;
        }
        System.out.println(getAns(M, N, costOne, costTwo));
    }
}
