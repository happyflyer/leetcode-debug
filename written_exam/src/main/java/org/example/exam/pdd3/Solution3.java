package org.example.exam.pdd3;

import java.util.*;

/**
 * 题目描述：
 * 输入：
 * 4
 * 0 1 1 0
 * 输出：
 * 2 4 3 1
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution3 {
    public static int[] getAns(int n, int[] nums) {
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(nums[i], i);
        }
        Iterator<Integer> iter = list.iterator();
        int index = 1;
        while (iter.hasNext()) {
            ans[iter.next()] = index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int i = 0;
        while (i < n) {
            nums[i] = sc.nextInt();
            i++;
        }
        int[] ans = getAns(n, nums);
        for (int j = 0; j < n; j++) {
            if (j > 0) {
                System.out.print(" ");
            }
            System.out.print(ans[j]);
        }
    }
}
