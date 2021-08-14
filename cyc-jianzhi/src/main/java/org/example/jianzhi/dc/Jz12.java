package org.example.jianzhi.dc;

/**
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165
 *
 * @author lifei
 */
public class Jz12 {
    /**
     * 遍历一遍
     */
    public double Power(double base, int exponent) {
        if (exponent == 1) {
            return base;
        }
        double ans = base;
        while (exponent > 1) {
            ans *= base;
            exponent--;
        }
        while (exponent < 1) {
            ans /= base;
            exponent++;
        }
        return ans;
    }

    /**
     * 分治法
     */
    public double Power2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else if (exponent == -1) {
            return 1 / base;
        }
        double half = Power2(base, exponent / 2);
        if (exponent > 1) {
            return exponent % 2 == 0 ? (half * half) : (half * half * base);
        } else {
            return exponent % 2 == 0 ? (half * half) : (half * half / base);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz12().Power2(2.0000d, 3)
        );
    }
}
