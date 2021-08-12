package org.example.exam.yuanfudao;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 排序后的数组互换两个字符，找出来。
 * <p>
 * 输入：2 6 4 5 3
 * 输出：2 5
 * <p>
 * 输入：1 3 12 15 26 36 178 51 60 72 79 90 91 96 102 111 116 119 130 131 143 144 154 164 174 47 183 186 193
 * 输出：7 26
 * <p>
 * 输入：2 1
 * 输出：1 2
 *
 * @author lifei
 */
public class Solution1 {
    /**
     * 双指针
     */
    public int[] findSwapPositions(int[] arr) {
        int n = arr.length;
        int[] ans = new int[2];
        int low = 0;
        int high = n - 1;
        while (low + 1 < n && arr[low] < arr[low + 1]) {
            low++;
        }
        ans[0] = low + 1;
        while (high - 1 >= 0 && arr[high - 1] < arr[high]) {
            high--;
        }
        ans[1] = high + 1;
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] strArr = input.split(" ");
        int[] intArr = Arrays.stream(strArr).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(intArr));
        System.out.println(
                Arrays.toString(
                        new Solution1().findSwapPositions(intArr)
                )
        );
    }
}
