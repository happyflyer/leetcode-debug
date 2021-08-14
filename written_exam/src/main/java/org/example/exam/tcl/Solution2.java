package org.example.exam.tcl;

/**
 * 如果一个字符串可以由某个长度为k的字符串重复多次得到，则称该串以k为周期。
 * 例如，abcabcabcabc以3为周期（注意，它也以6和12为周期）。
 *
 * @author lifei
 */
public class Solution2 {
    public int getT(String s) {
        int n = s.length();
        int ok = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                // 如果i是n的印数，i就有可能是周期
                ok = 1;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        ok = 0;
                        break;
                    }
                }
            }
            if (ok == 1) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution2().getT("abcabcabcabc")
        );
    }
}
