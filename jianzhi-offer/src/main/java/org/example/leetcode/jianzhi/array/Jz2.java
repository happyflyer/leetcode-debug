package org.example.leetcode.jianzhi.array;

/**
 * https://www.nowcoder.com/practice/0e26e5551f2b489b9f58bc83aa4b6c68?tpId=13&tqId=11155
 *
 * @author lifei
 */
public class Jz2 {
    /**
     * 临时数组
     */
    public String replaceSpace(String s) {
        int n = s.length();
        char[] array = new char[n * 3];
        int index = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = c;
            }
        }
        return new String(array, 0, index);
    }

    /**
     * 使用 StringBuilder
     */
    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 双指针
     */
    public String replaceSpace3(String s) {
        int slow = s.length() - 1;
        // 填充占位
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i <= slow; i++) {
            if (sb.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        // 快指针往前追慢指针
        int fast = sb.length() - 1;
        while (slow >= 0 && fast > slow) {
            char c = sb.charAt(slow--);
            if (c == ' ') {
                sb.setCharAt(fast--, '0');
                sb.setCharAt(fast--, '2');
                sb.setCharAt(fast--, '%');
            } else {
                sb.setCharAt(fast--, c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz2().replaceSpace3("We Are Happy")
        );
    }
}
