package org.example.exam.wanmeishijie;

/**
 * 输入："2","-2"
 * 输出："-4"
 * ac:70%
 *
 * @author lifei
 */
public class Solution3 {
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        boolean p1 = num1.charAt(0) == '-';
        boolean p2 = num2.charAt(0) == '-';
        boolean p = p1 == p2;
        num1 = p1 ? num1.substring(1) : num1;
        num2 = p2 ? num2.substring(1) : num2;
        int n1 = num1.length();
        int n2 = num2.length();
        if (n1 > n2) {
            return multiply(num2, num1);
        }
        String sum = "";
        for (int i = 0; i < n1; i++) {
            StringBuilder val = multiply(num2, num1.charAt(n1 - 1 - i));
            for (int j = 0; j < i; j++) {
                val.append("0");
            }
            sum = add(sum, val.toString());
        }
        return p ? sum : ("-" + sum);
    }

    private StringBuilder multiply(String num, char c) {
        StringBuilder sb = new StringBuilder();
        if (c == '0') {
            sb.append("0");
            return sb;
        }
        int n = num.length();
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int tmp = (num.charAt(i) - '0') * (c - '0');
            sb.append((tmp + carry) % 10);
            carry = (tmp + carry) / 10;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse();
    }

    private String add(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int tmp = num1.charAt(i) - '0' + num2.charAt(j) - '0';
            sb.append((tmp + carry) % 10);
            carry = (tmp + carry) / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int tmp = num1.charAt(i) - '0';
            sb.append((tmp + carry) % 10);
            carry = (tmp + carry) / 10;
            i--;
        }
        while (j >= 0) {
            int tmp = num2.charAt(j) - '0';
            sb.append((tmp + carry) % 10);
            carry = (tmp + carry) / 10;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution3().multiply("21", "-201")
        );
    }
}
