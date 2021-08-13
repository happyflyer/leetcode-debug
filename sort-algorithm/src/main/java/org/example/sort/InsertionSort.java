package org.example.sort;

/**
 * @author lifei
 */
public class InsertionSort extends Sort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int tmp = nums[i + 1];
            int j = i;
            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
    }
}
