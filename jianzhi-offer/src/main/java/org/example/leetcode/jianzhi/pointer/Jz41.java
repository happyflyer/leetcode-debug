package org.example.leetcode.jianzhi.pointer;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194
 *
 * @author lifei
 */
public class Jz41 {
    /**
     * 暴力法
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 1; i < sum / 2 + 1; i++) {
            int length = 0;
            int numSum = 0;
            // 区间求和
            while (numSum < sum && i + length < sum) {
                numSum += (i + length);
                length++;
            }
            if (numSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = i; j < i + length; j++) {
                    list.add(j);
                }
                ans.add(list);
            }
        }
        return ans;
    }

    /**
     * 双指针 / 滑动窗口
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int slow = 1;
        int fast = 2;
        while (slow <= sum / 2) {
            int numSum = (slow + fast) * (fast - slow + 1) / 2;
            if (numSum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = slow; j <= fast; j++) {
                    list.add(j);
                }
                ans.add(list);
            }
            if (numSum < sum) {
                fast++;
            } else {
                slow++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz41().FindContinuousSequence2(9)
        );
    }
}
