package org.example.leetcode.normal.solution17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author lifei
 */
public class Solution2 {
    Map<String, String> map = new HashMap<>();

    public Solution2() {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> ans = new ArrayList<>();
        List<String> cur;
        String letters;
        for (int i = 0; i < n; i++) {
            letters = map.get(digits.substring(i, i + 1));
            if (ans.isEmpty()) {
                for (int j = 0; j < letters.length(); j++) {
                    ans.add(letters.substring(j, j + 1));
                }
            } else {
                cur = ans;
                ans = new ArrayList<>();
                for (String item : cur) {
                    for (int j = 0; j < letters.length(); j++) {
                        ans.add(item + letters.charAt(j));
                    }
                }
            }
        }
        return ans;
    }
}
