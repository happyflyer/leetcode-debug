package org.example.exam.shopee1;

/**
 * 压缩字符串，
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
 * 比如，字符串aabcccccaaa会变为a2bc5a3。
 * 你可以假设字符串中只包含大小写英文字母（a至z）。
 * 只有一个字符，1 不用写，
 * 要求：时间复杂度O（N）
 * <p>
 * 输入："shopeew"
 * 输出："shope2w"
 *
 * @author lifei
 */
public class Solution3 {
    /**
     * 双指针
     */
    public String compressString(String param) {
        int n = param.length();
        if (n == 1) {
            return "";
        }
        char prev = param.charAt(0);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            char cur = param.charAt(i);
            if (prev != cur) {
                sb.append(prev);
                if (cnt > 1) {
                    sb.append(cnt);
                }
                prev = cur;
                cnt = 0;
            }
            cnt++;
            // 最后一个字符时
            if (i == n - 1) {
                sb.append(prev);
                if (cnt > 1) {
                    sb.append(cnt);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution3().compressString("aabcccccaaa")
        );
    }
}
