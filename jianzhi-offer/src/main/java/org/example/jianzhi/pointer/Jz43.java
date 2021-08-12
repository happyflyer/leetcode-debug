package org.example.jianzhi.pointer;

/**
 * https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196
 *
 * @author lifei
 */
public class Jz43 {
    /**
     * 使用 StringBuilder
     */
    public String LeftRotateString(String str, int n) {
        int length = str.length();
        if (length == 0) {
            return str;
        }
        n = n % length;
        StringBuilder sb = new StringBuilder();
        sb.append(str, n, length);
        sb.append(str, 0, n);
        return sb.toString();
    }

    /**
     * 双倍空间
     */
    public String LeftRotateString2(String str, int n) {
        int length = str.length();
        if (length == 0) {
            return str;
        }
        n = n % length;
        return (str + str).substring(n, n + length);
    }

    /**
     * 双指针
     */
    public String LeftRotateString3(String str, int n) {
        int length = str.length();
        if (length == 0) {
            return str;
        }
        n = n % length;
        return str.substring(n, length) + str.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz43().LeftRotateString3("abcXYZdef", 3)
        );
    }
}
