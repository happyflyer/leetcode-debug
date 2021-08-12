package org.example.lang.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lifei
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String str = sdf.format(date);
        System.out.println(str);
        String birthday = "1999-10-10 11:10:10:123";
        date = sdf.parse(birthday);
        System.out.println(date);
    }
}
