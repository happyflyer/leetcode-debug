package org.example.exam.mihayou;

/**
 * 题目描述：字符串截取。
 * 输入："我ABC汉DEF",6
 * 输出："我ABC"
 * 说明：
 * 通过：66.67%
 *
 * @author lifei
 */
public class Solution2 {
    public String cutString(String original, int count) {
        if (original == null || "".equals(original) || count == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int len = 0;
        int cur = 0;
        while (len < count) {
            char c = original.charAt(cur);
            String s = String.valueOf(c);
            int sLen = s.getBytes().length;
            if (sLen > 1) {
                if (len + 2 > count) {
                    break;
                }
                len += 2;
            } else {
                len++;
            }
            sb.append(c);
            cur++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "我ABC汉DEF";
        int count = 6;
        System.out.println(new Solution2().cutString(original, count));
    }
}
