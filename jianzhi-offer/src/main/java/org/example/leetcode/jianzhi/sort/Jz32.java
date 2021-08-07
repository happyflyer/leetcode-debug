package org.example.leetcode.jianzhi.sort;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185
 *
 * @author lifei
 */
public class Jz32 {
    /**
     * 转成字符串
     */
    public String PrintMinNumber(int[] numbers) {
        int n = numbers.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(ss, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        System.out.println(Arrays.toString(ss));
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz32().PrintMinNumber(new int[]{3, 32, 321})
        );
    }
}
