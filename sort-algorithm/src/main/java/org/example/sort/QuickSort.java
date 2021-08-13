package org.example.sort;

/**
 * @author lifei
 */
public class QuickSort extends Sort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
    }

    public void quickSort(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int pivot = nums[low];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, low, i);
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }
}
