package org.example.leetcode.jianzhi.pointer;

/**
 * https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?tpId=13&tqId=11197
 *
 * @author lifei
 */
public class Jz44 {
    /**
     * 双指针
     */
    public String ReverseSentence(String str) {
        int n = str.length();
        if (n == 0) {
            return str;
        }
        int left = n - 1;
        int right = n - 1;
        StringBuilder sb = new StringBuilder();
        while (left > 0) {
            if (str.charAt(left) == ' ') {
                sb.append(str, left + 1, right + 1);
                sb.append(" ");
                right = left - 1;
            }
            left--;
        }
        sb.append(str, left, right + 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz44().ReverseSentence("nowcoder. a am I")
        );
    }
}
