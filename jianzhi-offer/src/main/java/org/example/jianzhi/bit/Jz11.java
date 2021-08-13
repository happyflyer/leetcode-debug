package org.example.jianzhi.bit;

/**
 * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164
 *
 * @author lifei
 */
public class Jz11 {
    public int NumberOf1(int n) {
        if (n >= 0) {
            int cnt = 0;
            while (n != 0) {
                cnt += (n % 2);
                n /= 2;
            }
            return cnt;
        } else {
            return NumberOf1(n - Integer.MIN_VALUE) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz11().NumberOf1(10)
        );
    }
}
