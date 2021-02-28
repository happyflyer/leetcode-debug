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
public class Solution1 {
    Map<String, String> map = new HashMap<>();

    public Solution1() {
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
        for (int i = 0; i < n; i++) {
            ans = getNewList(ans, digits.substring(i, i + 1));
        }
        return ans;
    }

    public List<String> getNewList(List<String> list, String s) {
        List<String> ans = new ArrayList<>();
        String letters = map.get(s);
        if (list.isEmpty()) {
            for (int i = 0; i < letters.length(); i++) {
                ans.add(letters.substring(i, i + 1));
            }
        } else {
            for (String item : list) {
                for (int i = 0; i < letters.length(); i++) {
                    ans.add(item + letters.charAt(i));
                }
            }
        }
        return ans;
    }
}
