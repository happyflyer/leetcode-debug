package org.example.exam.shopee2;

/**
 * 输入："1^0|0|1",false
 * 输出：2
 * 说明：满足desired的组合数：1^((0|0)|1)、1^(0|(0|1))
 * <p>
 * 输入："1",false
 * 输出：0
 * 说明：无组合满足desired
 *
 * @author lifei
 */
public class Solution2 {
    public long GetNumOfExpress(String express, boolean desired) {
        int n = express.length();
        if (n == 1) {
            return "1".equals(express) == desired ? 1 : 0;
        } else if (n == 3) {
            if (express.charAt(1) == '&') {
            } else if (express.charAt(1) == '|') {
            } else if (express.charAt(1) == '^') {
            } else {
                return 0;
            }
        } else {
        }
        return 1L;
    }

    public static void main(String[] args) {
        String express = "1^0|0|1";
        boolean desired = false;
        System.out.println(new Solution2().GetNumOfExpress(express, desired));
    }
}
