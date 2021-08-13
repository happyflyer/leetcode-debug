package org.example.sort;

/**
 * @author lifei
 */
public class ShellSort extends Sort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = gap + i; j < n; j += gap) {
                    // 插入排序
                    int tmp = nums[j];
                    int prev = j - gap;
                    while (prev >= 0 && nums[prev] > tmp) {
                        nums[prev + gap] = nums[prev];
                        prev -= gap;
                    }
                    nums[prev + gap] = tmp;
                }
            }
        }
    }
}
