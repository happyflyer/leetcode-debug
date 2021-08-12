package org.example.sort.t;

import java.util.Arrays;

/**
 * @author lifei
 */
public class InsertionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        for (int high = 0; high < n - 1; high++) {
            T tmp = nums[high + 1];
            int j = high;
            while (j >= 0 && less(tmp, nums[j])) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
            System.out.println("high = " + high + ", insert pos = " + (j + 1));
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{6, 4, 3, 2, 5, 1};
        System.out.println("排序前：" + Arrays.toString(nums));
        new InsertionSort<Integer>().sort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
