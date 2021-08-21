package org.example.exam.wangyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 分纸张。
 * <p>
 * 输入：1 1 1
 * 输出：3
 * <p>
 * 输入：1 2 3
 * 输出：6
 * <p>
 * 输入：5
 * 输出：1
 *
 * @author lifei
 */
public class Solution3 {
    /**
     * 理解错误
     */
    public static int getPaperCount(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return n;
        }
        Arrays.sort(arr);
        int cur = 1;
        int sum = cur;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                cur++;
            }
            sum += cur;
        }
        return sum;
    }

    public static int getPaperCount2(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return n;
        }
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            min = Math.min(min, i);
        }
        int[] count = new int[n];
        int[] enough = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            if (arr[i] == min) {
                enough[i] = 1;
            }
        }
        int sum = 0;
        for (int i : count) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println(getPaperCount2(arr));
    }
}
