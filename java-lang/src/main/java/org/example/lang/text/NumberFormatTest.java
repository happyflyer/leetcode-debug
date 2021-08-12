package org.example.lang.text;

import java.text.NumberFormat;

/**
 * @author lifei
 */
public class NumberFormatTest {
    public static void main(String[] args) {
        double money = 1234565677777.33;
        String str = NumberFormat.getInstance().format(money);
        System.out.println(str);
    }
}
