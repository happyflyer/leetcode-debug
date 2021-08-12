package org.example.sort.t;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lifei
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        shuffle(nums);
        quickSort(nums, 0, n - 1);
    }

    private void quickSort(T[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        System.out.println("low = " + low + ", high = " + high);
        System.out.println(Arrays.toString(nums));
        int j = partition(nums, low, high);
        quickSort(nums, low, j - 1);
        quickSort(nums, j + 1, high);
    }

    private int partition(T[] nums, int low, int high) {
        int i = low;
        int j = high + 1;
        T pivot = nums[low];
        while (true) {
            while (less(nums[++i], pivot) && i != high) {
            }
            while (less(pivot, nums[--j]) && j != low) {
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private void shuffle(T[] nums) {
        List<T> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{6, 4, 3, 2, 5, 1};
        System.out.println("排序前：" + Arrays.toString(nums));
        new QuickSort<Integer>().sort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
