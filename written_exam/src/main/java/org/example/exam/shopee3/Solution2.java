package org.example.exam.shopee3;

/**
 * 题目描述：其实就是KMP，写kmp麻烦，这样写思路清晰
 * 输入：
 * 输出：
 * 说明：
 * 通过：90
 *
 * @author lifei
 */
public class Solution2 {
    public String FindAndReplace(String src, String match, String replace) {
        StringBuilder sb = new StringBuilder();
        char[] cache = new char[match.length()];
        int p = 0;
        for (int i = 0; i < src.length(); ) {
            char c = src.charAt(i);
            if (c == match.charAt(p)) {
                // 当前字符匹配
                cache[p] = c;
                p++;
                // 匹配完所有的字符
                if (p == match.length()) {
                    sb.append(replace);
                    p = 0;
                }
                // 只有当前字符匹配的情况下，才需要移动i指针
                // 如果当前字符不匹配，则需要开始处理cache数组
                i++;
            } else {
                if (p > 0) {
                    for (int j = 0; j < p; j++) {
                        if (j > 0 && cache[j] == match.charAt(0)) {
                            // 当前字符匹配到match的第一个字符，停下来
                            System.arraycopy(cache, j, cache, 0, p - j);
                            p -= j;
                        } else {
                            sb.append(cache[j]);
                        }
                    }
                }
            }
        }
        if (p > 0) {
            for (int i = 0; i < p; i++) {
                sb.append(cache[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().FindAndReplace(
                "ababac", "abac", "kkk"
        ));
    }
}
