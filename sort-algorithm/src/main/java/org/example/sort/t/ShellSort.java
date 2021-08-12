package org.example.sort.t;

import java.util.Arrays;

/**
 * @author lifei
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        int gap = 1;
        while (gap < n / 3) {
            // 1, 4, 13, 40, ...
            gap = 3 * gap + 1;
        }
        while (gap >= 1) {
            for (int i = gap; i < n; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (less(nums[j], nums[j - gap])) {
                        swap(nums, j, j - gap);
                    }
                }
            }
            System.out.println("gap = " + gap);
            System.out.println(Arrays.toString(nums));
            gap /= 3;
        }
    }

    public void sort2(T[] nums) {
        int n = nums.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                for (int j = gap + i; j < n; j += gap) {
                    // 插入排序
                    T tmp = nums[j];
                    int prev = j - gap;
                    while (prev >= 0 && less(tmp, nums[prev])) {
                        swap(nums, prev + gap, prev);
                        prev -= gap;
                    }
                    nums[prev + gap] = tmp;
                }
            }
            System.out.println("gap = " + gap);
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{6, 4, 3, 2, 5, 1};
        System.out.println("排序前：" + Arrays.toString(nums));
        new ShellSort<Integer>().sort2(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
