package org.example.leetcode.jianzhi.sort;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188
 *
 * @author lifei
 */
public class Jz35 {
    /**
     * 暴力法
     */
    public int InversePairs(int[] array) {
        int n = array.length;
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    cnt++;
                }
            }
        }
        return cnt % 1000000007;
    }

    private int cnt;
    private int[] tmp;

    public int InversePairs2(int[] array) {
        int n = array.length;
        cnt = 0;
        tmp = new int[n];
        mergeSort(array, 0, n - 1);
        return cnt;
    }

    /**
     * 归并排序
     */
    private void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    /**
     * 归并
     */
    private void merge(int[] array, int low, int mid, int high) {
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, low, high + 1)));
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
                // 奥妙之处
                cnt += (mid - i + 1);
                cnt %= 1000000007;
            }
        }
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        while (j <= high) {
            tmp[k++] = array[j++];
        }
        for (k = 0, i = low; i <= high; k++, i++) {
            array[i] = tmp[k];
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz35().InversePairs2(new int[]{1, 2, 3, 4, 5, 6, 7, 0})
        );
    }
}
