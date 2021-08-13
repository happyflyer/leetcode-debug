package org.example.sort;

import java.util.Arrays;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 3, 8, 2, 9, 1};
        System.out.println("排序前：" + Arrays.toString(nums));
        new HeapSort().sort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
