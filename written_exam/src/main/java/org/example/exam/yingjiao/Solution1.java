package org.example.exam.yingjiao;

/**
 * 九进制数字各位上的数字加1相乘，重复，直到结果为个位数。
 * 无法变为个位数，返回-1。
 * <p>
 * 输入：80
 * 输出：2
 *
 * @author lifei
 */
public class Solution1 {
    public int mulDigits(String num) {
        System.out.println("num = " + num);
        int n = num.length();
        int sum = 1;
        for (int i = 0; i < n; i++) {
            int cur = num.charAt(i) - '0';
            sum *= (cur + 1);
        }
        System.out.println("sum = " + sum);
        if (sum > 8) {
            return mulDigits(decimalToNine(sum));
        }
        return sum;
    }

    private String decimalToNine(int i) {
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            sb.append(i);
        }
        while (i > 0) {
            sb.append(i % 9);
            i /= 9;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().mulDigits("100"));
        System.out.println(new Solution1().mulDigits("1000000000"));
        System.out.println(new Solution1().mulDigits("888888888"));
    }
}
