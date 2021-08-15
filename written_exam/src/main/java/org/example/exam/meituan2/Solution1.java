package org.example.exam.meituan2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小美给小团一个n个数字构成的数字序列，问小团能不能经过重新排列后形成1到n的排列。
 * 举例：
 * 小美给小团[2, 1, 3]，则可以经过重新排列后构成[1, 2, 3]，这是可行的。
 * 小美给小团[4, 4, 1, 3]，则无法经过重新排列后构成[1, 2, 3, 4]，这是不可行的。
 * 为了防止小团靠运气碰对答案，小美会进行多组询问。
 * <p>
 * 输入：
 * 2
 * 3
 * 2 1 3
 * 4
 * 4 4 1 3
 * 输出：
 * Yes
 * No
 * <p>
 * AK！
 *
 * @author lifei
 */
public class Solution1 {
    public static boolean isSequence(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != (i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int pos = 0;
            while (n-- > 0) {
                arr[pos++] = sc.nextInt();
            }
            System.out.println(isSequence(arr) ? "Yes" : "No");
        }
    }
}
