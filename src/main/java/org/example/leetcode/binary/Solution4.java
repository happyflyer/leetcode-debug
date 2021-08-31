package org.example.leetcode.binary;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution4 {
    /**
     * 合并数组，复杂度为O（m+n）。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if (len == 0) {
            return 0;
        }
        int k = len / 2;
        int[] arr = new int[k + 1];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i <= k; i++) {
            if (p1 < nums1.length && p2 < nums2.length) {
                if (nums1[p1] <= nums2[p2]) {
                    arr[i] = nums1[p1];
                    p1++;
                } else {
                    arr[i] = nums2[p2];
                    p2++;
                }
            } else if (p1 < nums1.length) {
                arr[i] = nums1[p1];
                p1++;
            } else if (p2 < nums2.length) {
                arr[i] = nums2[p2];
                p2++;
            }
        }
        if (len % 2 == 1) {
            return arr[k];
        } else {
            return (arr[k - 1] + arr[k]) / 2.0d;
        }
    }

    /**
     * 官方解法。
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if (len == 0) {
            return 0;
        }
        int k = len / 2;
        if (len % 2 == 1) {
            return getKth(nums1, nums2, 0, 0, k + 1);
        } else {
            return (getKth(nums1, nums2, 0, 0, k)
                    + getKth(nums1, nums2, 0, 0, k + 1))
                    / 2.0d;
        }
    }

    /**
     * 找到第k个数（k从1开始）。
     */
    private int getKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (start1 == length1) {
            return nums2[start2 + k - 1];
        }
        if (start2 == length2) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int half = k / 2;
        int index1 = Math.min(start1 + half, length1) - 1;
        int index2 = Math.min(start2 + half, length2) - 1;
        if (nums1[index1] <= nums2[index2]) {
            k -= (index1 - start1 + 1);
            return getKth(nums1, nums2, index1 + 1, start2, k);
        } else {
            k -= (index2 - start2 + 1);
            return getKth(nums1, nums2, index1, index2 + 1, k);
        }
    }

    /**
     * 跟官方的思路一样。
     */
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if (len == 0) {
            return 0;
        }
        int k = len / 2;
        if (len % 2 == 1) {
            return getKth2(nums1, nums2, 0, 0, k);
        } else {
            return (getKth2(nums1, nums2, 0, 0, k - 1)
                    + getKth2(nums1, nums2, 0, 0, k))
                    / 2.0d;
        }
    }

    /**
     * 找到第k个数（k从0开始）。
     */
    private int getKth2(int[] nums1, int[] nums2, int start1, int start2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (start1 == length1) {
            return nums2[start2 + k];
        }
        if (start2 == length2) {
            return nums1[start1 + k];
        }
        if (k == 0) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        if (k == 1) {
            if (nums1[start1] == nums2[start2]) {
                return nums1[start1];
            }
            if (nums1[start1] < nums2[start2]) {
                return getKth2(nums1, nums2, start1 + 1, start2, 0);
            } else {
                return getKth2(nums1, nums2, start1, start2 + 1, 0);
            }
        }
        // 比较的位置在前一位，而不是当前位
        int half = k / 2 - 1;
        int index1 = Math.min(start1 + half, length1 - 1);
        int index2 = Math.min(start2 + half, length2 - 1);
        if (nums1[index1] <= nums2[index2]) {
            k -= (index1 - start1 + 1);
            return getKth2(nums1, nums2, index1 + 1, start2, k);
        } else {
            k -= (index2 - start2 + 1);
            return getKth2(nums1, nums2, start1, index2 + 1, k);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution4().findMedianSortedArrays3(
                        new int[]{2, 3, 4, 5, 6, 7, 8},
                        new int[]{1}
                )
        );
    }
}
