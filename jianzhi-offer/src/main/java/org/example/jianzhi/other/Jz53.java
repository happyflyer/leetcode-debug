package org.example.jianzhi.other;

/**
 * https://www.nowcoder.com/practice/e69148f8528c4039ad89bb2546fd4ff8?tpId=13&tqId=11206
 *
 * @author lifei
 */
public class Jz53 {
    public boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        final String p = "[+-]?(\\d+|\\d+\\.\\d*|\\.\\d+)([eE][+-]?\\d+)?";
        return str.trim().matches(p);
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz53().isNumeric("+")
        );
    }
}
