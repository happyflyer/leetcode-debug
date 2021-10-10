package org.example.exam.didi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述：
 * 输入：
 * 5
 * 1.3 2 1.5 1.3 1.50
 * 输出：
 * 3
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution1 {
    public static int getAns(int n, double[] nums) {
        Set<Double> set = new HashSet<>();
        for (double x : nums) {
            set.add(x);
        }
        return set.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextDouble();
        }
        System.out.println(getAns(n, nums));
    }
}
