package org.example.leetcode.normal.solution18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 *
 * @author lifei
 */
public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int first;
        int second;
        int third;
        int fourth;
        int cur;
        // 时间复杂度：O(n^3)
        for (first = 0; first < n; first++) {
            if (first > n - 4) {
                continue;
            }
            for (second = first + 1; second < n; second++) {
                if (second > n - 3) {
                    continue;
                }
                third = second + 1;
                fourth = n - 1;
                while (third < fourth) {
                    cur = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if (cur == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        list.add(nums[fourth]);
                        // 去重
                        if (!ans.contains(list)) {
                            ans.add(list);
                        }
                    }
                    if (cur < target) {
                        if (third < n - 1) {
                            third++;
                        } else {
                            break;
                        }
                    } else {
                        if (fourth > second + 1) {
                            fourth--;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
