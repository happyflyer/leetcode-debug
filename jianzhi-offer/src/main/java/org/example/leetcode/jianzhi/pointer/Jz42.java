package org.example.leetcode.jianzhi.pointer;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195
 *
 * @author lifei
 */
public class Jz42 {
    /**
     * 双指针
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            int cur = array[low] + array[high];
            if (cur == sum) {
                list.add(array[low]);
                list.add(array[high]);
                break;
            }
            if (cur < sum) {
                low++;
            } else {
                high--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz42().FindNumbersWithSum(
                        new int[]{1, 2, 4, 7, 11, 15},
                        15
                )
        );
    }
}
